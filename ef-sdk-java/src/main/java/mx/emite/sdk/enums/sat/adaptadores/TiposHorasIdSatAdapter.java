package mx.emite.sdk.enums.sat.adaptadores;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposHoras;

@Slf4j
public class TiposHorasIdSatAdapter extends TiposHorasAdapter{

	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposHoras)
			return TiposHoras.marshallIdSat((TiposHoras)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposHoras v) throws Exception {
		return TiposHoras.marshallIdSat(v);
	}
	
}
