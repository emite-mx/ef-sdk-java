package mx.emite.sdk.enums.sat;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoPagoRetencion implements Sat<String>{
	
	DEFINITIVO("Pago definitivo"),
	PROVISIONAL("Pago provisional")
	
	;
	
	final String idSat;
	final String descripcion;
	
	
	
	TipoPagoRetencion(String descripcion){
		this.idSat=descripcion;
		this.descripcion=descripcion;

	}
	
	
	/**
	 * Busca una unidad de medida de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return unidadesMedida valor del enum de acuerdo a la unidad de medida
	 */
	public static TipoPagoRetencion id(String idSat) {
		for(TipoPagoRetencion m:values()){
			if(m.idSat.equalsIgnoreCase(idSat))
				return m;
		}
		return null;
	}

	public static TipoPagoRetencion busca(String metodo) {
		for(TipoPagoRetencion m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
			
		}
		return null;
	}


	
	public static TipoPagoRetencion unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TipoPagoRetencion estado =  TipoPagoRetencion.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de pago de retención "+metodo+" no se encuentra en el catálogo de tipos de pago del SAT "+Arrays.toString(values()));
		else
			return estado;
	}
	
	
	public static String marshall(TipoPagoRetencion v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
}
