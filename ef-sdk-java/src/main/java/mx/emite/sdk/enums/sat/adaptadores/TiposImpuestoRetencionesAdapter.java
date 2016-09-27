package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TipoImpuestoRetenciones;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposImpuestoRetencionesAdapter extends XmlAdapter<String,TipoImpuestoRetenciones> implements TypeHandler{

	@Override
	public TipoImpuestoRetenciones unmarshal(String metodo) throws ApiException {
		return TipoImpuestoRetenciones.unmarshall(metodo);
	}
	@Override
	public Class<TipoImpuestoRetenciones> getType() {
		return TipoImpuestoRetenciones.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TipoImpuestoRetenciones.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TipoImpuestoRetenciones)
			return TipoImpuestoRetenciones.marshall((TipoImpuestoRetenciones)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TipoImpuestoRetenciones v) throws Exception {
		return TipoImpuestoRetenciones.marshall(v);
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
