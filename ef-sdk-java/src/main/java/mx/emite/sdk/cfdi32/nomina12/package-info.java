@javax.xml.bind.annotation.XmlSchema(namespace = "http://www.sat.gob.mx/cfd/3"
, xmlns = {
    @XmlNs(prefix = "cfdi", namespaceURI = "http://www.sat.gob.mx/cfd/3"),    
    @XmlNs(prefix = "nomina12", namespaceURI = "http://www.sat.gob.mx/nomina12"),
}
, elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED
)
@XmlJavaTypeAdapter(value=StringAdapter.class, type=String.class)

package mx.emite.sdk.cfdi32.nomina12;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mx.emite.sdk.enums.sat.adaptadores.StringAdapter;
	

	
