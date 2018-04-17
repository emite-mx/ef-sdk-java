package mx.emite.sdk.scot.request.extra;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Cp;
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
public class SucursalInfo {
 
	/**
	 *  nombre de la sucursal (único por emisor)
	 */
	@NotNull @Size(max=100) @NotEmpty
	private String nombre;
	
	/**
	 *  razonSocialRazón Social de la sucursal 
	 */
	@NotNull @Size(max=100) @NotEmpty
	public String razonSocial;
	
	
	/**
	 *  calle Calle de la sucursal
	 */
	@NotNull @Size(max=100) @NotEmpty
	public String calle;
		
	/**
	 *  noext No. exterior de la sucursal
	 */
	@Size(max=100)
	public String noext;
		
	/**
	 *  noint No. interior de la sucursal
	 */
	@Size(max=100)
	public String noint;
		
	/**
	 *  cp Código postal de la sucursal 
	 */
	@Size(min=5,max=5) @Cp @NotNull @NotEmpty
	public String cp;
		
	/**
	 *  colonia Colonia de la sucursal
	 */
	@Size(max=100)
	public String colonia;
		
	/**
	 *  referencias Referencias de la sucursal
	 * 
	 */
	@Size(max=100)
	public String referencias;
		
	/**
	 *  localidad Localidad de la sucursal
	 */
	@Size(max=50)
	public String localidad;
		
	/**
	 *  municipio Municipio / de laegación de la sucursal
	 */
	@NotNull @Size(max=50) @NotEmpty
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
	
	public Paises idPais=Paises.MEXICO;
	 
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
	 *  correo Buzón de correo de la sucursal 
	 */
	@Email @NotNull @NotEmpty
	public String correo;
	


	public static SucursalInfo nuevo() {
		return builder().build();
	}
	
	
	public SucursalInfo() {
		idPais=Paises.MEXICO;	
	}

	
	
}
