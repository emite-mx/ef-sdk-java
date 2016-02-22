package mx.emite.sdk.enums;

public enum TipoCobros {
	INTEGRADOR('I',"tipocobro.integrador"),
	EMISOR('E',"tipocobro.emisor"),
	EMITE('S',"tipocobro.emite"),
	
	;
	
	private Character id;
	private String titulo;
	
	TipoCobros(Character val,String titulo){
		this.id=val;
		this.titulo=titulo;
		
	}
	public static TipoCobros getTipo(Character estatus) {
		for(TipoCobros e:values()){
			if(e.id.equals(estatus))
				return e;
		}
		return null;
	}
	
	
	public Character getId() {
		return id;
	}

	
	public String getDescripcion() {
		return titulo;
	}
	@Override
	public String toString() {
		return titulo;
	}
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	public boolean compara(String compara) {
		return id==null?false:compara==null?false:id.equals(compara.charAt(0));
	}
	
	public boolean seCobra() {
		switch(this){
		case EMISOR:
		case INTEGRADOR: return true;
		case EMITE: return false;
		}
		return false;
	}
	
	
	
}