package mx.emite.sdk.cfdi33.addendas.emite;

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
@XmlType(name = "Ef_ClavesUnidad")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Ef_ClavesUnidad implements Serializable {

	

	private static final long serialVersionUID = -1332112344736091352L;

	@XmlAttribute(name="claveUnidad")
	private String claveUnidad;
	
	@XmlAttribute(name="descripcion")
	private String descripcion;
	
	
}
