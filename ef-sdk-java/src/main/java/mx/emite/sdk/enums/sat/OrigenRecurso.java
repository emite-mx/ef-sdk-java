package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum OrigenRecurso implements Sat<String>{
	
	INGRESOSPROPIOS("IP","Ingresos Propios"),
	INGRESOSFEDERALES("IF","Ingresos Federales"),
	INGRESOSMIXTOS("IM","Ingresos Mixtos")
	
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	OrigenRecurso(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	OrigenRecurso(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static OrigenRecurso busca(String metodo) {
		for(OrigenRecurso m:values()){
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
	
	public static OrigenRecurso unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final OrigenRecurso estado =  OrigenRecurso.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de horas "+metodo+" no se encuentra en el catálogo de Tipos de Horas del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(OrigenRecurso v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static OrigenRecurso getOrigenRecurso(String origenRecurso) {
		for(OrigenRecurso m:values()){
			if(m.idSat.equals(origenRecurso))
				return m;
		}
		return null;
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}
}
