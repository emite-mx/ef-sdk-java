package mx.emite.sdk.cfdi32.nomina12;

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
@XmlType(name = "OtrosPagos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo condicional para expresar otros pagos aplicables.
 * @author enrique
 *
 */
public class OtrosPagos implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7970936724823215826L;
	/**
	 * otrosPagos Nodo requerido para expresar la información detallada del otro pago.
	 */
    @XmlElement(namespace="http://www.sat.gob.mx/nomina",name="OtroPago")
    @Singular(value="otroPago")
    @Valid @NotEmpty
    private List<OtroPago> otrosPagos;

   

    
}
