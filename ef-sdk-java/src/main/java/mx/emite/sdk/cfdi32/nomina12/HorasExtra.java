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
import mx.emite.sdk.enums.sat.TiposHoras12;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposHorasIdSatAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HorasExtra")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo condicional para expresar las horas extra aplicables..
 * @author enrique
 *
 */
public class HorasExtra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5005112353848008607L;

	/**
	 * dias Atributo requerido para expresar el número de días en que el trabajador realizó horas extra en el periodo.
	 */
	@XmlAttribute(name="Dias")
	@NotNull @DecimalMin("1")
    private BigInteger dias;
	
	/**
	 * tipoHoras Atributo requerido para expresar el tipo de pago de las horas extra.
	 */
	@XmlAttribute(name="TipoHoras")
	@XmlJavaTypeAdapter(TiposHorasIdSatAdapter.class)
	@NotNull
    private TiposHoras12 tipoHoras;
	
	/**
	 * horasExtra Atributo requerido para expresar el número de horas extra trabajadas en el periodo.
	 */
	@XmlAttribute(name="HorasExtra")
	@NotNull @DecimalMin("1")
    private BigInteger horasExtra;
	
	/**
	 * importePagado Atributo requerido para expresar el importe pagado por las horas extra.
	 */
    @XmlAttribute(name="ImportePagado")
    @XmlJavaTypeAdapter(ImporteMxnAdapter.class)
    @NotNull @DecimalMin("0")
    private BigDecimal importePagado;
	
	
}
