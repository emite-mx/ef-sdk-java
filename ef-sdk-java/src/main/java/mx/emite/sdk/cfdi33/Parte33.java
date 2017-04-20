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
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parte33 implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3534126099848117734L;

	/**
	 * claveProdServ Atributo requerido para expresar la clave del producto o del servicio amparado por la presente parte. Es requerido y deben utilizar las claves del catálogo de productos y servicios, cuando los conceptos que registren por sus actividades correspondan con dichos conceptos.
	 */
	@XmlAttribute(name="ClaveProdServ")
	@NotNull
	@Size(min=1,max=8)
	private String claveProdServ;

	/**
	 * noIdentificacion Atributo opcional para expresar el número de serie, número de parte del bien o identificador del producto o del servicio amparado por la presente parte. Opcionalmente se puede utilizar claves del estándar GTIN.
	 */
	@XmlAttribute(name="NoIdentificacion")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü| Ü){1,100}",message="El noIdentificacion no cumple con el patrón del SAT")
	private String noIdentificacion;

	/**
	 *  cantidad Atributo requerido para precisar la cantidad de bienes o servicios del tipo particular definido por el presente concepto.
	 */
	@XmlAttribute(name="Cantidad")
	@NotNull
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	private BigDecimal cantidad;
	
	/**
	 * unidad Atributo opcional para precisar la unidad de medida propia de la operación del emisor, aplicable para la cantidad expresada en el concepto. La unidad debe corresponder con la descripción del concepto.
	 */
	@XmlAttribute(name="Unidad")
	@Size(min=1,max=20)
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü| Ü){1,20}",
	message="La Unidad no cumple con el patrón del SAT")
	private String unidad;
	
	/**
	 * descripcion Atributo requerido para precisar la descripción del bien o servicio cubierto por el presente concepto.
	 */
	@XmlAttribute(name="Descripcion")
	@Size(min=1,max=20)
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü| Ü){1,1000}",
	message="La Descripcion no cumple con el patrón del SAT")
	@NotNull
	private String descripcion;
	
	/**
	 * valorUnitario Atributo requerido para precisar el valor o precio unitario del bien o servicio cubierto por el presente concepto.
	 */
	@XmlAttribute(name="ValorUnitario")
	@NotNull
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	private BigDecimal valorUnitario;
	
	/**
	 * importe Atributo requerido para precisar el importe total de los bienes o servicios del presente concepto. Debe ser equivalente al resultado de multiplicar la cantidad por el valor unitario expresado en el concepto. No se permiten valores negativos.
	 */
	@XmlAttribute(name="Importe")
	@NotNull
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal importe;
	
	/**
	 * informacionAduaneras Nodo opcional para introducir la información aduanera aplicable cuando se trate de ventas de primera mano de mercancías importadas o se trate de operaciones de comercio exterior con bienes o servicios.
	 *
	 */
	@XmlElement(name="InformacionAduanera", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid @Singular("informacionAduanera")
	private List<InformacionAduanera33> informacionAduaneras;
	
}
