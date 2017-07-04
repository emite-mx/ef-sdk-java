package mx.emite.sdk.clientes.operaciones.emisores.valida33;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.ValidadorRequest;
import mx.emite.sdk.proxy.response.ValidadorResponse;

/**
 *  <h1>Operacion de validación de cfdi version 3.3</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Valida33Validador extends Operacion<ValidadorRequest,ValidadorResponse> {

	public Valida33Validador(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.VALIDA33_VALIDADOR33);
	}

	
	
	/**
	 * Método que valida un comprobante cfdi 3.3 en Base64
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
