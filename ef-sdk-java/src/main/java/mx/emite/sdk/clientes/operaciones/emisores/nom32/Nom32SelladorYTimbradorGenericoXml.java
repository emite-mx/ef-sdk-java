package mx.emite.sdk.clientes.operaciones.emisores.nom32;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.SellarYTimbrarRequest;
import mx.emite.sdk.proxy.response.SellarYTimbrarResponse;

/**
 *  <h1>Operacion de timbrado de xml generico sellado en version 3.2</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Nom32SelladorYTimbradorGenericoXml extends Operacion<SellarYTimbrarRequest,SellarYTimbrarResponse> {

	public Nom32SelladorYTimbradorGenericoXml(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.NOM32_SELLARYTIMBRARGENERICOXML);
	}

	
	
	/**
	 * Método que sella y timbra un comprobante generico a cfdi 3.2 
	 * 
	 * @param request Parametros de uso de sellado y timbrado (usuario, contraseña y xml generico en base 64)
	 * @return Objeto con el xml sellado y timbrado en Base64
	 * @throws ApiException en caso de que ocurra algun error
	 * @see SellarYTimbrarRequest
	 */
	@Override
	public SellarYTimbrarResponse ejecuta(SellarYTimbrarRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,SellarYTimbrarResponse.class));
	}
	
}
