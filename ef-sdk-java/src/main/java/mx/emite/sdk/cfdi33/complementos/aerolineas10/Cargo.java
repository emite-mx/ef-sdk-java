package mx.emite.sdk.cfdi33.complementos.aerolineas10;

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
@XmlType(name = "Cargo")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Cargo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5817069381238598693L;

	@XmlAttribute(name="CodigoCargo")
	private String codigoCargo;
    
	@XmlAttribute(name="Importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal importe;
	
	
	
}
