package mx.emite.sdk.clientes.operaciones.ef;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.ef.request.ConsumoEmiteRequest;
import mx.emite.sdk.ef.response.ConsumeResponse;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;

public class ConsumeEmite extends Operacion<ConsumoEmiteRequest,ConsumeResponse>{

	
	@Deprecated
	public ConsumeEmite(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.CONSUMEEMITE);
	}

	@Override
	@Deprecated
	public ConsumeResponse ejecuta(ConsumoEmiteRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,ConsumeResponse.class));
	}

	
}
