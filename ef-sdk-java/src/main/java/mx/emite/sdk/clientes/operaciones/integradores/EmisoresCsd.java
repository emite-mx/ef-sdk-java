package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.EmisoresCsdRequest;
import mx.emite.sdk.scot.response.EmisoresCsdResponse;

public class EmisoresCsd extends Operacion<EmisoresCsdRequest,EmisoresCsdResponse>{

	
	
	public EmisoresCsd(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.EMISORESCSD);
	}

	@Override
	public EmisoresCsdResponse ejecuta(EmisoresCsdRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,EmisoresCsdResponse.class));
	}

	
}
