package mx.emite.sdk.proxy.response.extra;

import org.jsondoc.core.annotation.ApiObject;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiObject
@AllArgsConstructor @NoArgsConstructor
public class InfoValidacionEmisorReceptor {

	public InfoValidacionEmisorReceptor(Node nodoemisor) {
		
		procesaNodo(nodoemisor);
		
	}
	
	
	private void procesaNodo(Node nodo) {
		if(nodo.hasAttributes()){
			final NamedNodeMap attr = nodo.getAttributes();
			for(int a=0;a<attr.getLength();a++){
				final Node at = attr.item(a);
				switch(at.getNodeName()){
				case "nombre": this.razonSocial = at.getNodeValue(); break;
				case "rfc": this.rfc = at.getNodeValue(); break;
				case "calle": this.calle = at.getNodeValue(); break;
				case "noExterior": this.noExterior= at.getNodeValue(); break;
				case "noInterior": this.noInterior = at.getNodeValue(); break;
				case "codigoPostal": this.codigoPostal = at.getNodeValue(); break;
				case "colonia": this.colonia = at.getNodeValue(); break;
				case "estado": this.estado = at.getNodeValue(); break;
				case "localidad": this.localidad = at.getNodeValue(); break;
				case "municipio": this.municipio = at.getNodeValue(); break;
				case "pais": this.pais = at.getNodeValue(); break;
				case "referencia": this.referencia = at.getNodeValue(); break;
				
				}
			}
		}
		final NodeList list = nodo.getChildNodes();
		for(int x=0; x< list.getLength();x++){
			final Node actual = list.item(x);
			if (actual.getNodeType() == Node.ELEMENT_NODE) {
	            //calls this method for all the children which is Element
	            procesaNodo(actual);
	        }
		}		
	}


	private String rfc;
	private String razonSocial;
	private String calle;
	private String noExterior;
	private String noInterior;
	private String codigoPostal;
	private String colonia;
	private String estado;
	private String localidad;
	private String municipio;
	private String pais;
	private String referencia;
	
}
