package mx.emite.sdk.enums;



/**
 *  <h1>Lista de ambientes disponibles para consumo de servicios</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public enum Ambiente {

	PRUEBAS,
	PRODUCCION,
	/**
	 * @deprecated Ambiente de uso exclusivo EmiteFacturacion
	 */
	@Deprecated
	LOCAL
	;
	
	
}
