package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubsidioAlEmpleo")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo para expresar la información referente al subsidio al empleo del trabajador.
 * @author enrique
 *
 */
public class SubsidioAlEmpleo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8038020679527553003L;
	/**
	 * subsidioCausado Atributo para expresar el subsidio causado conforme a la tabla del subsidio para el empleo publicada en el Anexo 8 de la RMF vigente.
	 */
	@XmlAttribute(name="SubsidioCausado")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@NotNull
	@DecimalMin("0")
	protected BigDecimal subsidioCausado;
	
	
}
