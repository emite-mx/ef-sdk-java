package mx.emite.sdk.dd10.dpiva10;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.utils.Utilerias;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "emisor", "tipoDocto" })
@XmlRootElement(name = "DoctoDigital", namespace = "http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/1")
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class DoctoDigital implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1887902476301046080L;

	@XmlElement(name = "Emisor", namespace = "http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/1", required = true)
	@Valid @NotNull
	private Emisor emisor;

	@XmlElement(name = "TipoDoctoDigital", namespace = "http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/1", required = true)
	@Valid @NotNull
	private TipoDoctoDigital tipoDocto;

	@XmlAttribute(name="TipoDoctoDigital")
	private final String tipoDoctoDigital="0001";

	@XmlAttribute(name="Version",required = true)
	protected final String version = "1.0";
	
	@XmlAttribute(name = "NumCert")
	@NotNull @Size(min=20,max=20)
	protected String numCert;
	
	@XmlAttribute(name = "Firma")
	protected String firma;
	
	@XmlAttribute(name = "Cert")
	protected String cert;

	public String generaXml(){
		return Utilerias.marshalldpiva10(this);
	}
}
