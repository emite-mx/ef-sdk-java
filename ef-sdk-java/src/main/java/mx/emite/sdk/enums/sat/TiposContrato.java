package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposContrato implements Sat<String>{
	
	BASE("01","Base"),
	SINDICALIZADO("02","Sindicalizado"),
	EVENTUAL("03","Eventual"),
	CONFIANZA("04","Confianza"),
	A_PRUEBA("05","A prueba", new String[]{"A_Prueba"}),
	OTROCONTRATO("99","OtroContrato"),
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposContrato(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposContrato(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposContrato busca(String metodo) {
		for(TiposContrato m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
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
	
	public static TiposContrato unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposContrato estado =  TiposContrato.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de contrato "+metodo+" no se encuentra en el catálogo de Tipos de Contrato del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposContrato v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	
}
