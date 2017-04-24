package mx.emite.sdk.cfdi33.complementos.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubContratacion12")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * 
 * @author enrique
 * Nodo condicional para expresar la lista de las personas que los subcontrataron.
 */
public class Subcontratacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3001320213264251351L;
	
	/**
	 *  rfcLabora Atributo requerido para expresar el RFC de la persona que subcontrata.
	 */
	@XmlAttribute(name="RfcLabora")
	@Rfc @NotNull
	protected String rfcLabora;
	
	/**
	 * porcentajeTiempo Atributo requerido para expresar el porcentaje del tiempo que prestó sus servicios con el RFC que lo subcontrata.
	 */
	@XmlAttribute(name="PorcentajeTiempo")
	@NotNull @DecimalMin("0.001") @DecimalMax("100.000")
	protected BigDecimal porcentajeTiempo;
	
}
