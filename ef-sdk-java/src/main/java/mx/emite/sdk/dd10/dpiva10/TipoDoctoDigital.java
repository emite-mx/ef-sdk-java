package mx.emite.sdk.dd10.dpiva10;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoDoctoDigital")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class TipoDoctoDigital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7441718197632783611L;
	
	@XmlElement(name="DPIVA", namespace="http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/TipoDPIVA/1")
	@Valid
	@NotNull
	@Singular(value="dpiva")
	private List<DpIva> dpivas;


}
