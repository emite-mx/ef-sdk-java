package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposRegimen12 implements Sat<String>{
	
	SUELDOS("02","Sueldos"),
	JUBILADOS("03","Jubilados"),
	PENSIONADOS("04","Pensionados"),
	ASIMILADOS_MIEMBROS_SOCIEDADES_COOPERATIVAS_PRODUCCION("05","Asimilados Miembros Sociedades Cooperativas Produccion"),
	ASIMILADOS_INTEGRANTES_SOCIEDADES_ASOCIACIONES_CIVILES("06","Asimilados Integrantes Sociedades Asociaciones Civiles"),
	ASIMILADOS_MIEMBROS_CONSEJOS("07","Asimilados Miembros consejos"),
	ASIMILADOS_COMISIONISTAS("08","Asimilados comisionistas"),
	ASIMILADOS_HONORARIOS("09","Asimilados Honorarios"),
	ASIMILADOS_ACCIONES("10","Asimilados acciones"),
	ASIMILADOS_OTROS("11","Asimilados otros"),
	OTROREGIMEN("99","Otro Regimen"),
	;
	
	final String idSat;
	final String descripcion;
	
	
	TiposRegimen12(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	
		
	}

	public static TiposRegimen12 busca(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		for(TiposRegimen12 m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
		}
		return null;
	}
	
	public static TiposRegimen12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposRegimen12 estado =  TiposRegimen12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de régimen "+metodo+" no se encuentra en el catálogo de Tipos de Régimen del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposRegimen12 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat().toString();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	
}
