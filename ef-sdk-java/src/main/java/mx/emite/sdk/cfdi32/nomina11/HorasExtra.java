package mx.emite.sdk.cfdi32.nomina11;

import java.io.Serializable;
import java.math.BigDecimal;

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
import mx.emite.sdk.enums.sat.TiposHoras12;
import mx.emite.sdk.enums.sat.adaptadores.TiposHorasAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class HorasExtra implements Serializable {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 30640465769316287L;

	@XmlAttribute(name="Dias")
    private Integer dias;
	
	@XmlAttribute(name="TipoHoras")
	@XmlJavaTypeAdapter(TiposHorasAdapter.class)
	@NotNull
    private TiposHoras12 tipoHoras;
	
	@XmlAttribute(name="HorasExtra")
    private Integer horasExtra;
	
    @XmlAttribute(name="ImportePagado")
    @NotNull
    private BigDecimal importePagado;


	

    
}
