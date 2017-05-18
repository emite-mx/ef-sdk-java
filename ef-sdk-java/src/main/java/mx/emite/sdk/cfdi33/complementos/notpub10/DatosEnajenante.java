package mx.emite.sdk.cfdi33.complementos.notpub10;

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
@XmlType(name = "DatosEnajenante10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DatosEnajenante implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7984126679082189757L;

	@XmlAttribute(name="CoproSocConyugalE")
	private String coproSocConyugalE;
    
	@XmlElement(name="DatosUnEnajenante", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DatosUnEnajenante datosUnEnajenante;
		
	@XmlElement(name="DatosEnajenantesCopSC", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DatosEnajenantesCopSc datosEnajenantesCopSC;
	
	
}
