package mx.emite.sdk.cfdi32;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.UnidadesMedida;
import mx.emite.sdk.enums.sat.adaptadores.UnidadesMedidaAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Concepto {

	
	@XmlAttribute(required = true)
	@NotNull @Min(value = 0)
	private BigDecimal cantidad;
	
	@XmlAttribute(required = true)
	@NotNull
	private String descripcion;
	
	@XmlAttribute(required = true)
	@NotNull @Min(value = 0)
	private BigDecimal importe;
	
	@XmlAttribute
	private String noIdentificacion;
	
	@XmlAttribute
	@XmlJavaTypeAdapter(UnidadesMedidaAdapter.class)
	@NotNull
	private UnidadesMedida unidad;
	
	@XmlAttribute(required = true)
	@NotNull @Min(value = 0)
	private BigDecimal valorUnitario;

	
}
