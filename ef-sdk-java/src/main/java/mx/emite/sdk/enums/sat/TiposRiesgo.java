package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposRiesgo implements Sat<Integer>{
	
	CLASEI(1,"Clase I",new String[]{"Clase_I"}),
	CLASEII(2,"Clase II",new String[]{"Clase_II"}),
	CLASEIII(3,"Clase III",new String[]{"Clase_III"}),
	CLASEIV(4,"Clase IV",new String[]{"Clase_IV"}),
	CLASEV(5,"Clase V",new String[]{"Clase_V"}),
	;
	
	final Integer idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposRiesgo(Integer idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposRiesgo(Integer idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposRiesgo busca(String metodo) {
		for(TiposRiesgo m:values()){
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
	
	public static TiposRiesgo unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposRiesgo estado =  TiposRiesgo.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de riesgo "+metodo+" no se encuentra en el catálogo de Tipos de Riesgo del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposRiesgo v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static String marshallIdSat(TiposRiesgo v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat().toString();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static TiposRiesgo busca(Integer tipoRiesgo) {
		if(tipoRiesgo==null)
			return null;
		for(TiposRiesgo t:values()){
			if(t.getIdSat().equals(tipoRiesgo))
				return t;
		}
		return null;
	}

	public static TiposRiesgo getTipoRiesgo(String riesgoPuesto) {
		if(StringUtils.isEmpty(riesgoPuesto)){
			return null;
		}
		int id;
		try{
			id = Integer.parseInt(riesgoPuesto);
		}catch(Exception ex){return null;}
		
		for(TiposRiesgo m:values()){
			if(m.idSat.equals(id))
				return m;
		}
		return null;
	}
	
	
}
