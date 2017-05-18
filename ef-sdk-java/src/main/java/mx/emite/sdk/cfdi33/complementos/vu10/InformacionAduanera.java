package mx.emite.sdk.cfdi33.complementos.vu10;

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
@XmlType(name = "InformacionAduanera10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class InformacionAduanera implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 6556657552017163088L;

	@XmlAttribute(name="numero")
	private String numero;
    
	@XmlAttribute(name="fecha")
	private String fecha;
	
	@XmlAttribute(name="aduana")
	private String aduana;
	
	
	
}
