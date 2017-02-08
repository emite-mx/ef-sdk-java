package mx.emite.sdk.cfdi32.comp;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "domicilioFiscal", "expedidoEn", "regimenFiscal" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emisor32{

	@XmlElement(name = "DomicilioFiscal", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@NotNull @Valid
	private TUbicacionFiscal32 domicilioFiscal;
	
	@XmlElement(name = "RegimenFiscal", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@NotNull @Valid
	private RegimenFiscal32 regimenFiscal;
	
	@XmlElement(name = "ExpedidoEn", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private TUbicacion32 expedidoEn;
	
	@XmlAttribute(required = true)
	@NotNull
	protected String nombre;
	
	@XmlAttribute(required = true)
	@NotNull @Rfc
	protected String rfc;

	
}
