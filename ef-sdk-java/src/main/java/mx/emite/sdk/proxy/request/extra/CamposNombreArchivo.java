package mx.emite.sdk.proxy.request.extra;

public enum CamposNombreArchivo {

	NINGUNO(""),
	FECHA("Fecha (AAAAMMDD)"),
	ANO("Año (AAAA)"),
	MES("Mes (MM)"),
	DIA("Día (DD)"),
	RECEPTOR("Receptor (XAXX010101000)"),
	TIPOTIMBRE("Tipo Timbre"),
	UUID("Uuid (Folio Fiscal)"),
	SERIE("Serie"),
	FOLIO("Folio"),
	SUCURSAL("Sucursal");

	private final String descripcion;
	
	private CamposNombreArchivo(final String descripcion) {
		this.descripcion=descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
	
	
}
