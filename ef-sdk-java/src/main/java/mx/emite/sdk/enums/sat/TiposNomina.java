package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposNomina implements Sat<String>{
	
	ORDINARIA("O","Nómina Ordinaria"),
	EXTRAORDINARIA("E","Nómina Extraordinaria"),
	;
	
	final String idSat;
	final String descripcion;
	
	
	TiposNomina(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
		
		
	}

	public static TiposNomina busca(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		for(TiposNomina m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;			
		}
		return null;
	}
	
	public static TiposNomina unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposNomina estado =  TiposNomina.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de régimen "+metodo+" no se encuentra en el catálogo de Tipos de Régimen del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposNomina v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat().toString();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	
}
