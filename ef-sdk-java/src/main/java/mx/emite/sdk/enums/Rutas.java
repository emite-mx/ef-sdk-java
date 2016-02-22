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
	PDFACUSE("/api/cfdi/3.2/acusecancelacion/pdf"),
	PDF("/api/cfdi/3.2/pdf"),
	CORREO("/api/cfdi/3.2/correo"),
	DESCARGA("/api/cfdi/3.2/descarga"),
	
	TOKEN("/api/integrador/token"),
	TIMBRES("/api/integrador/timbres"), 
	EMISORES("/api/integrador/emisores"),
	EMISORESALTA("/api/integrador/emisores/alta"),
	EMISORESCSD("/api/integrador/emisores/csd"),
	EMISORESCSDCONSULTA("/api/integrador/emisores/csd/consulta"),
	EMISORESESTATUS("/api/integrador/emisores/estatus"),
	SUCURSALES("/api/integrador/sucursales"),
	SUCURSALESALTA("/api/integrador/sucursales/alta"),
	
	@Deprecated
	FACTURAEMITE("/api/emite/factura"),   
	;
	
	private final String ruta;
	
	Rutas(final String ruta){
		this.ruta=ruta;
	}
	
	
}
