package mx.emite.sdk.enums.sat.adaptadores;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposJornada;

@Slf4j
public class TiposJornadaIdSatAdapter extends TiposJornadaAdapter{

	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposJornada)
			return TiposJornada.marshallIdSat((TiposJornada)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposJornada v) throws Exception {
		return TiposJornada.marshallIdSat(v);
	}
	
}
