package mx.emite.sdk.cfdi33.complementos.ecc11;

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
@XmlType(name = "TrasladoEcc11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Traslado implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3273263396965596944L;

	@XmlAttribute(name="Impuesto")
	private String impuesto;
    
	@XmlAttribute(name="TasaoCuota")
	private BigDecimal tasa;
	
	@XmlAttribute(name="Importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal importe;
	
	
	
}
