package mx.emite.sdk.enums.sat.adaptadores;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposHoras12;

@Slf4j
public class TiposHorasIdSatAdapter extends TiposHorasAdapter{

	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposHoras12)
			return TiposHoras12.marshallIdSat((TiposHoras12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposHoras12 v) throws Exception {
		return TiposHoras12.marshallIdSat(v);
	}
	
}
