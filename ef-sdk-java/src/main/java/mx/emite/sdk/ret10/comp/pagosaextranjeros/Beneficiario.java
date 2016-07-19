package mx.emite.sdk.ret10.comp.pagosaextranjeros;

import javax.validation.constraints.NotNull;
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
import mx.emite.sdk.cfdi32.anotaciones.Curp;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.enums.sat.TipoContribuyenteSujetoRetencion;
import mx.emite.sdk.enums.sat.adaptadores.TipoContribuyenteSujetoRetencionAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Beneficiario")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Beneficiario {

	
	/**
	 *  rfc Atributo requerido para expresar la clave del registro federal de contribuyentes del representante legal en México
	 */
	@XmlAttribute(required = true,name="RFC")
	@NotNull @Rfc
	protected String rfc;
	
	/**
	 *  curp Atributo requerido para la expresión de la CURP del representante legal
	 */
	@XmlAttribute(required = false,name="CURP")
	@NotNull @Curp
	protected String curp;
	
	/**
	 *  nomDenRazSocB Atributo requerido para expresar el nombre, denominación o razón social del contribuyente en México
	 */
	@XmlAttribute(required = false,name="NomDenRazSocB")
	@NotNull @Size(min=1,max=300)
	protected String nomDenRazSocB;
	
	
	/**
	 *  ConceptoPago Atributo requerido para expresar el tipo contribuyente sujeto a la retención, conforme al catálogo.
	 */
	@XmlAttribute(required = true,name="ConceptoPago")
	@XmlJavaTypeAdapter(TipoContribuyenteSujetoRetencionAdapter.class)
	@NotNull
	private TipoContribuyenteSujetoRetencion conceptoPago;
	
	/**
	 *  descripcionConcepto Atributo requerido para expresar la descripción de la definición del pago del residente en el extranjero
	 */
	@XmlAttribute(required = true,name="DescripcionConcepto")
	@NotNull @Size(min=1,max=255)
	private String descripcionConcepto;
	
		
}
