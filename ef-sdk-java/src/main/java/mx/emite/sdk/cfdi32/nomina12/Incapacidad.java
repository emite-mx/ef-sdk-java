package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

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
import mx.emite.sdk.enums.sat.TiposIncapacidad;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposIncapacidadAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Incapacidad")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo requerido para expresar información de las incapacidades.
 * @author enrique
 *
 */
public class Incapacidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 169119376591276357L;

	/**
	 * diasIncapacidad Atributo requerido para expresar el número de días enteros que el trabajador se incapacitó en el periodo.
	 */
	@XmlAttribute(name="DiasIncapacidad")
	@NotNull 
	@DecimalMin("1")
    private BigInteger diasIncapacidad;

	/**
	 * tipoIncapacidad Atributo requerido para expresar la razón de la incapacidad. Catálogo publicado en el Portal del SAT en internet.
	 */
	@XmlAttribute(required = true,name="TipoIncapacidad")
	@XmlJavaTypeAdapter(TiposIncapacidadAdapter.class)
	@NotNull
    private TiposIncapacidad tipoIncapacidad;
	
	/**
	 * importeMonetario Atributo condicional para expresar el monto del importe monetario de la incapacidad.
	 */
	@XmlAttribute(required = true,name="ImporteMonetario")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
    private BigDecimal importeMonetario;
	
	
   
    
}
