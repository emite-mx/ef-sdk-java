package mx.emite.sdk.enums.sat.cfdi33;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Getter
public enum TiposDeComprobante33 implements Sat<String>{
	
	INGRESO("I","Ingreso",BigDecimal.valueOf(20000000),BigDecimal.ZERO,BigDecimal.ZERO),
	EGRESO("E","Egreso",BigDecimal.valueOf(20000000),BigDecimal.ZERO,BigDecimal.ZERO),
	TRASLADO("T","Traslado",BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO),
	NOMINA("N","Nómina",BigDecimal.ZERO,BigDecimal.valueOf(400000),BigDecimal.valueOf(2000000)),
	PAGO("P","Egreso",BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO),
	
	;
	
	
	final String idSat;
	final String descripcion;
	final BigDecimal valorMaximo;
	final BigDecimal valorMaximoNs;
	final BigDecimal valorMaximoNds;
	
	TiposDeComprobante33(String idSat,String descripcion,BigDecimal valorMaximo,BigDecimal valorMaximoNs,BigDecimal valorMaximoNds){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.valorMaximo=valorMaximo;
		this.valorMaximoNs=valorMaximoNs;
		this.valorMaximoNds=valorMaximoNds;
	}

	public static TiposDeComprobante33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposDeComprobante33 estado =  TiposDeComprobante33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El TipoDeComprobante  "+metodo+" no se encuentra en el catálogo de TiposDeComprobante del SAT");
		else
			return estado;
	}

	private static TiposDeComprobante33 busca(String metodo) {
		for(TiposDeComprobante33 it:values()){
			if(it.getIdSat().equals(metodo))
				return it;
		}
		return null;
	}

	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static String marshall(TiposDeComprobante33 v) throws Exception {
		if(v==null)
			return null;
		return v.marshall();
	}
	
	private String marshall(){
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
