package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposIncapacidad12 implements Sat<String>{
	
	RIESGOTRABAJO("01","Riesgo de trabajo"),
	ENFERMEDADGENERAL("02","Enfermedad en general"),
	MATERNIDAD("03","Maternidad"),
	
	;
	
	final String idSat;
	final String descripcion;
	
	TiposIncapacidad12(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;		
		
	}

	public static TiposIncapacidad12 busca(String metodo) {
		for(TiposIncapacidad12 m:values()){
			if(Utilerias.compara(m.idSat,metodo))
				return m;
		}
		return null;
	}
	
	public static TiposIncapacidad12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposIncapacidad12 estado =  TiposIncapacidad12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de incapacidad "+metodo+" no se encuentra en el catálogo de Tipos de Incapacidad del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposIncapacidad12 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	@Deprecated
	public static TiposIncapacidad12 busca(Integer tipoRiesgo) {
		if(tipoRiesgo==null)
			return null;
		for(TiposIncapacidad12 t:values()){
			if(t.getIdSat().equals(tipoRiesgo<10?"0"+tipoRiesgo:tipoRiesgo))
				return t;
		}
		return null;
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}
	
	@Override
	public String toString(){
		return descripcion;
	}
	
	public static TiposIncapacidad12 idSat(String idSat) {
		for(TiposIncapacidad12 m:values()){
			if(m.idSat.equals(idSat))
				return m;
		}
		return null;
	}

	public static String descripcion(String idSat){
		if(idSat==null) return "";
		final TiposIncapacidad12 rf = idSat(idSat);
		if(rf!=null)
			return  idSat.concat(" - ").concat(rf.getDescripcion());
		return idSat;
	}
}
