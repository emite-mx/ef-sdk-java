package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class RegimenesFiscalesAdapter extends XmlAdapter<String,RegimenesFiscales> implements TypeHandler{

	@Override
	public RegimenesFiscales unmarshal(String metodo) throws ApiException {
		return RegimenesFiscales.unmarshall(metodo);
	}
	@Override
	public Class<RegimenesFiscales> getType() {
		return RegimenesFiscales.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return RegimenesFiscales.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof RegimenesFiscales)
			return RegimenesFiscales.marshall((RegimenesFiscales)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(RegimenesFiscales v) throws Exception {
		return RegimenesFiscales.marshall(v);
	}
	
	/*
	@Override
	public RegimenesFiscales unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		final RegimenesFiscales reg=  RegimenesFiscales.busca(metodo);
		if(reg==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El régimen "+metodo+" no se encuentra en el catálogo de regimenes del SAT");
		else
			return reg;
	}

	
	@Override
	public Class<?> getType() {
		return RegimenesFiscales.class;
	}*/
}
