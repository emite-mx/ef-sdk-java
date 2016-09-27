package mx.emite.sdk.ret10.comp.enajenaciondeacciones;

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

@XmlRootElement(name="EnajenaciondeAcciones",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/enajenaciondeacciones")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnajenaciondeAcciones")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class EnajenaciondeAcciones extends ComplementoInterface{

	/**
	 *  version Atributo requerido con valor prefijado que indica la versión del complemento de la enajenación de acciones u operaciones de valores
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	/**
	 *  contratoIntermediacion Atributo requerido para expresar la descripción del contrato de intermediación.
	 */
	@XmlAttribute(name="ContratoIntermediacion")
	@NotNull @Size(min=1,max=300)
	private String contratoIntermediacion;
	
	/**
	 *  ganancia Atributo requerido para expresar la ganancia obtenida por la enajenación de acciones u operación de valores
	 */
	@XmlAttribute(required = true,name="Ganancia")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal ganancia;
	
	/**
	 *  perdida Atributo requerido para expresar la pérdida en el contrato de intermediación
	 */
	@XmlAttribute(required = true,name="Perdida")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal perdida;
	
	
	

	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/enajenaciondeacciones http://www.sat.gob.mx/esquemas/retencionpago/1/enajenaciondeacciones/enajenaciondeacciones.xsd";
	}
	
	
}
