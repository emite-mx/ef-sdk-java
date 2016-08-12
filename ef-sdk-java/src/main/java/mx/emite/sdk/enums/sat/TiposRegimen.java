package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposRegimen implements Sat<Integer>{
	
	SUELDOS(2,"Sueldos"),
	JUBILADOS(3,"Jubilados"),
	PENSIONADOS(4,"Pensionados"),
	ASIMILADOS_MIEMBROS_SOCIEDADES_COOPERATIVAS_PRODUCCION(5,"Asimilados Miembros Sociedades Cooperativas Produccion"),
	ASIMILADOS_INTEGRANTES_SOCIEDADES_ASOCIACIONES_CIVILES(6,"Asimilados Integrantes Sociedades Asociaciones Civiles"),
	ASIMILADOS_MIEMBROS_CONSEJOS(7,"Asimilados Miembros consejos"),
	ASIMILADOS_COMISIONISTAS(8,"Asimilados comisionistas"),
	ASIMILADOS_HONORARIOS(9,"Asimilados Honorarios"),
	ASIMILADOS_ACCIONES(10,"Asimilados acciones"),
	ASIMILADOS_OTROS(11,"Asimilados otros"),
	OTROREGIMEN(99,"OtroRegimen"),
	;
	
	final Integer idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposRegimen(Integer idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposRegimen(Integer idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposRegimen busca(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		for(TiposRegimen m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
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
	
	public static TiposRegimen unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposRegimen estado =  TiposRegimen.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de régimen "+metodo+" no se encuentra en el catálogo de Tipos de Régimen del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposRegimen v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat().toString();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	
}
