package mx.emite.sdk.proxy.request.extra.generico.xml;



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

import lombok.Data;
import mx.emite.sdk.enums.sat.FormasPago;
import mx.emite.sdk.enums.sat.Monedas;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.enums.sat.TipoDeComprobante;
import mx.emite.sdk.enums.sat.TipoPago;
import mx.emite.sdk.enums.sat.adaptadores.FormasPagoAdapter;
import mx.emite.sdk.enums.sat.adaptadores.MonedasAdapter;
import mx.emite.sdk.enums.sat.adaptadores.RegimenesFiscalesAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoDeComprobanteAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoPagoAdapter;


@XmlRootElement(name="Factura")
@Data
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
	@XmlJavaTypeAdapter(FormasPagoAdapter.class)
	private FormasPago metodoPago;

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
	
	//@XmlAttribute(name="comentario")
	//@Size(max=200)
	//private String comentario;
	
	@XmlElement(name="ExpedidoEn")
	@Valid @NotNull
	private GenericoExpedidoEn expedidoEn;
	
	@XmlElement(name="Receptor")
	@Valid @NotNull
	private GenericoReceptor receptor;
	
	@XmlElement(name="Conceptos")
	@Valid @NotNull
	private List<GenericoConcepto> conceptos;
	
	
	
	/*public void setEmisor(GenericoEmisor emisor){
		if(this.emisor==null)
			this.emisor=emisor;
		else{
			if(this.emisor.getRegimenFiscal()==null)
				this.emisor.setRegimenFiscal(emisor.getRegimenFiscal());
			if(this.emisor.getExpedidoEn()==null)
				this.emisor.setExpedidoEn(emisor.getExpedidoEn());
		}
	}
	
	public List<GenericoConcepto> getPartidas(){
		if(conceptos==null)
			conceptos=new GenericoConceptos();
		return conceptos.getConcepto();
	}
	
	public void setPartidas(List<GenericoConcepto> c){
		if(conceptos==null)
			conceptos=new GenericoConceptos();
		conceptos.setConcepto(c);
	}*/
	
}
/*
<factura tipoComprobante="ingreso" serie="E" folio="0000000112" subtotal="13251185.4000" descuento="5279085.1400" total="7972100.2600" formaDePago="PAGO EN UNA SOLA EXHIBICION" noTicket="1447" lugarExpedicion="MEXICO, DISTRITO FEDERAL" metodoPago="NO IDENTIFICADO" numeroCuentaPago="NO IDENTIFICADO" moneda="MXN" tipoCambio="" comentario="">
<emisor>
	<RegimenFiscal Regimen="REGIMEN GENERAL DE LEY PERSONAS MORALES"/>
	<ExpedidoEn calle="REPUBLICA DE ARGENTINA" noExterior="15" noInterior="" colonia="CENTRO" municipio="CUAUHTEMOC" estado="DISTRITO FEDERAL" pais="Mexico" cp="06020"/>
</emisor>
<receptor rfc="LPH510514IQ7" nombre="LIBRERIA DE PORRUA HERMANOS Y COMPANIA, S.A. DE C.V." calle="REPUBLICA DE ARGENTINA" noExterior="15" noInterior="" colonia="CENTRO" localidad="" municipio="CUAUHTEMOC" estado="DISTRITO FEDERAL" cp="06020" pais="Mexico"/>
<conceptos>
	<concepto noIdentificacion="9789700767987" cantidad="11" unidad="PZA" descripcion="12 DISCIPLINAS PARA ALCANZAR TUS SUEOS" precioUnitario="105.00" iva="0.0000" importe="1155.0000" tasaIva="0.00"/>
</conceptos>
</factura>*/