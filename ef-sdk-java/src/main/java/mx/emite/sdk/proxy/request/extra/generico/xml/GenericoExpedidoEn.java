package mx.emite.sdk.proxy.request.extra.generico.xml;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.adaptadores.EstadosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.PaisesAdapter;

@Data
public class GenericoExpedidoEn {

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
	protected Estados estado;
	
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
