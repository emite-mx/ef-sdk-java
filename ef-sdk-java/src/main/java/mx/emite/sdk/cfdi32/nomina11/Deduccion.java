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
import mx.emite.sdk.enums.sat.TiposDeduccion;
import mx.emite.sdk.enums.sat.adaptadores.TiposDeduccionAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Deduccion implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6844451319223470161L;

	@XmlAttribute(required = true,name="TipoDeduccion")
	@XmlJavaTypeAdapter(TiposDeduccionAdapter.class)
	@NotNull
    private TiposDeduccion tipoDeduccion;
	
	@XmlAttribute(name="Clave")
    private String clave;
	
	@XmlAttribute(name="Concepto")
    private String concepto;
	
	@XmlAttribute(required = true,name="ImporteGravado")
	@NotNull
    private BigDecimal importeGravado;
	
	@XmlAttribute(required = true,name="ImporteExento")
	@NotNull
    private BigDecimal importeExento;
	
   
    
}
