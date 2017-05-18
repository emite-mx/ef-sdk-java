package mx.emite.sdk.cfdi33.complementos.pagos10;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrasladosPago10")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrasladosPago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3423266238693649302L;
	
	
	@XmlElement(name="Traslado", namespace = "http://www.sat.gob.mx/Pagos")
	@NotEmpty
	@Valid
	@Singular("traslado")
	protected List<TrasladoPago> traslados;

	
}
