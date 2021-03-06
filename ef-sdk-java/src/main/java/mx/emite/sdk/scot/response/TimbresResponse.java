package mx.emite.sdk.scot.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;
import mx.emite.sdk.scot.response.extra.Tarifa;
import mx.emite.sdk.scot.response.extra.Timbre;

@Getter
@Setter
@ToString(callSuper=true)
public class TimbresResponse extends ScotResponse {

	
	/**
	 * Timbre
	 * -- GETTER --
	 * Obtiene la lista de timbres asignados
	 * 
	 * @return Lista de timbres asignados al integrador
	 */
	private List<Timbre> timbres = new ArrayList<Timbre>();

	/**
	 * -- GETTER --
	 * @return Lista de tarifas asignadas al integrador
	 */
	private List<Tarifa> tarifas=new ArrayList<Tarifa>();
	
		
	
	
	
}
