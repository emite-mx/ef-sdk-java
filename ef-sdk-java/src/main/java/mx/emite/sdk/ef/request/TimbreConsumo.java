package mx.emite.sdk.ef.request;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class TimbreConsumo {

	private Boolean esCancelacion;

	@NotEmpty
	private String xml;
	
	
	@NotEmpty
	private String uuid;
	

	
	
	
}
