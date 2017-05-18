package mx.emite.sdk.cfdi33.complementos.spc10;

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


@XmlRootElement(name="parcialesconstruccion",namespace="http://www.sat.gob.mx/servicioparcialconstruccion")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parcialesconstruccion",namespace="http://www.sat.gob.mx/servicioparcialconstruccion")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ParcialesConstruccion extends Complemento33Interface implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1972720724120010809L;


	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	
	@XmlAttribute(name="NumPerLicoAut")
	private String numPerLicoAut;
	
	
	
	@XmlElement(name="Inmueble", namespace = "http://www.sat.gob.mx/servicioparcialconstruccion")
	@Valid @Singular("inmueble")
	private List<Inmueble> inmuebles;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/servicioparcialconstruccion http://www.sat.gob.mx/sitio_internet/cfd/servicioparcialconstruccion/servicioparcialconstruccion.xsd";
	}

	@Override
	public String getPrefijo() {
		return "servicioparcial";
	}
	
	
}
