package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.Estados;

public class EstadosAdapter extends SatAdapter<String,Estados>{

	@Override
	public Estados unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return Estados.busca(metodo);		
	}

}
