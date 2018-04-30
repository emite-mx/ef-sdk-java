package mx.emite.sdk.cfdi33.complementos.ter11;

import java.io.Serializable;

import javax.validation.constraints.Digits;
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
import mx.emite.sdk.enums.sat.Estados12;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.adaptadores.EstadosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.PaisesAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformacionFiscalTercero11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class InformacionFiscalTercero implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5674491550338468107L;

	@XmlAttribute
	@NotNull
	protected String calle;
	
	@XmlAttribute
	protected String noExterior;
	
	@XmlAttribute
	protected String noInterior;
	
	@XmlAttribute
	protected String colonia;
	
	@XmlAttribute
	protected String localidad;
	
	@XmlAttribute
	protected String referencia;
	
	@XmlAttribute
	@NotNull
	protected String municipio;
	
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(EstadosAdapter.class)
	@NotNull
	protected Estados12 estado;
	
	
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(PaisesAdapter.class)
	@NotNull
	protected Paises pais;
	
	
	@XmlAttribute
	@NotNull
	@Digits(integer=5, fraction = 0) @Size(min=4,max=5)
	protected String codigoPostal;
	
	
	
	
	
}
