package mx.emite.sdk.cfdi33.complementos.cdc10;

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
@XmlType(name = "Determinado10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Determinado implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3120635455041252449L;

	@XmlAttribute(name="impuesto")
	private String impuesto;
    
	@XmlAttribute(name="tasa")
	private BigDecimal tasa;
	
	@XmlAttribute(name="importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal importe;
	
	
}
