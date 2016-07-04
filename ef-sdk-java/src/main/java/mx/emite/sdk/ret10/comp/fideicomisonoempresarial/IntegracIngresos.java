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
@XmlType(name = "IntegracIngresos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class IntegracIngresos {

	
	
	/**
	 * @param concepto Atributo requerido para expresar la descripción del concepto de ingresos de los fideicomisos que no realizan actividades empresariales
	 */
	@XmlAttribute(required = true,name="Concepto")
	@NotNull @Size(min=1,max=100)
	protected String concepto;
	
		
}
