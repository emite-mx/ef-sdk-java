package mx.emite.sdk.enums.sat.cfdi33.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.cfdi33.UsosCfdi33;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class UsosCfdi33Adapter extends XmlAdapter<String,UsosCfdi33> implements TypeHandler{

	@Override
	public UsosCfdi33 unmarshal(String metodo) throws ApiException {
		return UsosCfdi33.unmarshall(metodo);
	}
	@Override
	public Class<UsosCfdi33> getType() {
		return UsosCfdi33.class;
	}
	
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return UsosCfdi33.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof UsosCfdi33)
			return UsosCfdi33.marshall((UsosCfdi33)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(UsosCfdi33 v) throws Exception {
		return UsosCfdi33.marshall(v);
	}
	
	 
}
