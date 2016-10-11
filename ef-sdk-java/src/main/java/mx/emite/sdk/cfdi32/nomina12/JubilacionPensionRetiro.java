package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;

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
@XmlType(name = "JubilacionPensionRetiro")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo condicional para expresar la información detallada de pagos por jubilación, pensiones o haberes de retiro.
 * @author enrique
 *
 */
public class JubilacionPensionRetiro implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8809432653208848183L;

	/**
	 * totalUnaExhibicion Atributo condicional que indica el monto total del pago cuando se realiza en una sola exhibición.
	 */
	@XmlAttribute(name="TotalUnaExhibicion")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal totalUnaExhibicion;
	
	/**
	 * totalParcialidad Atributo condicional para expresar los ingresos totales por pago cuando se hace en parcialidades.
	 */
	@XmlAttribute(name="TotalParcialidad")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal totalParcialidad;
	
	/**
	 * montoDiario Atributo condicional para expresar el monto diario percibido por jubilación, pensiones o haberes de retiro cuando se realiza en parcialidades.
	 */
	@XmlAttribute(name="MontoDiario")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal montoDiario;
	
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
