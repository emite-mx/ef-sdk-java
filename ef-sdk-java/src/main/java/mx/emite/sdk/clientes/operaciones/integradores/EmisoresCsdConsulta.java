package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.EmisoresCsdConsultaRequest;
import mx.emite.sdk.scot.response.EmisoresCsdConsultaResponse;

public class EmisoresCsdConsulta extends Operacion<EmisoresCsdConsultaRequest,EmisoresCsdConsultaResponse>{

	
	
	public EmisoresCsdConsulta(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.EMISORESCSDCONSULTA);
	}

	@Override 
	public EmisoresCsdConsultaResponse ejecuta(EmisoresCsdConsultaRequest request) throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,request,EmisoresCsdConsultaResponse.class));
	}

	
}
