package mx.emite.sdk.proxy.request.extra.generico.nomina.xml;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.TiposDeduccion;
import mx.emite.sdk.enums.sat.adaptadores.TiposDeduccionAdapter;
import mx.emite.sdk.utils.Utilerias;


@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class GenericoDeduccion {

	@XmlAttribute(name="importeExento")
	@Digits(integer=24,fraction=6)
	@NotNull 
	private BigDecimal importeExento;
	
	@XmlAttribute(name="importeGravado")
	@Digits(integer=24,fraction=6)
	@NotNull 
	private BigDecimal importeGravado;
	
	@XmlAttribute(name="concepto")
	@NotNull
	@Size(max=150)
	private String concepto;
	
	@XmlAttribute(name="clave")
	@NotNull
	@Size(max=150)
	private String clave;
	
	@XmlAttribute(name="tipo")
	@NotNull
	@XmlJavaTypeAdapter(TiposDeduccionAdapter.class)
	private TiposDeduccion tipo;
	
	public BigDecimal getImporte(){
		return Utilerias.nvl(importeExento,BigDecimal.ZERO).add(Utilerias.nvl(importeGravado,BigDecimal.ZERO));
	}
	
	
	
	
}
