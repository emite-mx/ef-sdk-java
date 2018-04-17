package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
@ApiObject(description="infovalidacionlco")
public class InfoValidacionLco implements Serializable{
	
	
	
	private static final long serialVersionUID = -3031442982685384327L;

	@ApiObjectField(description="rfc")
	private String rfc;
	
	@ApiObjectField(description="validezObligaciones")
	private Boolean validezObligaciones;
	
	@ApiObjectField(description="estatusCertificado")
	private String estatusCertificado;
	
	@ApiObjectField(description="noCertificado")
	private String noCertificado;
	
	@ApiObjectField(description="inicioVigencia")
	private String inicioVigencia;
	
	@ApiObjectField(description="finVigencia")
	private String finVigencia;
	
		
}
