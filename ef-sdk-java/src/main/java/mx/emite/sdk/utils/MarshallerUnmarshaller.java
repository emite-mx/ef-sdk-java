package mx.emite.sdk.utils;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPathConstants;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.cfdi32.comp.Comprobante32;
import mx.emite.sdk.cfdi32.complementos.cce11.ComercioExterior11;
import mx.emite.sdk.cfdi32.nomina11.ComprobanteNomina11;
import mx.emite.sdk.cfdi32.nomina12.ComprobanteNomina12;
import mx.emite.sdk.cfdi33.Comprobante33;
import mx.emite.sdk.cfdi33.complementos.aerolineas10.Aerolineas;
import mx.emite.sdk.cfdi33.complementos.cdc10.ConsumoDeCombustibles;
import mx.emite.sdk.cfdi33.complementos.divisas10.Divisas;
import mx.emite.sdk.cfdi33.complementos.ecc11.EstadoDeCuentaCombustible;
import mx.emite.sdk.cfdi33.complementos.implocal10.ImpuestosLocales;
import mx.emite.sdk.cfdi33.complementos.leyfisc10.LeyendasFiscales;
import mx.emite.sdk.cfdi33.complementos.notpub10.NotariosPublicos;
import mx.emite.sdk.cfdi33.complementos.pee10.PagoEnEspecie;
import mx.emite.sdk.cfdi33.complementos.pfic10.PFintegranteCoordinado;
import mx.emite.sdk.cfdi33.complementos.regfisc10.CFDIRegistroFiscal;
import mx.emite.sdk.cfdi33.complementos.spc10.ParcialesConstruccion;
import mx.emite.sdk.cfdi33.complementos.tpe10.TuristaPasajeroExtranjero;
import mx.emite.sdk.cfdi33.complementos.vdd10.ValesDeDespensa;
import mx.emite.sdk.cfdi33.complementos.vu10.VehiculoUsado;
import mx.emite.sdk.dd10.dpiva10.DoctoDigital;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.proxy.request.extra.generico.cfdi.xml.GenericoFactura;
import mx.emite.sdk.proxy.request.extra.generico.nomina.xml.GenericoNomina;
import mx.emite.sdk.ret10.Retenciones;
import mx.emite.sdk.ret10.comp.arrendamientofideicomiso.Arrendamientoenfideicomiso;
import mx.emite.sdk.ret10.comp.dividendos.Dividendos;
import mx.emite.sdk.ret10.comp.enajenaciondeacciones.EnajenaciondeAcciones;
import mx.emite.sdk.ret10.comp.fideicomisonoempresarial.Fideicomisonoempresarial;
import mx.emite.sdk.ret10.comp.intereses.Intereses;
import mx.emite.sdk.ret10.comp.intereseshipotecarios.Intereseshipotecarios;
import mx.emite.sdk.ret10.comp.operacionesconderivados.Operacionesconderivados;
import mx.emite.sdk.ret10.comp.pagosaextranjeros.Pagosaextranjeros;
import mx.emite.sdk.ret10.comp.planesretiro.Planesderetiro;
import mx.emite.sdk.ret10.comp.premios.Premios;
import mx.emite.sdk.ret10.comp.sectorfinanciero.SectorFinanciero;
import mx.emite.sdk.ret10.comp.timbrefiscaldigital.TimbreFiscalDigital;

@Slf4j
public class MarshallerUnmarshaller {

		
	//private final static Marshaller marshaller = xmlMarshaller();
	private final static JAXBContext contexto = contexto(Comprobante.class,GenericoFactura.class,GenericoNomina.class,ComprobanteNomina11.class,ComprobanteNomina12.class, Retenciones.class,EnajenaciondeAcciones.class
			,Dividendos.class,Intereses.class,Arrendamientoenfideicomiso.class,Pagosaextranjeros.class,
			Premios.class,Fideicomisonoempresarial.class,Planesderetiro.class,Intereseshipotecarios.class,
			Operacionesconderivados.class,SectorFinanciero.class,TimbreFiscalDigital.class,
			mx.emite.sdk.cfdi32.complementos.timbrefiscaldigital.TimbreFiscalDigital.class,DoctoDigital.class
			,Comprobante32.class,ComercioExterior11.class,
			Comprobante33.class
			,mx.emite.sdk.cfdi33.complementos.nomina12.Nomina.class
			,mx.emite.sdk.cfdi33.complementos.cce11.ComercioExterior11.class
			,mx.emite.sdk.cfdi33.complementos.ine11.Ine11.class
			,mx.emite.sdk.cfdi33.complementos.pagos10.Pagos10.class,
			EstadoDeCuentaCombustible.class, 
			Divisas.class,
			ImpuestosLocales.class,
			LeyendasFiscales.class,
			PFintegranteCoordinado.class,
			TuristaPasajeroExtranjero.class,
			CFDIRegistroFiscal.class,
			PagoEnEspecie.class,
			Aerolineas.class,
			ValesDeDespensa.class,
			ConsumoDeCombustibles.class,
			NotariosPublicos.class,
			VehiculoUsado.class,
			ParcialesConstruccion.class
			);
	public final static XpathExpresion xComplemento = new XpathExpresion("//*[contains(local-name(), 'Complemento')]");
	
	/** DocumentBuilderFactory. */
    private static final ThreadLocal<DocumentBuilderFactory> DOC_FACTORY = new ThreadLocal<DocumentBuilderFactory>() {
        @Override
        protected DocumentBuilderFactory initialValue() {
            final DocumentBuilderFactory dbf = DocumentBuilderFactory
                    .newInstance();
            dbf.setValidating(false);
            dbf.setIgnoringElementContentWhitespace(true);
            dbf.setNamespaceAware(true);	
            return dbf;
        };
    };
	
    
	public static Document leeXml(String xml) throws ApiException{
		try{
		return DOC_FACTORY.get().newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
		}
		catch(Exception ex){
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,ex);
		}
	}
	
	
	
	private final static String CFDI32_ESQUEMA="http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd";
	private static final String CFDI33_SCHEMA_LOCATION = "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd";
	
	private static Marshaller xmlMarshaller(final List<ComplementoInterface> complementos){
		try{
		final StringBuilder esquema = new StringBuilder(CFDI32_ESQUEMA);
		if(complementos!=null && !complementos.isEmpty()){
			complementos.stream().forEach(c->esquema.append(" ").append(c.getEsquemaLocation()));
		}
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, esquema.toString());
		
		
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
	
	private static Marshaller xmlNomina12Marshaller(){
		try{
		
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd http://www.sat.gob.mx/nomina12 http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina12.xsd");
		return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	private static Marshaller xmlRetencionesMarshaller(){
		try{
		
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/esquemas/retencionpago/1 http://www.sat.gob.mx/esquemas/retencionpago/1/retencionpagov1.xsd");
		return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	private static Marshaller xmlCfdi33Marshaller(final List<Complemento33Interface> ci){
		try{
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		if(ci==null||ci.isEmpty()){
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, CFDI33_SCHEMA_LOCATION);
		}
		else{
			final List<String> sl = new ArrayList<>();
			sl.add(CFDI33_SCHEMA_LOCATION);
			sl.addAll(ci.stream().map(i->i.getEsquemaLocation()).collect(Collectors.toList()));
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, sl.stream().collect(Collectors.joining(" ")));
		}
		return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	private static Marshaller xmlRetencionesComplementoMarshaller(final ComplementoInterface c){
		try{
		
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_FRAGMENT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, c.getEsquemaLocation());
		return m;
		}catch(Exception ex){
			log.error("creando marshaller",ex);
			return null;
		}
	}
	
	private static Marshaller xmlCfdiComplementoMarshaller(final ComplementoInterface c) throws Exception{
		try{
		
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_FRAGMENT, true);
		
		//m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, c.getEsquemaLocation());
		return m;
		}catch(Exception ex){
			throw ex;
		}
	}
	
	private static Marshaller xmlCfdi33ComplementoMarshaller(final Complemento33Interface c) throws Exception{
		try{
		
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_FRAGMENT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, c.getEsquemaLocation());
		return m;
		}catch(Exception ex){
			throw ex;
		}
	}
	
	 
	private static Marshaller xmlDpIva10Marshaller(final DoctoDigital c) throws Exception{
		try{
		
		final Marshaller m = contexto.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//m.setProperty(Marshaller.JAXB_FRAGMENT, true);
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/1 http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/1/DoctoDigital.xsd http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/TipoDPIVA/1 http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/TipoDPIVA/1/DPIVA.xsd");
		return m;
		}catch(Exception ex){
			throw ex;
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
			ex.printStackTrace();
			log.error("creando marshaller",ex);
			return null;
		}
		
	}

	public static String marshallCfdi32(Comprobante comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlMarshaller(null).marshal(comp,writer);
			final String xml = writer.toString();
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallCfdi32(Comprobante32 comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			final List<ComplementoInterface> comps = comp.getComplemento()!=null?comp.getComplemento().getComplementos():null;
			final Map<String,String> namespaces = new HashMap<>();
			if(comps==null || comps.isEmpty()){
				xmlMarshaller(comps).marshal(comp,writer);
			}
			else{
				comps.stream().forEach(i->namespaces.put(i.getPrefijo(), i.getEsquemaLocation()));
				xmlMarshaller(comps).marshal(comp,writer);
			}
			
			final String xml = writer.toString();
			if(comps==null || comps.isEmpty()){
				return xml;
			}
			else{
				//Agregamos los namespaces
				final StringBuilder sb = new StringBuilder();
				namespaces.entrySet().stream().forEach(i-> sb.append("xmlns:").append(i.getKey()).append("=\"").append(i.getValue().substring(0,i.getValue().indexOf(" "))).append("\" "));
				return xml.replace("<cfdi:Comprobante ", "<cfdi:Comprobante "+sb.toString());
			}
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
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
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
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
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	
	public static String marshallNomina32(ComprobanteNomina11 comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlNominaMarshaller().marshal(comp,writer);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallNomina32(ComprobanteNomina12 comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlNominaMarshaller().marshal(comp,writer);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallNomina12(ComprobanteNomina12 comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlNomina12Marshaller().marshal(comp,writer);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallRet10(Retenciones comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlRetencionesMarshaller().marshal(comp,writer);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallCfdi33(final Comprobante33 comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlCfdi33Marshaller(comp.getComplemento()!=null&&comp.getComplemento().getComplementos()!=null&&!comp.getComplemento().getComplementos().isEmpty()?comp.getComplemento().getComplementos():null).marshal(comp,writer);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallRet10Complemento(ComplementoInterface comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlRetencionesComplementoMarshaller(comp).marshal(comp,writer);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallCfdi32Complemento(ComplementoInterface comp) throws ApiException{
		try{
			final StringWriter sw = new StringWriter();
			xmlCfdiComplementoMarshaller(comp).marshal(comp,sw);
			final String xml = sw.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallCfdi33Complemento(Complemento33Interface comp) throws ApiException{
		try{
			final StringWriter sw = new StringWriter();
			xmlCfdi33ComplementoMarshaller(comp).marshal(comp,sw);
			final String xml = sw.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String marshallDpIva10(DoctoDigital comp) throws ApiException{
		try{
			final StringWriter writer = new StringWriter();
			xmlDpIva10Marshaller(comp).marshal(comp,writer);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	public static String formatea(String xml)  {
		try{
			 final Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
			 serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			 serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			 serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2");
		     serializer.setOutputProperty("{http://xml.customer.org/xslt}indent-amount","2");
		     final Source source = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes("UTF-8"))));
		     final StringWriter w = new StringWriter();
		     final StreamResult res = new StreamResult(w);
		     serializer.transform(source, res);
		     return w.toString();
		}
		catch(Exception ex){
			log.error("formateando",ex);
			return xml;
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
	
	public static Node sacaNodo(XpathExpresion exp, Document doc,String nombre) throws ApiException {
		try{
			final Node res = (Node) exp.evaluate(doc, XPathConstants.NODE);
			return res;
		}catch(Exception ex){
			log.error("error obteniendo "+nombre,ex);
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INFO_NOENCONTRADO,nombre);
			
		}
	}

	public static String marshall(Document doc) {
		try{
			final StringWriter writer = new StringWriter();
			final StreamResult result  = new StreamResult(writer);
			final TransformerFactory tf = TransformerFactory.newInstance();
			final Transformer tr = tf.newTransformer();
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty(OutputKeys.INDENT,"yes");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			doc.setXmlStandalone(true);
			final DOMSource domSource = new DOMSource(doc);
			tr.transform(domSource, result);
			final String xml = writer.toString();
			log.debug("\n"+xml);
			return xml;
			
		}catch(Exception api){
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,api);
		}
	}
	
	
	
}
