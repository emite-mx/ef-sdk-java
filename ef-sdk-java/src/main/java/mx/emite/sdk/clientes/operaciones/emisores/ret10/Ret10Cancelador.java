package mx.emite.sdk.clientes.operaciones.emisores.ret10;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.CancelarRequest;
import mx.emite.sdk.proxy.response.CancelarResponse;

/**
 *  <h1>Operacion de cancelación de retenciones version 1.0</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Ret10Cancelador extends Operacion<CancelarRequest,CancelarResponse> {

	public Ret10Cancelador(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.RET10_CANCELAR);
	}

	
	
	/**
	 * Método que cancela un comprobante de retenciones 1.0
	 * 
	 * @param request Parametros de cancelación (usuario, contraseña, lista de uuids y pfx en caso de no tenerlo guardado en Scot)
	 * @return Objeto con el xml de acuse de recibo de la cancelación ante el SAT
	 * @throws ApiException en caso de que ocurra algun error
	 * @see CancelarRequest
	 */
	@Override
	public CancelarResponse ejecuta(CancelarRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,CancelarResponse.class));
	}
	
}
