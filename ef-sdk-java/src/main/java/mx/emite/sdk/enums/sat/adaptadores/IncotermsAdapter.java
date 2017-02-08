package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.Incoterms;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class IncotermsAdapter extends XmlAdapter<String,Incoterms> implements TypeHandler{

	@Override
	public Incoterms unmarshal(String metodo) throws ApiException {
		return Incoterms.unmarshall(metodo);
	}
	@Override
	public Class<Incoterms> getType() {
		return Incoterms.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return Incoterms.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof Incoterms)
			return Incoterms.marshall((Incoterms)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(Incoterms v) throws Exception {
		return Incoterms.marshall(v);
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
