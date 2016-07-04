package mx.emite.sdk.ret10;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
import mx.emite.sdk.enums.sat.Nacionalidad;
import mx.emite.sdk.enums.sat.adaptadores.NacionalidadAdapter;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Receptor",propOrder={"nacional","extranjero"})
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * 
 *  <h1>Nodo requerido para expresar la información del contribuyente receptor del documento electrónico de retenciones e información de pagos.</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 * 
 */
public class Receptor {

	/**
	 * @param nacionalidad 
	 */
	@XmlAttribute(name="Nacionalidad")
	@XmlJavaTypeAdapter(NacionalidadAdapter.class)
	@NotNull
	private Nacionalidad nacionalidad;
	
	/**
	 * @param nacional Nodo requerido para expresar la información del contribuyente receptor en caso de que sea de nacionalidad mexicana
	 */
	@XmlElement(name="Nacional")
	@Valid
	private Nacional nacional;
	
	/**
	 * @param extranjero Nodo requerido para expresar la información del contribuyente receptor del documento cuando sea residente en el extranjero
	 */
	@XmlElement(name="Extranjero")
	@Valid
	private Extranjero extranjero;
	
	
	
}
