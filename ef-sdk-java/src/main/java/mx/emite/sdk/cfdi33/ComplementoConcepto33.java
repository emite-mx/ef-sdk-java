package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.util.List;

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
import mx.emite.sdk.utils.ComplementoConcepto33Interface;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplementoConcepto33 implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2480645786731387602L;
	@XmlTransient @Singular @Valid
	private List<ComplementoConcepto33Interface> complementos;
		
	
}
