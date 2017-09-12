package mx.emite.sdk.cfdi33.complementos.pagos10;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.enums.sat.cfdi33.FormasPago33;
import mx.emite.sdk.enums.sat.cfdi33.Monedas33;
import mx.emite.sdk.enums.sat.cfdi33.TiposCadenaPago33;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.FormasPago33Adapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.ImporteTcAdapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.Monedas33Adapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.TiposCadenaPago33Adapter;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pago10")
@Data
@Builder
@AllArgsConstructor
public class Pago implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 525066981767754007L;

	@XmlAttribute(name="FechaPago",required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@NotNull
	protected LocalDateTime fechaPago;
	
	@XmlAttribute(name="FormaDePagoP")
	@XmlJavaTypeAdapter(FormasPago33Adapter.class)
	@NotNull
	protected FormasPago33 formaDePagoP;
	
	@XmlAttribute(name="MonedaP")
	@XmlJavaTypeAdapter(Monedas33Adapter.class)
	@NotNull
	
	protected Monedas33 monedaP = Monedas33.MXN;
	
	@XmlAttribute(name="TipoCambioP")
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	@DecimalMin(value="0.000001")
	protected BigDecimal tipoCambioP;
	
	@XmlAttribute(name="Monto",required = true)
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull @Min(value = 0)
	protected BigDecimal monto;
	
	@XmlAttribute(name="NumOperacion")
	@Pattern(regexp="[^|]{1,100}")
	protected String numOperacion;
	
	@XmlAttribute(name="RfcEmisorCtaOrd")
	@Pattern(regexp="XEXX010101000|[A-Z&amp;Ñ]{3}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]")
	private String rfcEmisorCtaOrd;
	
	@XmlAttribute(name="NomBancoOrdExt")
	@Pattern(regexp="[^|]{1,300}")
	protected String nomBancoOrdExt;
    
	@XmlAttribute(name="CtaOrdenante")
	@Pattern(regexp="[A-Z0-9_]{10,50}")
	protected String ctaOrdenante;
	
	@XmlAttribute(name="RfcEmisorCtaBen")
	@Rfc
	private String rfcEmisorCtaBen;
	
	@XmlAttribute(name="CtaBeneficiario")
	@Pattern(regexp="[A-Z0-9_]{10,50}")
	protected String ctaBeneficiario;
	
	@XmlAttribute(name="TipoCadPago")
	@XmlJavaTypeAdapter(TiposCadenaPago33Adapter.class)
	protected TiposCadenaPago33 tipoCadPago;
	
	@XmlAttribute(name="CertPago")
	protected String certPago;
	
	@XmlAttribute(name="CadPago")
	@Size(max=8192)
	protected String cadPago;
	
	@XmlAttribute(name="SelloPago")
	protected String selloPago;
	
	@XmlElement(name="DoctoRelacionado",namespace="http://www.sat.gob.mx/Pagos")
	@Valid @Singular("doctoRelacionado")
	private List<DoctoRelacionado> doctoRelacionados;
	
	@XmlElement(name="Impuestos",namespace="http://www.sat.gob.mx/Pagos")
	@Valid @Singular("impuesto")
	private List<ImpuestosPago> impuestos;
	
	public static Pago nuevo() {
		return builder().build();
	}
	
	
	public Pago() {
		monedaP = Monedas33.MXN;	
	}
	
}
