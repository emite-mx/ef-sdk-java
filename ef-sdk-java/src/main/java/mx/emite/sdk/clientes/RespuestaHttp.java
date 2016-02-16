package mx.emite.sdk.clientes;

import lombok.Data;

@Data
public class RespuestaHttp {

	private static final String JSON_MIME_TYPE = "application/json";

    private String contentType;

    private int statusCode;

    private String body;

    public boolean isJson() {
        return this.contentType != null && this.contentType.startsWith(JSON_MIME_TYPE);
    }
	
}
