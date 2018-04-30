package mx.emite.sdk.cfdi33.complementos.cdc11;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
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


@XmlRootElement(name="ConsumoDeCombustibles",namespace=ConsumoDeCombustibles11.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumoDeCombustibles",namespace=ConsumoDeCombustibles11.NAMESPACE)
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ConsumoDeCombustibles11 extends Complemento33Interface implements Serializable{
	
	
	private static final long serialVersionUID = -1207089971374222490L;

	public final static String NAMESPACE="http://www.sat.gob.mx/ConsumoDeCombustibles11";
	
	@XmlAttribute(name="version")
    private final String version ="1.1";
	
	@XmlAttribute(name="tipoOperacion")
    private final String tipoOperacion ="monedero electrónico";
	
	
	
	@XmlAttribute(name="numeroDeCuenta")
    private String numeroDeCuenta;
	
	@XmlAttribute(name="subTotal")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal subTotal;
	
	@XmlAttribute(name="total")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal total;
	
	
	@XmlElement(name="Conceptos", namespace = NAMESPACE)
	@NotNull
	private Conceptos conceptos;
	
	
	@Override
	public String getEsquemaLocation() {
		return NAMESPACE+" http://www.sat.gob.mx/sitio_internet/cfd/consumodecombustibles/consumodeCombustibles11.xsd";
	}

	@Override
	public String getPrefijo() {
		return "consumodecombustibles";
	}
	
	
}
