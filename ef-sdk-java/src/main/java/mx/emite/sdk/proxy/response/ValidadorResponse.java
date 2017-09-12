package mx.emite.sdk.proxy.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.proxy.response.extra.InfoValidacion;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
@AllArgsConstructor @Builder
public class ValidadorResponse extends ProxyResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2329094578765391410L;

	private Integer timbresRestantes;
	
	private String pdf;
	
	
	private Boolean valido=false;
	
	private InfoValidacion info;

	public boolean es32() {
		return info!=null && info.getVersion()!=null && info.getVersion().compareTo(new BigDecimal("3.2"))==0;
	}
	
	public static ValidadorResponse nuevo() {
		return builder().build();
	}
	
	
	public ValidadorResponse() {
		valido=false;	
	}

	
	
	
	
}
