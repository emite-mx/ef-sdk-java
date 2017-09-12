package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiObject
@AllArgsConstructor @NoArgsConstructor
@Builder
public class InfoValidacionEmisorReceptor implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7981654414059799904L;
	@ApiObjectField(description="rfc del emisor / receptor")
	private String rfc;
	@ApiObjectField(description="razon Social")
	private String razonSocial;
	@ApiObjectField(description="calle")
	private String calle;
	@ApiObjectField(description="número exterior")
	private String noExterior;
	@ApiObjectField(description="número interior")
	private String noInterior;
	@ApiObjectField(description="codigo postal")
	private String codigoPostal;
	@ApiObjectField(description="colonia")
	private String colonia;
	@ApiObjectField(description="estado")
	private String estado;
	@ApiObjectField(description="localidad")
	private String localidad;
	@ApiObjectField(description="municipio")
	private String municipio;
	@ApiObjectField(description="pais")
	private String pais;
	@ApiObjectField(description="referencia")
	private String referencia;
	
	@ApiObjectField(description="listaNegra")
	private List<InfoValidacionListaNegra> listaNegra;
	
}
