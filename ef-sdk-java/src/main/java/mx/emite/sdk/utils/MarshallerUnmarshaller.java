package mx.emite.sdk.utils;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Slf4j
public class MarshallerUnmarshaller {

		
	private final static Marshaller marshaller = xmlMarshaller();
	
	
	private static Marshaller xmlMarshaller(){
		try{
		final JAXBContext context = JAXBContext.newInstance(Comprobante.class);
		final Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd");
		return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	public static String marshall(Comprobante comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			marshaller.marshal(comp,writer);
			final String xml = writer.toString();
			log.debug(xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.SERIALIZANDO,api);
		}
	}
	
	
	
}
