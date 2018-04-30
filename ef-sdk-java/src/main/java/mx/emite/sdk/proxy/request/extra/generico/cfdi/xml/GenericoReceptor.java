package mx.emite.sdk.proxy.request.extra.generico.cfdi.xml;



import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.enums.sat.Estados12;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.adaptadores.EstadosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.PaisesAdapter;


@Data
@Builder @NoArgsConstructor @AllArgsConstructor
@XmlRootElement(name="GenericoReceptorCfdi")
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericoReceptor {

	@XmlAttribute(name="rfc")
	@NotNull @Rfc
	protected String rfc;
	
	@XmlAttribute(name="nombre")
	@NotNull 
	protected String nombre;
	
	@XmlAttribute(name="calle")
	@NotNull
	protected String calle;
	
	@XmlAttribute(name="cp")
	@NotNull
	@Digits(integer=5, fraction = 0) @Size(min=4,max=5)
	protected String cp;
	
	@XmlAttribute(name="colonia")
	protected String colonia;
	
	@XmlAttribute(name="estado")
	@XmlJavaTypeAdapter(EstadosAdapter.class)
	@NotNull
	protected Estados12 estado;
	
	@XmlAttribute(name="localidad")
	protected String localidad;
	
	@XmlAttribute(name="municipio")
	@NotNull
	protected String municipio;
	
	@XmlAttribute(name="noExterior")
	protected String noExterior;
	
	@XmlAttribute(name="noInterior")
	protected String noInterior;
	
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(PaisesAdapter.class)
	@NotNull
	protected Paises pais;
	
	@XmlAttribute
	protected String referencia;
	
}
