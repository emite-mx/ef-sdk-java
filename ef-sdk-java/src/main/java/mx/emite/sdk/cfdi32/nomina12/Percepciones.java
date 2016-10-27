package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Percepciones")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Percepciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6456188308509936700L;
	
	/**
	 * totalSueldos Atributo condicional para expresar el total de percepciones brutas (gravadas y exentas) por sueldos y salarios y conceptos asimilados a salarios.
	 */
	@XmlAttribute(name="TotalSueldos")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
    private BigDecimal totalSueldos;
	
	/**
	 * totalSeparacionIndemnizacion Atributo condicional para expresar el importe exento y gravado de las claves tipo percepción 022 Prima por Antigüedad, 023 Pagos por separación y 025 Indemnizaciones.
	 */
	@XmlAttribute(name="TotalSeparacionIndemnizacion")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
    private BigDecimal totalSeparacionIndemnizacion;
	
	/**
	 * totalJubilacionPensionRetiro Atributo condicional para expresar el importe exento y gravado de las claves tipo percepción 039 Jubilaciones, pensiones o haberes de retiro en una exhibición y 044 Jubilaciones, pensiones o haberes de retiro en parcialidades.
	 */
	@XmlAttribute(name="TotalJubilacionPensionRetiro")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
    private BigDecimal totalJubilacionPensionRetiro;
	
	
	/**
	 * totalGravado Atributo requerido para expresar el total de percepciones gravadas que se relacionan en el comprobante.
	 */
	@XmlAttribute(name="TotalGravado")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
    private BigDecimal totalGravado;
	
	/**
	 * totalExento Atributo requerido para expresar el total de percepciones exentas que se relacionan en el comprobante.
	 */
	@XmlAttribute(name="TotalExento")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
    private BigDecimal totalExento;
	
	
	/**
	 * percepciones Nodo requerido para expresar la información detallada de una percepcion
	 */
    @XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="Percepcion")
    @Singular(value="percepcion") @Valid @NotEmpty
    private List<Percepcion> percepciones;

    
    /**
	 * jubilacionPensionRetiro Nodo condicional para expresar la información detallada de pagos por jubilación, pensiones o haberes de retiro.
	 */
    @XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="JubilacionPensionRetiro")
    @Valid
    private JubilacionPensionRetiro jubilacionPensionRetiro;
	
    /**
   	 * separacionIndemnizacion Nodo condicional para expresar la información detallada de otros pagos por separación.
   	 */
    @XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="SeparacionIndemnizacion")
    @Valid
    private SeparacionIndemnizacion separacionIndemnizacion;

    
}
