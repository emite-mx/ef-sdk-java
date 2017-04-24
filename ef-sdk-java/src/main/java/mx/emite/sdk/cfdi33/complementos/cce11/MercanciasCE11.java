package mx.emite.sdk.cfdi33.complementos.cce11;

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
@XmlType(name="MercanciasCE33")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class MercanciasCE11 implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3262653777763480588L;
	@XmlElement(name="Mercancia",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid @Singular("mercancia") @NotEmpty
	private List<MercanciaCE11> mercancias;
	
}
