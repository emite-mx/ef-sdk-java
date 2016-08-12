package mx.emite.sdk;

import lombok.Getter;
import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.ef.CancelaEmite;
import mx.emite.sdk.clientes.operaciones.ef.CancelaRetEmite;
import mx.emite.sdk.clientes.operaciones.ef.Consume;
import mx.emite.sdk.clientes.operaciones.ef.ConsumeEmite;
import mx.emite.sdk.clientes.operaciones.ef.ConsumoToken;
import mx.emite.sdk.clientes.operaciones.ef.FacturaEmite;
import mx.emite.sdk.clientes.operaciones.ef.SellaXml;
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
	private final ConsumoToken consumotoken;
	private final Consume consume;
	private final ConsumeEmite consumeemite;
	private final SellaXml sellaxml;
	private final CancelaEmite cancelaemite;
	private final CancelaRetEmite cancelaretemite;
	
	@Getter private String contrasena;
	@Getter private String usuario;
	
	@Deprecated
	public EFAPI(final Ambiente ambiente){
		this(ambiente,null,null);
	}
	
	@Deprecated
	public EFAPI(final Ambiente ambiente,final String usuario,final String contrasena){
		this.cliente=new ClienteJson(ambiente);
		this.facturaemite=new FacturaEmite(this.cliente);
		this.consumotoken=new ConsumoToken(this.cliente);
		this.consume=new Consume(this.cliente);
		this.consumeemite=new ConsumeEmite(this.cliente);
		this.sellaxml=new SellaXml(this.cliente);
		this.cancelaemite=new CancelaEmite(this.cliente);
		this.cancelaretemite=new CancelaRetEmite(this.cliente);
		this.usuario=usuario;
		this.contrasena=contrasena;
		
	}
	
	public FacturaEmite facturaemite(){
		return facturaemite;
	}

	public ConsumoToken consumotoken(){
		return consumotoken;
	}
	
	public ConsumeEmite consumeemite(){
		return consumeemite;
	}
	
	public SellaXml sellaxml(){
		return sellaxml;
	}
	
	public Consume consume(){
		return consume;
	}
	
	public CancelaEmite cancela(){
		return cancelaemite;
	}
	
	public CancelaRetEmite cancelaret(){
		return cancelaretemite;
	}
	
}
