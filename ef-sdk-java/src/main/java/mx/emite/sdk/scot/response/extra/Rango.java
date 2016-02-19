package mx.emite.sdk.scot.response.extra;

import java.math.BigDecimal;

import lombok.Data;
/**
 * 
 *  <h1>Datos sobre tarifas con rangos</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
@Data
public class Rango {

	
	/**
	 * @return limite inferior de timbres consumidos
	 */
	private Integer desde;
	
	/**
	 * @return limite superior de timbres consumidos
	 */
	private Integer hasta;

	/**
	 * @return precio unitario sin iva dentro del rango
	 */
	private BigDecimal precio;

	
	
	
	
	
	
	

}
