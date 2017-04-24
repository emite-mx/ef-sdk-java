package mx.emite.sdk.clientes.operaciones.emisores.nom33;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.ConfirmacionRequest;
import mx.emite.sdk.proxy.response.ConfirmacionResponse;

/**
 *  <h1>Servicio de obtención de código de confirmación para CFDI 3.3</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Nom33Confirmacion extends Operacion<ConfirmacionRequest,ConfirmacionResponse> {

	public Nom33Confirmacion(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.NOM33_CONFIRMACION);
	}

	
	
	/**
	 * Método que genera un código de confirmacion cfdi 3.3 
	 * 
	 * @param request Parametros de codigo de confirmacion
	 * @return Objeto con la confirmación para ser utilizada en el CFDI
	 * @throws ApiException en caso de que ocurra algun error
	 * @see ConfirmacionRequest
	 */
	@Override
	public ConfirmacionResponse ejecuta(ConfirmacionRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,ConfirmacionResponse.class));
	}
	
}
