package mx.emite.sdk.clientes.operaciones;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.response.ServiciosResponse;

public class Servicios extends Operacion{

	
	
	public Servicios(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.SERVICIOS);
	}

	public ServiciosResponse servicios() throws ApiException{
		final String ruta = creaRuta();
		return this.getCliente().post(ruta,null,ServiciosResponse.class);
	}
	
}
