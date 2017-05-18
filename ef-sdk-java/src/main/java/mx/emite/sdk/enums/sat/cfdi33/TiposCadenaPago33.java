package mx.emite.sdk.enums.sat.cfdi33;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Getter
public enum TiposCadenaPago33 implements Sat<String>{
	
	
	SPEI("01","SPEI"),
	
	
	;
	
	
	final String idSat;
	final String descripcion;
	
	TiposCadenaPago33(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;		
	}

	public static TiposCadenaPago33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposCadenaPago33 estado =  TiposCadenaPago33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El TipoCadenaPago  "+metodo+" no se encuentra en el catálogo de tipos de cadena de pago del SAT");
		else
			return estado;
	}

	private static TiposCadenaPago33 busca(String metodo) {
		for(TiposCadenaPago33 it:values()){
			if(it.getIdSat().equals(metodo))
				return it;
		}
		return null;
	}

	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static String marshall(TiposCadenaPago33 v) throws Exception {
		if(v==null)
			return null;
		return v.marshall();
	}
	
	private String marshall(){
		return idSat;
	}
	@Override
	public String getIdString() {
		return idSat;
	}
	
	public static TiposCadenaPago33 idSat(String idSat) {
		for(TiposCadenaPago33 it:values()){
			if(it.getIdSat().equals(idSat))
				return it;
		}
		return null;
	}
	
	public static String descripcion(String idSat){
		if(idSat==null) return "";
		final TiposCadenaPago33 rf = idSat(idSat);
		if(rf!=null)
			return  idSat.concat(" - ").concat(rf.getDescripcion());
		return idSat;
	}
	
	
	/*
		
	
	
	
	
	private String getIdSatString(){
		return marshall();
	}
	
	

	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(FormasPago33::getIdSatString).collect(Collectors.toList());		
	}
	*/
	
}
