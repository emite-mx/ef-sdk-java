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
import mx.emite.sdk.enums.sat.PaisesRetencion;
import mx.emite.sdk.enums.sat.TipoContribuyenteSujetoRetencion;
import mx.emite.sdk.enums.sat.adaptadores.PaisesRetencionAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoContribuyenteSujetoRetencionAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoBeneficiario")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class NoBeneficiario {

	
	/**
	 *  paisDeResidParaEfecFisc Atributo requerido para expresar la clave del país de residencia del extranjero, conforme al catálogo de países publicado en el Anexo 10 de la RMF.
	 */
	@XmlAttribute(required = true,name="PaisDeResidParaEfecFisc")
	@XmlJavaTypeAdapter(PaisesRetencionAdapter.class)
	@NotNull
	private PaisesRetencion paisDeResidParaEfecFisc;

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
