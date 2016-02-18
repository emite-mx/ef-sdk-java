package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.UnidadesMedida;

public class UnidadesMedidaAdapter extends SatAdapter<String,UnidadesMedida>{

	@Override
	public UnidadesMedida unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return UnidadesMedida.busca(metodo);		
	}

}
