package mx.emite.sdk.ret10.comp.fideicomisonoempresarial;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
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
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetEfectFideicomiso")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class RetEfectFideicomiso {

	/**
	 *  montRetRelPagFideic Atributo requerido para expresar el monto de la retenciones con relación al fideicomiso
	 */
	@XmlAttribute(required = true,name="MontRetRelPagFideic")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montRetRelPagFideic;
	
	
	/**
	 *  descRetRelPagFideic Atributo requerido para expresar la descripción de las retenciones con relación al fideicomiso
	 */
	@XmlAttribute(required = true,name="DescRetRelPagFideic")
	@NotNull @Size(min=1,max=100)
	protected String descRetRelPagFideic;
	
	
	
}
