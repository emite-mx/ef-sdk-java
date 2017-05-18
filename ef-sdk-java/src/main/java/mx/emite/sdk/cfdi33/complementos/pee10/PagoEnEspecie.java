package mx.emite.sdk.cfdi33.complementos.pee10;

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


@XmlRootElement(name="PagoEnEspecie",namespace="http://www.sat.gob.mx/pagoenespecie")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PagoEnEspecie",namespace="http://www.sat.gob.mx/pagoenespecie")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class PagoEnEspecie extends Complemento33Interface implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5162244084024836664L;

	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	@XmlAttribute(name="CvePIC")
    private String cvePic;
	
	@XmlAttribute(name="FolioSolDon")
    private String folioSolDon;
	
	
	@XmlAttribute(name="PzaArtNombre")
    private String pzaArtNombre;
	
	
	@XmlAttribute(name="PzaArtTecn")
    private String pzaArtTecn;
	
	@XmlAttribute(name="PzaArtAProd")
    private String pzaArtAProd;
	
	@XmlAttribute(name="PzaArtDim")
    private String pzaArtDim;
		
	
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/pagoenespecie http://www.sat.gob.mx/sitio_internet/cfd/pagoenespecie/pagoenespecie.xsd";
	}

	@Override
	public String getPrefijo() {
		return "pagoenespecie";
	}
	
	
}
