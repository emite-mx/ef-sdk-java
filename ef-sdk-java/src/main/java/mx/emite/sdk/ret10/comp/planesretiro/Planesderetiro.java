package mx.emite.sdk.ret10.comp.planesretiro;

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

@XmlRootElement(name="Planesderetiro",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Planesderetiro")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Planesderetiro extends ComplementoInterface{

	/**
	 *  version Atributo requerido con valor prefijado que indica la versión del complemento de planes personales de retiro
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	
	/**
	 *  sistemaFinanc Atributo requerido para expresar si los planes personales de retiro son del sistema financiero
	 */
	@XmlAttribute(name="SistemaFinanc")
	@NotNull  @Pattern(regexp="(SI|NO)",message="debe ser SI o NO")
	private String sistemaFinanc;
	
	
	/**
	 *  montTotAportAnioInmAnterior Atributo opcional que expresa el monto total de las aportaciones actualizadas en el año inmediato anterior de los planes personales de retiro
	 */
	@XmlAttribute(required = false,name="MontTotAportAnioInmAnterior")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotAportAnioInmAnterior;
	
	/**
	 *  montIntRealesDevengAniooInmAnt Atributo requerido para expresar el monto de los intereses reales devengados o percibidos durante el año inmediato anterior de los planes personales de retiro
	 */
	@XmlAttribute(required = false,name="MontIntRealesDevengAniooInmAnt")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montIntRealesDevengAniooInmAnt;
	
	/**
	 *  huboRetirosAnioInmAntPer Atributo requerido para expresar si se realizaron retiros de recursos invertidos y sus rendimientos en el ejercicio inmediato anterior antes de cumplir los requisitos de permanencia
	 */
	@XmlAttribute(name="HuboRetirosAnioInmAntPer")
	@NotNull  @Pattern(regexp="(SI|NO)",message="debe ser SI o NO")
	private String huboRetirosAnioInmAntPer;
	
	/**
	 *  montTotRetiradoAnioInmAntPer Atributo opcional que expresa el monto total del retiro realizado antes de cumplir con los requisitos de permanencia
	 */
	@XmlAttribute(required = false,name="MontTotRetiradoAnioInmAntPer")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotRetiradoAnioInmAntPer;
	
	/**
	 *  montTotExentRetiradoAnioInmAnt Atributo opcional que expresa el monto total exento del retiro realizado en el ejercicio inmediato anterior
	 */
	@XmlAttribute(required = false,name="MontTotExentRetiradoAnioInmAnt")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotExentRetiradoAnioInmAnt;
	
	/**
	 *  montTotExedenteAnioInmAnt Atributo opcional que expresa el monto total excedente del monto exento del retiro realizado en el ejercicio inmediato anterior
	 */
	@XmlAttribute(required = false,name="MontTotExedenteAnioInmAnt")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotExedenteAnioInmAnt;
	
	/**
	 *  huboRetirosAnioInmAnt Atributo requerido que expresa si se realizaron retiros en el ejercicio inmediato anterior
	 */
	@XmlAttribute(name="HuboRetirosAnioInmAnt")
	@NotNull  @Pattern(regexp="(SI|NO)",message="debe ser SI o NO")
	private String huboRetirosAnioInmAnt;
	
	/**
	 *  montTotRetiradoAnioInmAnt Atributo opcional que expresa el monto total del retiro realizado en el ejercicio inmediato anterior
	 */
	@XmlAttribute(required = false,name="MontTotRetiradoAnioInmAnt")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotRetiradoAnioInmAnt;
	

	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro/planesderetiro.xsd";
	}
	
	
}
