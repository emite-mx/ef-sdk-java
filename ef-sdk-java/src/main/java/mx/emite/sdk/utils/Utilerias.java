package mx.emite.sdk.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.Collator;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import lombok.Cleanup;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.proxy.request.extra.generico.xml.GenericoFactura;

public class Utilerias {

	
	private final static Decoder decoder = Base64.getDecoder();
	private final static Encoder encoder = Base64.getEncoder();
	private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	private final static Collator comparador = creaComparador();
	
	public static String decodifica64Utf8(final String xmlBase64) throws ApiException{
		try{
		return new String(decodifica64Utf8Byte(xmlBase64));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.DECODIFICANDO,ex);
		}
	}

	public static byte[] decodifica64Utf8Byte(final String xmlBase64) throws ApiException{
		try{
		return decoder.decode(utf8(xmlBase64));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.DECODIFICANDO,ex);
		}
	}
	
	private static Collator creaComparador() {
		final Collator res = Collator.getInstance(new Locale("es","MX"));
		res.setStrength(Collator.NO_DECOMPOSITION);
		return res;
	}

	public static String codifica64Utf8(final String xml) throws ApiException{
		try{
		return  utf8(encoder.encode(utf8(xml)));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.CODIFICANDO,ex);
		}
	}
	
	public static String codifica64Binario(byte[] cer) throws ApiException{
		try{
		return  utf8(encoder.encode(cer));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.CODIFICANDO,ex);
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
			throw new ApiException(I_Api_Errores.LEYENDO_ARCHIVO,io);
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
			@Cleanup ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    byte[] buffer = new byte[1024];
		    int length = 0;
		    while ((length = is.read(buffer)) != -1) {
		        baos.write(buffer, 0, length);
		    }
		    return utf8(baos.toByteArray());
		}
		catch(Exception io){
			throw new ApiException(I_Api_Errores.LEYENDO_ARCHIVO,io);
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

	public static String marshall(Comprobante comprobante) throws ApiException {
		valida(comprobante);
		return MarshallerUnmarshaller.marshallCfdi32(comprobante);
	}

	public static GenericoFactura unmarshallGenerico(final String xml) throws ApiException {
		
		return MarshallerUnmarshaller.unmarshallGenerico(xml);
	}
	
	public static boolean compara(String source, String target) {
		return comparador.compare(source, target)==0;
	}

	public static byte[] decodificaBinario(String pdf) throws ApiException{
		try{
			return decoder.decode(pdf.getBytes());
			}catch(Exception ex){
				throw new ApiException(I_Api_Errores.DECODIFICANDO,ex);
		}
	}

	public static void guardaArchivo(String ruta, byte[] pdfDecodificado) throws ApiException{
		try{
				Files.write(Paths.get(ruta), pdfDecodificado);
			}catch(Exception ex){
				throw new ApiException(I_Api_Errores.GUARDANDOARCHIVO,ex);
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
			throw new ApiException(I_Api_Errores.GUARDANDOARCHIVO,ex);
	}
		
	}

	public static <T> T nvl(T valor,T sinulo) {
		if(valor==null)
			return sinulo;
		return valor;
	}
	
	public static void main(String[] args){
		try{
			String xml="01|1231.43|1428.46|PAGO EN UNA SOLA EXHIBICIÓN|||dcabiedes@cofine.com.mx||MÉXICO DF|NO IDENTIFICADO|NO IDENTIFICADO|AA|35571||PESOS|ingreso|General de ley personas morales|Esta factura forma parte de la expedida el 2014-10-08 13:47:04, folio fiscal ED514122-49D9-4648-BDFD-628792DF5509 por un monto de 55551.12|\n" + 
					"02|COBS620908A54|SERGIO JESUS CORDERO BLANCO|LEONARDO NO 205|||RENACIMIENTO 1A Y 2A SEC.|MONTERREY|NUEVO LEON|64925|MEXICO|\n" + 
					"03|CALLE|COLONIA|EXT|INT|||||P10036|P10036|4937.18|Recuperacion parcial del financiamiento otorgado para el apoyo de Energia Electrica, llevado a cabo en su empresa. Parcialidad 19/48)|GR-2673-14|||||||\n" + 
					"04|1.00|NO APLICA|Recuperacion  del costo financiero correspondiente al financiamiento otorgado para el proyecto de ahorro de Energia Electrica, llevado a cabo en su empresa. Parcialidad 19/48)|1231.43|197.03|16.00|100|||||||||||\n"+
					"04|2.00|NO APLICA|Recuperacion  del costo financiero correspondiente al financiamiento otorgado para el proyecto de ahorro de Energia Electrica, llevado a cabo en su empresa. Parcialidad 19/48)|1231.43|197.03|16.00||||||||||||\n"+
					"05|||";
			GenericoFactura fac = unmarshallTxtGenerico(codifica64Utf8(xml));
			System.out.println(fac.toString().replace(", ", ",\n"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
				try{in.close();}catch(Exception ex){;}
		}
	}

	
	 
	
}
