package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.TiposImpuesto;

public class TiposImpuestoAdapter extends SatAdapter<String,TiposImpuesto>{

	@Override
	public TiposImpuesto unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return TiposImpuesto.busca(metodo);		
	}

}
