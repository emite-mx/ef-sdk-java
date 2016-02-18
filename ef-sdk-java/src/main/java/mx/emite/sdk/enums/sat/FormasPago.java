package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum FormasPago implements Sat{
	
	PAGOENUNASOLAEXHIBICION(1,"pago en una sola exhibición"),
	PAGOENPARCIALIDADES(2,"pago en parcialidades"),
	;
	
	final Integer idSat;
	final String descripcion;
	
	
	FormasPago(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	public static FormasPago busca(String metodo) {
		for(FormasPago m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
		}
		return null;
	}
	
}
