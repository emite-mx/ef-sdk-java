package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConceptosRetenciones33 implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2661844820659756807L;

	/**
	 * retenciones Nodo opcional para asentar los impuestos retenidos aplicables al presente concepto.
	 */
	@XmlElement(name="Retencion", namespace = "http://www.sat.gob.mx/cfd/3")
	@NotEmpty
	@Valid
	@Singular("retencion")
	protected List<ConceptosRetencion33> retenciones;

	
}
