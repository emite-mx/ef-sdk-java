package mx.emite.sdk.cfdi33.complementos.vdd10;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConceptoValesDeDespensa10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Concepto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 669984012672921854L;

	@XmlAttribute(name="identificador")
	private String identificador;

	@XmlAttribute(name="fecha",required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@NotNull
	protected LocalDateTime fecha;

	@XmlAttribute(name="rfc")
	private String rfc;
	
	@XmlAttribute(name="curp")
	private String curp;
	
	@XmlAttribute(name="nombre")
	private String nombre;

	@XmlAttribute(name="numSeguridadSocial")
	private String numSeguridadSocial;
	
	@XmlAttribute(name="importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal importe;
	
	
	
}
