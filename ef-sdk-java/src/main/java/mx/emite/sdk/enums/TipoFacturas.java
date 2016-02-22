package mx.emite.sdk.enums;

public enum TipoFacturas {
	CORTEMENSUAL('C',"tipofactura.cortemensual"),
	INSCRIPCION('I',"tipofactura.inscripcion"),
	ANUALIDAD('A',"tipofactura.anualidad"),
	;
	
	private Character id;
	private String titulo;
	
	TipoFacturas(Character val,String titulo){
		this.id=val;
		this.titulo=titulo;
		
	}
	public static TipoFacturas getTipo(Character estatus) {
		for(TipoFacturas e:values()){
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
	
	
	
	
}