package mx.emite.sdk.ret10;

import java.time.ZonedDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.enums.sat.ClavesRetenciones;
import mx.emite.sdk.enums.sat.adaptadores.ClavesRetencionesAdapter;
import mx.emite.sdk.serializers.ZonedDateTimeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "emisor", "receptor", "periodo", "totales", "complemento" })
@XmlRootElement(name = "Retenciones", namespace = "http://www.sat.gob.mx/esquemas/retencionpago/1")
@Data
@Builder
@AllArgsConstructor
public class Retenciones {
	
	@XmlElement(name = "Emisor", namespace = "http://www.sat.gob.mx/esquemas/retencionpago/1", required = true)
	@Valid @NotNull
	private Emisor emisor;
	
	@XmlElement(name = "Receptor", namespace = "http://www.sat.gob.mx/esquemas/retencionpago/1", required = true)
	@Valid @NotNull
	private Receptor receptor;
	
	@XmlElement(name = "Periodo", namespace = "http://www.sat.gob.mx/esquemas/retencionpago/1", required = true)
	@Valid @NotNull
	private Periodo periodo;
	
	@XmlElement(name = "Totales", namespace = "http://www.sat.gob.mx/esquemas/retencionpago/1", required = true)
	@Valid @NotNull
	private Totales totales;

	@XmlElement(name = "Complemento", namespace = "http://www.sat.gob.mx/esquemas/retencionpago/1", required = true)
	@Valid
	private Complemento complemento;
	
	/**
	 * @param version Atributo requerido con valor prefijado que indica la versión del estándar bajo el que se encuentra expresada la retención y/o comprobante de información de pagos.
	 */
	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	/**
	 * @param folio Atributo opcional para control interno del contribuyente que expresa el folio del documento que ampara la retención e información de pagos. Permite números y/o letras.
	 */
	@XmlAttribute(name="FolioInt")
	@Size(max=20)
	private String folio;
	
	/**
	 * @param sello Atributo requerido para contener el sello digital del documento de retención e información de pagos. El sello deberá ser expresado como una cadena de texto en formato base 64.
	 */
	@XmlAttribute(name="Sello")
	private String sello;

	/**
	 * @param numCertificado Atributo requerido para expresar el número de serie del certificado de sello digital con el que se selló digitalmente el documento de la retención e información de pagos.
	 */
	@XmlAttribute(name="NumCert")
	@Size(min=20,max=20) @NotNull
	private String numCertificado;
	
	
	/**
	 * @param certificado Atributo requerido que sirve para incorporar el certificado de sello digital que ampara el documento de retención e información de pagos como texto, en formato base 64.
	 */
	@XmlAttribute(name="Cert")
	private String certificado;
	
	/**
	 * @param fechaExpedicion Atributo requerido para la expresión de la fecha y hora de expedición del documento de retención e información de pagos. Se expresa en la forma yyyy-mm-ddThh:mm:ssTZD-6, de acuerdo con la especificación ISO 8601.
	 */
	@XmlAttribute(required = true,name="FechaExp")
	@XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
	@NotNull
	private ZonedDateTime fechaExpedicion;
	
	/**
	 * @param claveRetencion Atributo requerido para expresar la clave de la retención e información de pagos de acuerdo al catálogo publicado en internet por el SAT.
	 */
	@XmlAttribute(required = true,name="CveRetenc")
	@XmlJavaTypeAdapter(ClavesRetencionesAdapter.class)
	@NotNull
	private ClavesRetenciones claveRetencion;
	
	/**
	 * @param descripcionRetencion Atributo opcional que expresa la descripción de la retención e información de pagos en caso de que en el atributo CveRetenc se haya elegido el valor para 'otro tipo de retenciones'
	 */
	@XmlAttribute(name="DescRetenc")
	@Size(max=100)
	private String descripcionRetencion;
	
	public Retenciones(){
		this.version="1.0";
	}
	
}
