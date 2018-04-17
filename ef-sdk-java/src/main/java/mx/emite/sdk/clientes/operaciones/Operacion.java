package mx.emite.sdk.clientes.operaciones;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.interfaces.Respuesta;
import mx.emite.sdk.utils.Utilerias;


public abstract class Operacion<ENVIO,RESPUESTA extends Respuesta> {

	@Getter(AccessLevel.PROTECTED)
	private final ClienteJson cliente;
	private final Rutas ruta;
	private final Proveedor proveedor;
	
	public Operacion(@NonNull final ClienteJson cliente,final Proveedor proveedor,final Rutas ruta){
		this.cliente=cliente;
		this.ruta=ruta;		
		this.proveedor=proveedor;
	}
	
		
	@SuppressWarnings("deprecation")
	protected final String creaRuta(ENVIO envio) throws ApiException{
		Utilerias.valida(envio);
		final StringBuilder path = new StringBuilder();
		switch(cliente.getAmbiente()){
		case LOCAL: path.append("http://localhost:8080/").append(proveedor.getServidor()).append(ruta.getRuta());
			break;
		case PRODUCCION: path.append("https://").append(proveedor.getServidor()).append(".emite.mx").append(ruta.getRuta());
			break;
		case PRUEBAS: path.append("http://").append(proveedor.getServidor()).append("-qa.emite.mx").append(ruta.getRuta());
			break;		
		}
		return path.toString();
	}
	
	protected RESPUESTA procesa(RESPUESTA response) throws ApiException{
		try{
		if(response==null||response.getError()==null)	
			throw new ApiException(I_Api_Errores.PROXY_SERVICIO_NODISPONIBLE,"");
		if(!response.getError().getCodigo().equals(I_Api_Errores.OK.getId()))
			throw ApiException.error(I_Api_Errores.getTipo(response.getError().getCodigo()),response.getError().getErrores());
		return response;
		}
		catch(ApiException ae){
			throw ae;
		}
	}
	
	public abstract RESPUESTA ejecuta(ENVIO request) throws ApiException;
	
}
