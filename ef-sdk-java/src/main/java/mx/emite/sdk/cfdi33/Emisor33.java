package mx.emite.sdk.cfdi33;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
import mx.emite.sdk.enums.sat.cfdi33.RegimenesFiscales33;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.RegimenesFiscales33Adapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emisor33 implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2709515195378790315L;


	/**
	 * rfc Atributo requerido para registrar la Clave del Registro Federal de Contribuyentes correspondiente al contribuyente emisor del comprobante.
	 */
	@XmlAttribute(name="Rfc")
	@NotNull
	@Rfc
	private String rfc;

	/**
	 * nombre Atributo opcional para registrar el nombre, denominación o razón social del contribuyente emisor del comprobante.
	 */
	@XmlAttribute(name="Nombre")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,254}",message="El nombre del emisor no cumple con el patrón del SAT")
	private String nombre;
	
	/**
	 * regimenFiscal Atributo requerido para incorporar la clave del régimen del contribuyente emisor al que aplicará el efecto fiscal de este comprobante.
	 */
	@XmlAttribute(name="RegimenFiscal")
	@NotNull
	@XmlJavaTypeAdapter(RegimenesFiscales33Adapter.class) 
	protected RegimenesFiscales33 regimenFiscal;

	
}
