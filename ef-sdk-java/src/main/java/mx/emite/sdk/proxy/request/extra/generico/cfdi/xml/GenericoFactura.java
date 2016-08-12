package mx.emite.sdk.proxy.request.extra.generico.cfdi.xml;



import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
import mx.emite.sdk.enums.sat.Monedas;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.enums.sat.TipoDeComprobante;
import mx.emite.sdk.enums.sat.TipoPago;
import mx.emite.sdk.enums.sat.adaptadores.MetodosPagoAdapter;
import mx.emite.sdk.enums.sat.adaptadores.MonedasAdapter;
import mx.emite.sdk.enums.sat.adaptadores.RegimenesFiscalesAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoDeComprobanteAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoPagoAdapter;
import mx.emite.sdk.proxy.request.extra.generico.nomina.xml.GenericoEnvio;


@XmlRootElement(name="Factura")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class GenericoFactura {

	@XmlAttribute(name="tipoComprobante")
	@NotNull @XmlJavaTypeAdapter(TipoDeComprobanteAdapter.class)
	private TipoDeComprobante tipoComprobante;
	
	@XmlAttribute(name="serie")
	@Size(max=25)
	private String serie;
	
	@XmlAttribute(name="folio")
	@Size(max=40)
	private String folio;
	
	@XmlAttribute(name="subtotal")
	@Digits(integer=24,fraction=6)
	@NotNull
	private BigDecimal subtotal;
	
	@XmlAttribute(name="descuento")
	@Digits(integer=24,fraction=6)
	private BigDecimal descuento;
	
	@XmlAttribute(name="motivoDescuento")
	@Size(max=100)
	private String motivoDescuento;

	@XmlAttribute(name="total")
	@Digits(integer=24,fraction=6)
	@NotNull
	private BigDecimal total;
	
	@XmlAttribute(name="formaDePago")
	@NotNull
	@XmlJavaTypeAdapter(TipoPagoAdapter.class)
	private TipoPago formaDePago;
	
	@XmlAttribute(name="lugarExpedicion")
	@NotNull
	private String lugarExpedicion;
	
	//@XmlAttribute(name="noTicket")
	//private String noTicket;
	
	@XmlAttribute(name="metodoPago")
	@NotNull
	@XmlJavaTypeAdapter(MetodosPagoAdapter.class)
	private MetodosPago metodoPago;

	@XmlAttribute(name="numeroCuentaPago")
	@NotNull
	private String numeroCuentaPago;
	
	@XmlAttribute(name="moneda")
	@XmlJavaTypeAdapter(MonedasAdapter.class)
	private Monedas moneda;
	
	@XmlAttribute(name="tipoCambio")
	@Digits(integer=24,fraction=6)
	private BigDecimal tipoCambio;
	
	@XmlAttribute(name="regimen")
	@XmlJavaTypeAdapter(RegimenesFiscalesAdapter.class)
	private RegimenesFiscales regimen;
	
	
	
	@XmlElement(name="ExpedidoEn")
	@Valid 
	private GenericoExpedidoEn expedidoEn;
	
	@XmlElement(name="Receptor")
	@Valid @NotNull
	private GenericoReceptor receptor;
	
	@XmlElement(name="Conceptos")
	@Valid @NotNull @Singular
	private List<GenericoConcepto> conceptos;
	
	@XmlElement(name="Envio")
	@Valid 
	private GenericoEnvio envio;

	public BigDecimal getTotalImpuestosTrasladados() {
		return conceptos.stream().map(GenericoConcepto::getTotalImpuestosTrasladados).reduce(BigDecimal.ZERO,BigDecimal::add);
	}

	public BigDecimal getTotalImpuestosRetenidos() {
		return conceptos.stream().map(GenericoConcepto::getTotalImpuestosRetenidos).reduce(BigDecimal.ZERO,BigDecimal::add);
	}

	
	
	
}