package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoPago implements Sat{
	
	PAGOENUNASOLAEXHIBICION(1,"pago en una sola exhibición"),
	PAGOENPARCIALIDADES(2,"pago en parcialidades"),
	;
	
	final Integer idSat;
	final String descripcion;
	
	
	TipoPago(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	/**
	 * Busca una forma de pago de acuerdo a su descripcion
	 * @param descripcion pago en una sola exhibición o pago en parcialidades
	 * @return FormasPago valor del enum de acuerdo a la descripcion
	 */
	public static TipoPago busca(String descripcion) {
		for(TipoPago m:values()){
			if(Utilerias.compara(m.descripcion,descripcion))
				return m;
		}
		return null;
	}

	/**
	 * Busca una forma de pago de acuerdo a su id
	 * @param idTipoPago 1 o 2
	 * @return FormasPago valor del enum de acuerdo al id
	 */
	public static TipoPago id(Integer idTipoPago) {
		for(TipoPago m:values()){
			if(m.idSat.equals(idTipoPago))
				return m;
		}
		return null;
	}
	
}
