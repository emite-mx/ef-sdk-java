package mx.emite.sdk.enums.sat.adaptadores;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposRiesgo;

@Slf4j
public class TiposRiesgoIdSatAdapter extends TiposRiesgoAdapter{

	

	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposRiesgo)
			return TiposRiesgo.marshallIdSat((TiposRiesgo)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposRiesgo v) throws Exception {
		return TiposRiesgo.marshallIdSat(v);
	}
	
}
