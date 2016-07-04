package mx.emite.sdk.ret10.comp.arrendamientofideicomiso;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.ret10.comp.ComplementoInterface;

@XmlRootElement(name="Arrendamientoenfideicomiso",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/arrendamientoenfideicomiso")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Arrendamientoenfideicomiso")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Arrendamientoenfideicomiso extends ComplementoInterface{

	/**
	 * @param version Atributo requerido con valor prefijado que indica la versión del complemento de arrendamiento financiero
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	
	/**
	 * @param pagProvEfecPorFiduc Atributo requerido para expresar el importe del pago efectuado por parte del fiduciario al arrendador de bienes en el periodo
	 */
	@XmlAttribute(required = true,name="PagProvEfecPorFiduc")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal pagProvEfecPorFiduc;
	
	/**
	 * @param rendimFideicom Atributo requerido para expresar el importe de los rendimientos obtenidos en el periodo por el arrendamiento de bienes
	 */
	@XmlAttribute(required = true,name="RendimFideicom")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal rendimFideicom;
	
	/**
	 * @param deduccCorresp Atributo requerido para expresar el importe de las deducciones correspondientes al arrendamiento de los bienes durante el periodo
	 */
	@XmlAttribute(required = true,name="DeduccCorresp")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal deduccCorresp;
	
	/**
	 * @param montTotRet Atributo opcional para expresar el monto total de la retención del arrendamiento de los bienes del periodo
	 */
	@XmlAttribute(required = true,name="MontTotRet")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montTotRet;
	
	/**
	 * @param montResFiscDistFibras Atributo opcional para expresar el monto del resultado fiscal distribuido por FIBRAS
	 */
	@XmlAttribute(required = true,name="MontResFiscDistFibras")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montResFiscDistFibras;
	
	/**
	 * @param montOtrosConceptDistr Atributo opcional para expresar el monto de otros conceptos distribuidos
	 */
	@XmlAttribute(required = true,name="MontOtrosConceptDistr")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montOtrosConceptDistr;
	
	
	/**
	 * @param descrMontOtrosConceptDistr Atributo opcional para describir los conceptos distribuidos cuando se señalen otros conceptos.
	 */
	@XmlAttribute(required = true,name="DescrMontOtrosConceptDistr")
	@Size(max=300)
	protected String DescrMontOtrosConceptDistr;
	
	
	
	
	
	

	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/esquemas/retencionpago/1/arrendamientoenfideicomiso http://www.sat.gob.mx/esquemas/retencionpago/1/arrendamientoenfideicomiso/arrendamientoenfideicomiso.xsd";
	}
	
	
}
