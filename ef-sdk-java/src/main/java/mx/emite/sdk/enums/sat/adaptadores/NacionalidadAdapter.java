package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.Nacionalidad;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class NacionalidadAdapter extends XmlAdapter<String,Nacionalidad> implements TypeHandler{

	@Override
	public Nacionalidad unmarshal(String metodo) throws ApiException {
		return Nacionalidad.unmarshall(metodo);
	}
	@Override
	public Class<Nacionalidad> getType() {
		return Nacionalidad.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return Nacionalidad.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof Nacionalidad)
			return Nacionalidad.marshall((Nacionalidad)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(Nacionalidad v) throws Exception {
		return Nacionalidad.marshall(v);
	}
	
	/*@Override
	public UnidadesMedida unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		final UnidadesMedida um = UnidadesMedida.busca(metodo);
		if(um==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La unidad "+metodo+" no se encuentra en el catálogo de unidades de medida del SAT");
		else
			return um;
	}

	@Override
	public Class<?> getType() {
		return UnidadesMedida.class;
	}
*/
}
