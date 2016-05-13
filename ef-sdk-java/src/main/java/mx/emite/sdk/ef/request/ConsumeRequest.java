package mx.emite.sdk.ef.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;


@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ConsumeRequest {

	private String tokenEmite;
	
	/**
	 * @param  tokenConsumo token de consumo
	 */
	@NotNull
	private String tokenConsumo;

	/**
	 * @param  consumeTimbre si el timbre se va a consumir o no
	 */
	@NotNull
	private Boolean consumeTimbre;	
	
	
	/**
	 * @param  timbres lista de timbres a consumir
	 */	
	@NotEmpty
	@Singular("timbre")
	private List<TimbreConsumo> timbres;
	
 
	
}
