package mx.emite.sdk.cfdi32.comp.cce11;

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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.cfdi32.anotaciones.T_Descrip100;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class MercanciaCE11 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2664358971864902225L;

	@XmlAttribute(name="NoIdentificacion")
	@T_Descrip100
	@NotNull
	private String noIdentificacion;
	
	@XmlAttribute(name="FraccionArancelaria")
	@Size(min=8,max=8) @Pattern(regexp="\\d{8}",message="debe de ser una FraccionArancelaria válida")
	private String fraccionArancelaria;
	
	@XmlAttribute(name = "CantidadAduana")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin("0.001")
	private BigDecimal cantidadAduana;
	
	
	@XmlAttribute(name="UnidadAduana")
	@Size(min=2,max=2) @Pattern(regexp="\\d{2}",message="debe de ser una UnidadAduana válida")
	private String unidadAduana;
	
	@XmlAttribute(name = "ValorUnitarioAduana")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0.00")
	private BigDecimal valorUnitarioAduana;
	
	@XmlAttribute(name = "ValorDolares")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin("0.001")
	private BigDecimal valorDolares;
	
		
	@XmlElement(name="DescripcionesEspecificas",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid @Singular("descripcion") 
	private List<DescripcionesEspecificasCE11> descripciones;
	
	
	
}
