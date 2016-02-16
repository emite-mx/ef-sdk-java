package mx.emite.sdk.clientes.operaciones;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;


public abstract class Operacion {

	@Getter(AccessLevel.PROTECTED)
	private final ClienteJson cliente;
	private final Rutas ruta;
	private final Proveedor proveedor;
	
	public Operacion(@NonNull final ClienteJson cliente,final Proveedor proveedor,final Rutas ruta){
		this.cliente=cliente;
		this.ruta=ruta;		
		this.proveedor=proveedor;
	}
	
		
	protected final String creaRuta(){
		final StringBuilder path = new StringBuilder();
		switch(cliente.getAmbiente()){
		case LOCAL: path.append("http://localhost:8080/").append(proveedor.getServidor()).append(ruta.getRuta());
			break;
		case PRODUCCION: path.append("https://").append(proveedor.getServidor()).append(".emitefacturacion.mx").append(ruta.getRuta());
			break;
		case PRUEBAS: path.append("http://").append(proveedor.getServidor()).append("-qa.emitefacturacion.mx").append(ruta.getRuta());
			break;		
		}
		return path.toString();
	}
	
}
