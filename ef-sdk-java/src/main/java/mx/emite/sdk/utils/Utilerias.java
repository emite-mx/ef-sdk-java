package mx.emite.sdk.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import lombok.Cleanup;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

public class Utilerias {

	
	private final static Decoder decoder = Base64.getDecoder();
	private final static Encoder encoder = Base64.getEncoder();
	private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	private final static Collator comparador = creaComparador();
	
	public static String decodificaUtf8(final String xmlBase64) throws ApiException{
		try{
		return new String(decoder.decode(utf8(xmlBase64)));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.DECODIFICANDO,ex);
		}
	}

	private static Collator creaComparador() {
		final Collator res = Collator.getInstance(new Locale("es","MX"));
		res.setStrength(Collator.NO_DECOMPOSITION);
		return res;
	}

	public static String codificaUtf8(final String xml) throws ApiException{
		try{
		return  utf8(encoder.encode(utf8(xml)));
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

	public static void valida(Object objeto) throws ApiException{
		final Set<ConstraintViolation<Object>> errores = validator.validate(objeto);
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
		return MarshallerUnmarshaller.marshall(comprobante);
	}

	public static boolean compara(String source, String target) {
		return comparador.compare(source, target)==0;
	} 
	
}
