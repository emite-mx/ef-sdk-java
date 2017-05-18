package mx.emite.sdk.cfdi33.complementos.notpub10;

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
@XmlType(name = "DescInmueble10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DescInmueble implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 982575378222919622L;

	@XmlAttribute(name="TipoInmueble")
	private String tipoInmueble;
	
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
	
	@XmlAttribute(name="Pais")
	private String pais;
	
	@XmlAttribute(name="CodigoPostal")
	private String codigoPostal;
	
	
	
	
}
