package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.EmisoresRequest;
import mx.emite.sdk.scot.response.EmisoresResponse;

public class Emisores extends Operacion<EmisoresRequest,EmisoresResponse>{

	
	
	public Emisores(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.EMISORES);
	}

	@Override
	public EmisoresResponse ejecuta(EmisoresRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,EmisoresResponse.class));
	}

	
}
