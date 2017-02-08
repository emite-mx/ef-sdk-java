package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class PaisesSatAdapter extends XmlAdapter<String,Paises> implements TypeHandler{

	@Override
	public Paises unmarshal(String metodo) throws ApiException {
		return Paises.unmarshall(metodo);
	}
	@Override
	public Class<Paises> getType() {
		return Paises.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return Paises.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof Paises)
			return Paises.marshallSat((Paises)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(Paises v) throws Exception {
		return Paises.marshallSat(v);
	}
	
	/*@Override
	public Paises unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		final Paises pais = Paises.busca(metodo);
		if(pais==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El pais "+metodo+" no se encuentra en el catálogo de paises SAT");
		else
			return pais;
	}



	@Override
	public Class<?> getType() {
		return Paises.class;
	}*/
}
