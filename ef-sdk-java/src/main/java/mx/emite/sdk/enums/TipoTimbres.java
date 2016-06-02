package mx.emite.sdk.enums;

public enum TipoTimbres {
	TODOS,
	CFDI,
	NOMINA,
	RETENCIONES,
	PSRDD,
	CONTABILIDAD,
	;
	
	public static TipoTimbres[] consultables(){
		final TipoTimbres[] res = new TipoTimbres[values().length-1];
		for(int x=1;x<values().length;x++)
			res[x-1]=values()[x];
		return res;
	}
	
	
	
	
}