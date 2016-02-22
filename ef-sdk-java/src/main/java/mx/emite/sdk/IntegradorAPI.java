package mx.emite.sdk;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.integradores.Emisores;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresAlta;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresCsd;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresCsdConsulta;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresEstatus;
import mx.emite.sdk.clientes.operaciones.integradores.Sucursales;
import mx.emite.sdk.clientes.operaciones.integradores.Timbres;
import mx.emite.sdk.clientes.operaciones.integradores.Token;
import mx.emite.sdk.enums.Ambiente;


/**
 * @author enrique
 *
 *	IntegradorAPI es la clase principal de consumo de Integradores
 *
 *	
 */
public class IntegradorAPI {

	
	private final ClienteJson cliente;
	
	private final Timbres timbres;
	private final Token token;
	private final Emisores emisores;
	private final Sucursales sucursales;
	private final EmisoresAlta emisoresalta;
	private final EmisoresCsd emisorescsd;
	private final EmisoresCsdConsulta emisorescsdconsulta;
	private final EmisoresEstatus emisoresestatus;
	
	/**
	 * Se crea un objeto de tipo api, mediante el cual se ejecutarán todos los servicios implementados
	 * 
	 * @param ambiente 
	 * <h3>PRODUCCION</h3><p>Ambiente productivo</p>
	 * <h3>PRUEBAS</h3><p>Ambiente de pruebas</p>
	 * <h3>LOCAL</h3><p>Ambiente de uso exclusivo emite</p>
	 * @see Ambiente
	 * @since 0.0.3
	 */
	public IntegradorAPI(final Ambiente ambiente){
		this.cliente=new ClienteJson(ambiente);
		this.timbres=new Timbres(this.cliente);
		this.token=new Token(this.cliente);
		this.emisores=new Emisores(this.cliente);
		this.sucursales=new Sucursales(this.cliente);
		this.emisoresalta=new EmisoresAlta(this.cliente);
		this.emisorescsd=new EmisoresCsd(this.cliente);
		this.emisorescsdconsulta=new EmisoresCsdConsulta(this.cliente);
		this.emisoresestatus=new EmisoresEstatus(this.cliente);
	}
	
	/**
	 * Servicio consulta de tarifa y timbres asignados
	 * @return timbres
	 * @since 0.0.3
	 */
	public Timbres timbres(){
		return timbres;
	}

	/**
	 * Servicio de generación de token para consumo de integrador
	 * @return token
	 * @since 0.0.3
	 */
	public Token token() {
		return token;
	}

	/**
	 * Servicio de consulta de emisores
	 * @return emisores
	 * @since 0.0.4
	 */
	public Emisores emisores() {
		return emisores;
	}
	
	/**
	 * Servicio de consulta de sucursales
	 * @return sucursales
	 * @since 0.0.4
	 */
	public Sucursales sucursales() {
		return sucursales;
	}
	
	/**
	 * Servicio de alta / modificación de emisores
	 * @return emisoresalta
	 * @since 0.0.4
	 */
	public EmisoresAlta emisoresalta() {
		return emisoresalta;
	}
	
	/**
	 * Servicio de carga de CSD
	 * @return emisorescsd
	 * @since 0.0.4
	 */
	public EmisoresCsd emisorescsd() {
		return emisorescsd;
	}
	
	/**
	 * Servicio de consulta CSD
	 * @return emisorescsdconsulta
	 * @since 0.0.4
	 */
	public EmisoresCsdConsulta emisorescsdconsulta() {
		return emisorescsdconsulta;
	}
	
	/**
	 * Servicio de consulta de estatus de emisores
	 * @return emisoresestatus
	 * @since 0.0.4
	 */
	public EmisoresEstatus emisoresestatus() {
		return emisoresestatus;
	}
}
