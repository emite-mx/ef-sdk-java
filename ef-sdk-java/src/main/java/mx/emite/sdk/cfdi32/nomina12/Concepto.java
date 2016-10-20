package mx.emite.sdk.cfdi32.nomina12;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
@NoArgsConstructor
@AllArgsConstructor
public class Concepto {

	
	@XmlAttribute(name="cantidad",required = true)
	@NotNull @Min(value = 0)
	private final BigDecimal cantidad = BigDecimal.ONE;
	
	@XmlAttribute(name="descripcion",required = true)
	@NotNull
	private final String descripcion = "Pago de nómina";
	
	@XmlAttribute(name="importe",required = true)
	@NotNull @Min(value = 0)
	private BigDecimal importe;
	
	@XmlAttribute(name="noIdentificacion")
	@Null
	private final String noIdentificacion = null;
	
	@XmlAttribute(name="unidad")
	@NotNull
	private final String unidad = "ACT";
	
	@XmlAttribute(name="valorUnitario",required = true)
	@NotNull @Min(value = 0)
	private BigDecimal valorUnitario;

	
}
