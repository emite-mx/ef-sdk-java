package mx.emite.sdk.enums.sat.adaptadores;

import org.apache.commons.lang3.StringUtils;

import mx.emite.sdk.enums.sat.TipoDeComprobante;

public class TipoDeComprobanteAdapter extends SatAdapter<String,TipoDeComprobante>{

	@Override
	public TipoDeComprobante unmarshal(String metodo) throws Exception {
		if(StringUtils.isEmpty(metodo))
			return null;
		return TipoDeComprobante.busca(metodo);
	}

}
