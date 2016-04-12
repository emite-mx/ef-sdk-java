package mx.emite.sdk.proxy.response.extra;

import lombok.Data;

@Data
public class InfoValidacion  {
	
	
	private String resultadoValidacion;
	
	private String fechaValidacion;
	
	private String emisor;
	
	private String receptor;
	
	private String uuid;
	
	private String servicioSAT;
	
	private String codigoSAT;
	
	private String estadoSAT;
	
	private String folio;
	
	private String fechaEmision;
	
	private String cadenaOriginal;
	
	private String fechaCertificacion;
	
	private String rfcPAC;
	
}
