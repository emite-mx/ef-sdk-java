package mx.emite.sdk.ret10.comp.fideicomisonoempresarial;

import java.math.BigDecimal;

import javax.validation.Valid;
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
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeduccOSalidas")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class DeduccOSalidas {

	/**
	 *  montTotEgresPeriodo Atributo requerido para expresar el importe total de los egresos del periodo de fideicomiso que no realizan actividades empresariales
	 */
	@XmlAttribute(required = true,name="MontTotEgresPeriodo")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montTotEgresPeriodo;
	
	
	/**
	 *  partPropDelFideicom Atributo requerido para expresar la parte proporcional de las deducciones autorizadas del periodo que corresponden al fideicomisario o fideicomitente
	 */
	@XmlAttribute(required = true,name="PartPropDelFideicom")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal partPropDelFideicom;
	
	/**
	 *  propDelMontTot Atributo requerido para expresar la proporción de participación del fideicomisario o fideicomitente de acuerdo al contrato
	 */
	@XmlAttribute(required = true,name="PropDelMontTot")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal propDelMontTot;
	
	
	/**
	 *  integracEgresos Nodo requerido para expresar la integración de las deducciones en los ingresos obtenidos por fideicomisos que no realizan actividades empresariales
	 */
	@XmlElement(name="IntegracEgresos",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial")
	@Valid @NotNull
	private IntegracEgresos integracEgresos;
	
}
