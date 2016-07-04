package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.EntidadesFederativas;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class EntidadesFederativasAdapter extends XmlAdapter<String,EntidadesFederativas> implements TypeHandler{

	@Override
	public EntidadesFederativas unmarshal(String metodo) throws ApiException {
		return EntidadesFederativas.unmarshall(metodo);
	}
	@Override
	public Class<EntidadesFederativas> getType() {
		return EntidadesFederativas.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return EntidadesFederativas.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof EntidadesFederativas)
			return EntidadesFederativas.marshall((EntidadesFederativas)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(EntidadesFederativas v) throws Exception {
		return EntidadesFederativas.marshall(v);
	}
}
