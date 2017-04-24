package mx.emite.sdk.enums.sat.cfdi33;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposImpuesto33 implements Sat<String>{
	
	ISR("001","ISR"),
	IVA("002","IVA"),
	IEPS("003","IEPS"),
	
	;
	
	final String idSat;
	final String descripcion;
	
	
	
	TiposImpuesto33(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	
		
	}

	public static TiposImpuesto33 busca(String metodo) {
		for(TiposImpuesto33 m:values()){
			if(Utilerias.compara(m.idSat,metodo))
				return m;			
		}
		return null;
	}
	
	public static TiposImpuesto33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposImpuesto33 estado =  TiposImpuesto33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de impuesto "+metodo+" no se encuentra en el catálogo de Tipos de Impuesto del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposImpuesto33 v) throws Exception {
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

	public boolean in(TiposImpuesto33... ti) {
		for(TiposImpuesto33 t:ti){
			if(this.equals(t))
				return true;
		}
		return false;
	}
	
	public boolean notin(TiposImpuesto33... ti) {
		return !in(ti);
	}

	public static boolean existe(String impuesto) {
		for(TiposImpuesto33 t:values()){
			if(StringUtils.equals(t.getIdSat(),impuesto))
				return true;
		}
		return false;
	}
	
	public static TiposImpuesto33 idSat(String idSat) {
		for(TiposImpuesto33 it:values()){
			if(it.getIdSat().equals(idSat))
				return it;
		}
		return null;
	}
	
	
	public static String descripcion(String idSat){
		if(idSat==null) return "";
		final TiposImpuesto33 rf = idSat(idSat);
		if(rf!=null)
			return  idSat.concat(" - ").concat(rf.getDescripcion());
		return idSat;
	}
	
}
