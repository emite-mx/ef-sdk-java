package mx.emite.sdk.ret10.comp.premios;

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
import mx.emite.sdk.enums.sat.EntidadesFederativas;
import mx.emite.sdk.enums.sat.adaptadores.EntidadesFederativasAdapter;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.ret10.comp.ComplementoInterface;

@XmlRootElement(name="Premios",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/premios")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Premios")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Premios extends ComplementoInterface{

	/**
	 * @param version Atributo requerido con valor prefijado que indica la versión del complemento de premios obtenidos
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	
	/**
	 * @param entidadFederativa Atributo requerido para expresar la entidad federativa en la que se paga el premio obtenido, conforme al catálogo.
	 */
	@XmlAttribute(required = true,name="EntidadFederativa")
	@XmlJavaTypeAdapter(EntidadesFederativasAdapter.class)
	@NotNull
	protected EntidadesFederativas entidadFederativa;
	
	/**
	 * @param montTotPago Atributo requerido para expresar el importe del pago realizado por la obtención de un premio
	 */
	@XmlAttribute(required = true,name="MontTotPago")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montTotPago;
	
	/**
	 * @param montTotPagoGrav Atributo requerido para expresar el importe gravado en la obtención de un premio
	 */
	@XmlAttribute(required = true,name="MontTotPagoGrav")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montTotPagoGrav;
	
	/**
	 * @param montTotPagoExent Atributo requerido para expresar el monto total exento en la obtención de un premio
	 */
	@XmlAttribute(required = true,name="MontTotPagoExent")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montTotPagoExent;
	
	
	
	

	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/premios http://www.sat.gob.mx/esquemas/retencionpago/1/premios/premios.xsd";
	}
	
	
}
