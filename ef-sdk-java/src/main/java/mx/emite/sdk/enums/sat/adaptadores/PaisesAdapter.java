package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.Paises;

public class PaisesAdapter extends SatAdapter<String,Paises>{

	@Override
	public Paises unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return Paises.busca(metodo);		
	}

}
