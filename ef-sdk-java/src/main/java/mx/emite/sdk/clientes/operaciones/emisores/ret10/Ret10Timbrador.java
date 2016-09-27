package mx.emite.sdk.clientes.operaciones.emisores.ret10;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.SellarYTimbrarRequest;
import mx.emite.sdk.proxy.request.TimbrarRequest;
import mx.emite.sdk.proxy.response.TimbrarResponse;

/**
 *  <h1>Operacion de timbrado de retenciones sellado en version 1.0</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Ret10Timbrador extends Operacion<TimbrarRequest,TimbrarResponse> {

	public Ret10Timbrador(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.RET10_TIMBRAR);
	}

	
	
	/**
	 * Método que sella y timbra un comprobante cfdi 3.2 sellado en Base64
	 * 
	 * @param request Parametros de uso de sellado y timbrado (usuario, contraseña y xml en base 64)
	 * @return Objeto con el xml sellado y timbrado en Base64
	 * @throws ApiException en caso de que ocurra algun error
	 * @see SellarYTimbrarRequest
	 */
	@Override
	public TimbrarResponse ejecuta(TimbrarRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,TimbrarResponse.class));
	}
	
}
