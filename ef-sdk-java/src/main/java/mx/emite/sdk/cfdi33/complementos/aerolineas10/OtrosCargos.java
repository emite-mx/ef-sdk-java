package mx.emite.sdk.cfdi33.complementos.aerolineas10;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
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
import lombok.Singular;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtrosCargos10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class OtrosCargos implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4013123207239254468L;


	@XmlAttribute(name="TotalCargos")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal totalCargos;
	

	@XmlElement(name="Cargo", namespace = "http://www.sat.gob.mx/aerolineas")
	@Valid @Singular("cargo")
	private List<Cargo> cargos;
	
	
	
}
