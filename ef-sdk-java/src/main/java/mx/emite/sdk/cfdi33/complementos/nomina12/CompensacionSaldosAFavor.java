package mx.emite.sdk.cfdi33.complementos.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompensacionSaldosAFavor12")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo condicional para expresar la información referente a la compensación de saldos a favor de un trabajador.
 * @author enrique
 *
 */
public class CompensacionSaldosAFavor implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2397961585567145637L;


	/**
	 * saldoAFavor Atributo requerido para expresar el saldo a favor determinado por el patrón al trabajador en periodos o ejercicios anteriores.
	 */
	@XmlAttribute(name="SaldoAFavor")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
	protected BigDecimal saldoAFavor;
	
	
	/**
	 * ano Atributo requerido para expresar el año en que se determinó el saldo a favor del trabajador por el patrón.
	 */
	@XmlAttribute(name="Año")
	@NotNull
	@DecimalMin("2016") @DecimalMax("2050")
	protected BigInteger ano;
	
	
	/**
	 * remanenteSalFav Atributo requerido para expresar el remanente del saldo a favor del trabajador.
	 */
	@XmlAttribute(name="RemanenteSalFav")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
	protected BigDecimal remanenteSalFav;
	
}
