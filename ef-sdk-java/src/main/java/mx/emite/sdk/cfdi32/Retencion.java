package mx.emite.sdk.cfdi32;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
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
import mx.emite.sdk.enums.sat.TiposImpuesto;
import mx.emite.sdk.enums.sat.adaptadores.TiposImpuestoAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Retencion {

	@XmlAttribute(required = true)
	@NotNull @Min(0)
	private BigDecimal importe;
	
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(TiposImpuestoAdapter.class)
	@NotNull
	private TiposImpuesto impuesto;

	
}
