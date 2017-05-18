package mx.emite.sdk.cfdi33.complementos.ecc11;

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
@XmlType(name = "ConceptosEcc11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Conceptos implements Serializable {

	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5030385567395463458L;
	
	@XmlElement(namespace="http://www.sat.gob.mx/EstadoDeCuentaCombustible",name="ConceptoEstadoDeCuentaCombustible")
	@Valid @Singular("concepto")
	private List<ConceptoEstadoDeCuentaCombustible> conceptos;
	
    
	
}
