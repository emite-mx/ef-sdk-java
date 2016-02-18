package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoDeComprobante implements Sat {
	
	INGRESO(1,"ingreso"),
	EGRESO(2,"egreso"),
	;
	
	final Integer idSat;
	final String descripcion;
	
	
	TipoDeComprobante(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	public static TipoDeComprobante busca(String metodo) {
		for(TipoDeComprobante m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
		}
		return null;
	}
	
}
