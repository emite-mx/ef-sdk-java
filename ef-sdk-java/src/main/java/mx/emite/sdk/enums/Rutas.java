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
	VALIDADOR32("/api/validador/3.2/validador"),
	TIMBRARNOMINA32("/api/nomina/3.2/timbrar"),
	SELLARYTIMBRARNOMINA32("/api/nomina/3.2/sellarytimbrar"),
	
	TOKEN("/api/integrador/token"),
	TIMBRES("/api/integrador/timbres"), 
	EMISORES("/api/integrador/emisores"),
	EMISORESALTA("/api/integrador/emisores/alta"),
	EMISORESMODIFICACION("/api/integrador/emisores/modificacion"),
	EMISORESCSD("/api/integrador/emisores/csd"),
	EMISORESDOCUMENTOS("/api/integrador/emisores/documentos"),
	EMISORESCSDCONSULTA("/api/integrador/emisores/csd/consulta"),
	EMISORESESTATUS("/api/integrador/emisores/estatus"),
	SUCURSALES("/api/integrador/sucursales"),
	SUCURSALESALTA("/api/integrador/sucursales/alta"),
	SUCURSALESNOMBRE("/api/integrador/sucursales/nombre"),
	SUCURSALESMODIFICACION("/api/integrador/sucursales/modificacion"),
	
	@Deprecated
	FACTURAEMITE("/api/emite/factura"),
	@Deprecated
	CONSUMOTOKEN("/api/emite/consumo/token"),
	@Deprecated
	CONSUME("/api/emite/consumo/consume"), 
	@Deprecated
	CONSUMEEMITE("/api/emite/consumo/emite"),
	@Deprecated
	SELLAEMITE("/api/emite/sella"),
	;
	
	private final String ruta;
	
	Rutas(final String ruta){
		this.ruta=ruta;
	}
	
	
}
