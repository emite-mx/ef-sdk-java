package mx.emite.sdk.cfdi32;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.adaptadores.EstadosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.PaisesAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TUbicacionFiscal{

	@XmlAttribute
	@NotNull
	protected String calle;
	
	@XmlAttribute
	protected String noExterior;
	
	@XmlAttribute
	protected String noInterior;

	@XmlAttribute(required = true)
	@NotNull
	@Digits(integer=5, fraction = 0) @Size(min=4,max=5)
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

	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(PaisesAdapter.class)
	@NotNull
	protected Paises pais;
	
	@XmlAttribute
	protected String referencia;

	
}
