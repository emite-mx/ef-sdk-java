package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoImpuestoRetenciones implements Sat{
	
	ISR("01","ISR"),
	IVA("02","IVA"),
	IEPS("03","IEPS")
	
	;
	
	final String idSat;
	final String descripcion;
	
	
	
	TipoImpuestoRetenciones(final String idsat,String descripcion){
		this.idSat=idsat;
		this.descripcion=descripcion;

	}
	
	
	/**
	 * Busca una unidad de medida de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return unidadesMedida valor del enum de acuerdo a la unidad de medida
	 */
	public static TipoImpuestoRetenciones id(String idSat) {
		for(TipoImpuestoRetenciones m:values()){
			if(m.idSat.equalsIgnoreCase(idSat))
				return m;
		}
		return null;
	}

	public static TipoImpuestoRetenciones busca(String metodo) {
		for(TipoImpuestoRetenciones m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
			
		}
		return null;
	}


	
	public static TipoImpuestoRetenciones unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TipoImpuestoRetenciones estado =  TipoImpuestoRetenciones.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de impuesto "+metodo+" no se encuentra en el catálogo de tipos de impuestos del SAT ");
		else
			return estado;
	}
	
	
	public static String marshall(TipoImpuestoRetenciones v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
}
