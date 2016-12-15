package mx.emite.sdk.clientes.operaciones.emisores.dpiva10;

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
public class DpIva10Timbrador extends Operacion<TimbrarRequest,TimbrarResponse> {

	public DpIva10Timbrador(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.DPIVA10_TIMBRAR);
	}

	
	
	/**
	 * Método que sella y timbra una declaración de Proveedores de IVA
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
