package mx.emite.sdk.cfdi33.complementos.aerolineas10;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="Aerolineas",namespace="http://www.sat.gob.mx/aerolineas")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Aerolineas",namespace="http://www.sat.gob.mx/aerolineas")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Aerolineas extends Complemento33Interface implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8938331102342542221L;

	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	@XmlAttribute(name="TUA")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	private BigDecimal tua;
	
	
	@XmlElement(name="OtrosCargos", namespace = "http://www.sat.gob.mx/aerolineas")
	private OtrosCargos otrosCargos;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/aerolineas http://www.sat.gob.mx/sitio_internet/cfd/aerolineas/aerolineas.xsd";
	}

	@Override
	public String getPrefijo() {
		return "aerolineas";
	}
	
	
}
