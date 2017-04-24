package mx.emite.sdk.cfdi32.complementos.cce11;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.T_Descrip100;
import mx.emite.sdk.cfdi32.anotaciones.T_NumeroDomicilio;
import mx.emite.sdk.cfdi32.anotaciones.T_Referencia;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.adaptadores.EstadosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.PaisesSatAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DomicilioCE11 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4764547256039567583L;

	@XmlAttribute(name="Calle")
	@T_Descrip100
	@NotNull
	private String calle;
	
	@XmlAttribute(name="NumeroExterior")
	@T_NumeroDomicilio
	private String numeroExterior;
	
	@XmlAttribute(name="NumeroInterior")
	@T_NumeroDomicilio
	private String numeroInterior;
	
	@XmlAttribute(name="Colonia")
	@Size(min=4,max=4) @Pattern(regexp="\\d{4}",message="debe de ser un código de Colonia válido")
	private String colonia;
	
	@XmlAttribute(name="Localidad")
	@Size(min=2,max=2) @Pattern(regexp="\\d{2}",message="debe de ser un código de Localidad válido")
	private String localidad;
	
	@XmlAttribute(name="Referencia")
	@T_Referencia
	private String referencia;
	
	@XmlAttribute(name="Municipio")
	@Size(min=3,max=3) @Pattern(regexp="\\d{3}",message="debe de ser un código de Municipio válido")
	private String municipio;
	
	@XmlAttribute(name="Estado")
	@XmlJavaTypeAdapter(EstadosAdapter.class)
	@NotNull
	protected Estados estado;
	
	@XmlAttribute(name="Pais")
	@XmlJavaTypeAdapter(PaisesSatAdapter.class)
	@NotNull
	protected Paises pais;
	
	@XmlAttribute(name="CodigoPostal")
	@Size(min=5,max=5) @Pattern(regexp="\\d{5}",message="debe de ser un código postal válido")
	@NotNull
	private String codigoPostal;
	
}
