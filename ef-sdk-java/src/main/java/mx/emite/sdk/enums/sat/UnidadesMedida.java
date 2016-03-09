package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum UnidadesMedida implements Sat{
	
	
	BARRIL(15,"BARRIL"),
	BOTELLA(21,"BOTELLA"),
	CABEZA(7,"CABEZA"),
	CAJA(20,"CAJA"),
	CIENTOS(18,"CIENTOS"),
	DECENAS(17,"DECENAS"),
	DOCENAS(19,"DOCENAS"),
	GRAMO(2,"GRAMO"),
	GRAMONETO  (16,"GRAMO NETO"),
	JUEGO(12,"JUEGO"),
	KILO(1,"KILO"),
	KILOWATT(10,"KILOWATT"),
	KILOWATTHORA(13,"KILOWATT/HORA"),
	LITRO(8,"LITRO"),
	METROCUADRADO(4,"METRO CUADRADO"),
	METROCUBICO(5,"METRO CUBICO"),
	METROLINEAL(3,"METRO LINEAL"),
	MILLAR(11,"MILLAR"),
	PAR(9,"PAR"),
	PIEZA(6,"PIEZA"),
	SERVICIO(99,"SERVICIO"),
	TONELADA(14,"TONELADA"),
	;
	
	final Integer idSat;
	final String descripcion;
	
	
	UnidadesMedida(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}
	
	/**
	 * Busca una unidad de medida de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return unidadesMedida valor del enum de acuerdo a la unidad de medida
	 */
	public static UnidadesMedida id(Integer idSat) {
		for(UnidadesMedida m:values()){
			if(m.idSat.equals(idSat))
				return m;
		}
		return null;
	}

	public static UnidadesMedida busca(String metodo) {
		for(UnidadesMedida m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
		}
		return null;
	}

	public static UnidadesMedida[] unidades() {
		 return values();
	}
	
	public Integer getIdUnidadMedida(){
		return idSat;
	}
	
}
