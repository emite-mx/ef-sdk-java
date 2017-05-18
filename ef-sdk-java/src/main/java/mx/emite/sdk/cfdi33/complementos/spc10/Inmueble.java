package mx.emite.sdk.cfdi33.complementos.spc10;

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
@XmlType(name = "Inmueble10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Inmueble implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2972607249560290897L;

	@XmlAttribute(name="Calle")
	private String calle;

	@XmlAttribute(name="NoExterior")
	private String noExterior;
	
	@XmlAttribute(name="NoInterior")
	private String noInterior;
	
	@XmlAttribute(name="Colonia")
	private String colonia;
	
	@XmlAttribute(name="Localidad")
	private String localidad;
	
	@XmlAttribute(name="Referencia")
	private String referencia;
	
	@XmlAttribute(name="Municipio")
	private String municipio;
	
	@XmlAttribute(name="Estado")
	private String estado;
	
	@XmlAttribute(name="CodigoPostal")
	private String codigoPostal;
	
	
}
