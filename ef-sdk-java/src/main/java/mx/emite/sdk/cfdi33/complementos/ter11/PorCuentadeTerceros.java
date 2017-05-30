package mx.emite.sdk.cfdi33.complementos.ter11;

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
import mx.emite.sdk.utils.ComplementoConcepto33Interface;


@XmlRootElement(name="PorCuentadeTerceros",namespace="http://www.sat.gob.mx/terceros")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PorCuentadeTerceros",namespace="http://www.sat.gob.mx/terceros")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class PorCuentadeTerceros extends ComplementoConcepto33Interface implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7995856089683418090L;

	@XmlAttribute(name="version")
    private final String version ="1.1";
	
	@XmlAttribute(name="rfc")
	private String rfc;
	
	@XmlAttribute(name="nombre")
	private String nombre;
	
	@XmlElement(name="InformacionFiscalTercero", namespace = "http://www.sat.gob.mx/terceros")
	private InformacionFiscalTercero informacionFiscalTercero;
	
	@XmlElement(name="InformacionAduanera", namespace = "http://www.sat.gob.mx/terceros")
	private InformacionAduanera informacionaduaneras;
	
	@XmlElement(name="Parte", namespace = "http://www.sat.gob.mx/terceros")
	@Valid @Singular("parte")
	private List<Parte> partes;
	
	@XmlElement(name="CuentaPredial", namespace = "http://www.sat.gob.mx/terceros")
	private CuentaPredial cuentaPredial;
	
	@XmlElement(name="Impuestos", namespace = "http://www.sat.gob.mx/terceros")
	private Impuestos impuestos;
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/terceros http://www.sat.gob.mx/sitio_internet/cfd/terceros/terceros11.xsd";
	}

	@Override
	public String getPrefijo() {
		return "terceros";
	}
	
	
}
