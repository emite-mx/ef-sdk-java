package mx.emite.sdk.cfdi33.complementos.nomina12;

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
@XmlType(name = "Incapacidades12")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Incapacidades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4338168644300293838L;
	
	/**
	 * incapacidades Nodo condicional para expresar información de las incapacidades
	 */
    @XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="Incapacidad")
    @Singular(value="incapacidad")
    @Valid @NotEmpty
    private List<Incapacidad> incapacidades;

   

    
}
