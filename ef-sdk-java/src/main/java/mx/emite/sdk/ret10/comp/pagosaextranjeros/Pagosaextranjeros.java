package mx.emite.sdk.ret10.comp.pagosaextranjeros;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.utils.ComplementoInterface;

@XmlRootElement(name="Pagosaextranjeros",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pagosaextranjeros")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Pagosaextranjeros extends ComplementoInterface{

	/**
	 *  version Atributo requerido con valor prefijado que indica la versión del complemento de pagos realizados a residentes a residentes en el extranjero
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private final String version="1.0";
	
	/**
	 *  esBenefEfectDelCobro Atributo requerido para expresar si el beneficiario del pago es la misma persona que retiene
	 */
	@XmlAttribute(name="EsBenefEfectDelCobro")
	@NotNull  @Pattern(regexp="(SI|NO)",message="debe ser SI o NO")
	private String esBenefEfectDelCobro;
	
	
	/**
	 *  noBeneficiario Nodo opcional para expresar la información del residente extranjero efectivo del cobro
	 */
	@XmlElement(name="NoBeneficiario",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros")
	@Valid
	private NoBeneficiario noBeneficiario;
	
	/**
	 *  remanente Nodo opcional para precisar la información del representante para efectos fiscales en México
	 */
	@XmlElement(name="Beneficiario",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros")
	@Valid
	private Beneficiario beneficiario;

	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros/pagosaextranjeros.xsd";
	}

	@Override
	public String getPrefijo() {
		return "pagosaextranjeros";
	}
	
	
}
