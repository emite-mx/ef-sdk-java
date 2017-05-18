package mx.emite.sdk.cfdi33.complementos.notpub10;

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


@XmlRootElement(name="NotariosPublicos",namespace="http://www.sat.gob.mx/notariospublicos")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotariosPublicos",namespace="http://www.sat.gob.mx/notariospublicos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class NotariosPublicos extends Complemento33Interface implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 9202286384158927956L;



	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	
	
	@XmlElement(name="DescInmuebles", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DescInmuebles descinmuebles;
	
	@XmlElement(name="DatosOperacion", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DatosOperacion datosOperacion;
	
	@XmlElement(name="DatosNotario", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DatosNotario datosNotario;
	
	@XmlElement(name="DatosEnajenante", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DatosEnajenante datosEnajenante;
	
	@XmlElement(name="DatosAdquiriente", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DatosAdquiriente datosAdquiriente;
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/notariospublicos http://www.sat.gob.mx/sitio_internet/cfd/notariospublicos/notariospublicos.xsd";
	}

	@Override
	public String getPrefijo() {
		return "notariospublicos";
	}
	
	
}
