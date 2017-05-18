package mx.emite.sdk.cfdi33.complementos.pagos10;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
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
import lombok.Singular;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="Pagos",namespace="http://www.sat.gob.mx/Pagos")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pagos10",namespace="http://www.sat.gob.mx/Pagos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Pagos10 extends Complemento33Interface implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5930382259944812958L;

	@XmlAttribute(name="Version")
    private final String version="1.0";
	
	@XmlElement(name="Pago",namespace="http://www.sat.gob.mx/Pagos")
	@Valid @Singular("pago")
	private List<Pago> pagos;
	
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/Pagos http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos10.xsd";
	}

	@Override
	public String getPrefijo() {
		return "pago10";
	}
	
	
}
