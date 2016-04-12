package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.TipoPago;

public class TipoPagoAdapter extends SatAdapter<String,TipoPago>{

	@Override
	public TipoPago unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return TipoPago.busca(metodo);		
	}

}
