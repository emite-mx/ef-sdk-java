package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
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
@XmlType(name = "Deducciones")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Deducciones implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2592267276524033821L;

	
	/**
	 * totalOtrasDeducciones Atributo condicional para expresar el total de deducciones que se relacionan en el comprobante, donde la clave de tipo de deducción sea distinta a la 002 correspondiente a ISR.
	 */
	@XmlAttribute(name="TotalOtrasDeducciones")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
    private BigDecimal totalOtrasDeducciones;
	
	/**
	 * totalImpuestosRetenidos Atributo condicional para expresar el total de los impuestos federales retenidos, es decir, donde la clave de tipo de deducción sea 002 correspondiente a ISR.
	 */
	@XmlAttribute(name="TotalImpuestosRetenidos")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
    private BigDecimal totalImpuestosRetenidos;
	
	/**
	 * percepciones Nodo requerido para expresar la información detallada de una deduccion
	 */
    @XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Deduccion")
    @Singular(value="deduccion") @Valid @NotEmpty
    private List<Deduccion> deducciones;

   

    
}
