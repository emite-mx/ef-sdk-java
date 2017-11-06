package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.cfdi33.complementos.timbrefiscaldigital.TimbreFiscalDigital11;
import mx.emite.sdk.utils.Complemento33Interface;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Complemento33")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Complemento33 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2390008506099873792L;

	
	
	@XmlTransient @Singular @Valid
	private List<Complemento33Interface> complementos;



	public TimbreFiscalDigital11 getTimbre() {
		if(complementos!=null) {
				final Optional<Complemento33Interface> timbre = complementos.stream().filter(i->i instanceof TimbreFiscalDigital11).findAny();
				if(timbre.isPresent())
					return (TimbreFiscalDigital11) timbre.get();
		}
		return null;
	}
	
	/*@XmlElement(name = "Nomina", namespace="http://www.sat.gob.mx/nomina12")
	@Valid
	@Singular(value="nomina")
	private List<Nomina> nominas;*/
}
