package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoSocDistrDiv implements Sat<String>{
	
	NACIONAL("Sociedad Nacional"),
	EXTRANJERO("Sociedad Extranjera")
	
	;
	
	final String idSat;
	final String descripcion;
	
	
	
	TipoSocDistrDiv(String descripcion){
		this.idSat=descripcion;
		this.descripcion=descripcion;

	}
	
	
	/**
	 * Busca una unidad de medida de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return unidadesMedida valor del enum de acuerdo a la unidad de medida
	 */
	public static TipoSocDistrDiv id(String idSat) {
		for(TipoSocDistrDiv m:values()){
			if(m.idSat.equalsIgnoreCase(idSat))
				return m;
		}
		return null;
	}

	public static TipoSocDistrDiv busca(String metodo) {
		for(TipoSocDistrDiv m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
			
		}
		return null;
	}


	
	public static TipoSocDistrDiv unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TipoSocDistrDiv estado =  TipoSocDistrDiv.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de sociedad "+metodo+" no se encuentra en el catálogo de tipo de sociedades del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TipoSocDistrDiv v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
}
