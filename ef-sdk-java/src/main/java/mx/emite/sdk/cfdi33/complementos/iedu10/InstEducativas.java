package mx.emite.sdk.cfdi33.complementos.iedu10;

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
import mx.emite.sdk.utils.ComplementoConcepto33Interface;


@XmlRootElement(name="instEducativas",namespace="http://www.sat.gob.mx/iedu")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instEducativas",namespace="http://www.sat.gob.mx/iedu")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class InstEducativas extends ComplementoConcepto33Interface implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2936223756990872722L;

	@XmlAttribute(name="version")
    private final String version ="1.0";
	
	@XmlAttribute(name="nombreAlumno")
	private String nombreAlumno;
	
	@XmlAttribute(name="CURP")
	private String curp;
	
	@XmlAttribute(name="nivelEducativo")
	private String nivelEducativo;
	
	@XmlAttribute(name="autRVOE")
	private String autRVOE;
	
	@XmlAttribute(name="rfcPago")
	private String rfcPago;
	
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/iedu http://www.sat.gob.mx/sitio_internet/cfd/iedu/iedu.xsd";
	}

	@Override
	public String getPrefijo() {
		return "iedu";
	}
	
	
}
