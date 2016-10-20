package mx.emite.sdk.enums.sat.adaptadores;

import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.RegimenesFiscales;

@Slf4j
public class RegimenesFiscalesIdSatAdapter extends RegimenesFiscalesAdapter implements TypeHandler{

	@Override
	public String format(Object value){
		try{
		if(value instanceof RegimenesFiscales)
			return RegimenesFiscales.marshallIdSat((RegimenesFiscales)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(RegimenesFiscales v) throws Exception {
		return RegimenesFiscales.marshallIdSat(v);
	}
	
	
}
