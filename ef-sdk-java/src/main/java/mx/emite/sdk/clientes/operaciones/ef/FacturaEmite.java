package mx.emite.sdk.clientes.operaciones.ef;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.ef.request.FacturaEmiteRequest;
import mx.emite.sdk.ef.response.FacturaEmiteResponse;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;

public class FacturaEmite extends Operacion<FacturaEmiteRequest,FacturaEmiteResponse>{

	
	@Deprecated
	public FacturaEmite(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.FACTURAEMITE);
	}

	@Override
	@Deprecated
	public FacturaEmiteResponse ejecuta(FacturaEmiteRequest request) throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,request,FacturaEmiteResponse.class));
	}

	
}
