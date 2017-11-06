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
	
	INGRESO("I","Ingreso",BigDecimal.valueOf(100_000_000),BigDecimal.ZERO),
	EGRESO("E","Egreso",BigDecimal.valueOf(100_000_000),BigDecimal.ZERO),
	TRASLADO("T","Traslado",BigDecimal.ZERO,BigDecimal.ZERO),
	NOMINA("N","Nómina",BigDecimal.valueOf(100_000_000),BigDecimal.valueOf(100_000_000)),
	PAGO("P","Pago",BigDecimal.valueOf(100_000_000),BigDecimal.ZERO),
	
	;
	
	
	final String idSat;
	final String descripcion;
	final BigDecimal valorMaximo;
	//final BigDecimal valorMaximoNs;
	final BigDecimal valorMaximoNds;
	
	TiposDeComprobante33(String idSat,String descripcion,BigDecimal valorMaximo,BigDecimal valorMaximoNds){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.valorMaximo=valorMaximo;
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
	
	@Override
	public String getIdString() {
		return idSat;
	}

	public static TiposDeComprobante33 idSat(String tipoDeComprobante) {
		for(TiposDeComprobante33 it:values()){
			if(it.getIdSat().equals(tipoDeComprobante))
				return it;
		}
		return null;
	}
	
	public boolean in(TiposDeComprobante33... lista){
		for(TiposDeComprobante33 tc:lista){
			if(this.equals(tc))
				return true;
		}
		return false;
	}
	
	public boolean notin(TiposDeComprobante33... lista){
		return !in(lista);
	}
	
	public boolean esIngresoEgresoNomina(){
		return in(INGRESO,EGRESO,NOMINA);
	}
	
	public boolean esTrasladoPago(){
		return in(TRASLADO,PAGO);
	}

	public boolean esIngresoEgreso() {
		return in(INGRESO,EGRESO);
	}

	public Character getIdSatChar() {
		return idSat.charAt(0);
	}
	
	public static String descripcion(String idSat){
		if(idSat==null) return "";
		final TiposDeComprobante33 rf = idSat(idSat);
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
