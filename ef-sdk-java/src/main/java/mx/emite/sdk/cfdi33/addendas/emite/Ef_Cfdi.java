package mx.emite.sdk.cfdi33.addendas.emite;

import java.io.Serializable;

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

@XmlRootElement(name="Ef_Cfdi")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ef_Cfdi")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Ef_Cfdi  implements Serializable{

	private static final long serialVersionUID = -4513367681716085193L;

	@XmlAttribute(name="tipoComprobante")
	private String tipoComprobante;
	
	@XmlAttribute(name="formaPago")
	private String formaPago;
	
	@XmlAttribute(name="usoCfdi")
	private String usoCfdi;
	
	@XmlAttribute(name="moneda")
	private String moneda;
	
	@XmlAttribute(name="metodoPago")
	private String metodoPago;
	
	@XmlAttribute(name="regimenFiscal")
	private String regimenFiscal;	
	
	@XmlAttribute(name="totalE")
	private String totalE;
	
	@XmlAttribute(name="totalD")
	private String totalD;
	

	
}
