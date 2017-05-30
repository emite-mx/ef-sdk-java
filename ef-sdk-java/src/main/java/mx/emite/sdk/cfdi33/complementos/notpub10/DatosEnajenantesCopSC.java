package mx.emite.sdk.cfdi33.complementos.notpub10;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosEnajenantesCopSC10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DatosEnajenantesCopSC implements Serializable {

	    
	/**
	 * 
	 */
	private static final long serialVersionUID = -2580775504231092449L;
	@XmlElement(name="DatosEnajenanteCopSC", namespace = "http://www.sat.gob.mx/notariospublicos")
	private List<DatosUnEnajenante> datosEnajenanteCopSC;
		
	
	
	
}
