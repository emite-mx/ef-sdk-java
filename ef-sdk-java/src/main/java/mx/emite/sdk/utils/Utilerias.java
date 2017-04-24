package mx.emite.sdk.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.cfdi32.comp.Comprobante32;
import mx.emite.sdk.cfdi32.nomina11.ComprobanteNomina11;
import mx.emite.sdk.cfdi32.nomina12.ComprobanteNomina12;
import mx.emite.sdk.cfdi33.Comprobante33;
import mx.emite.sdk.dd10.dpiva10.DoctoDigital;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.proxy.request.extra.generico.cfdi.xml.GenericoFactura;
import mx.emite.sdk.proxy.request.extra.generico.nomina.xml.GenericoNomina;
import mx.emite.sdk.ret10.Retenciones;

public class Utilerias {

	
	private final static Decoder decoder = Base64.getDecoder();
	private final static Encoder encoder = Base64.getEncoder();
	private final static Validator validator = creaValidador();
	private final static Collator comparador = creaComparador();
	private final static String UTF8_BOM = "\uFEFF";
	public final static String PATRON_RFC = "^[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]$";
	
	
	/*public static void main (String[] agr){
		
		final Pattern patron = Pattern.compile(PATRON_RFC);
		Matcher matcher = patron.matcher("GO&R350322KH5");
		System.out.println(matcher.matches());
		
	}*/
	
	
	public static String decodifica64Utf8(final String xmlBase64) throws ApiException{
		try{
		return new String(decodifica64Utf8Byte(xmlBase64));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.PROXY_DECODIFICANDO,ex);
		}
	}

	private static Validator creaValidador() {
		try{
		return Validation.buildDefaultValidatorFactory().getValidator();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	public static byte[] decodifica64Utf8Byte(final String xmlBase64) throws ApiException{
		try{
		return decoder.decode(utf8(xmlBase64));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.PROXY_DECODIFICANDO,ex);
		}
	}
	
	private static Collator creaComparador() {
		try{
		final Collator res = Collator.getInstance(new Locale("es","MX"));
		res.setStrength(Collator.NO_DECOMPOSITION);
		return res;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

	public static String codifica64Utf8(final String xml) throws ApiException{
		try{
		return  utf8(encoder.encode(utf8(xml)));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.PROXY_CODIFICANDO,ex);
		}
	}
	
	public static String codifica64Binario(byte[] cer) throws ApiException{
		try{
		return  utf8(encoder.encode(cer));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.PROXY_CODIFICANDO,ex);
		}
	}

	
	public static byte[] utf8(String xmlBase64) throws Exception{
		return xmlBase64.getBytes(Charset.forName("UTF-8"));
	}
	
	public static String utf8(byte[] xml) throws Exception{
		return new String(xml, Charset.forName("UTF-8"));
	}

	public static String leeArchivo(String ruta) throws ApiException {
		try{
			return utf8(Files.readAllBytes(Paths.get(ruta)));
		}
		catch(Exception io){
			throw new ApiException(I_Api_Errores.PROXY_LEYENDO_ARCHIVO,io);
		}
	}

	public static String leeArchivo(Path ruta) throws ApiException {
		try{
			return utf8(Files.readAllBytes(ruta));
		}
		catch(Exception io){
			throw new ApiException(I_Api_Errores.PROXY_LEYENDO_ARCHIVO,io);
		}
	}

	
	public static <T> void valida(T objeto) throws ApiException{
		if(objeto==null) return;
		
		final Set<ConstraintViolation<T>> errores = validator.validate(objeto);
		if(errores.isEmpty())
			return;
		throw new ApiException(I_Api_Errores.CLIENTE_REQUEST_INVALIDO,errores);
	}

	public static String leeArchivo(InputStream is) throws ApiException {
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    byte[] buffer = new byte[1024];
		    int length = 0;
		    while ((length = is.read(buffer)) != -1) {
		        baos.write(buffer, 0, length);
		    }
		    return utf8(baos.toByteArray());
		}
		catch(Exception io){
			throw new ApiException(I_Api_Errores.PROXY_LEYENDO_ARCHIVO,io);
		}
		finally{
			if(is!=null)
				try {
					is.close();
				} catch (IOException e) {
					;	
				}
		}
	}

	public static String marshallcfdi32(Comprobante comprobante) throws ApiException {
		valida(comprobante);
		return MarshallerUnmarshaller.marshallCfdi32(comprobante);
	}

	public static String marshallcfdi32(Comprobante32 comprobante) throws ApiException {
		if(comprobante.getComplemento()!=null&&comprobante.getComplemento().getComplementos()!=null&&!comprobante.getComplemento().getComplementos().isEmpty())
		{
			final List<String> complementos = new ArrayList<>();
			for(ComplementoInterface c : comprobante.getComplemento().getComplementos()){
				complementos.add(MarshallerUnmarshaller.marshallCfdi32Complemento(c));
			}
			
			final String xml = MarshallerUnmarshaller.marshallCfdi32(comprobante);
		    final Document doc = MarshallerUnmarshaller.leeXml(xml);
		    final Node complemento = MarshallerUnmarshaller.sacaNodo(MarshallerUnmarshaller.xComplemento, doc, "Complemento");
		    for(String insertar:complementos){
		    	final Document docin = MarshallerUnmarshaller.leeXml(insertar);
		    	final Node importado = doc.importNode(docin.getFirstChild(), true);
		    	complemento.appendChild(importado);
		    }
			return MarshallerUnmarshaller.marshall(doc);
			
		}
		else return MarshallerUnmarshaller.marshallCfdi32(comprobante);
	}
	
	
	public static String marshallnom32(ComprobanteNomina11 comprobante) throws ApiException {
		valida(comprobante);
		return MarshallerUnmarshaller.marshallNomina32(comprobante);
	}
	
	public static String marshallnom12(ComprobanteNomina12 comprobante) throws ApiException {
		valida(comprobante);
		return MarshallerUnmarshaller.marshallNomina12(comprobante);
	}
	
	public static String marshalldpiva10(DoctoDigital comprobante) throws ApiException {
		valida(comprobante);
		return MarshallerUnmarshaller.marshallDpIva10(comprobante);
	}
	
	public static String marshallret10(Retenciones comprobante) throws ApiException {
		valida(comprobante);
		if(comprobante.getComplemento()!=null&&comprobante.getComplemento().getComplementos()!=null&&!comprobante.getComplemento().getComplementos().isEmpty())
		{
			final List<String> complementos = new ArrayList<>();
			for(ComplementoInterface c : comprobante.getComplemento().getComplementos()){
				complementos.add(MarshallerUnmarshaller.marshallRet10Complemento(c));
			}
			
			final String xml = MarshallerUnmarshaller.marshallRet10(comprobante);
		    final Document doc = MarshallerUnmarshaller.leeXml(xml);
		    final Node complemento = MarshallerUnmarshaller.sacaNodo(MarshallerUnmarshaller.xComplemento, doc, "Complemento");
		    for(String insertar:complementos){
		    	final Document docin = MarshallerUnmarshaller.leeXml(insertar);
		    	final Node importado = doc.importNode(docin.getFirstChild(), true);
		    	complemento.appendChild(importado);
		    }
			return MarshallerUnmarshaller.marshall(doc);
			
		}
		else
			return MarshallerUnmarshaller.marshallRet10(comprobante);
	}
	
	public static String marshallcfdi33(final Comprobante33 comprobante) throws ApiException {
		valida(comprobante);
		if(comprobante.getComplemento()!=null&&comprobante.getComplemento().getComplementos()!=null&&!comprobante.getComplemento().getComplementos().isEmpty())
		{
			final List<String> complementos = new ArrayList<>();
			for(Complemento33Interface c : comprobante.getComplemento().getComplementos()){
				final String c1 = MarshallerUnmarshaller.marshallCfdi33Complemento(c);
				complementos.add(c1);
			}
			
			final String xml = MarshallerUnmarshaller.marshallCfdi33(comprobante);
		    final Document doc = MarshallerUnmarshaller.leeXml(xml);
		    final Node complemento = MarshallerUnmarshaller.sacaNodo(MarshallerUnmarshaller.xComplemento, doc, "Complemento");
		    for(String insertar:complementos){
		    	final Document docin = MarshallerUnmarshaller.leeXml(insertar);
		    	final Node importado = doc.importNode(docin.getFirstChild(), true);
		    	for(int x=0;x<importado.getAttributes().getLength();x++){
		    		final Node attr = importado.getAttributes().item(x);
		    		if(StringUtils.startsWith(attr.getNodeName(),"xmlns:")||StringUtils.startsWith(attr.getNodeName(),"xsi:")){
		    			importado.getAttributes().removeNamedItem(attr.getNodeName());
		    			x=0;
		    			if(StringUtils.startsWith(attr.getNodeName(),"xmlns:")&&!StringUtils.equals(attr.getNodeName(),"xmlns:cfdi")){
		    				final Element e = (Element) doc.getFirstChild();
		    				e.setAttribute(attr.getNodeName(),attr.getNodeValue());
		    				//doc.getAttributes().setNamedItem();
		    			}
		    		}
		    		System.out.println(importado.getAttributes().item(x).getNodeName()+"->"+importado.getAttributes().item(x).getNodeValue());
		    	}
		    	
		    	complemento.appendChild(importado);
		    }
			return MarshallerUnmarshaller.marshall(doc);
			
		}
		else
			return MarshallerUnmarshaller.marshallCfdi33(comprobante);
	}
	
	public static GenericoFactura unmarshallGenerico(final String xml) throws ApiException {
		return MarshallerUnmarshaller.unmarshallGenerico(xml);
	}
	
	public static GenericoNomina unmarshallGenericoNomina(final String xml) throws ApiException {
		return MarshallerUnmarshaller.unmarshallGenericoNomina(xml);
	}
	
	public static boolean compara(String source, String target) {
		if(StringUtils.isEmpty(target))
			return false;
		return comparador.compare(source, target)==0;
	}

	public static byte[] decodificaBinario(String pdf) throws ApiException{
		try{
			return decoder.decode(pdf.getBytes());
			}catch(Exception ex){
				throw new ApiException(I_Api_Errores.PROXY_DECODIFICANDO,ex);
		}
	}

	public static byte[] decodificaBinario(String pdf,final I_Api_Errores error) throws ApiException{
		try{
			return decoder.decode(pdf.getBytes());
			}catch(Exception ex){
				throw new ApiException(error,ex);
		}
	}
	
	public static void guardaArchivo(String ruta, byte[] pdfDecodificado) throws ApiException{
		try{
				Files.write(Paths.get(ruta), pdfDecodificado);
			}catch(Exception ex){
				throw new ApiException(I_Api_Errores.PROXY_GUARDANDOARCHIVO,ex);
		}
	}

	public static void guardaUrl(String ruta, String url) {
		try{
			final URL u = new URL(url);
			final URLConnection con = u.openConnection();
			try (ReadableByteChannel source = Channels.newChannel(con.getInputStream());
		        FileChannel out = FileChannel.open(Paths.get(ruta), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
				out.transferFrom(source, 0, Long.MAX_VALUE);
		    }
			
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.PROXY_GUARDANDOARCHIVO,ex);
	}
		
	}

	public static <T> T nvl(T valor,T sinulo) {
		if(valor==null)
			return sinulo;
		return valor;
	}
	
	

	public static GenericoFactura unmarshallTxtGenerico(String txt) throws ApiException {
		BeanReader in=null;
		try{
		final StreamFactory factory = StreamFactory.newInstance();
        factory.load(Utilerias.class.getResourceAsStream("/facturagenericatxt.xml"));
        final StringReader sr = new StringReader(decodifica64Utf8(txt));
        // use a StreamFactory to create a BeanReader
        in = factory.createReader("emiteGenerico",sr);
        GenericoFactura res = (GenericoFactura) in.read();
        in.close();
        return res;
        
		}
		catch(ApiException api){throw api;}
		catch(Exception ex){
			if(ex.getCause() instanceof ApiException)
				throw (ApiException)ex.getCause();
			else
				throw new ApiException(I_Api_Errores.PROXY_LEYENDO_TXT,ex);
		}
		finally{
			if(in!=null)
				try{in.close();}catch(Exception ex){ex.printStackTrace();}
		}
	}

	public static GenericoNomina unmarshallTxtGenericoNomina(String txt) throws ApiException {
		BeanReader in=null;
		try{
		final StreamFactory factory = StreamFactory.newInstance();
        factory.load(Utilerias.class.getResourceAsStream("/facturagenericatxt.xml"));
        final StringReader sr = new StringReader(decodifica64Utf8(txt));
        // use a StreamFactory to create a BeanReader
        in = factory.createReader("emiteGenericoNomina",sr);
        GenericoNomina res = (GenericoNomina) in.read();
        in.close();
        return res;
        
		}
		catch(ApiException api){
			try{if(in!=null)in.close();}catch(Exception ex){ex.printStackTrace();}
			throw api;
		}
		catch(Exception ex){
			try{if(in!=null)in.close();}catch(Exception ex3){ex3.printStackTrace();}
			if(ex.getCause() instanceof ApiException)
				throw (ApiException)ex.getCause();
			else
				throw new ApiException(I_Api_Errores.PROXY_LEYENDO_TXT,ex);
		}
		
	}

	public static String marshallTxtGenericoNomina(final GenericoNomina txt) throws ApiException {
		BeanWriter out=null;
		try{
		final StreamFactory factory = StreamFactory.newInstance();
        factory.load(Utilerias.class.getResourceAsStream("/facturagenericatxt.xml"));
        final StringWriter writer = new StringWriter();
        out = factory.createWriter("emiteGenericoNomina", writer);
        out.write(txt);
        out.close();
        return writer.toString();
        
		}
		catch(ApiException api){
			try{if(out!=null) out.close();}catch(Exception ex){ex.printStackTrace();}
			throw api;
		}
		catch(Exception ex){
			try{if(out!=null) out.close();}catch(Exception ex3){ex3.printStackTrace();}
			if(ex.getCause() instanceof ApiException)
				throw (ApiException)ex.getCause();
			else
				throw new ApiException(I_Api_Errores.PROXY_LEYENDO_TXT,ex);
		}
		
	}
	
	
	public static String marshallGenerico(GenericoFactura comprobante) {
		return MarshallerUnmarshaller.marshallGenericoXml(comprobante);
	}

	public static String marshallGenericoNomina(GenericoNomina comprobante) {
		return MarshallerUnmarshaller.marshallGenericoNominaXml(comprobante);
	}
	
	public static Long toLong(String folio, I_Api_Errores error, String campo) throws ApiException{
		try{
			return Long.parseLong(folio);
		}
		catch(Exception ex){
			throw new ApiException(error,"El "+campo+ " "+ folio + " no es un número válido",ex);
		}
	}

	public static String quitaBom(final String s) {
		if(StringUtils.isEmpty(s))
			return s;
	    if (s.startsWith(UTF8_BOM)) {
	        return s.substring(1);
	    }
	    return s;
	}

	public static byte[] quitaBom(final byte[] bom) {
		try {
			return quitaBom(new String(bom,"UTF-8")).getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return quitaBom(new String(bom)).getBytes();
		}
		
	}
	
	public static String transforma(Document tempo) throws Exception {
		DOMSource domSource = new DOMSource(tempo);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		return writer.toString();
	}

	 
	
}
