package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposNomina;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposNominaAdapter extends XmlAdapter<String,TiposNomina> implements TypeHandler{

	@Override
	public TiposNomina unmarshal(String metodo) throws ApiException {
		return TiposNomina.unmarshall(metodo);
	}
	@Override
	public Class<TiposNomina> getType() {
		return TiposNomina.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposNomina.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposNomina)
			return TiposNomina.marshall((TiposNomina)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposNomina v) throws Exception {
		return TiposNomina.marshall(v);
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
