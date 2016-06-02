package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.EmisoresModificacionRequest;
import mx.emite.sdk.scot.response.EmisoresModificacionResponse;

public class EmisoresModificacion extends Operacion<EmisoresModificacionRequest,EmisoresModificacionResponse>{

	
	
	public EmisoresModificacion(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.EMISORESMODIFICACION);
	}

	@Override
	public EmisoresModificacionResponse ejecuta(EmisoresModificacionRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,EmisoresModificacionResponse.class));
	}

	
}
