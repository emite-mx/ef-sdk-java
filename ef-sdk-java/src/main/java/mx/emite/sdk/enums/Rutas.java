package mx.emite.sdk.enums;

import lombok.Getter;

@Getter
public enum Rutas {

	SERVICIOS("/api/catalogos/servicios"),
	TIMBRAR32("/api/cfdi/3.2/timbrar"),
	SELLARYTIMBRAR32("/api/cfdi/3.2/sellarytimbrar"),
	CANCELAR32("/api/cfdi/3.2/cancelar"),
	
	;
	
	private final String ruta;
	
	Rutas(final String ruta){
		this.ruta=ruta;
	}
	
	
}
