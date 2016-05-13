package mx.emite.sdk.enums;

import lombok.Getter;

@Getter
public enum Rutas {

	SERVICIOS("/api/catalogos/servicios"),
	CFDI32_TIMBRAR("/api/cfdi/3.2/timbrar"),
	CFDI32_SELLARYTIMBRAR("/api/cfdi/3.2/sellarytimbrar"),
	CFDI32_CANCELAR("/api/cfdi/3.2/cancelar"),
	CFDI32_XML("/api/cfdi/3.2/xml"),
	CFDI32_ACUSE("/api/cfdi/3.2/acusecancelacion/xml"),
	CFDI32_PDFACUSE("/api/cfdi/3.2/acusecancelacion/pdf"),
	CFDI32_PDF("/api/cfdi/3.2/pdf"),
	CFDI32_CORREO("/api/cfdi/3.2/correo"),
	CFDI32_DESCARGA("/api/cfdi/3.2/descarga"),
	CFDI32_SELLARYTIMBRARGENERICOXML("/api/cfdi/3.2/generico/xml/emite"),
	CFDI32_SELLARYTIMBRARGENERICOTXT("/api/cfdi/3.2/generico/txt/emite"),
	VALIDA32_VALIDADOR32("/api/validador/3.2/validador"),
	NOM32_TIMBRAR("/api/nomina/3.2/timbrar"),
	NOM32_SELLARYTIMBRAR("/api/nomina/3.2/sellarytimbrar"),
	NOM32_CANCELAR("/api/nomina/3.2/cancelar"),
	NOM32_CORREO("/api/nomina/3.2/correo"),
	NOM32_SELLARYTIMBRARGENERICOXML("/api/nomina/3.2/generico/xml/emite"),
	NOM32_SELLARYTIMBRARGENERICOTXT("/api/nomina/3.2/generico/txt/emite"),
	NOM32_PDFACUSE("/api/nomina/3.2/acusecancelacion/pdf"),
	NOM32_PDF("/api/nomina/3.2/pdf"),
	NOM32_XML("/api/nomina/3.2/xml"),
	NOM32_ACUSE("/api/nomina/3.2/acusecancelacion/xml"),
	
	
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
