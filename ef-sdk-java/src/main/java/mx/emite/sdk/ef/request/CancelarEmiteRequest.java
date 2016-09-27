package mx.emite.sdk.ef.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;


@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=false)
@Builder
public class CancelarEmiteRequest  {

	@NotNull
	private String tokenWs;
	
	@NotNull
	private String pfx;

	@NotNull
	private String contrasenaPfx;
	
	@NotNull
	@Rfc
	private String rfc;
	
	@NotEmpty
	@Singular
	private List<String> uuids;
	
	

	
	

	 
	
}
