package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum UnidadesAduana implements Sat<String>{
	
	KILO("01","KILO"),
	GRAMO("02","GRAMO"),
	METROLINEAL("03","METRO LINEAL"),
	METROCUADRADO  ("04","METRO CUADRADO"),
	METROCUBICO  ("05","METRO CUBICO"),
	PIEZA("06","PIEZA"),
	CABEZA("07","CABEZA"),
	LITRO("08","LITRO"),
	PAR("09","PAR"),
	KILOWATT("10","KILOWATT"),
	MILLAR("11","MILLAR"),
	JUEGO("12","JUEGO"),
	KILOWATTHORA("13","KILOWATT/HORA"),
	TONELADA("14","TONELADA"),
	BARRIL("15","BARRIL"),
	GRAMONETO("16","GRAMO NETO"),
	DECENAS("17","DECENAS"),
	CIENTOS("18","CIENTOS"),
	DOCENAS("19","DOCENAS"),
	CAJA("20","CAJA"),
	BOTELLA("21","BOTELLA"),
	SERVICIO("99","SERVICIO"),
	;
	
	final String idSat;
	final String descripcion;
	
	
	UnidadesAduana(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	public static UnidadesAduana busca(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		for(UnidadesAduana m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
		}
		return null;
	}
	
	public static UnidadesAduana unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final UnidadesAduana estado =  UnidadesAduana.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La unidadAduana "+metodo+" no se encuentra en el catálogo de Unidades de Medida del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(UnidadesAduana v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat().toString();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static UnidadesAduana getTipoRegimen(String tipoRegimen) {
		if(StringUtils.isEmpty(tipoRegimen))
			return null;
		for(UnidadesAduana m:values()){
			if(m.idSat.equals(tipoRegimen))
				return m;
		}
		return null;
	}

	public static boolean existe(String idSat) {
		if(StringUtils.isEmpty(idSat))
			return false;
		for(UnidadesAduana m:values()){
			if(m.idSat.equals(idSat))
				return true;
		}
		return false;
	}
	
	
}
