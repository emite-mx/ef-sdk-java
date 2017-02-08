package mx.emite.sdk.cfdi32.comp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.adaptadores.EstadosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.PaisesSatAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "c_Ubicacion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TUbicacion32{

	
	@XmlAttribute
	@NotNull
	protected String calle;
	
	@XmlAttribute
	@NotNull
	@Size(min=5,max=10)
	protected String codigoPostal;
	
	@XmlAttribute
	protected String colonia;
	
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(EstadosAdapter.class)
	@NotNull
	protected Estados estado;
	
	@XmlAttribute
	protected String localidad;
	
	@XmlAttribute
	@NotNull
	protected String municipio;
	
	@XmlAttribute
	protected String noExterior;
	
	@XmlAttribute
	protected String noInterior;
	
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(PaisesSatAdapter.class)
	@NotNull
	protected Paises pais;
	
	@XmlAttribute
	protected String referencia;

	
}
