package mx.emite.sdk.clientes.operaciones.emisores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.ValidadorRequest;
import mx.emite.sdk.proxy.response.ValidadorResponse;

/**
 *  <h1>Operacion de validación de cfdi version 3.2</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Validador32 extends Operacion<ValidadorRequest,ValidadorResponse> {

	public Validador32(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.VALIDADOR32);
	}

	
	
	/**
	 * Método que valida un comprobante cfdi 3.2 en Base64
	 * 
	 * @param request Parametros de uso de timbrado (usuario, contraseña y xml sellado en base 64)
	 * @return Objeto con el xml timbrado en Base64
	 * @throws ApiException en caso de que ocurra algun error
	 * @see ValidadorRequest
	 */
	@Override
	public ValidadorResponse ejecuta(ValidadorRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,ValidadorResponse.class));
	}
	
}
