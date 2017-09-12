package mx.emite.sdk.ret10.comp.sectorfinanciero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.utils.ComplementoInterface;

@XmlRootElement(name="SectorFinanciero",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/sectorfinanciero")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SectorFinanciero")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class SectorFinanciero extends ComplementoInterface{

	/**
	 * @param version Atributo requerido con valor prefijado que indica la versión del complemento sector financiero
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private final String version="1.0";
	
	/**
	 * @param idFideicom Atributo requerido para expresar el Identificador o Número del Fideicomiso
	 */
	@XmlAttribute(name="IdFideicom")
	@NotNull @Size(min=1,max=20)
	private String idFideicom;
	
	
	/**
	 * @param nomFideicom Atributo opcional para expresar el Nombre del Fideicomiso
	 */
	@XmlAttribute(name="NomFideicom")
	@Size(max=100)
	private String nomFideicom;
	
	/**
	 * @param descripFideicom Atributo requerido para expresar el objeto o fin del Fideicomiso
	 */
	@XmlAttribute(name="DescripFideicom")
	@NotNull @Size(min=1,max=300)
	private String descripFideicom;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/sectorfinanciero http://www.sat.gob.mx/esquemas/retencionpago/1/sectorfinanciero/sectorfinanciero.xsd";
	}


	@Override
	public String getPrefijo() {
		return "sectorfinanciero";
	}
	
	
}
