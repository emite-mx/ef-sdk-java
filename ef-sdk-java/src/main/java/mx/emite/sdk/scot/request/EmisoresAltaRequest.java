package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.cfdi32.validadores.Cp;
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
	 *  token
	 *            Token del <b>Integrador</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull
	private String token;
	
	
	/**
	 *  rfc del emisor, si se deja en blanco se consultan todos los emisores	
	 */
	@Rfc
	@NotNull
	private String rfc;
	
	/**
	 *  tipo de emisor
	 */
	@NotNull
	private TipoIntegradorEmisor tipoEmisor;
	
	/**
	 *  usuario WS
	 */
	@NotNull
	private String usuario;
	
	/**
	 *  contrasena WS
	 */
	@NotNull
	private String contrasena;
	
	/**
	 *  correo electrónico
	 */
	@NotNull @Email	
	private String correo;
	
	/**
	 *  razon Social 
	 */
	@NotNull
	public String razonSocial;
	
	
	/**
	 *  calle
	 */
	@NotNull
	public String calle;
		
	/**
	 *  numero exterior
	 */
	public String noext;
		
	/**
	 *  numero interior
	 */
	public String noint;
		
	/**
	 *  cp
	 */
	@Size(min=5,max=5) @Cp @NotNull
	public String cp;
		
	/**
	 *  colonia
	 */
	public String colonia;
		
	/**
	 *  referencias
	 */
	public String referencias;
		
	/**
	 *  localidad
	 */
	public String localidad;
		
	/**
	 *  municipio
	 */
	@NotNull
	public String municipio;
		
	/**
	 *  estado
	 */
	@NotNull
	@JsonSerialize(using=EstadosSerializer.class)
	public Estados idEstado;
		
	/**
	 *  pais
	 */
	@NotNull
	@JsonSerialize(using=PaisesSerializer.class)
	public Paises idPais=Paises.MEXICO ;
	
	/**
	 *  regimen
	 */
	@NotNull
	@JsonSerialize(using=RegimenesSerializer.class)
	public RegimenesFiscales idRegimen;
	
	/**
	 *  forma de pago
	 */
	@NotNull
	@JsonSerialize(using=FormasPagoSerializer.class)
	public FormasPago idFormaPago;
	
	/**
	 *  número de cuenta pago
	 */
	@NotNull
	public String cuentapago;
	
	/**
	 *  modificar si el rfc ya se encuentra dado de alta
	 */
	@NotNull
	public Boolean modificar;

	

	 
	
}
