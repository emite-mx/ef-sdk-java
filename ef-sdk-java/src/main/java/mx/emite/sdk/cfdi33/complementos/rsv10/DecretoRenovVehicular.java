package mx.emite.sdk.cfdi33.complementos.rsv10;

import java.io.Serializable;
import java.util.List;

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
@XmlType(name = "DecretoRenovVehicular10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DecretoRenovVehicular implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2940697177490494705L;

	@XmlAttribute(name="VehEnaj")
	private String vehEnaj;
    
	@XmlElement(name="VehiculosUsadosEnajenadoPermAlFab", namespace = "http://www.sat.gob.mx/renovacionysustitucionvehiculos")
	private VehiculosUsadosEnajenadoPermAlFab vehiculosUsadosEnajenadoPermAlFab;
	
	@XmlElement(name="VehiculoNuvoSemEnajenadoFabAlPerm", namespace = "http://www.sat.gob.mx/renovacionysustitucionvehiculos")
	private List<VehiculoNuvoSemEnajenadoFabAlPerm> vehiculoNuvoSemEnajenadoFabAlPerm;
}
