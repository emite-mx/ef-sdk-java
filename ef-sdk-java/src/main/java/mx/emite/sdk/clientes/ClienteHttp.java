package mx.emite.sdk.clientes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Slf4j
public class ClienteHttp {

	private static final String AGENTE = "ef-sdk-java/";

    private static final int DEFAULT_CONNECTION_TIMEOUT = 90000;

    private final CloseableHttpClient httpClient;

    private final String userAgent;

    private RequestConfig requestConfig;

    public ClienteHttp() {
        this.httpClient = this.initHttpClient(true, DEFAULT_CONNECTION_TIMEOUT,
                DEFAULT_CONNECTION_TIMEOUT);
        String version = this.getClass().getPackage().getImplementationVersion();
        if (version == null) {
            version = "UNKNOWN";
        }
        this.userAgent = AGENTE + version;
    }
    
    protected CloseableHttpClient initHttpClient(final boolean requirePoolManager, final int connectionTimeout,
            final int socketTimeout) {
        CloseableHttpClient httpClient;
        HttpClientConnectionManager manager;
        manager = new PoolingHttpClientConnectionManager();
       
        this.requestConfig = RequestConfig.custom().setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeout).build();
        ConnectionConfig connnectionConfig = ConnectionConfig.custom().setCharset(Charset.forName("UTF-8")).build();
        httpClient = HttpClientBuilder.create()
                .setConnectionManager(manager)
                .setDefaultConnectionConfig(connnectionConfig)
                .setDefaultRequestConfig(this.requestConfig)
                .build();
        return httpClient;
    }

    public RespuestaHttp get(final String url) throws ApiException {
        HttpGet request = new HttpGet(url);
        return this.executeOperation(request,url);
    }

    
    public RespuestaHttp get(final String url, final Map<String, String> queryParams) throws ApiException {
        URI uri;
        if (queryParams == null) {
            uri = URI.create(url);
        } else {
            uri = this.createUriWithParams(url, queryParams);
        }
        HttpGet request = new HttpGet(uri);
        return this.executeOperation(request,url);

    }
    
    

    protected URI createUriWithParams(final String url, final Map<String, String> queryParams)
            throws IllegalArgumentException {
        URIBuilder builder = new URIBuilder(URI.create(url));
        for (Entry<String, String> entry : queryParams.entrySet()) {
            if (entry.getValue() != null) {
                builder.addParameter(entry.getKey(), entry.getValue());
            }
        }
        try {
            return builder.build();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public RespuestaHttp delete(final String url) throws ApiException {
        HttpDelete request = new HttpDelete(URI.create(url));
        return this.executeOperation(request,url);
    }

    public RespuestaHttp put(final String url, final String json) throws ApiException {
        HttpPut request = new HttpPut(URI.create(url));
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        return this.executeOperation(request,url);
    }

    public RespuestaHttp post(final String url, final String json) throws ApiException {
        HttpPost request = new HttpPost(URI.create(url));
        request.setEntity(new StringEntity(json, Consts.UTF_8.name()));
        return this.executeOperation(request,url);
    }

    protected RespuestaHttp executeOperation(final HttpRequestBase request, final String url) throws ApiException {
        this.addHeaders(request);
       
        long init = System.currentTimeMillis();
        CloseableHttpResponse response = this.callService(request);
        RespuestaHttp serviceResponse;
        try {
            serviceResponse = this.createResult(response);
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
        log.trace(url+" -> Tiempo Respuesta: {}", (System.currentTimeMillis() - init));
        return serviceResponse;
    }

    protected void addHeaders(final HttpRequestBase request) {
        request.addHeader(new BasicHeader("User-Agent", this.userAgent));
        request.addHeader(new BasicHeader("Accept", "application/json"));
        request.setHeader(new BasicHeader("Content-Type", "application/json"));
    }

    
    

    protected CloseableHttpResponse callService(final HttpRequestBase request) throws ApiException {
        request.setConfig(this.requestConfig);
        CloseableHttpResponse response;
        try {
            response = this.httpClient.execute(request);
        } catch (ClientProtocolException e) {
            throw new ApiException(I_Api_Errores.SERVICIO_NODISPONIBLE,e);
        } catch (IOException e) {
        	throw new ApiException(I_Api_Errores.SERVICIO_NODISPONIBLE,e);
        }
        return response;
    }

    protected RespuestaHttp createResult(final HttpResponse response) throws ApiException {
        RespuestaHttp serviceResponse = new RespuestaHttp();
        serviceResponse.setStatusCode(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try {
                serviceResponse.setBody(EntityUtils.toString(entity));
            } catch (IOException e) {
                log.error("Error obteniendo body del request", e);
            }
            if (entity.getContentType() != null) {
                serviceResponse.setContentType(entity.getContentType().getValue());
            }
        }
        return serviceResponse;
    }

	
}
