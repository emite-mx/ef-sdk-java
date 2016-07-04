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
@XmlType(name = "IngresosOEntradas")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class IngresosOEntradas {

	/**
	 * @param montTotEntradasPeriodo Atributo requerido para expresar el importe total de los ingresos del periodo de los fideicomisos que no realizan actividades empresariales
	 */
	@XmlAttribute(required = true,name="MontTotEntradasPeriodo")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montTotEntradasPeriodo;
	
	
	/**
	 * @param partPropAcumDelFideicom Atributo requerido para expresar la parte proporcional de los ingresos acumulables del periodo que correspondan al fideicomisario o fideicomitente
	 */
	@XmlAttribute(required = true,name="PartPropAcumDelFideicom")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal partPropAcumDelFideicom;
	
	/**
	 * @param propDelMontTot Atributo requerido para expresar la proporción de participación del fideicomisario o fideicomitente de acuerdo al contrato
	 */
	@XmlAttribute(required = true,name="PropDelMontTot")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal propDelMontTot;
	
	
	/**
	 * @param integracIngresos Nodo requerido para expresar el detalle de la integración de los ingresos obtenidos en el periodo por fideicomisos que no realizan actividades empresariales
	 */
	@XmlElement(name="IntegracIngresos",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial")
	@Valid @NotNull
	private IntegracIngresos integracIngresos;
	
}
