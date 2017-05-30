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
@XmlType(name = "TrasladosTerceros11", propOrder = { "traslados" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Traslados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7598471483006235514L;
	@XmlElement(name = "Traslado", namespace = "http://www.sat.gob.mx/terceros", required = true)
	@Valid @Singular("traslado")
	protected List<Traslado> traslados;
 
	
}
