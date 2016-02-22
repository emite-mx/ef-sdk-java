package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.SucursalesAltaRequest;
import mx.emite.sdk.scot.response.SucursalesAltaResponse;

public class SucursalesAlta extends Operacion<SucursalesAltaRequest,SucursalesAltaResponse>{

	
	
	public SucursalesAlta(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.SUCURSALESALTA);
	}

	@Override
	public SucursalesAltaResponse ejecuta(SucursalesAltaRequest request) throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,request,SucursalesAltaResponse.class));
	}

	
}
