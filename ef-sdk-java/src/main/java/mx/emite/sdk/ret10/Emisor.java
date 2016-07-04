package mx.emite.sdk.ret10;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Curp;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Emisor")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Emisor {

	/**
	 * @param rfc Atributo requerido para incorporar la clave en el Registro Federal de Contribuyentes correspondiente al contribuyente emisor del documento de retención e información de pagos, sin guiones o espacios.
	 */
	@XmlAttribute(required = true,name="RFCEmisor")
	@NotNull @Rfc
	protected String rfc;
	
	/**
	 * @param razonSocial Atributo opcional para el nombre, denominación o razón social del contribuyente emisor del documento de retención e información de pagos.
	 */
	@XmlAttribute(required = false,name="NomDenRazSocE")
	@Size(max=300)
	protected String razonSocial;
	
	/**
	 * @param curp Atributo opcional para la Clave Única del Registro Poblacional del contribuyente emisor del documento de retención e información de pagos.
	 */
	@XmlAttribute(required = false,name="CURPE")
	@Curp
	protected String curp;
	
}
