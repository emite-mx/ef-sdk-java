package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.ImporteTcAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder={"impuestos","informacionAduaneras","cuentaPredial","complementoConcepto","partes"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Concepto33 implements Serializable{

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 5790851250574830023L;

	/**
	 * claveProdServ Atributo requerido para expresar la clave del producto o del servicio amparado por el presente concepto. Es requerido y deben utilizar las claves del catálogo de productos y servicios, cuando los conceptos que registren por sus actividades correspondan con dichos conceptos.
	 */
	@XmlAttribute(name="ClaveProdServ")
	@NotNull
	@Size(min=1,max=8)
	private String claveProdServ;

	/**
	 * noIdentificacion Atributo opcional para expresar el número de parte, identificador del producto o del servicio, la clave de producto o servicio, SKU o equivalente, propia de la operación del emisor, amparado por el presente concepto.
	 */
	@XmlAttribute(name="NoIdentificacion")
	@Pattern(regexp="^([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;|´|-|:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,100}$",message="El noIdentificacion no cumple con el patrón del SAT")
	private String noIdentificacion;
	
	/**
	 * cantidad Atributo requerido para precisar la cantidad de bienes o servicios del tipo particular definido por el presente concepto.
	 */
	@XmlAttribute(name="Cantidad")
	@NotNull
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	private BigDecimal cantidad;
	
	
	/**
	 * claveUnidad Atributo requerido para precisar la clave de unidad de medida estandarizada aplicable para la cantidad expresada en el concepto. La unidad debe corresponder con la descripción del concepto.
	 */
	@XmlAttribute(name="ClaveUnidad")
	@NotNull @Size(min=2,max=3)
	private String claveUnidad;

	/**
	 * unidad Atributo opcional para precisar la unidad de medida propia de la operación del emisor, aplicable para la cantidad expresada en el concepto. La unidad debe corresponder con la descripción del concepto.
	 */
	@XmlAttribute(name="Unidad")
	@Size(min=1,max=20)
	@Pattern(regexp="^([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;|´|-|:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,20}$",
	message="La Unidad no cumple con el patrón del SAT")
	private String unidad;
	
	/**
	 * descripcion Atributo requerido para precisar la descripción del bien o servicio cubierto por el presente concepto.
	 */
	@XmlAttribute(name="Descripcion")
	@Size(min=1,max=1000)
	@Pattern(regexp="[^|]{1,1000}",
	message="La Descripcion no cumple con el patrón del SAT")
	@NotNull
	private String descripcion;
	
	
	/**
	 * valorUnitario Atributo requerido para precisar el valor o precio unitario del bien o servicio cubierto por el presente concepto.
	 */
	@XmlAttribute(name="ValorUnitario")
	@NotNull
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	private BigDecimal valorUnitario;
	
	/**
	 * importe Atributo requerido para precisar el importe total de los bienes o servicios del presente concepto. Debe ser equivalente al resultado de multiplicar la cantidad por el valor unitario expresado en el concepto. No se permiten valores negativos.
	 */
	@XmlAttribute(name="Importe")
	@NotNull
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal importe;
	
	/**
	 * descuento Atributo opcional para representar el importe de los descuentos aplicables al concepto. No se permiten valores negativos.
	 */
	@XmlAttribute(name="Descuento")
	@XmlJavaTypeAdapter(ImporteTcAdapter.class)
	private BigDecimal descuento;
	
	/**
	 * impuestos Nodo opcional para capturar los impuestos aplicables al presente concepto. Cuando un concepto no registra un impuesto, implica que no es objeto del mismo.
	 *
	 */
	@XmlElement(name="Impuestos", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private ConceptosImpuestos33 impuestos;
	
	/**
	 * informacionAduaneras Nodo opcional para introducir la información aduanera aplicable cuando se trate de ventas de primera mano de mercancías importadas o se trate de operaciones de comercio exterior con bienes o servicios.
	 *
	 */
	@XmlElement(name="InformacionAduanera", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid @Singular("informacionAduanera")
	private List<InformacionAduanera33> informacionAduaneras;
	
	/**
	 * cuentaPredial Nodo opcional para asentar el número de cuenta predial con el que fue registrado el inmueble, en el sistema catastral de la entidad federativa de que trate, o bien para incorporar los datos de identificación del certificado de participación inmobiliaria no amortizable.
	 *
	 */
	@XmlElement(name="CuentaPredial", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private CuentaPredial33 cuentaPredial;
	
	/**
	 * complementoConcepto Nodo opcional para asentar el número de cuenta predial con el que fue registrado el inmueble, en el sistema catastral de la entidad federativa de que trate, o bien para incorporar los datos de identificación del certificado de participación inmobiliaria no amortizable.
	 *
	 */
	@XmlElement(name="ComplementoConcepto", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private ComplementoConcepto33 complementoConcepto;
	
	/**
	 * partes Nodo opcional para expresar las partes o componentes que integran la totalidad del concepto expresado en el comprobante fiscal digital por Internet.
	 *
	 */
	@XmlElement(name="Parte", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid @Singular("parte")
	private List<Parte33> partes;
	
	public boolean tieneComplementos(){
		return complementoConcepto!=null&&complementoConcepto.getComplementos()!=null&&!complementoConcepto.getComplementos().isEmpty();
	}

	public Boolean hayRetenciones() {
		return impuestos!=null && impuestos.getRetenciones()!=null && impuestos.getRetenciones().getRetenciones()!=null;
		
	}
	
	public Boolean hayTraslados() {
		return impuestos!=null && impuestos.getTraslados()!=null && impuestos.getTraslados().getTraslados()!=null;
		
	}
	
}
