package mx.emite.sdk.clientes.operaciones.emisores;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.response.ServiciosResponse;

public class Servicios extends Operacion<ServiciosResponse,ServiciosResponse>{

	
	
	public Servicios(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.SERVICIOS);
	}

	public ServiciosResponse ejecuta() throws ApiException{
		final String ruta = creaRuta();
		return procesa(this.getCliente().post(ruta,null,ServiciosResponse.class));
	}

	
	/* 
	 * @deprecated Se debe utilizar el metodo ejecuta sin parametros
	 */
	@Override
	@Deprecated
	public ServiciosResponse ejecuta(ServiciosResponse request) throws ApiException {
		return null;
	}
	
}
