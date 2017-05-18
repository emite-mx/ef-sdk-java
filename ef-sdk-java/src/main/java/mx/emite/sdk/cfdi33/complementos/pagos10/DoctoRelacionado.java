package mx.emite.sdk.cfdi33.complementos.pagos10;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.enums.sat.cfdi33.MetodosPago33;
import mx.emite.sdk.enums.sat.cfdi33.Monedas33;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.ImporteTcAdapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.MetodosPago33Adapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.Monedas33Adapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DoctoRelacionado10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DoctoRelacionado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3727181174606856713L;

	@XmlAttribute(name="IdDocumento")
	@NotNull
	@Pattern(regexp="([a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12})|([0-9]{3}-[0-9]{2}-[0-9]{9})")
	protected String idDocumento;
	
	@XmlAttribute(name="Serie")
	@Pattern(regexp="[^|]{1,25}")
	protected String Serie;
	
	@XmlAttribute(name="Folio")
	@Pattern(regexp="[^|]{1,40}")
	protected String Folio;
	
	@XmlAttribute(name="MonedaDR")
	@XmlJavaTypeAdapter(Monedas33Adapter.class)
	@NotNull
	protected Monedas33 monedaDR;
	
	@XmlAttribute(name="TipoCambioDR")
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	@DecimalMin(value="0.000001")
	protected BigDecimal tipoCambioDR;
	
	@XmlAttribute(name="MetodoDePagoDR")
	@XmlJavaTypeAdapter(MetodosPago33Adapter.class)
	@NotNull
	protected MetodosPago33 metodoDePagoDR;
	
	@XmlAttribute(name="NumParcialidad")
	protected Integer numParcialidad;
	
	@XmlAttribute(name="ImpSaldoAnt")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal impSaldoAnt;
	
	@XmlAttribute(name="ImpPagado")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal impPagado;
	
	@XmlAttribute(name="ImpSaldoInsoluto")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal ImpSaldoInsoluto;
	
		
}
