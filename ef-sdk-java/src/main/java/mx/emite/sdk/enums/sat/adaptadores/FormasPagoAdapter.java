package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.MetodosPago;

public class FormasPagoAdapter extends SatAdapter<String,MetodosPago>{

	@Override
	public MetodosPago unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return MetodosPago.busca(metodo);		
	}

}
