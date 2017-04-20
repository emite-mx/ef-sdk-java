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
public class InformacionAduanera33 implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4555771857481943146L;

	/**
	 * numeroPedimento Atributo requerido para expresar el número del pedimento que ampara la importación del bien que se expresa en el siguiente formato: últimos 2 dígitos del año de validación seguidos por dos espacios, 2 dígitos de la aduana de despacho seguidos por dos espacios, 4 dígitos del número de la patente seguidos por dos espacios, 1 dígito que corresponde al último dígito del año en curso, salvo que se trate de un pedimento consolidado iniciado en el año inmediato anterior o del pedimento original de una rectificación, seguido de 6 dígitos de la numeración progresiva por aduana.
	 */
	@XmlAttribute(name="NumeroPedimento")
	@NotNull
	@Pattern(regexp="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}",
	message="NumeroPedimento no  cumple con el patrón del SAT [0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}")
	private String numeroPedimento;
	
		
	
}
