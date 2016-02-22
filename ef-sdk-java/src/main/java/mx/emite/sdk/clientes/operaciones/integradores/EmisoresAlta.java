package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.EmisoresAltaRequest;
import mx.emite.sdk.scot.response.EmisoresAltaResponse;

public class EmisoresAlta extends Operacion<EmisoresAltaRequest,EmisoresAltaResponse>{

	
	
	public EmisoresAlta(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.EMISORESALTA);
	}

	@Override
	public EmisoresAltaResponse ejecuta(EmisoresAltaRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,EmisoresAltaResponse.class));
	}

	
}
