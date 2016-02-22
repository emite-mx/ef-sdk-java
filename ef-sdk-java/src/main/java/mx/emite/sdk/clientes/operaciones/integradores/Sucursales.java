package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.SucursalesRequest;
import mx.emite.sdk.scot.response.SucursalesResponse;

public class Sucursales extends Operacion<SucursalesRequest,SucursalesResponse>{

	
	
	public Sucursales(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.SUCURSALES);
	}

	@Override
	public SucursalesResponse ejecuta(SucursalesRequest request) throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,request,SucursalesResponse.class));
	}

	
}
