package mx.emite.sdk.cfdi33.addendas.emite;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@XmlRootElement(name="Ef_Conceptos",namespace="http://www.emite.mx/addenda")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ef_Conceptos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Ef_Conceptos  implements Serializable{

	private static final long serialVersionUID = -2394021128029074230L;

	@XmlElement(name="Ef_ClavesUnidad",namespace="http://www.emite.mx/addenda")
	private Set<Ef_ClavesUnidad> cums;
	
	@XmlElement(name="Ef_ClavesProdServ",namespace="http://www.emite.mx/addenda")
	private Set<Ef_ClavesProdServ> cpss;
	
	@XmlAttribute(name="noConceptos")
	private Integer noConceptos;
	
	
}
