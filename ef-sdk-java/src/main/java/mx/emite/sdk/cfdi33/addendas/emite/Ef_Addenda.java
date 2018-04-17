package mx.emite.sdk.cfdi33.addendas.emite;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.utils.Complemento33Interface;

@XmlRootElement(name="Ef_Addenda",namespace="http://www.emite.mx/addenda")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ef_Addenda")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
//quitar extends para generar xsd
//extends Complemento33Interface
public class Ef_Addenda extends Complemento33Interface implements Serializable{

	

	private static final long serialVersionUID = 1170417838206323896L;

	@XmlAttribute(name="Version")
	private final String version="1.0";

	@XmlElement(name="Ef_Cfdi",namespace="http://www.emite.mx/addenda")
	private Ef_Cfdi efCfdi;
	
	@XmlElement(name="Ef_Conceptos",namespace="http://www.emite.mx/addenda")
	private Ef_Conceptos efConceptos;
	
	@XmlElement(name="Ef_Qr",namespace="http://www.emite.mx/addenda")
	private String qr; 
	 
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.emite.mx/addenda http://connect.emite.mx/addenda/ef10.xsd";
	}

	
	
	@Override
	public String getPrefijo() {
		return "ef";
	}
	
	
	public static void main(String[] args) {
		try {
		JAXBContext jaxbContext = JAXBContext.newInstance(Ef_Addenda.class);
		SchemaOutputResolver sor = new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
				 final File file = new File("/Users/enrique/Downloads/ef10.xsd");
			     final StreamResult result = new StreamResult(file);
			     result.setSystemId(file.getAbsolutePath());
			     return result;
			}
		};
		jaxbContext.generateSchema(sor);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
