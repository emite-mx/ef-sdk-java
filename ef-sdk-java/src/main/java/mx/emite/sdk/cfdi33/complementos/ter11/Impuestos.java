package mx.emite.sdk.cfdi33.complementos.ter11;

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
@XmlType(name = "ImpuestosTerceros11", propOrder = { "retenciones", "traslados" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Impuestos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8367333688786859472L;

	@XmlElement(name = "Retenciones", namespace = "http://www.sat.gob.mx/terceros")
	@Valid
	private Retenciones retenciones;
	
	@XmlElement(name = "Traslados", namespace = "http://www.sat.gob.mx/terceros")
	@Valid
	private Traslados traslados;
	
	 

	
}
