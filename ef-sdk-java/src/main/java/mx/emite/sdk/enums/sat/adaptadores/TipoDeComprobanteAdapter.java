package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TipoDeComprobante;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TipoDeComprobanteAdapter extends XmlAdapter<String,TipoDeComprobante> implements TypeHandler{

	@Override
	public TipoDeComprobante unmarshal(String metodo) throws ApiException {
		return TipoDeComprobante.unmarshall(metodo);
	}
	@Override
	public Class<TipoDeComprobante> getType() {
		return TipoDeComprobante.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TipoDeComprobante.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TipoDeComprobante)
			return TipoDeComprobante.marshall((TipoDeComprobante)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TipoDeComprobante v) throws Exception {
		return TipoDeComprobante.marshall(v);
	}
	
	/*@Override
	public TipoDeComprobante unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		return TipoDeComprobante.busca(metodo);
	}
	
	

	@Override
	public Class<?> getType() {
		return TipoDeComprobante.class;
	}
*/
}
