package mx.emite.sdk.enums;

import lombok.Getter;

@Getter
public enum Proveedor {

	PROXY("proxy"),
	SCOT("scot"),
	ENVIOCFDI("enviocfdi"),
	EMITEETL("timbradoapi")
	;
	
	final String servidor;
	
	Proveedor(final String servidor){
		this.servidor=servidor;
	}
}
