package mx.emite.sdk.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.codec.binary.Base64;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.cfdi32.nomina.ComprobanteNomina;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.proxy.request.extra.generico.cfdi.xml.GenericoFactura;
import mx.emite.sdk.proxy.request.extra.generico.nomina.xml.GenericoNomina;

@Slf4j
public class MarshallerUnmarshaller {

		
	//private final static Marshaller marshaller = xmlMarshaller();
	private final static JAXBContext contexto = contexto(Comprobante.class,GenericoFactura.class,GenericoNomina.class,ComprobanteNomina.class);
	
	
	private static Marshaller xmlMarshaller(){
		try{
		
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd");
		return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	private static Marshaller xmlNominaMarshaller(){
		try{
		
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd http://www.sat.gob.mx/nomina http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina11.xsd");
		return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	private static Unmarshaller genericoUnmarshaller(){
		try{
		
		final Unmarshaller m = contexto.createUnmarshaller();
		return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	private static Marshaller genericoMarshaller(){
		try{
		
			final Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	private static JAXBContext contexto(Class<?>... clase) {
		try{
			return JAXBContext.newInstance(clase);
		}
		catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
		
	}

	public static String marshallCfdi32(Comprobante comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlMarshaller().marshal(comp,writer);
			final String xml = writer.toString();
			log.debug(xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.SERIALIZANDO,api);
		}
	}
	

	public static String marshallGenericoXml(GenericoFactura comprobante) {
		try{
			final StringWriter writer = new StringWriter();
			genericoMarshaller().marshal(comprobante,writer);
			final String xml = writer.toString();
			log.debug(xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.SERIALIZANDO,api);
		}
	}
	
	public static String marshallGenericoNominaXml(GenericoNomina comprobante) {
		try{
			final StringWriter writer = new StringWriter();
			genericoMarshaller().marshal(comprobante,writer);
			final String xml = writer.toString();
			log.debug(xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.SERIALIZANDO,api);
		}
	}
	
	
	public static String marshallNomina32(ComprobanteNomina comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlNominaMarshaller().marshal(comp,writer);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.SERIALIZANDO,api);
		}
	}
	
	public static GenericoFactura unmarshallGenerico(String xml) {
		if(!Base64.isBase64(xml))
			throw new ApiException(I_Api_Errores.CLIENTE_XML_BASE64);
		try{
			final StringReader res = new StringReader(Utilerias.decodifica64Utf8(xml));
			final StreamSource source = new StreamSource(res);
			return (GenericoFactura) genericoUnmarshaller().unmarshal(source);
		}
		catch(ApiException ae){
			throw ae;
		}
		catch(Exception ex){
			if(ex.getCause() instanceof ApiException)
				throw (ApiException)ex.getCause();
			else
				throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,ex);
		}
	}

	public static GenericoNomina unmarshallGenericoNomina(String xml) {
		if(!Base64.isBase64(xml))
			throw new ApiException(I_Api_Errores.CLIENTE_XML_BASE64);
		try{
			final StringReader res = new StringReader(Utilerias.decodifica64Utf8(xml));
			final StreamSource source = new StreamSource(res);
			return (GenericoNomina) genericoUnmarshaller().unmarshal(source);
		}
		catch(ApiException ae){
			throw ae;
		}
		catch(Exception ex){
			if(ex.getCause() instanceof ApiException)
				throw (ApiException)ex.getCause();
			else
				throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,ex);
		}
	}
	
	
}
