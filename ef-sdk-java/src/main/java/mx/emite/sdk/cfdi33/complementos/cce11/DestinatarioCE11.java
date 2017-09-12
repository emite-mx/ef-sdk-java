package mx.emite.sdk.cfdi33.complementos.cce11;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DestinatarioCE33")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DestinatarioCE11 implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 715733184957910595L;

	@XmlAttribute(name="NumRegIdTrib")
	@Size(min=6,max=40)
	private String numRegIdTrib;
	
	@XmlAttribute(name="Nombre")
	@Pattern(regexp="^[^|]{1,300}$",message="Nombre no cumple con el patrón del SAT")
	private String nombre;
	
	@XmlElement(name="Domicilio",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid @Singular @NotEmpty
	private List<DomicilioCE11> domicilios;
	
}
