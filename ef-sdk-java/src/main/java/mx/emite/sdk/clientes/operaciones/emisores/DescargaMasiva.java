package mx.emite.sdk.clientes.operaciones.emisores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.ZipRequest;
import mx.emite.sdk.proxy.response.ZipResponse;

/**
 *  <h1>Operacion de descarga masiva de XML y PDF</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class DescargaMasiva extends Operacion<ZipRequest,ZipResponse> {

	public DescargaMasiva(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.DESCARGA);
	}

	
	
	/**
	 * Método que genera un archivo zip de acuerdo a un filtro
	 * 
	 * @param request Parametros de descarga (usuario, contraseña, filtro)
	 * @return Objeto con el url del zip
	 * @throws ApiException en caso de que ocurra algun error
	 * @see ZipRequest
	 */
	@Override
	public ZipResponse ejecuta(ZipRequest request) throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,request,ZipResponse.class));
	}
	
}
