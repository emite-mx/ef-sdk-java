package mx.emite.sdk.cfdi33.complementos.rsv10;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehiculoNuvoSemEnajenadoFabAlPerm10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class VehiculoNuvoSemEnajenadoFabAlPerm implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2933876956556358001L;

	@XmlAttribute(name="Año")
	private Integer ano;
	
	@XmlAttribute(name="Modelo")
	private String modelo;
	
	@XmlAttribute(name="RFC")
	private String rfc;
	
	
	@XmlAttribute(name="NumPlacas")
	private String numPlacas;
	
	
	
}
