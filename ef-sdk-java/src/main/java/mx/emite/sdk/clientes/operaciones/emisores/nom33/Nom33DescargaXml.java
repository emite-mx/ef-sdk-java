package mx.emite.sdk.clientes.operaciones.emisores.nom33;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.XmlRequest;
import mx.emite.sdk.proxy.response.XmlResponse;

/**
 *  <h1>Operacion de descarga de cfdi version 3.3</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Nom33DescargaXml extends Operacion<XmlRequest,XmlResponse> {

	public Nom33DescargaXml(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.NOM33_XML);
	}

	
	
	/**
	 * Método que descarga un cfdi 3.3
	 * 
	 * @param request Parametros de descarga (usuario, contraseña, uuid)
	 * @return Objeto con el xml codificado en Base 64
	 * @throws ApiException en caso de que ocurra algun error
	 * @see XmlRequest
	 */
	@Override
	public XmlResponse ejecuta(XmlRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,XmlResponse.class));
	}
	
}
