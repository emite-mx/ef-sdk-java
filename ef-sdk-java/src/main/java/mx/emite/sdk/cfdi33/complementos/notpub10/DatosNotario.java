package mx.emite.sdk.cfdi33.complementos.notpub10;

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
@XmlType(name = "DatosNotario10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DatosNotario implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = -2183494660675323574L;

	@XmlAttribute(name="CURP")
	private String curp;
    
	@XmlAttribute(name="NumNotaria",required = true)
	protected String numNotaria;

	@XmlAttribute(name="EntidadFederativa")
	private String entidadFederativa;
	
	@XmlAttribute(name="Adscripcion")
	private String adscripcion;
	
	
	
	
}
