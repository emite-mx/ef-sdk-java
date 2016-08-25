package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiObject
@AllArgsConstructor @NoArgsConstructor
public class InfoValidacionEmisorReceptor implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7981654414059799904L;
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
