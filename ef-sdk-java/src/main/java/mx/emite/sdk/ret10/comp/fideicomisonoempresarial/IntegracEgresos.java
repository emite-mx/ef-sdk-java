package mx.emite.sdk.ret10.comp.fideicomisonoempresarial;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegracEgresos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class IntegracEgresos {

	
	
	/**
	 * @param conceptoS Atributo requerido para expresar la descripción del concepto de egresos de los fideicomisos que no realizan actividades empresariales
	 */
	@XmlAttribute(required = true,name="ConceptoS")
	@NotNull @Size(min=1,max=100)
	protected String conceptoS;
	
		
}
