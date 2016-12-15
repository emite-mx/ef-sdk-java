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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Totales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3966935680273627712L;

	@XmlAttribute(name="TotOperac")
	protected BigInteger totalOperacion;
	
	@XmlAttribute(name="TotActPagTas15o16IVA")
	protected BigInteger totActPagTas15o16IVA;
	
	@XmlAttribute(name="TotActPagTas15IVA")
	protected BigInteger totActPagTas15IVA;
	
	@XmlAttribute(name="TotIVAPagNoAcrTas15o16")
	protected BigInteger totIVAPagNoAcrTas15o16;
	
	@XmlAttribute(name="TotActPagTas10u11IVA")
	protected BigInteger totActPagTas10u11IVA;
	
	@XmlAttribute(name="TotActPagTas10IVA")
	protected BigInteger totActPagTas10IVA;
	
	@XmlAttribute(name="TotIVAPagNoAcrTas10u11")
	protected BigInteger totIVAPagNoAcrTas10u11;
	
	@XmlAttribute(name="TotActPagImpBySTas15o16IVA")
	protected BigInteger totActPagImpBySTas15o16IVA;
	
	@XmlAttribute(name="TotIVAPagNoAcrImpTas15o16")
	protected BigInteger totIVAPagNoAcrImpTas15o16;
	
	@XmlAttribute(name="TotActPagImpBySTas10u11IVA")
	protected BigInteger totActPagImpBySTas10u11IVA;
	
	@XmlAttribute(name="TotIVAPagNoAcrImpTas10u11")
	protected BigInteger totIVAPagNoAcrImpTas10u11;
	
	@XmlAttribute(name="TotActPagImpBySNoPagIVA")
	protected BigInteger totActPagImpBySNoPagIVA;
	
	@XmlAttribute(name="TotDemActPagTas0IVA")
	protected BigInteger totDemActPagTas0IVA;
	
	@XmlAttribute(name="TotActPagNoPagIVA")
	protected BigInteger totActPagNoPagIVA;
	
	@XmlAttribute(name="TotIVARetCont")
	protected BigInteger totIVARetCont;
	
	@XmlAttribute(name="TotIVADevDescyBonifComp")
	protected BigInteger totIVADevDescyBonifComp;
	
	@XmlAttribute(name="TotIVATraslContExcImpByS")
	protected BigInteger totIVATraslContExcImpByS;
	
	@XmlAttribute(name="TotIVAPagImpByS")
	protected BigInteger totIVAPagImpByS;
	
	

	
}
