package mx.emite.sdk.clientes.operaciones.ef;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.ef.request.TokenConsumoRequest;
import mx.emite.sdk.ef.response.TokenConsumoResponse;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;

public class ConsumoToken extends Operacion<TokenConsumoRequest,TokenConsumoResponse>{

	
	@Deprecated
	public ConsumoToken(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.CONSUMOTOKEN);
	}

	@Override
	@Deprecated
	public TokenConsumoResponse ejecuta(TokenConsumoRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,TokenConsumoResponse.class));
	}

	
}
