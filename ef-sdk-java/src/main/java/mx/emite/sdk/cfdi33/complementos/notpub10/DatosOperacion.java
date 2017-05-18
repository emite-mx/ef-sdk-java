package mx.emite.sdk.cfdi33.complementos.notpub10;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosOperacion10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DatosOperacion implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3902005914006629995L;

	@XmlAttribute(name="NumInstrumentoNotarial")
	private String numInstrumentoNotarial;
    
	@XmlAttribute(name="FechaInstNotarial",required = true)
	protected String fechaInstNotarial;

	@XmlAttribute(name="MontoOperacion")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal montoOperacion;
	
	@XmlAttribute(name="Subtotal")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal subtotal;
	
	
	@XmlAttribute(name="IVA")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal iva;
	
	
}
