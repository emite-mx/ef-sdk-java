package mx.emite.sdk.cfdi33.complementos.ccd10;

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
@XmlType(name = "InformacionAduaneraVD10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class InformacionAduanera implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5167208457536504614L;

	@XmlAttribute(name="NumPedImp")
	private String numPedImp;
    
	@XmlAttribute(name="Fecha")
	private String fecha;
	
	@XmlAttribute(name="Aduana")
	private String aduana;
	
	
	
}
