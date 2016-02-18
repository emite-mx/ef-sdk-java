package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum UnidadesMedida implements Sat{
	
	KILO(1,"KILO"),
	GRAMO(2,"GRAMO"),
	METROLINEAL(3,"METRO LINEAL"),
	METROCUADRADO  (4,"METRO CUADRADO"),
	METROCUBICO  (5,"METRO CUBICO"),
	PIEZA(6,"PIEZA"),
	CABEZA(7,"CABEZA"),
	LITRO(8,"LITRO"),
	PAR(9,"PAR"),
	KILOWATT(10,"KILOWATT"),
	MILLAR(11,"MILLAR"),
	JUEGO(12,"JUEGO"),
	KILOWATTHORA(13,"KILOWATT/HORA"),
	TONELADA(14,"TONELADA"),
	BARRIL(15,"BARRIL"),
	GRAMONETO(16,"GRAMO NETO"),
	DECENAS(17,"DECENAS"),
	CIENTOS(18,"CIENTOS"),
	DOCENAS(19,"DOCENAS"),
	CAJA(20,"CAJA"),
	BOTELLA(21,"BOTELLA"),
	SERVICIO(99,"SERVICIO"),
	;
	
	final Integer idSat;
	final String descripcion;
	
	
	UnidadesMedida(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	public static UnidadesMedida busca(String metodo) {
		for(UnidadesMedida m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
		}
		return null;
	}
	
}
