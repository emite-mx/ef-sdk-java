package mx.emite.sdk.clientes.operaciones.emisores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.EstatusRequest;
import mx.emite.sdk.proxy.request.ZipRequest;
import mx.emite.sdk.scot.response.EmisoresEstatusResponse;

/**
 *  <h1>Operacion de consulta de estatus de emisores</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Estatus extends Operacion<EstatusRequest,EmisoresEstatusResponse> {

	public Estatus(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.EMISORES_ESTATUS);
	}

	
	
	/**
	 * Método que consulta el estatus de un emisor
	 * 
	 * @param request Parametros de consulta (usuario, contraseña, filtro)
	 * @return Objeto con la información del estatus
	 * @throws ApiException en caso de que ocurra algun error
	 * @see ZipRequest
	 */
	@Override
	public EmisoresEstatusResponse ejecuta(EstatusRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,EmisoresEstatusResponse.class));
	}
	
}
