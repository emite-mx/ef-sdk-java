package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
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
import mx.emite.sdk.enums.sat.TiposDeduccion12;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposDeduccionAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Deduccion")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo requerido para expresar la información detallada de una deduccion
 * @author enrique
 *
 */
public class Deduccion implements Serializable {

	   	

	/**
	 * 
	 */
	private static final long serialVersionUID = -966270901010639899L;

	/**
	 * tipoDeduccion Atributo requerido para registrar la clave agrupadora que clasifica la deducción conforme al catálogo publicado en el Portal del SAT en internet.
	 */
	@XmlAttribute(required = true,name="TipoDeduccion")
	@XmlJavaTypeAdapter(TiposDeduccionAdapter.class)
	@NotNull
    private TiposDeduccion12 tipoDeduccion;
	
	/**
	 * clave Atributo requerido para expresar la clave de deducción de nómina propia de la contabilidad de cada patrón, puede conformarse desde 3 hasta 15 caracteres.
	 */
	@XmlAttribute(name="Clave")
	@NotNull @Size(min=3,max=15)
	@Pattern(regexp="^[^|]{3,15}$",message="La clave no cumple con el patrón especificado por el SAT")
	private String clave;
	
	@XmlAttribute(name="Concepto")
	@NotNull
	@Size(min=1,max=100)
	@Pattern(regexp="^[^|]{3,100}$",message="El concepto no cumple con el patrón especificado por el SAT")
    private String concepto;
	
	@XmlAttribute(required = true,name="Importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
    private BigDecimal importe;
	
	
   
    
}
