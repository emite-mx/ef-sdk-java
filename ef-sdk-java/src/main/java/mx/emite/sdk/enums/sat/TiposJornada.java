package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposJornada implements Sat{
	
	DIURNA("01","Diurna"),
	NOCTURNA("02","Nocturna"),
	MIXTA("03","Mixta"),
	POR_HORA("04","Por Hora",new String[]{"Por_hora"}),
	REDUCIDA("05","Reducida"),
	CONTINUADA("06","Continuada"),
	PARTIDA("07","Partida"),
	POR_TURNOS("08","Por Turnos", new String[]{"Por_turnos"}),
	OTRAJORNADA("99","OtraJornada"),
	
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposJornada(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposJornada(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposJornada busca(String metodo) {
		for(TiposJornada m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(m.sinonimos!=null){
				for(String s:m.sinonimos){
					if(Utilerias.compara(s,metodo))
						return m;
				}
			}
		}
		return null;
	}
	
	public static TiposJornada unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposJornada estado =  TiposJornada.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de jornada "+metodo+" no se encuentra en el catálogo de Tipos de Jornadas del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposJornada v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	
}
