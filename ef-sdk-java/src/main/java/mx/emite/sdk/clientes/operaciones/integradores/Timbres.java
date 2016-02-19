package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.TimbresRequest;
import mx.emite.sdk.scot.response.TimbresResponse;

public class Timbres extends Operacion<TimbresRequest,TimbresResponse>{

	
	
	public Timbres(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.TIMBRES);
	}

	@Override
	public TimbresResponse ejecuta(TimbresRequest request) throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,request,TimbresResponse.class));
	}

	
}
