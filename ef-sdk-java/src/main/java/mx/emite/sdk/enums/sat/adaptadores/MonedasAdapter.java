package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.Monedas;

public class MonedasAdapter extends SatAdapter<String,Monedas>{

	@Override
	public Monedas unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return Monedas.busca(metodo);		
	}

}
