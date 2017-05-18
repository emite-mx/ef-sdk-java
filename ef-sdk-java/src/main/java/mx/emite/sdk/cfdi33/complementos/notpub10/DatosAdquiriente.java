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
@XmlType(name = "DatosAdquiriente10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DatosAdquiriente implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3396029615556641933L;

	@XmlAttribute(name="CoproSocConyugalE")
	private String coproSocConyugalE;
    
	@XmlElement(name="DatosUnAdquiriente", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DatosUnAdquiriente datosUnAdquiriente;
		
	@XmlElement(name="DatosAdquirientesCopSC", namespace = "http://www.sat.gob.mx/notariospublicos")
	private DatosAdquirientesCopSC datosAdquirientesCopSC;
	
	
}
