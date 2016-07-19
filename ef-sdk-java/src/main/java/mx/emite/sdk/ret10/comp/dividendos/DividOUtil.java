package mx.emite.sdk.ret10.comp.dividendos;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.TipoDividendosOUtilidadDistribuida;
import mx.emite.sdk.enums.sat.TipoSocDistrDiv;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoDividendosOUtilidadDistribuidaAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoSocDistrDivAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DividOUtil")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class DividOUtil {

	/**
	 *  cveTipDivOUtil Atributo requerido para expresar la clave del tipo de dividendo o utilidad distribuida de acuerdo al catálogo.
	 */
	@XmlAttribute(required = true,name="CveTipDivOUtil")
	@XmlJavaTypeAdapter(TipoDividendosOUtilidadDistribuidaAdapter.class)
	@NotNull
	private TipoDividendosOUtilidadDistribuida cveTipDivOUtil;

	/**
	 *  montISRAcredRetMexico Atributo requerido para expresar el importe o retención del dividendo o utilidad en territorio nacional
	 */
	@XmlAttribute(required = true,name="MontISRAcredRetMexico")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montISRAcredRetMexico;
	
	/**
	 *  montISRAcredRetExtranjero Atributo requerido para expresar el importe o retención del dividendo o utilidad en territorio extranjero
	 */
	@XmlAttribute(required = true,name="MontISRAcredRetExtranjero")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montISRAcredRetExtranjero;
	
	/**
	 *  montRetExtDivExt Atributo opcional para expresar el monto de la retención en el extranjero sobre dividendos del extranjero
	 */
	@XmlAttribute(required = true,name="MontRetExtDivExt")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montRetExtDivExt;
	
	/**
	 *  cveTipDivOUtil Atributo requerido para expresar la clave del tipo de dividendo o utilidad distribuida de acuerdo al catálogo.
	 */
	@XmlAttribute(required = true,name="TipoSocDistrDiv")
	@XmlJavaTypeAdapter(TipoSocDistrDivAdapter.class)
	@NotNull
	private TipoSocDistrDiv tipoSocDistrDiv;
	
	/**
	 *  montISRAcredNal Atributo opcional para expresar el monto del ISR acreditable nacional
	 */
	@XmlAttribute(required = true,name="MontISRAcredNal")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montISRAcredNal;
	
	/**
	 *  montDivAcumNal Atributo opcional para expresar el monto del dividendo acumulable nacional
	 */
	@XmlAttribute(required = true,name="MontDivAcumNal")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montDivAcumNal;
	
	/**
	 *  montDivAcumExt Atributo opcional para expresar el monto del dividendo acumulable extranjero
	 */
	@XmlAttribute(required = true,name="MontDivAcumExt")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montDivAcumExt;
	
}
