package mx.emite.sdk.ret10.comp.dividendos;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Remanente")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Remanente {

	
	
	/**
	 *  proporcionRem Atributo opcional que expresa el porcentaje de participación de sus integrantes o accionistas
	 */
	@XmlAttribute(required = true,name="ProporcionRem")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal proporcionRem;
	
		
}
