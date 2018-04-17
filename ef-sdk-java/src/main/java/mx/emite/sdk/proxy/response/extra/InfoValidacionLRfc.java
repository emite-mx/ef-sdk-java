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
@ApiObject(description="infovalidacionlrfc")
public class InfoValidacionLRfc implements Serializable{
	
	
	private static final long serialVersionUID = -9090225383493699928L;

	@ApiObjectField(description="rfc")
	private String rfc;
	
	@ApiObjectField(description="sncf")
	private Boolean sncf;
	
	@ApiObjectField(description="subcontratacion")
	private Boolean subcontratacion;
	
		
}
