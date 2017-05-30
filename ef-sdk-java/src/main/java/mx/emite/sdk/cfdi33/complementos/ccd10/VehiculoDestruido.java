package mx.emite.sdk.cfdi33.complementos.ccd10;

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
@XmlType(name = "VehiculoDestruido10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class VehiculoDestruido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2808216316486017725L;


	@XmlAttribute(name="Marca")
	private String marca;
	
	
	@XmlAttribute(name="TipooClase")
	private String tipooClase;
	
	@XmlAttribute(name="Año")
	private Integer ano;
	
	@XmlAttribute(name="Modelo")
	private String modelo;
	
	@XmlAttribute(name="NIV")
	private String niv;
	
	@XmlAttribute(name="NumSerie")
	private String numSerie;
	
	@XmlAttribute(name="NumPlacas")
	private String numPlacas;
	
	
	@XmlAttribute(name="NumMotor")
	private String numMotor;
	
	@XmlAttribute(name="NumFolTarjCir")
	private String numFolTarjCir;
	
	

	
}
