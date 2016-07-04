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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extranjero")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Extranjero {

	/**
	 * @param numRegIdTrib Atributo opcional para expresar el número de registro de identificación fiscal del receptor del documento cuando sea residente en el extranjero
	 */
	@XmlAttribute(required = false,name="NumRegIdTrib")
	@Size(max=20) 
	protected String numRegIdTrib;
	
	/**
	 * @param razonSocial Atributo requerido para expresar el nombre, denominación o razón social del receptor del documento cuando sea residente en el extranjero
	 */
	@XmlAttribute(required = true,name="NomDenRazSocR")
	@NotNull @Size(max=300)
	protected String razonSocial;
	
	
}
