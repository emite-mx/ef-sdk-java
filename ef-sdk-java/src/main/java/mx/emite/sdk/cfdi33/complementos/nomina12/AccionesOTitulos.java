package mx.emite.sdk.cfdi33.complementos.nomina12;

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
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccionesOTitulos12")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo condicional para expresar ingresos por acciones o títulos valor que representan bienes. Se vuelve requerido cuando existan ingresos por sueldos derivados de adquisición de acciones o títulos (Art. 94, fracción VII LISR).
 * @author enrique
 *
 */
public class AccionesOTitulos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5453130126189360166L;

	/**
	 * valorMercado Atributo requerido para expresar el valor de mercado de las Acciones o Títulos valor al ejercer la opción.
	 */
	@XmlAttribute(name="ValorMercado")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull @DecimalMin("0.000001")
	protected BigDecimal valorMercado;
	
	/**
	 * precioAlOtorgarse Atributo requerido para expresar el precio establecido al otorgarse la opción de ingresos en acciones o títulos
	 */
	@XmlAttribute(name="PrecioAlOtorgarse")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull @DecimalMin("0.000001")
	protected BigDecimal precioAlOtorgarse;
	
	
}
