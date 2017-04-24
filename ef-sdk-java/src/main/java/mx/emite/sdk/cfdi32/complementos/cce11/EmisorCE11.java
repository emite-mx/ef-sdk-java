package mx.emite.sdk.cfdi32.complementos.cce11;

import java.io.Serializable;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Curp;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EmisorCE11 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6589630099818124914L;

	@XmlAttribute(name="Curp")
	@Curp
	private String curp;
	
	@XmlElement(name="Domicilio",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid
	private DomicilioCE11 domicilio;
	
}
