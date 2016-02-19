package mx.emite.sdk.clientes.operaciones.integradores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.scot.request.TokenRequest;
import mx.emite.sdk.scot.response.TokenResponse;

public class Token extends Operacion<TokenRequest,TokenResponse>{

	
	
	public Token(final ClienteJson cliente) {
		super(cliente,Proveedor.SCOT,Rutas.TOKEN);
	}

	@Override
	public TokenResponse ejecuta(TokenRequest request) throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,request,TokenResponse.class));
	}

	
}
