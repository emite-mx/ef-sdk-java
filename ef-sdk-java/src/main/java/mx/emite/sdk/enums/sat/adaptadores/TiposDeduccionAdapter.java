package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposDeduccion12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposDeduccionAdapter extends XmlAdapter<String,TiposDeduccion12> implements TypeHandler{

	@Override
	public TiposDeduccion12 unmarshal(String metodo) throws ApiException {
		return TiposDeduccion12.unmarshall(metodo);
	}
	@Override
	public Class<TiposDeduccion12> getType() {
		return TiposDeduccion12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposDeduccion12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposDeduccion12)
			return TiposDeduccion12.marshall((TiposDeduccion12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposDeduccion12 v) throws Exception {
		return TiposDeduccion12.marshall(v);
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
