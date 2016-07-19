package mx.emite.sdk.ret10.comp.fideicomisonoempresarial;

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
import mx.emite.sdk.ret10.comp.ComplementoInterface;

@XmlRootElement(name="Fideicomisonoempresarial",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fideicomisonoempresarial")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Fideicomisonoempresarial extends ComplementoInterface{

	/**
	 *  version Atributo requerido con valor prefijado que indica la versión del complemento de la enajenación de acciones u operaciones de valores
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	/**
	 *  ingresosOEntradas Nodo requerido para expresar el importe de los ingresos del periodo de fideicomisos que no realizan actividades empresariales
	 */
	@XmlElement(name="IngresosOEntradas",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial")
	@Valid @NotNull
	private IngresosOEntradas ingresosOEntradas;
	
	
	
	/**
	 *  deduccOSalidas Nodo requerido para expresar el importe de los egresos del periodo de fideicomisos que no realizan actividades empresariales
	 */
	@XmlElement(name="DeduccOSalidas",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial")
	@Valid @NotNull
	private DeduccOSalidas deduccOSalidas;
	
	/**
	 *  retEfectFideicomiso Nodo requerido para expresar las retenciones efectuadas al fideicomiso
	 */
	@XmlElement(name="RetEfectFideicomiso",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial")
	@Valid @NotNull
	private RetEfectFideicomiso retEfectFideicomiso;

	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial/fideicomisonoempresarial.xsd";
	}
	
	
}
