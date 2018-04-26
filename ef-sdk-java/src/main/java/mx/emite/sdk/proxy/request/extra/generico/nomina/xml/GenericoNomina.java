package mx.emite.sdk.proxy.request.extra.generico.nomina.xml;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.enums.sat.MetodosPago;
import mx.emite.sdk.enums.sat.TiposDeduccion12;
import mx.emite.sdk.enums.sat.TiposPeriodicidad12;
import mx.emite.sdk.enums.sat.adaptadores.MetodosPagoAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposPeriodicidadAdapter;
import mx.emite.sdk.serializers.LocalDateAdapter;

@XmlRootElement(name="GenericoNomina")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericoNomina {

	@XmlAttribute(name="serie")
	@Size(max=25)
	private String serie;
	
	@XmlAttribute(name="folio")
	@Size(max=40)
	private String folio;
	
	@XmlAttribute(name="concepto")
	@NotNull @Size(max=150)
	private String concepto;
	
	@XmlAttribute(name="lugarExpedicion")
	@NotNull
	private String lugarExpedicion;
	
	
	@XmlAttribute(name="metodoPago")
	@NotNull
	@XmlJavaTypeAdapter(MetodosPagoAdapter.class)
	private MetodosPago metodoPago;
	
	@XmlAttribute(name="numCuentaPago")
	@NotNull @Size(max=25)
	private String numCuentaPago;
	
	@XmlAttribute(name="registroPatronal")
	@Size(max=25)
	private String registroPatronal;
	
	
	@XmlAttribute(name="fechaInicialPago")
	@NotNull
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate fechaInicialPago;
	
	@XmlAttribute(name="fechaFinalPago")
	@NotNull
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate fechaFinalPago;
	
	@XmlAttribute(name="fechaPago")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate fechaPago;
	
	@XmlAttribute(name="numDiasPagados")
	private Integer numDiasPagados;
	
	@XmlAttribute(name="observaciones")
	@Size(max=200)
	private String observaciones;
	
	@XmlAttribute(name="periodicidadPago")
	@XmlJavaTypeAdapter(TiposPeriodicidadAdapter.class)
	@NotNull 
	private TiposPeriodicidad12 periodicidadPago;
	
	@XmlElement(name="Empleado")
	@NotNull @Valid
	private GenericoEmpleado empleado;
	
	@XmlElement(name="Percepcion")
	@Valid @Singular("percepcion")
	private List<GenericoPercepcion> percepciones;
	
	@XmlElement(name="Deduccion")
	@Valid @Singular("deduccion")
	private List<GenericoDeduccion> deducciones;

	@XmlElement(name="Envio")
	@Valid 
	private GenericoEnvio envio;
	
	public BigDecimal subtotal() {
		if(percepciones==null||percepciones.isEmpty())
			return BigDecimal.ZERO;
		return percepciones.stream().map(GenericoPercepcion::getImporte).reduce(BigDecimal.ZERO,BigDecimal::add);
	}
	
	public BigDecimal isr() {
		if(deducciones==null||deducciones.isEmpty())
			return BigDecimal.ZERO;
		return deducciones.stream().filter(d->d.getTipo().in(TiposDeduccion12.ISR)) .map(GenericoDeduccion::getImporte).reduce(BigDecimal.ZERO,BigDecimal::add);
	}
	
	public BigDecimal descuento() {
		if(deducciones==null||deducciones.isEmpty())
			return BigDecimal.ZERO;
		return deducciones.stream().filter(d->d.getTipo().notin(TiposDeduccion12.ISR)) .map(GenericoDeduccion::getImporte).reduce(BigDecimal.ZERO,BigDecimal::add);
	}
	
	public BigDecimal total(){
		return subtotal().subtract(isr()).subtract(descuento());
	}
	
}
