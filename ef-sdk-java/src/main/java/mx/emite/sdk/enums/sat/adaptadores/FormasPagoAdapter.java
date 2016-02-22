package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.FormasPago;

public class FormasPagoAdapter extends SatAdapter<String,FormasPago>{

	@Override
	public FormasPago unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return FormasPago.busca(metodo);		
	}

}
