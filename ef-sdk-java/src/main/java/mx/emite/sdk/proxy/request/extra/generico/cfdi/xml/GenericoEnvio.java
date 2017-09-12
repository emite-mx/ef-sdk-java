package mx.emite.sdk.proxy.request.extra.generico.cfdi.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;


@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@XmlRootElement(name="GenericoEnvioCfdi")
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericoEnvio {

	@XmlAttribute(name="observaciones")
	private String observaciones;
	
	
	@XmlElement(name="Correos")
	@Singular("correo") 
	private List<String> correos;
	
		
}
