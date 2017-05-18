package mx.emite.sdk.cfdi33.complementos.pfic10;

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


@XmlRootElement(name="PFintegranteCoordinado",namespace="http://www.sat.gob.mx/pfic")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PFintegranteCoordinado",namespace="http://www.sat.gob.mx/pfic")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class PFintegranteCoordinado extends Complemento33Interface implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3448306096970085843L;

	@XmlAttribute(name="version")
    private final String version ="1.0";
	
	@XmlAttribute(name="ClaveVehicular")
    private String claveVehicular;
	
	@XmlAttribute(name="Placa")
    private String placa;
	
	@XmlAttribute(name="RFCPF")
    private String rfcpf;
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/pfic http://www.sat.gob.mx/sitio_internet/cfd/pfic/pfic.xsd";
	}

	@Override
	public String getPrefijo() {
		return "pfic";
	}
	
	
}
