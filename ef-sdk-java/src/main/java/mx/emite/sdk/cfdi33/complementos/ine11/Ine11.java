package mx.emite.sdk.cfdi33.complementos.ine11;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
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


@XmlRootElement(name="INE",namespace="http://www.sat.gob.mx/ine")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INE11",namespace="http://www.sat.gob.mx/ine")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
/**
 * 
 * @author enrique
 * Complemento para incorporar la información en el caso de Exportación de Mercancías en definitiva.
 */
public class Ine11 extends Complemento33Interface implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2062114616060760096L;

	/**
	 * version Atributo requerido para la expresión de la versión del complemento. 1.2
	 */
	@XmlAttribute(name="Version")
    private final String version="1.1";
	
	@XmlAttribute(name="TipoProceso")
	@Pattern(regexp="(Ordinario|Precampaña|Campaña){1}",message="Debe de estar en el catálogo t_TipoProc")
    private String tipoProceso;
	
	@XmlAttribute(name="TipoComite")
	@Pattern(regexp="(Ejecutivo Nacional|Ejecutivo Estatal|Directivo Estatal){1}",message="Debe de estar en el catálogo t_TipoComite")
	private String tipoComite;
	
	@XmlAttribute(name="IdContabilidad")
	private BigInteger idContabilidad;
	
	
	
	@XmlElement(name="Entidad",namespace="http://www.sat.gob.mx/ine")
	@Valid @Singular("entidad")
	private List<Entidad> entidades;
	
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/ine http://www.sat.gob.mx/sitio_internet/cfd/ine/ine11.xsd";
	}

	@Override
	public String getPrefijo() {
		return "ine";
	}
	
	
}
