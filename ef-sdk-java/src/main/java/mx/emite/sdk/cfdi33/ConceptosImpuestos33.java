package mx.emite.sdk.cfdi33;

import java.io.Serializable;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder={"traslados","retenciones"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConceptosImpuestos33 implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1929024390252570035L;
	
	
	
	
	/**
	 * traslados Nodo opcional para asentar los impuestos trasladados aplicables al presente concepto.
	 */
	@XmlElement(name="Traslados", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private ConceptosTraslados33 traslados;

	/**
	 * retenciones Nodo opcional para asentar los impuestos retenidos aplicables al presente concepto.
	 */
	@XmlElement(name="Retenciones", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private ConceptosRetenciones33 retenciones;

	
}
