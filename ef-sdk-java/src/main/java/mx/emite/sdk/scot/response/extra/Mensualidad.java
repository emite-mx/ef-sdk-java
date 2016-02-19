package mx.emite.sdk.scot.response.extra;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 
 *  <h1>Datos sobre tarifa con mensualidad</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
@Data
public class Mensualidad {

	
	/**
	 * @return Monto de la mensualidad
	 */
	private BigDecimal mensualidad;

	/**
	 * @return límite de timbres mensuales que cubren el costo de la mensualidad
	 */
	
	private Integer limiteTimbres;
	
	/**
	 * @return precio unitario sin iva de timbre adicional cuando se sobrepasa el límite de timbres mensuales 
	 */
	private BigDecimal timbreAdicional;


	

	
	
	
	

}
