package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.OrigenRecurso;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class OrigenRecursoAdapter extends XmlAdapter<String,OrigenRecurso> implements TypeHandler{

	@Override
	public OrigenRecurso unmarshal(String metodo) throws ApiException {
		return OrigenRecurso.unmarshall(metodo);
	}
	@Override
	public Class<OrigenRecurso> getType() {
		return OrigenRecurso.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return OrigenRecurso.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof OrigenRecurso)
			return OrigenRecurso.marshall((OrigenRecurso)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(OrigenRecurso v) throws Exception {
		return OrigenRecurso.marshall(v);
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
