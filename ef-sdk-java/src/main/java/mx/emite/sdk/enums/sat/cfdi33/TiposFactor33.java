package mx.emite.sdk.enums.sat.cfdi33;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposFactor33 implements Sat<String>{
	
	TASA("Tasa","Tasa"),
	CUOTA("Cuota","Cuota"),
	EXENTO("Exento","Exento"),
	
	;
	
	final String idSat;
	final String descripcion;
	
	
	
	TiposFactor33(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	
		
	}

	public static TiposFactor33 busca(String metodo) {
		for(TiposFactor33 m:values()){
			if(Utilerias.compara(m.idSat,metodo))
				return m;			
		}
		return null;
	}
	
	public static TiposFactor33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposFactor33 estado =  TiposFactor33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de factor "+metodo+" no se encuentra en el catálogo de Tipos de Factor del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposFactor33 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}

	public static TiposFactor33 idSat(String idSat) {
		for(TiposFactor33 m:values()){
			if(StringUtils.equals(m.idSat, idSat))
				return m;			
		}
		return null;
	}

	public boolean in(TiposFactor33... tasas) {
		for(TiposFactor33 t:tasas) {
			if(this.equals(t))
				return true;
			
		}
		return false;
	}
}
