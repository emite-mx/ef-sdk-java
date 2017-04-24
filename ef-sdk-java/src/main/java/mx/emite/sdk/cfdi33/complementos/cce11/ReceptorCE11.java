package mx.emite.sdk.cfdi33.complementos.cce11;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@XmlType(name="ReceptorCE33")
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ReceptorCE11 implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8798989313068176472L;

	@XmlAttribute(name="NumRegIdTrib")
	@Size(min=6,max=40)
	private String numRegIdTrib;
	
	@XmlElement(name="Domicilio",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid
	private DomicilioCE11 domicilio;
	
}
