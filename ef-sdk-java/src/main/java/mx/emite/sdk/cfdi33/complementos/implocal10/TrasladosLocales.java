package mx.emite.sdk.cfdi33.complementos.implocal10;

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
@XmlType(name = "TrasladosLocales")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class TrasladosLocales implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3049968299140371835L;

	@XmlAttribute(name="ImpLocTrasladado")
	private String impLocTrasladado;
    
	@XmlAttribute(name="TasadeTraslado")
	private BigDecimal tasaDeTraslado;
	
	@XmlAttribute(name="Importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal importe;
	
	
	
}
