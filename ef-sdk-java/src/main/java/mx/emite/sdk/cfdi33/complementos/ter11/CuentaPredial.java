package mx.emite.sdk.cfdi33.complementos.ter11;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CuentaPredialTer11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class CuentaPredial implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 3060220280911692152L;

	@XmlAttribute(name="numero")
	private String numero;
    
	
}
