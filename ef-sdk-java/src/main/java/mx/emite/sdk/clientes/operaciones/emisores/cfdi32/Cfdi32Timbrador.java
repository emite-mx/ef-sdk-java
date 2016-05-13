package mx.emite.sdk.clientes.operaciones.emisores.cfdi32;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.TimbrarRequest;
import mx.emite.sdk.proxy.response.TimbrarResponse;

/**
 *  <h1>Operacion de timbrado de cfdi sellado en version 3.2</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Cfdi32Timbrador extends Operacion<TimbrarRequest,TimbrarResponse> {

	public Cfdi32Timbrador(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.CFDI32_TIMBRAR);
	}

	
	
	/**
	 * Método que sella y timbra un comprobante cfdi 3.2 sellado en Base64
	 * 
	 * @param request Parametros de uso de timbrado (usuario, contraseña y xml sellado en base 64)
	 * @return Objeto con el xml timbrado en Base64
	 * @throws ApiException en caso de que ocurra algun error
	 * @see TimbrarRequest
	 */
	@Override
	public TimbrarResponse ejecuta(TimbrarRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,TimbrarResponse.class));
	}
	
}
