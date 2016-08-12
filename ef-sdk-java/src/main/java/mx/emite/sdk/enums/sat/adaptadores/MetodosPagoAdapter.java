package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.MetodosPago;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class MetodosPagoAdapter extends XmlAdapter<String,MetodosPago> implements TypeHandler{

	@Override
	public MetodosPago unmarshal(String metodo) throws ApiException {
		return MetodosPago.unmarshall(metodo);
	}
	@Override
	public Class<MetodosPago> getType() {
		return MetodosPago.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return MetodosPago.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof MetodosPago)
			return MetodosPago.marshall((MetodosPago)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(MetodosPago v) throws Exception {
		return MetodosPago.marshall(v);
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
