package mx.emite.sdk.cfdi33.complementos.ecc11;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
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
import lombok.Singular;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="EstadoDeCuentaCombustible",namespace="http://www.sat.gob.mx/EstadoDeCuentaCombustible")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstadoDeCuentaCombustible",namespace="http://www.sat.gob.mx/EstadoDeCuentaCombustible")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
/**
 * 
 * @author enrique
 * Complemento para incorporar la información en el caso de Exportación de Mercancías en definitiva.
 */
public class EstadoDeCuentaCombustible extends Complemento33Interface implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6306093174230850809L;

	@XmlAttribute(name="Version")
    private final String Version ="1.1";
	
	@XmlAttribute(name="TipoOperacion")
    private final String tipoOperacion = "Tarjeta";
	
	@XmlAttribute(name="NumeroDeCuenta")
	private String numeroDeCuenta;
	
	@XmlAttribute(name="SubTotal")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal subTotal;
	
	@XmlAttribute(name="Total")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal total;
	
	@XmlElement(name="Conceptos",namespace="http://www.sat.gob.mx/EstadoDeCuentaCombustible")
	@Valid @Singular("concepto")
	private List<Conceptos> conceptos;
	
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/EstadoDeCuentaCombustible http://www.sat.gob.mx/sitio_internet/cfd/ecc/ecc11.xsd";
	}

	@Override
	public String getPrefijo() {
		return "ecc11";
	}
	
	
}
