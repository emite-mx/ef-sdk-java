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
@XmlType(name = "Ef_ClavesProdServ")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Ef_ClavesProdServ implements Serializable {

	private static final long serialVersionUID = 7946527829622512552L;

	@XmlAttribute(name="claveProdServ")
	private String claveProdServ;
	
	@XmlAttribute(name="descripcion")
	private String descripcion;
	
	
}
