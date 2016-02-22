package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.EmisoresEstatusRequest;
import mx.emite.sdk.scot.response.EmisoresEstatusResponse;

public class EmisoresEstatus extends Operacion<EmisoresEstatusRequest,EmisoresEstatusResponse>{

	
	
	public EmisoresEstatus(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.EMISORESESTATUS);
	}

	@Override
	public EmisoresEstatusResponse ejecuta(EmisoresEstatusRequest request) throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,request,EmisoresEstatusResponse.class));
	}

	
}
