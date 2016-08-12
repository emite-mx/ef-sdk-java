package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoDividendosOUtilidadDistribuida implements Sat<String>{
	
	CUFIN("01","Proviene de CUFIN"),
	NOCUFIN("02","No proviene de CUFIN"),
	REEMBOLSO("03","Reembolso o reducción de capital"),
	LIQUIDACION("04","Liquidación de la persona moral"),
	CUFINRE("05","CUFINRE"),
	CUFIN2013("06","Proviene de CUFIN al 31 de diciembre 2013"),
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TipoDividendosOUtilidadDistribuida(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TipoDividendosOUtilidadDistribuida(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TipoDividendosOUtilidadDistribuida busca(String metodo) {
		for(TipoDividendosOUtilidadDistribuida m:values()){
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
	
	public static TipoDividendosOUtilidadDistribuida unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TipoDividendosOUtilidadDistribuida estado =  TipoDividendosOUtilidadDistribuida.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de dividendo "+metodo+" no se encuentra en el catálogo de Tipos de Dividendos del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TipoDividendosOUtilidadDistribuida v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	
}
