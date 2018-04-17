@javax.xml.bind.annotation.XmlSchema(namespace = "http://www.emite.mx/addenda"
, xmlns = {
    @XmlNs(prefix = "ef", namespaceURI = "http://www.emite.mx/addenda"),    
    
}
, elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED
)
@XmlJavaTypeAdapter(value=StringAdapter.class, type=String.class)
package mx.emite.sdk.cfdi33.addendas.emite;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mx.emite.sdk.enums.sat.adaptadores.StringAdapter;
	
