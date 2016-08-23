package mx.emite.sdk.clientes.operaciones.ef;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.ef.request.CancelarEmiteRequest;
import mx.emite.sdk.ef.response.CancelarEmiteResponse;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;

public class CancelaRetUnicaEmite extends Operacion<CancelarEmiteRequest,CancelarEmiteResponse>{

	
	@Deprecated
	public CancelaRetUnicaEmite(final ClienteJson cliente) {
		super(cliente,Proveedor.ENVIOCFDI,Rutas.CANCELARETUNICAEMITE);
	}

	@Override
	@Deprecated
	public CancelarEmiteResponse ejecuta(CancelarEmiteRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,CancelarEmiteResponse.class));
	}

	
}
