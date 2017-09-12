package mx.emite.sdk.enums.sat.cfdi33;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum ClavesUnidad33 implements Sat<String>{
	
	
	TARIFA("A9","Tarifa"),
	ACTIVIDAD("ACT","Actividad"),
	UNIDADDESERVICIO("E48","Unidad de servicio"),
	ELEMENTO("EA","Elemento"),
	NUMEROARTICULOS("NAR","Número de artículos"),
	//UNIDAD("XUN","Unidad"),
	MUTUAMENTEDEFINIDOS("ZZ","Mutuamente definido")
	;
	
	final String idSat;
	final String descripcion;
	
	
	
	ClavesUnidad33(final String idsat,String descripcion){
		this.idSat=idsat;
		this.descripcion=descripcion;

	}
	
	
	/**
	 * Busca una clave de retencion de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return clavesRetenciones valor del enum de acuerdo a la clave de retencion
	 */
	public static ClavesUnidad33 id(String idSat) {
		for(ClavesUnidad33 m:values()){
			if(m.idSat.equalsIgnoreCase(idSat))
				return m;
		}
		return null;
	}

	public static ClavesUnidad33 busca(String metodo) {
		for(ClavesUnidad33 m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
			
		}
		return null;
	}


	
	public static ClavesUnidad33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final ClavesUnidad33 estado =  ClavesUnidad33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La clave de unidad "+metodo+" no se encuentra en el catálogo de claves de retención del SAT ");
		else
			return estado;
	}
	
	
	public static String marshall(ClavesUnidad33 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static void main(String[] args){
		for(ClavesUnidad33 c:values()){
			System.out.println(c.idSat);
		}
		System.out.println();
		for(ClavesUnidad33 c:values()){
			System.out.println(c.descripcion);
		}
	}
	@Override
	public String getIdString() {
		return idSat;
	}
}
