package mx.emite.sdk.cfdi33.complementos.leyfisc10;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Leyenda")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Leyenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6469368545860293292L;

	@XmlAttribute(name="disposicionFiscal")
	private String disposicionFiscal;
    
	@XmlAttribute(name="norma")
	private String norma;
	
	@XmlAttribute(name="textoLeyenda")
	private String textoLeyenda;
	
	
	
}
