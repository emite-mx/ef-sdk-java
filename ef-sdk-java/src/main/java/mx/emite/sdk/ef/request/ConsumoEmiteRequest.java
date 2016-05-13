package mx.emite.sdk.ef.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.TipoCobros;
import mx.emite.sdk.enums.TipoIntegradorEmisor;
import mx.emite.sdk.enums.TipoTimbres;


@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ConsumoEmiteRequest  {

	@NotNull
	private String tokenEmite;
	
	@NotNull
	private Integer idIntegrador;
	
	
	@NotNull
	private Integer idEmisor;
	
	
	private Integer idSucursal;
	
	
	@NotNull
	private TipoTimbres tipoTimbre;
	
	
	@NotNull
	private TipoIntegradorEmisor tipoIntegrador;
	
	
	@NotNull
	private TipoIntegradorEmisor tipoEmisor;
	
	
	@NotNull
	private TipoCobros tipoCobro;
	
	
	@NotNull
	private Boolean esCancelacion;

	@NotEmpty
	private String xml;
	
	@NotEmpty
	private String uuid;
	
	

	
	
	
	
	

	 
	
}
