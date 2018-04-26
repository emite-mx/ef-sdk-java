package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum OrigenRecurso12 implements Sat<String>{
	
	INGRESOSPROPIOS("IP","Ingresos Propios"),
	INGRESOSFEDERALES("IF","Ingresos Federales"),
	INGRESOSMIXTOS("IM","Ingresos Mixtos")
	
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	OrigenRecurso12(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	OrigenRecurso12(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static OrigenRecurso12 busca(String metodo) {
		for(OrigenRecurso12 m:values()){
			if(m.idSat.equals(metodo))
				return m;
			else if(Utilerias.compara(m.descripcion,metodo))
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
	
	public static OrigenRecurso12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final OrigenRecurso12 estado =  OrigenRecurso12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de horas "+metodo+" no se encuentra en el catálogo de Tipos de Horas del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(OrigenRecurso12 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static OrigenRecurso12 getOrigenRecurso(String origenRecurso) {
		for(OrigenRecurso12 m:values()){
			if(m.idSat.equals(origenRecurso))
				return m;
		}
		return null;
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}

	public static OrigenRecurso12 idSat(String origenRecurso) {
		for(OrigenRecurso12 m:values()){
			if(m.idSat.equals(origenRecurso))
				return m;
		}
		return null;
	}
}
