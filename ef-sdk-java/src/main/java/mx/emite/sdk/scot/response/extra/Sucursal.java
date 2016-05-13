package mx.emite.sdk.scot.response.extra;

import lombok.Data;
import mx.emite.sdk.enums.TipoIntegradorEmisor;

@Data
public class Sucursal {

	
	/**
	 * @return Nombre de la sucursal
	 */
	private String nombre;
	
	
	/**
	 * @return Rfc de la sucursal
	 */
	private String rfc;
	
	
	/**
	 * @return tipo de emisor
	 */
	private TipoIntegradorEmisor tipoEmisor;
	
	
	/**
	 * @return si el emisor esta habilitado
	 */
	private Boolean emisorHabilitado;
	
	
	/**
	 * @return si la sucursal esta habilitada
	 */
	private Boolean sucursalHabilitada;
	
	



	
	
}
