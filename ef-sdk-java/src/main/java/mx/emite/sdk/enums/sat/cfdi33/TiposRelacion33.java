package mx.emite.sdk.enums.sat.cfdi33;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Getter
public enum TiposRelacion33 implements Sat<String>{
	
	NOTACREDITO("01","Nota de crédito de los documentos relacionados"),
	NOTADEBITO("02","Nota de débito de los documentos relacionados"),
	DEVOLUCIONMERCANCIA("03","Devolución de mercancía sobre facturas o traslados previos"),
	SUSTITUCION("04","Sustitución de los CFDI previos"),
	TRASLADOSMERCANCIA("05","Traslados de mercancias facturados previamente"),
	TRASLADOSPREVIOS("06","Factura generada por los traslados previos"),
	ANTICIPO("07","CFDI por aplicación de anticipo"),
	PAGOSENPARCIALIDADES("08","Factura generada por pagos en parcialidades"),
	PAGOSDIFERIDOS("09","Factura generada por pagos diferidos"),
	;
	
	
	final String idSat;
	final String descripcion;
	
	TiposRelacion33(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;		
	}

	public static TiposRelacion33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposRelacion33 estado =  TiposRelacion33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El TipoRelacion  "+metodo+" no se encuentra en el catálogo de c_TipoRelacion del SAT");
		else
			return estado;
	}

	private static TiposRelacion33 busca(String metodo) {
		for(TiposRelacion33 it:values()){
			if(it.getIdSat().equals(metodo))
				return it;
		}
		return null;
	}

	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static String marshall(TiposRelacion33 v) throws Exception {
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
	
	public static TiposRelacion33 idSat(String idSat) {
		return busca(idSat);
	}
	
	public static String descripcion(String idSat){
		if(idSat==null) return "";
		final TiposRelacion33 rf = idSat(idSat);
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
