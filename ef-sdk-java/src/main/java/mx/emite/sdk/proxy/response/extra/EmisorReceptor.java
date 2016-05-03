package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor @NoArgsConstructor
public class EmisorReceptor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7401802560153634038L;
	private String rfc;
	private String razonSocial;
	private String calle;
	private String noExterior;
	private String noInterior;
	private String codigoPostal;
	private String colonia;
	private String estado;
	private String localidad;
	private String municipio;
	private String pais;
	private String referencia;
	
}
