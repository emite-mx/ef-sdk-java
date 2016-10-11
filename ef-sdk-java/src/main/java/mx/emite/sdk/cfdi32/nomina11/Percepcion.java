package mx.emite.sdk.cfdi32.nomina11;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.TiposPercepcion;
import mx.emite.sdk.enums.sat.adaptadores.TiposPercepcionAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Percepcion implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6456188308509936700L;
	
	@XmlAttribute(required = true,name="TipoPercepcion")
	@XmlJavaTypeAdapter(TiposPercepcionAdapter.class)
	@NotNull
    private TiposPercepcion tipoPercepcion;
	
	@XmlAttribute(name="Clave")
	private String clave;
	
	@XmlAttribute(name="Concepto")
	@NotNull
    private String concepto;
	
	@XmlAttribute(required = true,name="ImporteGravado")
	@NotNull
    private BigDecimal importeGravado;
	
	@XmlAttribute(required = true,name="ImporteExento")
	@NotNull
    private BigDecimal importeExento;
	
   
	
    
}
