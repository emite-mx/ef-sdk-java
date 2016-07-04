package mx.emite.sdk.ret10.comp.operacionesconderivados;

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

@XmlRootElement(name="Operacionesconderivados",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/operacionesconderivados")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Operacionesconderivados")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Operacionesconderivados extends ComplementoInterface{

	/**
	 * @param version Atributo requerido con valor prefijado que indica la versión del complemento de las operaciones financieras derivadas de capital.
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	
	/**
	 * @param montGanAcum Atributo requerido para expresar el monto de la ganancia acumulable.
	 */
	@XmlAttribute(required = false,name="MontGanAcum")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montGanAcum;
	
	
	
	/**
	 * @param montPerdDed Atributo requerido para expresar el monto de la pérdida deducible.
	 */
	@XmlAttribute(required = false,name="MontPerdDed")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montPerdDed;
	
	
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/operacionesconderivados http://www.sat.gob.mx/esquemas/retencionpago/1/operacionesconderivados/operacionesconderivados.xsd";
	}
	
	
}
