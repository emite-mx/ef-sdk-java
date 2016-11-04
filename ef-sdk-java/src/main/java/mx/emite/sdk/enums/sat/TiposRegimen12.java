package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposRegimen12 implements Sat<String>{
	
	SUELDOS("02","Sueldos",true),
	JUBILADOS("03","Jubilados",true),
	PENSIONADOS("04","Pensionados",true),
	ASIMILADOS_MIEMBROS_SOCIEDADES_COOPERATIVAS_PRODUCCION("05","Asimilados Miembros Sociedades Cooperativas Produccion",false),
	ASIMILADOS_INTEGRANTES_SOCIEDADES_ASOCIACIONES_CIVILES("06","Asimilados Integrantes Sociedades Asociaciones Civiles",false),
	ASIMILADOS_MIEMBROS_CONSEJOS("07","Asimilados Miembros consejos",false),
	ASIMILADOS_COMISIONISTAS("08","Asimilados comisionistas",false),
	ASIMILADOS_HONORARIOS("09","Asimilados Honorarios",false),
	ASIMILADOS_ACCIONES("10","Asimilados acciones",false),
	ASIMILADOS_OTROS("11","Asimilados otros",false),
	OTROREGIMEN("99","Otro Regimen",false),
	;
	
	final String idSat;
	final String descripcion;
	final Boolean requiereRegistroPatronal;
	
	TiposRegimen12(String idSat,String descripcion,boolean requiereRegistroPatronal){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.requiereRegistroPatronal=requiereRegistroPatronal;
		
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

	public static TiposRegimen12 getTipoRegimen(String tipoRegimen) {
		if(StringUtils.isEmpty(tipoRegimen))
			return null;
		for(TiposRegimen12 m:values()){
			if(m.idSat.equals(tipoRegimen))
				return m;
		}
		return null;
	}
	
	
}
