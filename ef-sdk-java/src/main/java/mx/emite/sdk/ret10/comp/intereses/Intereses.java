package mx.emite.sdk.ret10.comp.intereses;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.ret10.comp.ComplementoInterface;

@XmlRootElement(name="Intereses",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/intereses")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Intereses")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Intereses extends ComplementoInterface{

	/**
	 * @param version Atributo requerido con valor prefijado que indica la versión del complemento de intereses obtenidos en el periodo o ejercicio
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	/**
	 * @param sistFinanciero Atributo requerido para expresar si los interés obtenidos en el periodo o ejercicio provienen del sistema financiero
	 */
	@XmlAttribute(name="SistFinanciero")
	@NotNull  @Pattern(regexp="(SI|NO)",message="debe ser SI o NO")
	private String sistFinanciero;
	
	
	/**
	 * @param retiroAORESRetInt Atributo requerido para expresar si los intereses obtenidos fueron retirados en el periodo o ejercicio
	 */
	@XmlAttribute(name="RetiroAORESRetInt")
	@NotNull  @Pattern(regexp="(SI|NO)",message="debe ser SI o NO")
	private String retiroAORESRetInt;
	
	/**
	 * @param operFinancDerivad Atributo requerido para expresar si los intereses obtenidos corresponden a operaciones financieras derivadas.
	 */
	@XmlAttribute(name="OperFinancDerivad")
	@NotNull  @Pattern(regexp="(SI|NO)",message="debe ser SI o NO")
	private String operFinancDerivad;
	
	/**
	 * @param montIntNominal Atributo requerido para expresar el importe del interés Nóminal obtenido en un periodo o ejercicio
	 */
	@XmlAttribute(required = true,name="MontIntNominal")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montIntNominal;
	
	/**
	 * @param montIntReal Atributo requerido para expresar el monto de los intereses reales (diferencia que se obtiene restando al tipo de interés nominal y la tasa de inflación del periodo o ejercicio )
	 */
	@XmlAttribute(required = true,name="MontIntReal")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montIntReal;
	
	/**
	 * @param perdida Atributo requerido para expresar la pérdida por los intereses obtenidos en el periodo o ejercicio
	 */
	@XmlAttribute(required = true,name="Perdida")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal perdida;
	

	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/intereses http://www.sat.gob.mx/esquemas/retencionpago/1/intereses/intereses.xsd";
	}
	
	
}
