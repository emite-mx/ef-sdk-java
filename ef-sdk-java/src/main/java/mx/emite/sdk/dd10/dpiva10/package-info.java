@javax.xml.bind.annotation.XmlSchema(namespace = "http://www.sat.gob.mx/cfd/3"
, xmlns = {
    @XmlNs(prefix = "DD", namespaceURI = "http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/1"),    
    @XmlNs(prefix = "DPIVA", namespaceURI = "http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/TipoDPIVA/1"),
}
, elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED
)
@XmlJavaTypeAdapter(value=StringAdapter.class, type=String.class)

package mx.emite.sdk.dd10.dpiva10;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mx.emite.sdk.enums.sat.adaptadores.StringAdapter;
	

	
