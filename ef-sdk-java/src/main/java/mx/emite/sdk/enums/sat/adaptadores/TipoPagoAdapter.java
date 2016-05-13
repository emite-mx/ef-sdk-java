package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TipoPago;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TipoPagoAdapter  extends XmlAdapter<String,TipoPago> implements TypeHandler{

	@Override
	public TipoPago unmarshal(String metodo) throws ApiException {
		return TipoPago.unmarshall(metodo);
	}
	@Override
	public Class<TipoPago> getType() {
		return TipoPago.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TipoPago.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TipoPago)
			return TipoPago.marshall((TipoPago)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TipoPago v) throws Exception {
		return TipoPago.marshall(v);
	}
	/*@Override
	public TipoPago unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		final TipoPago estado =  TipoPago.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de pago "+metodo+" no se encuentra en el catálogo de tipos de pago del SAT");
		else
			return estado;
	}

	@Override
	public Class<?> getType() {
		return TipoPago.class;
	}
*/
}
