package mx.emite.sdk;

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
@Deprecated
public class EFAPI {

	
	private final ClienteJson cliente;
	
	private final FacturaEmite facturaemite;
	
	
	
	public EFAPI(final Ambiente ambiente){
		this.cliente=new ClienteJson(ambiente);
		this.facturaemite=new FacturaEmite(this.cliente);
		
	}
	
	public FacturaEmite facturaemite(){
		return facturaemite;
	}

	
}
