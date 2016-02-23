package mx.emite.sdk;

import lombok.Getter;
import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.ef.FacturaEmite;
import mx.emite.sdk.enums.Ambiente;


/**
 * @author enrique
 *
 *	Solo para uso interno
 *
 *	
 */

public class EFAPI {

	
	private final ClienteJson cliente;
	
	private final FacturaEmite facturaemite;
	@Getter private String contrasena;
	@Getter private String usuario;
	
	@Deprecated
	public EFAPI(final Ambiente ambiente,final String usuario,final String contrasena){
		this.cliente=new ClienteJson(ambiente);
		this.facturaemite=new FacturaEmite(this.cliente);
		this.usuario=usuario;
		this.contrasena=contrasena;
		
	}
	
	public FacturaEmite facturaemite(){
		return facturaemite;
	}

	
}
