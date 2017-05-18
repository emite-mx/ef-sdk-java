package mx.emite.sdk.cfdi33.complementos.divisas10;

import java.io.Serializable;

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
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="Divisas",namespace="http://www.sat.gob.mx/divisas")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Divisas",namespace="http://www.sat.gob.mx/divisas")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Divisas extends Complemento33Interface implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4075292666265752224L;

	@XmlAttribute(name="version")
    private final String version ="1.0";
	
	@XmlAttribute(name="tipoOperacion")
    private String tipoOperacion;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/divisas http://www.sat.gob.mx/sitio_internet/cfd/divisas/divisas.xsd";
	}

	@Override
	public String getPrefijo() {
		return "divisas";
	}
	
	
}
