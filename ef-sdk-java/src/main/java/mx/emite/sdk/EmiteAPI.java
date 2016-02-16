package mx.emite.sdk;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Servicios;
import mx.emite.sdk.clientes.operaciones.Timbrador32;
import mx.emite.sdk.enums.Ambiente;


/**
 * @author enrique
 *
 *	EmiteAPI es la clase principal de consumo
 *
 *	
 */
public class EmiteAPI {

	
	private final ClienteJson cliente;
	
	private final Servicios servicios;
	private final Timbrador32 timbrador32;
	
	/**
	 * Se crea un objeto de tipo api, mediante el cual se ejecutarán todos los servicios implementados
	 * 
	 * @param ambiente 
	 * <h3>PRODUCCION</h3><p>Ambiente productivo</p>
	 * <h3>PRUEBAS</h3><p>Ambiente de pruebas</p>
	 * <h3>LOCAL</h3><p>Ambiente de uso exclusivo emite</p>
	 * @see Ambiente
	 */
	public EmiteAPI(final Ambiente ambiente){
		this.cliente=new ClienteJson(ambiente);
		this.servicios=new Servicios(this.cliente);
		this.timbrador32=new Timbrador32(this.cliente);
	}
	
	public Servicios servicios(){
		return servicios;
	}

	public Timbrador32 timbrador32(){
		return timbrador32;
	}
	
}
