package mx.emite.sdk.cfdi32.complementos.cce11;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@XmlAccessorType(XmlAccessType.FIELD)
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
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,300}",message="Nombre no cumple con el patrón del SAT")
	private String nombre;
	
	@XmlElement(name="Domicilio",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid @Singular @NotEmpty
	private List<DomicilioCE11> domicilios;
	
}
