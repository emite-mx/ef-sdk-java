package mx.emite.sdk.cfdi33.complementos.ter11;

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
@XmlType(name = "RetencionesTerceros11", propOrder = { "retenciones" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Retenciones implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3020259720133274694L;
	@XmlElement(name = "Retencion", namespace = "http://www.sat.gob.mx/terceros", required = true)
	@Valid @Singular(value="retencion")
	protected List<Retencion> retenciones;

	
}
