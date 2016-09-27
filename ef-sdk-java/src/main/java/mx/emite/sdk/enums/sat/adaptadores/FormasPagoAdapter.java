package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.FormasPago;
import mx.emite.sdk.errores.ApiException;

@Slf4j
@Deprecated
public class FormasPagoAdapter extends XmlAdapter<String,FormasPago> implements TypeHandler{

	@Override
	public FormasPago unmarshal(String metodo) throws ApiException {
		return FormasPago.unmarshall(metodo);
	}
	@Override
	public Class<FormasPago> getType() {
		return FormasPago.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return FormasPago.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof FormasPago)
			return FormasPago.marshall((FormasPago)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(FormasPago v) throws Exception {
		return FormasPago.marshall(v);
	}
	
	/*
	@Override
	public FormasPago unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		final FormasPago fp =  FormasPago.busca(metodo);		
		if(fp==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El método de pago "+metodo+" no se encuentra en el catálogo de métodos de pago del SAT");
		else
			return fp;
	}
	
	

	@Override
	public Class<?> getType() {
		return FormasPago.class;
	}*/
}
