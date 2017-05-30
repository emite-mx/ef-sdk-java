package mx.emite.sdk.cfdi33.complementos.vv11;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
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
import lombok.Singular;
import mx.emite.sdk.utils.ComplementoConcepto33Interface;


@XmlRootElement(name="VentaVehiculos",namespace="http://www.sat.gob.mx/ventavehiculos")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VentaVehiculos",namespace="http://www.sat.gob.mx/ventavehiculos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class VentaVehiculos extends ComplementoConcepto33Interface implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2936223756990872722L;

	@XmlAttribute(name="version")
    private final String version ="1.1";
	
	@XmlAttribute(name="ClaveVehicular")
	private String claveVehicular;
	
	@XmlAttribute(name="CURP")
	private String curp;
	
	@XmlAttribute(name="Niv")
	private String niv;
	

	@XmlElement(name="InformacionAduanera", namespace = "http://www.sat.gob.mx/ventavehiculos")
	@Valid @Singular("informacionaduanera")
	private List<InformacionAduanera> informacionaduaneras;
	
	@XmlElement(name="Parte", namespace = "http://www.sat.gob.mx/ventavehiculos")
	@Valid @Singular("parte")
	private List<Parte> partes;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/ventavehiculos http://www.sat.gob.mx/sitio_internet/cfd/ventavehiculos/ventavehiculos11.xsd";
	}

	@Override
	public String getPrefijo() {
		return "ventavehiculos";
	}
	
	
}
