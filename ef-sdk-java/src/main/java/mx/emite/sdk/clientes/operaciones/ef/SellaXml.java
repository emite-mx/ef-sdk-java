package mx.emite.sdk.clientes.operaciones.ef;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.ef.request.SellaXmlRequest;
import mx.emite.sdk.ef.response.SellaXmlResponse;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;

public class SellaXml extends Operacion<SellaXmlRequest,SellaXmlResponse>{

	
	@Deprecated
	public SellaXml(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.SELLAEMITE);
	}

	@Override
	@Deprecated
	public SellaXmlResponse ejecuta(SellaXmlRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,SellaXmlResponse.class));
	}

	
}
