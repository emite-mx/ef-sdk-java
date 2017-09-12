package mx.emite.sdk.cfdi33;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.adaptadores.PaisesSatAdapter;
import mx.emite.sdk.enums.sat.cfdi33.UsosCfdi33;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.UsosCfdi33Adapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receptor33 implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3808702153875576897L;

	/**
	 * rfc Atributo requerido para precisar la Clave del Registro Federal de Contribuyentes correspondiente al contribuyente receptor del comprobante.
	 */
	@XmlAttribute(name="Rfc")
	@NotNull
	@Rfc
	private String rfc;

	/**
	 * nombre Atributo opcional para precisar el nombre, denominación o razón social del contribuyente receptor del comprobante.
	 */
	@XmlAttribute(name="Nombre")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,254}",message="El nombre del receptor no cumple con el patrón del SAT")
	private String nombre;
	
	/**
	 * residenciaFiscal Atributo condicional para registrar la clave del país de residencia para efectos fiscales del receptor del comprobante, cuando se trate de un extranjero, y que es conforme con la especificación ISO 3166-1 alpha-3. Es requerido cuando se incluya el complemento de comercio exterior o se registre el atributo NumRegIdTrib.
	 */
	@XmlAttribute(name="ResidenciaFiscal")
	@XmlJavaTypeAdapter(PaisesSatAdapter.class) 
	private Paises residenciaFiscal;

	/**
	 * numRegIdTrib Atributo condicional para expresar el número de registro de identidad fiscal del receptor cuando sea residente en el extranjero. Es requerido cuando se incluya el complemento de comercio exterior.
	 */
	@XmlAttribute(name="NumRegIdTrib")
	@Size(min=1,max=40)
	private String numRegIdTrib;
	
	/**
	 * usoCfdi Atributo requerido para expresar la clave del uso que dará a esta factura el receptor del CFDI.
	 */
	@XmlAttribute(name="UsoCFDI")
	@XmlJavaTypeAdapter(UsosCfdi33Adapter.class) 
	@NotNull
	private UsosCfdi33 usoCfdi;
	
}
