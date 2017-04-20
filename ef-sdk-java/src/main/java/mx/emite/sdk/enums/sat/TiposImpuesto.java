package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposImpuesto implements Sat<Integer>{
	
	ISR(1,"ISR",new String[]{"i.s.r."}),
	IVA(2,"IVA",new String[]{"i.v.a."}),
	IEPS(3,"IEPS",new String[]{"i.e.p.s."}),
	OTROS(999,"OTROS"),
	;
	
	final Integer idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposImpuesto(Integer idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposImpuesto(Integer idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposImpuesto busca(String metodo) {
		for(TiposImpuesto m:values()){
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
	
	public static TiposImpuesto unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposImpuesto estado =  TiposImpuesto.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de impuesto "+metodo+" no se encuentra en el catálogo de Tipos de Impuesto del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposImpuesto v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	@Override
	public String getIdString() {
		return idSat.toString();
	}
}
