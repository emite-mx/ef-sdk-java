package mx.emite.sdk.cfdi33;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaPredial33 implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4828415713924345982L;
	/**
	 * numero Atributo requerido para precisar el número de la cuenta predial del inmueble cubierto por el presente concepto, o bien para incorporar los datos de identificación del certificado de participación inmobiliaria no amortizable, tratándose de arrendamiento.
	 */
	@XmlAttribute(name="Numero")
	@NotNull
	@Pattern(regexp="[0-9]{1,150}",
	message="Numero  de CuentaPredial no  cumple con el patrón del SAT [0-9]{1,150}")
	private String numero;
	
		
	
}
