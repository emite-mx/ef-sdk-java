package mx.emite.sdk.cfdi33.complementos.rsv10;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecretoSustitVehicular10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DecretoSustitVehicular implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4544751477229444167L;

	@XmlAttribute(name="VehEnaj")
	private String vehEnaj;
	
	@XmlElement(name="VehiculoUsadoEnajenadoPermAlFab", namespace = "http://www.sat.gob.mx/renovacionysustitucionvehiculos")
	private VehiculoUsadoEnajenadoPermAlFab vehiculoUsadoEnajenadoPermAlFab;
	
	@XmlElement(name="VehiculoNuvoSemEnajenadoFabAlPerm", namespace = "http://www.sat.gob.mx/renovacionysustitucionvehiculos")
	private VehiculoNuvoSemEnajenadoFabAlPerm vehiculoNuvoSemEnajenadoFabAlPerm;
	
}
