package mx.emite.sdk.cfdi32.nomina12;

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
@XmlType(name = "SeparacionIndemnizacion")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo condicional para expresar la información detallada de otros pagos por  separación.
 * @author enrique
 *
 */
public class SeparacionIndemnizacion implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4110430922063623409L;

	/**
	 * totalPagado Atributo requerido que indica el monto total del pago.
	 */
	@XmlAttribute(name="TotalPagado")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
	protected BigDecimal totalPagado;
	
	/**
	 * numAnosServicio Atributo requerido para expresar el número de años de servicio del trabajador. Se redondea al entero superior si la cifra contiene años y meses y hay más de 6 meses.
	 */
	@XmlAttribute(name="NumAñosServicio")
	@NotNull
	@DecimalMin("0") @DecimalMax("99")
	protected BigInteger numAnosServicio;
	
	/**
	 * ultimoSueldoMensOrd Atributo requerido que indica el último sueldo mensual
	 */
	@XmlAttribute(name="UltimoSueldoMensOrd")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
	protected BigDecimal ultimoSueldoMensOrd;
	
	/**
	 * ingresoAcumulable Atributo requerido para expresar los ingresos acumulables.
	 */
	@XmlAttribute(name="IngresoAcumulable")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
	protected BigDecimal ingresoAcumulable;
	
	/**
	 * ingresoNoAcumulable Atributo requerido para expresar los ingresos no acumulables.
	 */
	@XmlAttribute(name="IngresoNoAcumulable")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
	protected BigDecimal ingresoNoAcumulable;
	
	
}
