package mx.emite.sdk.enums;

import lombok.Getter;

@Getter
public enum TipoIntegradorEmisor{
	PREPAGO('P',"Prepago"),
	POSTPAGO('O',"Postpago"),
	POSTPAGO_SUCURSALES('S',"Postpago con Sucursales"),
	
	;
	
	private Character id;
	private String titulo;
	
	TipoIntegradorEmisor(Character val,String titulo){
		this.id=val;
		this.titulo=titulo;
		
	}
	public static TipoIntegradorEmisor getTipo(Character estatus) {
		for(TipoIntegradorEmisor e:values()){
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