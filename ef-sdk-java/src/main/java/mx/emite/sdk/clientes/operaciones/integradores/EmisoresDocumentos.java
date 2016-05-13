package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.EmisoresDocumentosRequest;
import mx.emite.sdk.scot.response.EmisoresDocumentosResponse;

public class EmisoresDocumentos extends Operacion<EmisoresDocumentosRequest,EmisoresDocumentosResponse>{

	
	
	public EmisoresDocumentos(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.EMISORESDOCUMENTOS);
	}

	@Override
	public EmisoresDocumentosResponse ejecuta(EmisoresDocumentosRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,EmisoresDocumentosResponse.class));
	}

	
}
