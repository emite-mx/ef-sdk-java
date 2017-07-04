package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.cfdi33.FormasPago33;
import mx.emite.sdk.enums.sat.cfdi33.MetodosPago33;
import mx.emite.sdk.enums.sat.cfdi33.Monedas33;
import mx.emite.sdk.enums.sat.cfdi33.TiposDeComprobante33;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.FormasPago33Adapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.ImporteTcAdapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.MetodosPago33Adapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.Monedas33Adapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.TiposDeComprobante33Adapter;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;
import mx.emite.sdk.utils.ComplementoConcepto33Interface;
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "cfdiRelacionados","emisor","receptor","conceptos","impuestos","complemento" })
@XmlRootElement(name = "Comprobante", namespace = "http://www.sat.gob.mx/cfd/3")
@Data
@Builder 
@NoArgsConstructor 
@AllArgsConstructor
public class Comprobante33  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5776970128209831995L;

	/**
	 * version  Atributo requerido con valor prefijado a 3.3 que indica la versión del estándar bajo el que se encuentra expresado el comprobante.
	 */
	@XmlAttribute(required = true,name="Version")
	@NotNull
	protected final String version = "3.3";
	
	/**
	 * serie Atributo opcional para precisar la serie para control interno del contribuyente. Este atributo acepta una cadena de caracteres.
	 */
	@XmlAttribute(name="Serie")
	@Size(max=25) 
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü| Ü){1,25}")
	protected String serie;
	
	/**
	 * folio Atributo opcional para control interno del contribuyente que expresa el folio del comprobante, caracteres.
	 */
	@XmlAttribute(name="Folio")
	@Size(max=25)
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü| Ü){1,40}")
	protected String folio;
	
	/**
	 * fecha Atributo requerido para la expresión de la fecha y hora de expedición del Comprobante Fiscal Digital por Internet. Se expresa en la forma AAAA-MM-DDThh:mm:ss y debe corresponder con la hora local donde se expide el comprobante.
	 */
	@XmlAttribute(name="Fecha",required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@NotNull
	protected LocalDateTime fecha;

	/**
	 * sello Atributo requerido para contener el sello digital del comprobante fiscal, al que hacen referencia las reglas de resolución miscelánea vigente. El sello debe ser expresado como una cadena de texto en formato Base 64.
	 */
	@XmlAttribute(name="Sello")
	protected String sello;
	
	/**
	 * formaPago Atributo condicional para expresar la clave de la forma de pago de los bienes o servicios amparados por el comprobante. Si no se conoce la forma de pago este atributo se debe omitir.
	 */
	@XmlAttribute(name="FormaPago")
	@XmlJavaTypeAdapter(FormasPago33Adapter.class)
	protected FormasPago33 formaPago;

	/**
	 * noCertificado Atributo requerido para expresar el número de serie del certificado de sello digital que ampara al comprobante, de acuerdo con el acuse correspondiente a 20 posiciones otorgado por el sistema del SAT.
	 */
	@XmlAttribute(name="NoCertificado",required = true)
	@Digits(integer=20, fraction = 0)
	protected String noCertificado;
	
	/**
	 * certificado Atributo requerido que sirve para incorporar el certificado de sello digital que ampara al comprobante, como texto en formato base 64.
	 */
	@XmlAttribute(name="Certificado",required = true)
	protected String certificado;
	
	/**
	 * condicionesDePago Atributo condicional para expresar las condiciones comerciales aplicables para el pago del comprobante fiscal digital por Internet. Este atributo puede ser condicionado mediante atributos o complementos.
	 */
	@XmlAttribute(name="CondicionesDePago")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü| Ü){1,1000}")
	protected String condicionesDePago;
	
	/**
	 * subtotal Atributo requerido para representar la suma de los importes de los conceptos antes de descuentos e impuesto. No se permiten valores negativos.
	 */
	@XmlAttribute(name="SubTotal",required = true)
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	@NotNull @Min(value = 0)
	protected BigDecimal subTotal;
	
	/**
	 * descuento Atributo condicional para representar el importe total de los descuentos aplicables antes de impuestos. No se permiten valores negativos. Se debe registrar cuando existan conceptos con descuento.
	 */
	@XmlAttribute(name="Descuento")
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	@Min(value = 0)
	protected BigDecimal descuento;
	
	/**
	 * moneda Atributo condicional para expresar la clave de la forma de pago de los bienes o servicios amparados por el comprobante. Si no se conoce la forma de pago este atributo se debe omitir.
	 */
	@XmlAttribute(name="Moneda")
	@XmlJavaTypeAdapter(Monedas33Adapter.class)
	@NotNull
	protected Monedas33 moneda = Monedas33.MXN;
	
	/**
	 *  tipoCambio Atributo condicional para representar el tipo de cambio conforme con la moneda usada. Es requerido cuando la clave de moneda es distinta de MXN y de XXX. El valor debe reflejar el número de pesos mexicanos que equivalen a una unidad de la divisa señalada en el atributo moneda. Si el valor está fuera del porcentaje aplicable a la moneda tomado del catálogo c_Moneda, el emisor debe obtener del PAC que vaya a timbrar el CFDI, de manera no automática, una clave de confirmación para ratificar que el valor es correcto e integrar dicha clave en el atributo Confirmacion.
	 */
	@XmlAttribute(required = true,name="TipoCambio")
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	@DecimalMin(value="0.000001")
	protected BigDecimal tipoCambio;
	
	
	/**
	 * total Atributo requerido para representar la suma del subtotal, menos los descuentos aplicables, más las contribuciones recibidas (impuestos trasladados - federales o locales, derechos, productos, aprovechamientos, aportaciones de seguridad social, contribuciones de mejoras) menos los impuestos retenidos. Si el valor es superior al límite que establezca el SAT en la Resolución Miscelánea Fiscal vigente, el emisor debe obtener del PAC que vaya a timbrar el CFDI, de manera no automática, una clave de confirmación para ratificar que el valor es correcto e integrar dicha clave en el atributo Confirmacion. No se permiten valores negativos.
	 */
	@XmlAttribute(name="Total",required = true)
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	@NotNull @Min(value = 0)
	protected BigDecimal total;
	
	/**
	 * tipoDeComprobante Atributo requerido para expresar la clave del efecto del comprobante fiscal para el contribuyente emisor.
	 */
	@XmlAttribute(name="TipoDeComprobante")
	@XmlJavaTypeAdapter(TiposDeComprobante33Adapter.class)
	@NotNull
	protected TiposDeComprobante33 tipoDeComprobante;
	
	/**
	 * metodoPago Atributo condicional para precisar la clave del método de pago que aplica para este comprobante fiscal digital por Internet, conforme al Artículo 29-A fracción VII incisos a y b del CFF.
	 */
	@XmlAttribute(name="MetodoPago")
	@XmlJavaTypeAdapter(MetodosPago33Adapter.class)
	protected MetodosPago33 metodoPago;
	
	
	/**
	 * lugarExpedicion Atributo requerido para incorporar el código postal del lugar de expedición del comprobante (domicilio de la matriz o de la sucursal).
	 */
	@XmlAttribute(name="LugarExpedicion")
	@Pattern(regexp="\\d{5}")
	@NotNull
	protected String lugarExpedicion;
	
	
	/**
	 * confirmacion Atributo condicional para registrar la clave de confirmación que entregue el PAC para expedir el comprobante con importes grandes, con un tipo de cambio fuera del rango establecido o con ambos casos. Es requerido cuando se registra un tipo de cambio o un total fuera del rango establecido.
	 */
	@XmlAttribute(name="Confirmacion")
	@Pattern(regexp="[0-9a-zA-Z]{5}")
	protected String confirmacion;
	
	/**
	 * cfdiRelacionados Nodo opcional para precisar la información de los comprobantes relacionados.
	 */
	@XmlElement(name = "CfdiRelacionados", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid
	private CfdiRelacionados33 cfdiRelacionados;
	
	/**
	 * emisor  Nodo requerido para expresar la información del contribuyente emisor del comprobante.
	 */
	@XmlElement(name = "Emisor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Emisor33 emisor;
	
	/**
	 * receptor Nodo requerido para precisar la información del contribuyente receptor del comprobante.
	 */
	@XmlElement(name = "Receptor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Receptor33 receptor;
	
	/**
	 * conceptos Nodo requerido para listar los conceptos cubiertos por el comprobante.
	 */
	@XmlElement(name = "Conceptos", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Conceptos33 conceptos;
	
	/**
	 * impuestos Nodo condicional para expresar el resumen de los impuestos aplicables.
	 *
	 */
	@XmlElement(name="Impuestos", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private Impuestos33 impuestos;
	
	@XmlElement(name = "Complemento", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	private Complemento33 complemento = null;
	
	public boolean tieneComplementos(){
		return complemento!=null&&complemento.getComplementos()!=null&&!complemento.getComplementos().isEmpty();
	}
	
	public boolean tieneComplementosConceptos(){
		return conceptos!=null&& conceptos.getConceptos()!=null && conceptos.getConceptos().stream().filter(i->i.tieneComplementos()).findAny().isPresent();
	}

	public List<ComplementoConcepto33Interface> getComplementosConceptos() {
		return conceptos.getConceptos().stream().flatMap(i->i.getComplementoConcepto().getComplementos().stream()).collect(Collectors.toList());
	}
	
	/*@XmlElement(name = "Emisor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Emisor emisor;

	@XmlElement(name = "Receptor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Receptor receptor;

	@XmlElement(name = "Conceptos", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Conceptos conceptos;

	@XmlElement(name = "Impuestos", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private final Impuestos impuestos = new Impuestos();

	@XmlElement(name = "Complemento", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	private Complemento complemento = null;

	@XmlAttribute
	protected String certificado;

	@XmlAttribute(name = "LugarExpedicion")
	@NotNull
	protected String lugarExpedicion;

	@XmlAttribute
	@Min(value = 0)
	protected BigDecimal descuento;

	@XmlAttribute(name="motivoDescuento")
	protected String motivoDescuento;
	
	
	@XmlAttribute(required = true)
	protected String folio;

	@XmlAttribute(required = true,name="formaDePago")
	@NotNull 
	protected final String formaDePago = "En una sola exhibición";

	@XmlAttribute
	@NotNull
	@XmlJavaTypeAdapter(MetodosPagoAdapter.class)
	protected final MetodosPago metodoDePago = MetodosPago.NA;

	


	

	@XmlAttribute(required = true)
	@NotNull @Min(value = 0)
	protected BigDecimal subTotal;

	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(TipoDeComprobanteAdapter.class)
	@NotNull
	protected final TipoDeComprobante tipoDeComprobante = TipoDeComprobante.EGRESO;

	@XmlAttribute(required = true)
	@NotNull @Min(value = 0)
	protected BigDecimal total;

	@XmlAttribute(name = "Moneda")
	@XmlJavaTypeAdapter(MonedasAdapter.class)
	protected final Monedas moneda = Monedas.MXN;

	@XmlAttribute(name = "TipoCambio")
	@Min(value = 0)
	protected final BigDecimal tipoCambio = null;

	

	@XmlAttribute(required = true, name = "NumCtaPago")
	@Null
	protected final String numCtaPago = null;

	public String generaXml(){
		return Utilerias.marshallnom12(this);
	}
	*/
}
