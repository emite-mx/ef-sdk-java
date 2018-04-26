package mx.emite.sdk.cfdi32.nomina12;

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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.enums.sat.TiposPercepcion12;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposPercepcionAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Percepcion")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo requerido para expresar la información detallada de una percepcion
 * @author enrique
 *
 */
public class Percepcion implements Serializable {

	   	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2929289968346173912L;

	/**
	 * tipoPercepcion Atributo requerido para expresar la Clave agrupadora bajo la cual se clasifica la percepción conforme al catálogo publicado en el Portal del SAT en Internet.
	 */
	@XmlAttribute(name="TipoPercepcion")
	@XmlJavaTypeAdapter(TiposPercepcionAdapter.class)
	@NotNull
    private TiposPercepcion12 tipoPercepcion;
	
	/**
	 * clave Atributo requerido para expresar la clave de percepción de nómina propia de la contabilidad de cada patrón, puede conformarse desde 3 hasta 15 caracteres.
	 */
	@XmlAttribute(name="Clave")
	@NotNull @Size(min=3,max=15)
	@Pattern(regexp="^[^|]{3,15}$",message="La clave no cumple con el patrón especificado por el SAT")
	private String clave;

	/**
	 * concepto Atributo requerido para la descripción del concepto de percepción
	 */
	@XmlAttribute(name="Concepto")
	@NotNull @Size(min=1,max=100)
	@Pattern(regexp="^[^|]{3,100}$",message="El concepto no cumple con el patrón especificado por el SAT")
    private String concepto;
	
	/**
	 * importeGravado Atributo requerido, representa el importe gravado de un concepto de percepción.
	 */
	@XmlAttribute(name="ImporteGravado")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
    private BigDecimal importeGravado;
	
	/**
	 * importeExento Atributo requerido, representa el importe exento de un concepto de percepción.
	 */
	@XmlAttribute(name="ImporteExento")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
    private BigDecimal importeExento;
	
	/**
	 * accionesOTitulos Nodo condicional para expresar ingresos por acciones o títulos valor que representan bienes. Se vuelve requerido cuando existan ingresos por sueldos derivados de adquisición de acciones o títulos (Art. 94, fracción VII LISR).
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="AccionesOTitulos")
	@Valid
	private AccionesOTitulos accionesOTitulos;
   
	/**
	 * horasExtra Nodo condicional para expresar las horas extra aplicables..
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="HorasExtra")
	@Valid @Singular("horaExtra")
	private List<HorasExtra> horasExtra;
	
    
	@XmlTransient
	public BigDecimal getImporte(){
		return (importeGravado==null?BigDecimal.ZERO:importeGravado).add(importeExento==null?BigDecimal.ZERO:importeExento);
	}
	
}
