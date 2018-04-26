package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.OrigenRecurso12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class OrigenRecursoAdapter extends XmlAdapter<String,OrigenRecurso12> implements TypeHandler{

	@Override
	public OrigenRecurso12 unmarshal(String metodo) throws ApiException {
		return OrigenRecurso12.unmarshall(metodo);
	}
	@Override
	public Class<OrigenRecurso12> getType() {
		return OrigenRecurso12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return OrigenRecurso12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof OrigenRecurso12)
			return OrigenRecurso12.marshall((OrigenRecurso12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(OrigenRecurso12 v) throws Exception {
		return OrigenRecurso12.marshall(v);
	}
	
	/*@Override
	public TiposImpuesto unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		return TiposImpuesto.busca(metodo);		
	}

	@Override
	public Class<?> getType() {
		return TiposImpuesto.class;
	}
*/
}
