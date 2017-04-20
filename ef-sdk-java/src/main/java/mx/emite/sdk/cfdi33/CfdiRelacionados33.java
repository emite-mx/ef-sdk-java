package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.enums.sat.cfdi33.TiposRelacion33;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.TiposRelacion33Adapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CfdiRelacionados33 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 761050221440341223L;
	
	@XmlAttribute(name="TipoRelacion")
	@NotNull
	@XmlJavaTypeAdapter(TiposRelacion33Adapter.class)
	protected TiposRelacion33 tipoRelacion;

	
	@XmlElement(name="CfdiRelacionado",namespace = "http://www.sat.gob.mx/cfd/3")
	@NotNull
	@Valid @NotEmpty @Singular("cfdiRelacionado")
	protected List<CfdiRelacionado33> cfdiRelacionados;

	
}
