package mx.emite.sdk.cfdi33.complementos.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;

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
import mx.emite.sdk.enums.sat.TiposOtroPago;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposOtroPagoAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtroPago12")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo requerido para expresar la información detallada del otro pago.
 * @author enrique
 *
 */
public class OtroPago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -817552509450501724L;

	/**
	 * tipoOtroPago Atributo requerido para expresar la clave agrupadora bajo la cual se clasifica el otro pago conforme al catálogo publicado en el Portal del SAT en Internet.
	 */
	@XmlAttribute(required = true,name="TipoOtroPago")
	@XmlJavaTypeAdapter(TiposOtroPagoAdapter.class)
	@NotNull
    private TiposOtroPago tipoOtroPago;
	
	/**
	 * clave Atributo requerido, representa la clave de otro pago de nómina propia de la contabilidad de cada patrón, puede conformarse desde 3 hasta 15 caracteres.
	 */
	@XmlAttribute(name="Clave")
	@NotNull @Size(min=3,max=15)
	@Pattern(regexp="^[^|]{3,15}$",message="La clave no cumple con el patrón especificado por el SAT")
	private String clave;
	
	/**
	 * concepto Atributo requerido para la descripción del concepto de otro pago.
	 */
	@XmlAttribute(name="Concepto")
	@NotNull
	@Size(min=1,max=100)
	@Pattern(regexp="^[^|]{3,100}$",message="El concepto no cumple con el patrón especificado por el SAT")
    private String concepto;
	
	
	/**
	 * importe Atributo requerido para expresar el importe del concepto de otro pago.
	 */
	@XmlAttribute(name="Importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	@NotNull
    private BigDecimal importe;
	
	/**
	 * subsidioAlEmpleo Nodo para expresar la información referente al subsidio al empleo del trabajador.
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="SubsidioAlEmpleo")
	@Valid
    private SubsidioAlEmpleo subsidioAlEmpleo;
   
	/**
	 * compensacionSaldosAFavor Nodo condicional para expresar la información referente a la compensación de saldos a favor de un trabajador.
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="CompensacionSaldosAFavor")
	@Valid
    private CompensacionSaldosAFavor compensacionSaldosAFavor;
    
}
