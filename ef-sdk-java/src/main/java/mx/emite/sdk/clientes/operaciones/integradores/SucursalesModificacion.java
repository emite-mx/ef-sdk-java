package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.SucursalesModificacionRequest;
import mx.emite.sdk.scot.response.SucursalesModificacionResponse;

public class SucursalesModificacion extends Operacion<SucursalesModificacionRequest,SucursalesModificacionResponse>{

	
	
	public SucursalesModificacion(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.SUCURSALESMODIFICACION);
	}

	@Override
	public SucursalesModificacionResponse ejecuta(SucursalesModificacionRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,SucursalesModificacionResponse.class));
	}

	
}
