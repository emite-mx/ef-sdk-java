package mx.emite.sdk.cfdi32.complementos.cce11;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DescripcionesEspecificasCE11 implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1328407489822830132L;

	@XmlAttribute(name="Marca")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,35}",message="debe de ser una Marca válida")
	@NotNull
	private String marca;
	
	@XmlAttribute(name="Modelo")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,80}"
	,message="debe de ser un Modelo válido")
	private String modelo;
	
	@XmlAttribute(name="SubModelo")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,50}"
	,message="debe de ser un SubModelo válido")
	private String subModelo;
	
	@XmlAttribute(name="NumeroSerie")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,40}"
	,message="debe de ser un NumeroSerie válido")
	private String numeroSerie;
	
}
