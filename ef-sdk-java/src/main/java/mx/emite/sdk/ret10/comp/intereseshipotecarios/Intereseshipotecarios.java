package mx.emite.sdk.ret10.comp.intereseshipotecarios;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

@XmlRootElement(name="Intereseshipotecarios",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/intereseshipotecarios")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Intereseshipotecarios")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Intereseshipotecarios extends ComplementoInterface{

	/**
	 * @param version Atributo requerido con valor prefijado que indica la versión del complemento de intereses reales deducibles por crédito hipotecarios
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	
	/**
	 * @param creditoDeInstFinanc Atributo requerido para expresar si el crédito otorgado fue por institución financiera
	 */
	@XmlAttribute(name="CreditoDeInstFinanc")
	@NotNull  @Pattern(regexp="(SI|NO)",message="debe ser SI o NO")
	private String creditoDeInstFinanc;
	
	
	/**
	 * @param saldoInsoluto Atributo requerido para expresar el saldo insoluto al 31 de diciembre del ejercicio inmediato anterior o fecha de contratación si se llevo a cabo en el ejercicio en curso
	 */
	@XmlAttribute(required = false,name="SaldoInsoluto")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal saldoInsoluto;
	
	/**
	 * @param propDeducDelCredit Atributo opcional que expresa la proporción deducible del crédito aplicable sobre los intereses reales devengados y pagados
	 */
	@XmlAttribute(required = false,name="PropDeducDelCredit")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal propDeducDelCredit;
	
	
	/**
	 * @param montTotIntNominalesDev Atributo opcional que expresa el monto total de intereses nominales devengados
	 */
	@XmlAttribute(required = false,name="MontTotIntNominalesDev")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotIntNominalesDev;
	
	
	/**
	 * @param montTotIntNominalesDevYPag Atributo opcional que expresa el monto total de intereses nominales devengados y pagados
	 */
	@XmlAttribute(required = false,name="MontTotIntNominalesDevYPag")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotIntNominalesDevYPag;
	
	
	/**
	 * @param montTotIntRealPagDeduc Atributo opcional que expresa el monto total de intereses reales pagados deducibles
	 */
	@XmlAttribute(required = false,name="MontTotIntRealPagDeduc")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotIntRealPagDeduc;
	
	
	/**
	 * @param numContrato Atributo opcional que expresa el número de contrato del crédito hipotecario
	 */
	@XmlAttribute(name="NumContrato")
	@Size(max=300)
	private String numContrato;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/intereseshipotecarios http://www.sat.gob.mx/esquemas/retencionpago/1/intereseshipotecarios/intereseshipotecarios.xsd";
	}
	
	
}
