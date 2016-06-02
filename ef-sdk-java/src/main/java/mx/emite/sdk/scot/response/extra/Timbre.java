package mx.emite.sdk.scot.response.extra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import mx.emite.sdk.enums.TipoIntegradorEmisor;
import mx.emite.sdk.enums.TipoTimbres;

@Data
public class Timbre {

	
	private TipoTimbres tipoTimbre;

	private TipoIntegradorEmisor tipoIntegrador;
	
	
	@JsonInclude(Include.NON_NULL)
	private Integer contratados;
	
	@JsonInclude(Include.NON_NULL)
	private Integer asignados;
	
	
	private Integer consumidos;
	
	
	@JsonInclude(Include.NON_NULL)
	private Integer porasignar;

	
	@JsonInclude(Include.NON_NULL)
	private Integer restantes;
	
	public Timbre() {
		super();
	}

	
	
	
}
