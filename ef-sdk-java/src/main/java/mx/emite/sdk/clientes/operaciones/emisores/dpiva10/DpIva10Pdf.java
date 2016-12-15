package mx.emite.sdk.clientes.operaciones.emisores.dpiva10;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.PdfRequest;
import mx.emite.sdk.proxy.request.XmlRequest;
import mx.emite.sdk.proxy.response.PdfResponse;

/**
 *  <h1>Operacion de descarga de cfdi version 3.2</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class DpIva10Pdf extends Operacion<PdfRequest,PdfResponse> {

	public DpIva10Pdf(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.DPIVA10_PDF);
	}

	
	
	/**
	 * Método que descarga una Declaración de Proveedores de IVA 1.0 
	 * 
	 * @param request Parametros de descarga (usuario, contraseña, uuid)
	 * @return Objeto con el xml codificado en Base 64
	 * @throws ApiException en caso de que ocurra algun error
	 * @see XmlRequest
	 */
	@Override
	public PdfResponse ejecuta(PdfRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,PdfResponse.class));
	}
	
}
