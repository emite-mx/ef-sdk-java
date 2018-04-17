package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Cp;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.cfdi33.FormasPago33;
import mx.emite.sdk.enums.sat.cfdi33.MetodosPago33;
import mx.emite.sdk.enums.sat.cfdi33.RegimenesFiscales33;
import mx.emite.sdk.enums.sat.cfdi33.UsosCfdi33;
import mx.emite.sdk.serializers.EstadosSerializer;
import mx.emite.sdk.serializers.FormasPago33Serializer;
import mx.emite.sdk.serializers.MetodosPago33Serializer;
import mx.emite.sdk.serializers.PaisesSerializer;
import mx.emite.sdk.serializers.RegimenesFiscales33Serializer;
import mx.emite.sdk.serializers.UsosCfdi33Serializer;

@Data
@Builder
@AllArgsConstructor
public class EmisoresModificacionRequest  {

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
	 *  correo electrónico
	 */
	@NotNull @Email	@NotEmpty
	private String correo;
	
	/**
	 *  razon Social 
	 */
	@NotNull @NotEmpty
	public String razonSocial;
	
	
	/**
	 *  calle
	 */
	@NotNull @NotEmpty
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
	@Size(min=5,max=5) @Cp @NotNull @NotEmpty
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
	@NotNull @NotEmpty
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
	public Paises idPais=Paises.getDefault();
	
	/**
	 *  regimen
	 */
	@NotNull
	@JsonSerialize(using=RegimenesFiscales33Serializer.class)
	public RegimenesFiscales33 idRegimen;
	
	@NotNull
	@JsonSerialize(using=FormasPago33Serializer.class)
	public FormasPago33 idFormaPago;
	
	@NotNull
	@JsonSerialize(using=MetodosPago33Serializer.class)
	public MetodosPago33 idMetodoPago;
	
	@NotNull
	@JsonSerialize(using=UsosCfdi33Serializer.class)
	public UsosCfdi33 usocfdi;
	
	
	/**
	 *  número de cuenta pago
	 */
	@NotNull @NotEmpty
	public String cuentapago;
	
	/**
	 *  nombre de la plantilla
	 */
	@Size(max=100)
	public String plantilla;
	
	/**
	 *  si utiliza tarifa especial
	 */
	public Integer idTarifa;

	
	public static EmisoresModificacionRequest nuevo() {
		return builder().build();
	}
	
	
	public EmisoresModificacionRequest() {
		idPais=Paises.getDefault();	
	}

	 


	 
	
}
