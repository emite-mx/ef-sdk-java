package mx.emite.sdk.cfdi33.complementos.ccd10;

import java.io.Serializable;

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
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="certificadodedestruccion",namespace="http://www.sat.gob.mx/certificadodestruccion")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certificadodedestruccion",namespace="http://www.sat.gob.mx/certificadodestruccion")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CertificadoDeDestruccion extends Complemento33Interface implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4333924917375081450L;

	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	@XmlAttribute(name="Serie")
	private String serie;
	
	@XmlAttribute(name="NumFolDesVeh")
	private String numFolDesVeh;
	
	@XmlElement(name="VehiculoDestruido", namespace = "http://www.sat.gob.mx/certificadodestruccion")
	private VehiculoDestruido vehiculoDestruido;
	
	@XmlElement(name="InformacionAduanera", namespace = "http://www.sat.gob.mx/certificadodestruccion")
	private InformacionAduanera informacionaduaneras;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/certificadodedestruccion http://www.sat.gob.mx/sitio_internet/cfd/certificadodestruccion/certificadodedestruccion.xsd";
	}

	@Override
	public String getPrefijo() {
		return "destruccion";
	}
	
	
}
