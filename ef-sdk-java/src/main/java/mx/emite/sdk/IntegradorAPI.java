package mx.emite.sdk;

import java.time.LocalDateTime;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.integradores.Emisores;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresAlta;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresCsd;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresCsdConsulta;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresDocumentos;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresEstatus;
import mx.emite.sdk.clientes.operaciones.integradores.EmisoresModificacion;
import mx.emite.sdk.clientes.operaciones.integradores.Sucursales;
import mx.emite.sdk.clientes.operaciones.integradores.SucursalesAlta;
import mx.emite.sdk.clientes.operaciones.integradores.SucursalesModificacion;
import mx.emite.sdk.clientes.operaciones.integradores.SucursalesNombre;
import mx.emite.sdk.clientes.operaciones.integradores.Timbres;
import mx.emite.sdk.clientes.operaciones.integradores.Token;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.scot.request.TokenRequest;
import mx.emite.sdk.scot.response.TokenResponse;


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
	private final EmisoresModificacion emisoresmodificacion;
	private final EmisoresCsd emisorescsd;
	private final EmisoresCsdConsulta emisorescsdconsulta;
	private final EmisoresEstatus emisoresestatus;
	private final SucursalesAlta sucursalesalta;
	private final SucursalesModificacion sucursalesmodificacion;
	private final SucursalesNombre sucursalesnombre;
	private final EmisoresDocumentos emisoresdocumentos;
	
	private String contrasena;
	private String usuario;
	
	private String tokenWs;
	private LocalDateTime expira;
	
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
		this(ambiente,null,null);
	}
	
	/**
	 * Se crea un objeto de tipo api, incluyendo credenciales 
	 * 
	 * @param ambiente 
	 * <h3>PRODUCCION</h3><p>Ambiente productivo</p>
	 * <h3>PRUEBAS</h3><p>Ambiente de pruebas</p>
	 * <h3>LOCAL</h3><p>Ambiente de uso exclusivo emite</p>
	 * @param usuario usuario de Integrador
	 * @param contrasena contraseña de Integrador
	 * @see Ambiente
	 * @since 0.0.3
	 */
	public IntegradorAPI(final Ambiente ambiente,final String usuario,final String contrasena){
		this.cliente=new ClienteJson(ambiente);
		this.timbres=new Timbres(this.cliente);
		this.token=new Token(this.cliente);
		this.emisores=new Emisores(this.cliente);
		this.sucursales=new Sucursales(this.cliente);
		this.emisoresalta=new EmisoresAlta(this.cliente);
		this.emisoresmodificacion=new EmisoresModificacion(this.cliente);
		this.emisorescsd=new EmisoresCsd(this.cliente);
		this.emisorescsdconsulta=new EmisoresCsdConsulta(this.cliente);
		this.emisoresestatus=new EmisoresEstatus(this.cliente);
		this.sucursalesalta=new SucursalesAlta(this.cliente);
		this.sucursalesmodificacion=new SucursalesModificacion(this.cliente);
		this.sucursalesnombre=new SucursalesNombre(this.cliente);
		this.emisoresdocumentos=new EmisoresDocumentos(this.cliente);
		this.usuario=usuario;
		this.contrasena=contrasena;
	}
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getTokenWs() throws ApiException{
		if(this.tokenWs==null||this.expira==null||this.expira.isBefore(LocalDateTime.now()))
		{
			if(this.usuario==null || this.contrasena==null)
				throw new ApiException(I_Api_Errores.SCOT_EMITE_USUARIO_EMISOR_CONTRASENA,"usuario / contrasaña no especificada");
			final TokenRequest tr = TokenRequest.builder()
					.usuario(this.usuario)
					.contrasena(this.contrasena)
					.build();
			final TokenResponse tokenresp = token.ejecuta(tr);
			this.tokenWs=tokenresp.getToken();
			this.expira=tokenresp.getVigenciaTermino();
		}
		return tokenWs;
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
	
	/**
	 * Servicio de alta de sucursales para emisores de postpago-sucursales
	 * @return sucursalesalta
	 * @since 0.0.4
	 */
	public SucursalesAlta sucursalesalta() {
		return sucursalesalta;
	}

	/**
	 * Servicio de carga de documentación de emisores
	 * @return emisoresdocumentos
	 * @since 0.0.5
	 */
	public EmisoresDocumentos emisoresdocumentos() {
		return emisoresdocumentos;
	}

	/**
	 * Servicio de modificación de emisores
	 * @return emisoresmodificacion
	 * @since 0.0.6
	 */
	public EmisoresModificacion emisoresmodificacion() {
		return emisoresmodificacion;
	}
	
	/**
	 * Servicio de cambio de nombre a sucursal
	 * @return sucursalesnombre
	 * @since 0.0.6
	 */
	public SucursalesNombre sucursalesnombre() {
		return sucursalesnombre;
	}
	
	/**
	 * Servicio de modificación de sucursal
	 * @return sucursalesmodificacion
	 * @since 0.0.6
	 */
	public SucursalesModificacion sucursalesmodificacion() {
		return sucursalesmodificacion;
	}
	
}
