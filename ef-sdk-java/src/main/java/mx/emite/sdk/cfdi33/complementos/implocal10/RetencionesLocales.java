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
@XmlType(name = "RetencionesLocales")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class RetencionesLocales implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7524375291753209995L;

	@XmlAttribute(name="ImpLocRetenido")
	private String impLocRetenido;
    
	@XmlAttribute(name="TasadeRetencion")
	private BigDecimal tasaDeRetencion;
	
	@XmlAttribute(name="Importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal importe;
	
	
	
}
