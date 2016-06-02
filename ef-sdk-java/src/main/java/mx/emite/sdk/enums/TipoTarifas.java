package mx.emite.sdk.enums;

import lombok.Getter;

@Getter
public enum TipoTarifas {
	FIJA('F',"Fija"),
	RANGOS('R',"Rangos"),
	MENSUAL('M',"Mensualidad"),
	;
	
	private Character id;
	private String titulo;
	
	TipoTarifas(Character val,String titulo){
		this.id=val;
		this.titulo=titulo;
		
	}
	public static TipoTarifas getTipo(Character estatus) {
		for(TipoTarifas e:values()){
			if(e.id.equals(estatus))
				return e;
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		return titulo;
	}
	
	
	public boolean compara(String compara) {
		return id==null?false:compara==null?false:id.equals(compara.charAt(0));
	}
	
	
}