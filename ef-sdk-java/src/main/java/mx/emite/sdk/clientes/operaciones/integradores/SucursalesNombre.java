package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.SucursalesNombreRequest;
import mx.emite.sdk.scot.response.SucursalesNombreResponse;

public class SucursalesNombre extends Operacion<SucursalesNombreRequest,SucursalesNombreResponse>{

	
	
	public SucursalesNombre(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.SUCURSALESNOMBRE);
	}

	@Override
	public SucursalesNombreResponse ejecuta(SucursalesNombreRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,SucursalesNombreResponse.class));
	}

	
}
