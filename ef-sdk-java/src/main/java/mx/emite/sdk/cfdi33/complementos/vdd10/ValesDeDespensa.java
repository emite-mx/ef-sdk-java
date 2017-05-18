package mx.emite.sdk.cfdi33.complementos.vdd10;

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
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="ValesDeDespensa",namespace="http://www.sat.gob.mx/valesdedespensa")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValesDeDespensa",namespace="http://www.sat.gob.mx/valesdedespensa")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ValesDeDespensa extends Complemento33Interface implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8938331102342542221L;

	@XmlAttribute(name="version")
    private final String version ="1.0";
	
	@XmlAttribute(name="tipoOperacion")
    private final String tipoOperacion ="monedero electrónico";
	
	@XmlAttribute(name="registroPatronal")
    private String registroPatronal;
	
	@XmlAttribute(name="numeroDeCuenta")
    private String numeroDeCuenta;
	
	@XmlAttribute(name="total")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal total;
	
	
	@XmlElement(name="Conceptos", namespace = "http://www.sat.gob.mx/valesdedespensa")
	private Conceptos conceptos;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/valesdedespensa http://www.sat.gob.mx/sitio_internet/cfd/valesdedespensa/valesdedespensa.xsd";
	}

	@Override
	public String getPrefijo() {
		return "valesdedespensa";
	}
	
	
}
