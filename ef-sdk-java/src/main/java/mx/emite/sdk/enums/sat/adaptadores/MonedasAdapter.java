package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.Monedas;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class MonedasAdapter extends XmlAdapter<String,Monedas> implements TypeHandler{

	@Override
	public Monedas unmarshal(String metodo) throws ApiException {
		return Monedas.unmarshall(metodo);
	}
	@Override
	public Class<Monedas> getType() {
		return Monedas.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return Monedas.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof Monedas)
			return Monedas.marshall((Monedas)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(Monedas v) throws Exception {
		return Monedas.marshall(v);
	}
	
	/*@Override
	public Monedas unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		final Monedas moneda = Monedas.busca(metodo);
		if(moneda==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La moneda del comprobante "+metodo+" no se encuentra en el catálogo de monedas SAT (ISO 4217)");
		else
			return moneda;
	}
	
	

	@Override
	public Class<?> getType() {
		return Monedas.class;
	}*/
}
