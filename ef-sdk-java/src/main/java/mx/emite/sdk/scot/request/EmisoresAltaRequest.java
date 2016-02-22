package mx.emite.sdk.scot.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.enums.TipoIntegradorEmisor;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.FormasPago;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.serializers.EstadosSerializer;
import mx.emite.sdk.serializers.FormasPagoSerializer;
import mx.emite.sdk.serializers.PaisesSerializer;
import mx.emite.sdk.serializers.RegimenesSerializer;

@Data
@Builder
public class EmisoresAltaRequest  {

	
	/**
	 * Token del <b>Integrador</b> obtenido con el servicio de Token 
	 * -- SETTER --
	 * 
	 * @param token
	 *            Token del <b>Integrador</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull
	private String token;
	
	
	/**
	 * @param rfc del emisor, si se deja en blanco se consultan todos los emisores	
	 */
	@Rfc
	@NotNull
	private String rfc;
	
	/**
	 * @param tipo de emisor
	 */
	@NotNull
	private TipoIntegradorEmisor tipoEmisor;
	
	/**
	 * @param usuario WS
	 */
	@NotNull
	private String usuario;
	
	/**
	 * @param contrasena WS
	 */
	@NotNull
	private String contrasena;
	
	/**
	 * @param correo electrónico
	 */
	@NotNull @Email	
	private String correo;
	
	/**
	 * @param razon Social 
	 */
	@NotNull
	public String razonSocial;
	
	
	/**
	 * @param calle
	 */
	@NotNull
	public String calle;
		
	/**
	 * @param numero exterior
	 */
	public String noext;
		
	/**
	 * @param numero interior
	 */
	public String noint;
		
	/**
	 * @param cp
	 */
	@Digits(fraction = 0, integer = 5) @Size(min=4,max=5)
	public String cp;
		
	/**
	 * @param colonia
	 */
	public String colonia;
		
	/**
	 * @param referencias
	 */
	public String referencias;
		
	/**
	 * @param localidad
	 */
	public String localidad;
		
	/**
	 * @param municipio
	 */
	@NotNull
	public String municipio;
		
	/**
	 * @param estado
	 */
	@NotNull
	@JsonSerialize(using=EstadosSerializer.class)
	public Estados idEstado;
		
	/**
	 * @param pais
	 */
	@NotNull
	@JsonSerialize(using=PaisesSerializer.class)
	public Paises idPais=Paises.MEXICO ;
	
	/**
	 * @param regimen
	 */
	@NotNull
	@JsonSerialize(using=RegimenesSerializer.class)
	public RegimenesFiscales idRegimen;
	
	/**
	 * @param forma de pago
	 */
	@NotNull
	@JsonSerialize(using=FormasPagoSerializer.class)
	public FormasPago idFormaPago;
	
	/**
	 * @param número de cuenta pago
	 */
	@NotNull
	public String cuentapago;
	
	/**
	 * @param modificar si el rfc ya se encuentra dado de alta
	 */
	@NotNull
	public Boolean modificar;

	

	 
	
}
