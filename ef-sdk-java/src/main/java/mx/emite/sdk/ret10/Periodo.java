package mx.emite.sdk.ret10;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Periodo")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * 
 *  <h1>Nodo requerido para expresar el periodo que ampara el documento de retenciones e información de pagos</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 * 
 */
public class Periodo {

	/**
	 *  mesInicial Atributo requerido para la expresión del mes inicial del periodo de la retención e información de pagos
	 */
	@XmlAttribute(required = true,name="MesIni")
	@NotNull @Min(1) @Max(12)
	protected Integer mesInicial;
	
	/**
	 *  mesFinal Atributo requerido para la expresión del mes final del periodo de la retención e información de pagos
	 */
	@XmlAttribute(required = true,name="MesFin")
	@NotNull @Min(1) @Max(12)
	protected Integer mesFinal;
	
	/**
	 *  ejercicio Atributo requerido para la expresión del ejercicio fiscal (año)
	 */
	@XmlAttribute(required = true,name="Ejerc")
	@NotNull @Min(2004) @Max(2024)
	protected Integer ejercicio;
	
	
}
