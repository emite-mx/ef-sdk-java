package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TipoDividendosOUtilidadDistribuida;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TipoDividendosOUtilidadDistribuidaAdapter extends XmlAdapter<String,TipoDividendosOUtilidadDistribuida> implements TypeHandler{

	@Override
	public TipoDividendosOUtilidadDistribuida unmarshal(String metodo) throws ApiException {
		return TipoDividendosOUtilidadDistribuida.unmarshall(metodo);
	}
	@Override
	public Class<TipoDividendosOUtilidadDistribuida> getType() {
		return TipoDividendosOUtilidadDistribuida.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TipoDividendosOUtilidadDistribuida.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TipoDividendosOUtilidadDistribuida)
			return TipoDividendosOUtilidadDistribuida.marshall((TipoDividendosOUtilidadDistribuida)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TipoDividendosOUtilidadDistribuida v) throws Exception {
		return TipoDividendosOUtilidadDistribuida.marshall(v);
	}
	
	
}
