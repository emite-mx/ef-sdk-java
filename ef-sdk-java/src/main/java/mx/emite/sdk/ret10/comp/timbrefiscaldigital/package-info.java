@javax.xml.bind.annotation.XmlSchema(namespace = "http://www.sat.gob.mx/esquemas/retencionpago/1"
, xmlns = {
    @XmlNs(prefix = "tfd", namespaceURI = "http://www.sat.gob.mx/TimbreFiscalDigital"),    
    
}
, elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED
)
@XmlJavaTypeAdapter(value=StringAdapter.class, type=String.class)
package mx.emite.sdk.ret10.comp.timbrefiscaldigital;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mx.emite.sdk.enums.sat.adaptadores.StringAdapter;
	

	
