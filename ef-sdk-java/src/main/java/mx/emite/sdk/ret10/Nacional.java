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
@XmlType(name = "Nacional")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * 
 *  <h1>titulo</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 * Nodo requerido para expresar la información del contribuyente receptor en caso de que sea de nacionalidad mexicana
 */
public class Nacional {

	/**
	 * @param rfc Atributo requerido para la clave del Registro Federal de Contribuyentes correspondiente al contribuyente receptor del documento
	 */
	@XmlAttribute(required = true,name="RFCRecep")
	@NotNull @Rfc
	protected String rfc;
	
	/**
	 * @param razonSocial Atributo opcional para el nombre, denominación o razón social del contribuyente receptor del documento.
	 */
	@XmlAttribute(required = false,name="NomDenRazSocR")
	@Size(max=300)
	protected String razonSocial;
	
	/**
	 * @param curp Atributo opcional para la Clave Única del Registro Poblacional del contribuyente receptor del documento
	 */
	@XmlAttribute(required = false,name="CURPR")
	@Curp
	protected String curp;
	
}
