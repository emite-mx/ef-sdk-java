package mx.emite.sdk.cfdi33.complementos.donat11;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="Donatarias",namespace="http://www.sat.gob.mx/donat")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Donatarias",namespace="http://www.sat.gob.mx/donat")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Donatarias extends Complemento33Interface implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6550350968778717597L;

	@XmlAttribute(name="version")
    private final String version ="1.1";
	
	@XmlAttribute(name="noAutorizacion")
    private String noAutorizacion;
	
	@XmlAttribute(name="fechaAutorizacion",required = true)
	@NotNull
	protected String fechaAutorizacion;

	
	@XmlAttribute(name="leyenda")
	private String leyenda;
	
	
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/donat http://www.sat.gob.mx/sitio_internet/cfd/donat/donat11.xsd";
	}

	@Override
	public String getPrefijo() {
		return "donat";
	}
	
	
}
