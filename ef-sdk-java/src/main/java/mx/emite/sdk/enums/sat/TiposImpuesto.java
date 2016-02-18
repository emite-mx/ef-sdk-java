package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposImpuesto implements Sat{
	
	ISR(1,"ISR"),
	IVA(2,"IVA"),
	IEPS(3,"IEPS"),
	OTROS(999,"OTROS"),
	;
	
	final Integer idSat;
	final String descripcion;
	
	
	TiposImpuesto(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	public static TiposImpuesto busca(String metodo) {
		for(TiposImpuesto m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
		}
		return null;
	}
	
}
