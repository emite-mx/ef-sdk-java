package mx.emite.sdk.cfdi33.complementos.regfisc10;

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


@XmlRootElement(name="CFDIRegistroFiscal",namespace="http://www.sat.gob.mx/registrofiscal")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFDIRegistroFiscal",namespace="http://www.sat.gob.mx/registrofiscal")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CFDIRegistroFiscal extends Complemento33Interface implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4075292666265752224L;

	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	@XmlAttribute(name="Folio")
    private String folio;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/registrofiscal http://www.sat.gob.mx/sitio_internet/cfd/cfdiregistrofiscal/cfdiregistrofiscal.xsd";
	}

	@Override
	public String getPrefijo() {
		return "registrofiscal";
	}
	
	
}
