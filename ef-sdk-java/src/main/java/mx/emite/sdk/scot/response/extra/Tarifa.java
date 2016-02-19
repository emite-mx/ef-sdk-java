package mx.emite.sdk.scot.response.extra;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import mx.emite.sdk.enums.TipoTarifas;
import mx.emite.sdk.enums.TipoTimbres;

/**
 * 
 *  <h1>Tarifa</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */

@Data
public class Tarifa {

	/**
	 * @return el tipo de timbre que cubre esta tarifa
	 */
	private TipoTimbres tipoTimbre;

	/**
	 * @return tipo de tarifa asignada al integrador
	 */
	private TipoTarifas tipoTarifa;
	
	/**
	 * @return precio unitario sin iva por timbre
	 */
	private BigDecimal precio;
	
	/**
	 * @return para casos de tarifas con rangos
	 */
	private List<Rango> rangos;
	
	/**
	 * @return para casos de tarifas con mensualidad
	 */
	private Mensualidad mensualidad;
	
	
	public Tarifa() {
		super();
	}

	


	

}
