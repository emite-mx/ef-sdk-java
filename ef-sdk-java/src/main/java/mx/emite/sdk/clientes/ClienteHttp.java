package mx.emite.sdk.clientes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultServiceUnavailableRetryStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Slf4j
public class ClienteHttp {

	private static final String AGENTE = "ef-sdk-java/";

    private static final int DEFAULT_CONNECTION_TIMEOUT = 10000;
    private static final int DEFAULT_SOCKET_TIMEOUT = 120000;

    private final CloseableHttpClient httpClient;

    private final String userAgent;
    private final String apiKey;
    
    private RequestConfig requestConfig;

    public ClienteHttp() {
       this(null);
    }
    
    public ClienteHttp(String apikey) {
    	 this.httpClient = this.initHttpClient(true, DEFAULT_CONNECTION_TIMEOUT,
                 DEFAULT_SOCKET_TIMEOUT);
         String version = this.getClass().getPackage().getImplementationVersion();
         if (version == null) {
             version = "UNKNOWN";
         }
         this.userAgent = AGENTE + version;
         this.apiKey=apikey;
	}

	protected CloseableHttpClient initHttpClient(final boolean requirePoolManager, final int connectionTimeout,
            final int socketTimeout) {
        final CloseableHttpClient httpClient;
        HttpClientConnectionManager manager;
       
        
        
        final SSLContext sslContext = getSslContext();
        
        final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        final Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslsf)
                .build();

        manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        
        this.requestConfig = RequestConfig.custom()
			    .setSocketTimeout(socketTimeout)
			    .setConnectTimeout(connectionTimeout)
			    .setConnectionRequestTimeout(connectionTimeout)
			    .build(); 
        final ConnectionConfig connnectionConfig = ConnectionConfig.custom().setCharset(Charset.forName("UTF-8")).build();
        httpClient = HttpClientBuilder.create()
                .setConnectionManager(manager)
                .setDefaultConnectionConfig(connnectionConfig)
                .setDefaultRequestConfig(this.requestConfig)
                .setRetryHandler(new StandardHttpRequestRetryHandler(5, true))
				.setServiceUnavailableRetryStrategy(new DefaultServiceUnavailableRetryStrategy(5, 500))
				.setSSLSocketFactory(sslsf)
				.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
				.setSSLContext(sslContext)
				
				.build();
        return httpClient;
    }

    private SSLContext getSslContext() {
    	SSLContext sslContext = null;
        try {
        sslContext = SSLContexts.custom() 
        		.loadTrustMaterial(null, new TrustSelfSignedStrategy() {
                        @Override
                        public boolean isTrusted(final X509Certificate[] chain, final String authType)
                                throws CertificateException {
                            return true;
                        }
                    }).build();
        
        } catch (Exception e) {
        	log.error("ssl",e);
        }
        return sslContext;
	}

	public RespuestaHttp get(final String url) throws ApiException {
        final HttpGet request = new HttpGet(url);
        return this.executeOperation(request,url);
    }

    
    public RespuestaHttp get(final String url, final Map<String, String> queryParams) throws ApiException {
        URI uri;
        if (queryParams == null) {
            uri = URI.create(url);
        } else {
            uri = this.createUriWithParams(url, queryParams);
        }
        final HttpGet request = new HttpGet(uri);
        return this.executeOperation(request,url);

    }
    
    

    protected URI createUriWithParams(final String url, final Map<String, String> queryParams)
            throws IllegalArgumentException {
        final URIBuilder builder = new URIBuilder(URI.create(url));
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
        final HttpDelete request = new HttpDelete(URI.create(url));
        return this.executeOperation(request,url);
    }

    public RespuestaHttp put(final String url, final String json) throws ApiException {
        final HttpPut request = new HttpPut(URI.create(url));
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        return this.executeOperation(request,url);
    }

    public RespuestaHttp post(final String url, final String json) throws ApiException {
        final HttpPost request = new HttpPost(URI.create(url));
        if(!StringUtils.isEmpty(apiKey))
        	request.addHeader("x-api-key", apiKey);
        
        request.setEntity(new StringEntity(json, Consts.UTF_8.name()));
        return this.executeOperation(request,url);
    }
    
    public RespuestaHttp post(final String url,final String apiKey, final Map<String,String> valores) throws ApiException {
       return post(url,apiKey,null,valores);
    }

    public RespuestaHttp post(final String url,final String apiKey,final String key, final Map<String,String> valores) throws ApiException {
        final HttpPost request = new HttpPost(URI.create(url));
        if(!StringUtils.isEmpty(apiKey))
        	request.addHeader("x-api-key", apiKey);
        if(!StringUtils.isEmpty(key))
        	request.addHeader("key", key);
        
        List<BasicNameValuePair> lista = valores.entrySet().stream().map(i->new BasicNameValuePair(i.getKey(), i.getValue())).collect(Collectors.toList());
        try{
        request.setEntity(new UrlEncodedFormEntity(lista));
        }catch(Exception ex){
        	throw new ApiException(I_Api_Errores.TIMBRADOR_ENVIANDOCOMPROBANTE,ex);
        }
        
        
        return this.executeOperation(request,url,false);
    }
    
    public RespuestaHttp postSoap(final String url,final String soap, final Map<String,String> headers) throws ApiException {
        final HttpPost request = new HttpPost(URI.create(url));
        headers.entrySet().stream().forEach(h-> request.addHeader(h.getKey(), h.getValue()));
        try{
        final StringEntity entity = new StringEntity(soap,ContentType.TEXT_XML);	
        request.setEntity(entity);
        }catch(Exception ex){
        	throw new ApiException(I_Api_Errores.TIMBRADOR_ENVIANDOCOMPROBANTE,ex);
        }
        return this.executeOperation(request,url,null);
    }
    
    
    protected RespuestaHttp executeOperation(final HttpRequestBase request, final String url) throws ApiException {
    	return executeOperation(request, url,true);
    }
    
    protected RespuestaHttp executeOperation(final HttpRequestBase request, final String url,final Boolean esjson) throws ApiException {
        this.addHeaders(request,esjson);
       
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

    protected void addHeaders(final HttpRequestBase request,final Boolean esjson) {
        request.addHeader(new BasicHeader("User-Agent", this.userAgent));
        if(esjson==null) return;
        if(esjson){
        	request.setHeader(new BasicHeader("Content-Type", "application/json"));
        	request.addHeader(new BasicHeader("Accept", "application/json"));
             
        }
        else{
        	request.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
        	request.addHeader(new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"));
             
        }
    }

    
    

    protected CloseableHttpResponse callService(final HttpRequestBase request) throws ApiException {
        request.setConfig(this.requestConfig);
        CloseableHttpResponse response;
        try {
        	
            response = this.httpClient.execute(request);
        } catch (ClientProtocolException e) {
            throw new ApiException(I_Api_Errores.PROXY_SERVICIO_NODISPONIBLE,e);
        } catch (IOException e) {
        	throw new ApiException(I_Api_Errores.PROXY_SERVICIO_NODISPONIBLE,e);
        }
        return response;
    }

    protected RespuestaHttp createResult(final HttpResponse response) throws ApiException {
        RespuestaHttp serviceResponse = new RespuestaHttp();
        serviceResponse.setStatusCode(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try {
                serviceResponse.setBody(EntityUtils.toString(entity,"UTF-8"));
            } catch (IOException e) {
                log.error("Error obteniendo body del request", e);
            }
            if (entity.getContentType() != null) {
                serviceResponse.setContentType(entity.getContentType().getValue());
            }
        }
        return serviceResponse;
    }

	public byte[] getBinario(String url) throws ApiException {
		 final HttpGet request = new HttpGet(url);
		 this.addHeaders(request,false);
	     //long init = System.currentTimeMillis();
	     final CloseableHttpResponse response = this.callService(request);
	     try(final InputStream is = response.getEntity().getContent();final ByteArrayOutputStream out = new ByteArrayOutputStream()){
	    	 IOUtils.copy(is, out);
	    
	    	 return out.toByteArray();
	     }
	     catch(Exception ex){
	    	 throw new ApiException(I_Api_Errores.VALIDADOR_CERTIFICADOSAT,ex);
	     }
	    
	}

	
}
