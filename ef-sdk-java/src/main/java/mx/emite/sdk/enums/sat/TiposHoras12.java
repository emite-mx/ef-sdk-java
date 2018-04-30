package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposHoras12 implements Sat<String>{
	
	DOBLES("01","Dobles"),
	TRIPLES("02","Triples"),
	SIMPLES("03","Simples")
	
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposHoras12(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposHoras12(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposHoras12 busca(String metodo) {
		for(TiposHoras12 m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat,metodo))
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
	
	public static TiposHoras12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposHoras12 estado =  TiposHoras12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de horas "+metodo+" no se encuentra en el catálogo de Tipos de Horas del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposHoras12 v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static String marshallIdSat(TiposHoras12 v) throws Exception {
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
	
	@Override
	public String toString(){
		return descripcion;
	}
	
	public static TiposHoras12 idSat(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		
		for(TiposHoras12 m:values()){
			if(StringUtils.equals(m.idSat, metodo))
				return m;
			
		}
		return null;
	}
	
	public static String descripcion(String idSat){
		if(idSat==null) return "";
		final TiposHoras12 rf = idSat(idSat);
		if(rf!=null)
			return  idSat.concat(" - ").concat(rf.getDescripcion());
		return idSat;
	}
}
