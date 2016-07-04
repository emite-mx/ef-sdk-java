package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TipoSocDistrDiv;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TipoSocDistrDivAdapter extends XmlAdapter<String,TipoSocDistrDiv> implements TypeHandler{

	@Override
	public TipoSocDistrDiv unmarshal(String metodo) throws ApiException {
		return TipoSocDistrDiv.unmarshall(metodo);
	}
	@Override
	public Class<TipoSocDistrDiv> getType() {
		return TipoSocDistrDiv.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TipoSocDistrDiv.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TipoSocDistrDiv)
			return TipoSocDistrDiv.marshall((TipoSocDistrDiv)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TipoSocDistrDiv v) throws Exception {
		return TipoSocDistrDiv.marshall(v);
	}
	

}
