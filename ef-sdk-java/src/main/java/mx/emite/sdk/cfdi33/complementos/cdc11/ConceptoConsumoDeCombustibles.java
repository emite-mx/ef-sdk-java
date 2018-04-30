package mx.emite.sdk.cfdi33.complementos.cdc11;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.Importe3Adapter;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConceptoConsumoDeCombustibles11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class ConceptoConsumoDeCombustibles implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2876304239140051349L;

	@XmlAttribute(name="identificador")
	private String identificador;

	@XmlAttribute(name="fecha",required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@NotNull
	protected LocalDateTime fecha;

	@XmlAttribute(name="rfc")
	private String rfc;
	
	@XmlAttribute(name="claveEstacion")
	private String claveEstacion;
	
	@XmlAttribute(name="tipoCombustible")
	private String tipoCombustible;
	
	@XmlAttribute(name="cantidad")
	@XmlJavaTypeAdapter(Importe3Adapter.class)
	private BigDecimal cantidad;
	
	@XmlAttribute(name="nombreCombustible")
	private String nombreCombustible;

	@XmlAttribute(name="folioOperacion")
	private String folioOperacion;
	
	@XmlAttribute(name="valorUnitario")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal valorUnitario;
	
	@XmlAttribute(name="importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal importe;
	
	@XmlElement(name="Determinados", namespace = ConsumoDeCombustibles11.NAMESPACE)
	private Determinados determinado;
	
	
}
