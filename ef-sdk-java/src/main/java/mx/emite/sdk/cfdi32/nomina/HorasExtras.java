package mx.emite.sdk.cfdi32.nomina;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
public class HorasExtras implements Serializable {

	
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2344214813949883224L;
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="HorasExtra")
	@Valid @Singular
    private List<HorasExtra> horasExtras;
	
	    
	
	
	

    
}
