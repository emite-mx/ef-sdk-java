@javax.xml.bind.annotation.XmlSchema(namespace = "http://www.sat.gob.mx/cfd/3"
, xmlns = {
    @XmlNs(prefix = "cfdi", namespaceURI = "http://www.sat.gob.mx/cfd/3"),    
    @XmlNs(prefix = "consumodecombustibles", namespaceURI = mx.emite.sdk.cfdi33.complementos.cdc11.ConsumoDeCombustibles11.NAMESPACE),
},
elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED
,attributeFormDefault = javax.xml.bind.annotation.XmlNsForm.UNQUALIFIED
)
@XmlJavaTypeAdapter(value=StringAdapter.class, type=String.class)
package mx.emite.sdk.cfdi33.complementos.cdc11;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mx.emite.sdk.enums.sat.adaptadores.StringAdapter;
	