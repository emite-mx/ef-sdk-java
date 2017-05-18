package mx.emite.sdk.cfdi33.complementos.cdc10;

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
@XmlType(name = "ConceptosCombustibles10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Conceptos implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4803509053840925004L;
	@XmlElement(name="ConceptoConsumoDeCombustibles", namespace = "http://www.sat.gob.mx/consumodecombustibles")
	@Valid @Singular("concepto")
	private List<ConceptoConsumoDeCombustibles> conceptos;
	
	
	
}
