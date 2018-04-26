package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposNomina12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposNominaAdapter extends XmlAdapter<String,TiposNomina12> implements TypeHandler{

	@Override
	public TiposNomina12 unmarshal(String metodo) throws ApiException {
		return TiposNomina12.unmarshall(metodo);
	}
	@Override
	public Class<TiposNomina12> getType() {
		return TiposNomina12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposNomina12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposNomina12)
			return TiposNomina12.marshall((TiposNomina12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposNomina12 v) throws Exception {
		return TiposNomina12.marshall(v);
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
