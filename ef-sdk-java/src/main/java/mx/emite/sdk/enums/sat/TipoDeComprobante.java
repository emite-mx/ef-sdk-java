package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoDeComprobante implements Sat<Integer> {
	
	INGRESO(1,"ingreso"),
	EGRESO(2,"egreso"),
	;
	
	final Integer idSat;
	final String descripcion;
	
	
	TipoDeComprobante(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	public static TipoDeComprobante busca(String metodo) {
		for(TipoDeComprobante m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
		}
		return null;
	}
	
	public static TipoDeComprobante unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TipoDeComprobante estado =  TipoDeComprobante.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de comprobante "+metodo+" no se encuentra en el catálogo de TipoDeComprobante del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TipoDeComprobante v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
}
