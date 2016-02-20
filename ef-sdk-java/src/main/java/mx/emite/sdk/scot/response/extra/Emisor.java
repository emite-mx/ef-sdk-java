package mx.emite.sdk.scot.response.extra;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.emite.sdk.enums.TipoIntegradorEmisor;

/**
 * 
 *  <h1>Información de un emisor</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
@Data
public class Emisor {

	
	/**
	 * @return Rfc del Emisor
	 */
	private String rfc;

	/**
	 * @return Tipo de Emisor
	 */
	private TipoIntegradorEmisor tipoEmisor;
	
	
	/**
	 * @return si el emisor esta habilitado o no
	 */
	private Boolean habilitado;
	
	
	/**
	 * @return correo electrónico del emisor
	 */
	private String correo;
	
	
	/**
	 * @return usuario de consumo de Ws
	 */
	private String usuarioWs;

	/**
	 * @return Contraseña de consumo de WS
	 */
	private String contrasenaWs;


	/**
	 * @return Lista de timbres asignados al emisor
	 */
	private List<Timbre> timbres = new ArrayList<Timbre>();
	
	
	
	

	
	
}
