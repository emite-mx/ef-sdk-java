package mx.emite.sdk.dd10.dpiva10;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProvNacional")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class ProvNacional  implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1154593321438070461L;

	
	@XmlAttribute(name="TipoOperac")
	protected String tipoOperac;
	
	@XmlAttribute(name="RFCProv")
	@Rfc
	protected String rfcProv;
	
	@XmlAttribute(name="ValActPagTas15o16IVA")
	protected BigInteger valActPagTas15o16IVA;
	
	@XmlAttribute(name="ValActPagTas15IVA")
	protected BigInteger valActPagTas15IVA;
	
	@XmlAttribute(name="MonIVAPagNoAcrTas15o16")
	protected BigInteger monIVAPagNoAcrTas15o16;
	
	@XmlAttribute(name="ValActPagTas10u11IVA")
	protected BigInteger valActPagTas10u11IVA;
	
	@XmlAttribute(name="ValActPagTas10IVA")
	protected BigInteger valActPagTas10IVA;
	
	@XmlAttribute(name="MonIVAPagNoAcrTas10u11")
	protected BigInteger monIVAPagNoAcrTas10u11;
	
	@XmlAttribute(name="ValActPagTas0IVA")
	protected BigInteger valActPagTas0IVA;
	
	@XmlAttribute(name="ValActPagNoIVA")
	protected BigInteger valActPagNoIVA;
	
	@XmlAttribute(name="IVARetCont")
	protected BigInteger ivaRetCont;
	
	@XmlAttribute(name="IVADevDescyBonifComp")
	protected BigInteger ivaDevDescyBonifComp;
	
	
	
}
