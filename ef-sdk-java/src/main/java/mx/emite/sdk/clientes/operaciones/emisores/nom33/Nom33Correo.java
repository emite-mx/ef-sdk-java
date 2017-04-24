package mx.emite.sdk.clientes.operaciones.emisores.nom33;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.CorreoRequest;
import mx.emite.sdk.proxy.response.CorreoResponse;

/**
 *  <h1>Operacion de envio de correos</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Nom33Correo extends Operacion<CorreoRequest,CorreoResponse> {

	public Nom33Correo(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.NOM33_CORREO);
	}

	
	
	/**
	 * Método que envia por correo el XML y PDF previamente timbrado
	 * 
	 * @param request Parametros de envio de correo y de generación de pdf (usuario, contraseña, uuid, correo, parametros)
	 * @return Si recuperarArchivos = true, el xml y pdf codificado en Base 64, de lo contrario no regresa nada
	 * @throws ApiException en caso de que ocurra algun error
	 * @see CorreoRequest
	 */
	@Override
	public CorreoResponse ejecuta(CorreoRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,CorreoResponse.class));
	}
	
}
