package mx.emite.sdk.cfdi33.complementos.notpub10;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescInmuebles10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DescInmuebles implements Serializable {


	/**
	 */
	private static final long serialVersionUID = 2939473299426980555L;
	@XmlElement(name="DescInmueble", namespace = "http://www.sat.gob.mx/notariospublicos")
	@Valid @Singular("descinmueble")
	private List<DescInmueble> descinmuebles;
	
	
	
}
