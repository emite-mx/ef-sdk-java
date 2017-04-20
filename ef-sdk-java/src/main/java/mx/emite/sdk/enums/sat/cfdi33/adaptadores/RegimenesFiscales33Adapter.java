package mx.emite.sdk.enums.sat.cfdi33.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.cfdi33.RegimenesFiscales33;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class RegimenesFiscales33Adapter extends XmlAdapter<String,RegimenesFiscales33> implements TypeHandler{

	@Override
	public RegimenesFiscales33 unmarshal(String metodo) throws ApiException {
		return RegimenesFiscales33.unmarshall(metodo);
	}
	@Override
	public Class<RegimenesFiscales33> getType() {
		return RegimenesFiscales33.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return RegimenesFiscales33.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof RegimenesFiscales33)
			return RegimenesFiscales33.marshallIdSat((RegimenesFiscales33)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(RegimenesFiscales33 v) throws Exception {
		return RegimenesFiscales33.marshallIdSat(v);
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
