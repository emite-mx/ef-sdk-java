package mx.emite.sdk.ret10.comp.dividendos;

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
import mx.emite.sdk.utils.ComplementoInterface;

@XmlRootElement(name="Dividendos",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dividendos")
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Dividendos extends ComplementoInterface{

	/**
	 *  version Atributo requerido con valor prefijado que indica la versión del complemento de la enajenación de acciones u operaciones de valores
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private final String version="1.0";
	
	/**
	 *  dividOUtil Nodo opcional que expresa los dividendos o utilidades distribuidas del periodo o ejercicio
	 */
	@XmlElement(name="DividOUtil",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos")
	@Valid
	private DividOUtil dividOUtil;
	
	/**
	 *  remanente Nodo opcional que expresa el resultado obtenido de la diferencia entre ingresos y egresos de las personas morales que distribuyan anticipos o rendimientos o sociedades de producción, sociedades y asociaciones civiles.
	 */
	@XmlElement(name="Remanente",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos")
	@Valid
	private Remanente remanente;

	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos/dividendos.xsd";
	}

	@Override
	public String getPrefijo() {
		return "dividendos";
	}
	
	public static Dividendos nuevo() {
		return builder().build();
	}
	
	@Deprecated
	Dividendos() {
		
	}
	
}
