package mx.emite.sdk.cfdi33.complementos.rsv10;

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


@XmlRootElement(name="renovacionysustitucionvehiculos",namespace="http://www.sat.gob.mx/renovacionysustitucionvehiculos")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "renovacionysustitucionvehiculos",namespace="http://www.sat.gob.mx/renovacionysustitucionvehiculos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class RenovacionySustitucionVehiculos extends Complemento33Interface implements Serializable{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -5345726377519034420L;



	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	@XmlAttribute(name="TipoDeDecreto")
	private String tipoDeDecreto;
	
	
	
	@XmlElement(name="DecretoRenovVehicular", namespace = "http://www.sat.gob.mx/renovacionysustitucionvehiculos")
	private DecretoRenovVehicular decretoRenovVehicular;
	
	@XmlElement(name="DecretoSustitVehicular", namespace = "http://www.sat.gob.mx/renovacionysustitucionvehiculos")
	private DecretoSustitVehicular decretoSustitVehicular;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/renovacionysustitucionvehiculos http://www.sat.gob.mx/sitio_internet/cfd/renovacionysustitucionvehiculos/renovacionysustitucionvehiculos.xsd";
	}

	@Override
	public String getPrefijo() {
		return "decreto";
	}
	
	
}
