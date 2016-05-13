package mx.emite.sdk.cfdi32.nomina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Deducciones implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2401057397602968982L;

	@XmlAttribute(required = true,name="TotalGravado")
	@NotNull
    private BigDecimal totalGravado;
	
	@XmlAttribute(required = true,name="TotalExento")
    private BigDecimal totalExento;
	
    @XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Deduccion")
    @Valid @Singular(value="deduccion")
    private List<Deduccion> deducciones;

    
	
    
}
