package mx.emite.sdk.enums;

import lombok.Getter;

@Getter
public enum Rutas {

	SERVICIOS("/api/catalogos/servicios"),
	TIMBRAR32("/api/cfdi/3.2/timbrar"),
	SELLARYTIMBRAR32("/api/cfdi/3.2/sellarytimbrar"),
	CANCELAR32("/api/cfdi/3.2/cancelar"),
	XML("/api/cfdi/3.2/xml"),
	ACUSE("/api/cfdi/3.2/acusecancelacion/xml"),
	PDF("/api/cfdi/3.2/pdf"),
	
	;
	
	private final String ruta;
	
	Rutas(final String ruta){
		this.ruta=ruta;
	}
	
	
}
