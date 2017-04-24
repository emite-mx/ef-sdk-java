package mx.emite.sdk.cfdi33.complementos.ine11;

import java.io.Serializable;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contabilidad11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Contabilidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6818533242684309458L;
	@XmlAttribute(name="IdContabilidad")
	@NotNull
	private BigInteger idContabilidad;
    
	
}
