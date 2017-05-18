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
@XmlType(name = "RetencionesPago10")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetencionesPago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2945319912241349511L;
	@XmlElement(name="Retencion", namespace = "http://www.sat.gob.mx/Pagos")
	@NotEmpty
	@Valid
	@Singular("retencion")
	protected List<RetencionPago> retenciones;

	
}
