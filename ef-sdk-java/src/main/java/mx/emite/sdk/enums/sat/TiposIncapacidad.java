package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposIncapacidad implements Sat<String>{
	
	RIESGOTRABAJO("01","Riesgo de trabajo"),
	ENFERMEDADGENERAL("02","Enfermedad en general"),
	MATERNIDAD("03","Maternidad"),
	
	;
	
	final String idSat;
	final String descripcion;
	
	TiposIncapacidad(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;		
		
	}

	public static TiposIncapacidad busca(String metodo) {
		for(TiposIncapacidad m:values()){
			if(Utilerias.compara(m.idSat,metodo))
				return m;
		}
		return null;
	}
	
	public static TiposIncapacidad unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposIncapacidad estado =  TiposIncapacidad.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de incapacidad "+metodo+" no se encuentra en el catálogo de Tipos de Incapacidad del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposIncapacidad v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static TiposIncapacidad busca(Integer tipoRiesgo) {
		if(tipoRiesgo==null)
			return null;
		for(TiposIncapacidad t:values()){
			if(t.getIdSat().equals(tipoRiesgo))
				return t;
		}
		return null;
	}
	
	
}
