package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposDeduccion implements Sat{
	
	IMSS("001","Seguridad social"),
	ISR("002","ISR"),
	APORTACIONESARETIROCESANTIAYVEJEZ("003","Aportaciones a retiro, cesantía en edad avanzada y vejez."),
	OTROS("004","Otros"),
	APORTACIONESAFONDODEVIVIENDA("005","Aportaciones a Fondo de vivienda"),
	DESCUENTOPORINCAPACIDAD("006","Descuento por incapacidad"),
	PENSIONALIMENTICIA("007","Pensión alimenticia"),
	RENTA("008","Renta"),
	PRESTAMOSINFONAVIT("009","Préstamos provenientes del Fondo Nacional de la Vivienda para los Trabajadores"),
	PAGOPORCREDITODEVIVIENDA("010","Pago por crédito de vivienda"),
	PAGODEABONOSINFONACOT("011","Pago de abonos INFONACOT"),
	ANTICIPODESALARIOS("012","Anticipo de salarios"),
	PAGOSHECHOSCONEXCESOALTRABAJADOR("013","Pagos hechos con exceso al trabajador"),
	ERRORES("014","Errores"),
	PERDIDAS("015","Pérdidas"),
	AVERIAS("016","Averías"),
	ADQUISICIONDEARTICULOSPRODUCIDOSPORLAEMPRESA("017","Adquisición de artículos producidos por la empresa o establecimiento"),
	CUOTASDECAJASDEAHORRO("018","Cuotas para la constitución y fomento de sociedades cooperativas y de cajas de ahorro"),
	CUOTASSINDICALES("019","Cuotas sindicales"),
	AUSENCIA("020","Ausencia (Ausentismo)"),
	CUOTASOBREROPATRONALES("021","Cuotas obrero patronales"),
	IMPUESTOSLOCALES("022","Impuestos Locales"),
	APORTACIONESVOLUNTARIAS("023","Aportaciones voluntarias"),
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposDeduccion(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposDeduccion(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposDeduccion busca(String metodo) {
		for(TiposDeduccion m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
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
	
	public static TiposDeduccion unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposDeduccion estado =  TiposDeduccion.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de deducción "+metodo+" no se encuentra en el catálogo de Tipos de Deducciones del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposDeduccion v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public boolean in(TiposDeduccion... tipos){
		for(TiposDeduccion t:tipos){
			if(this.equals(t)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean notin(TiposDeduccion... tipos){
		return !in(tipos);
	}
	

	public String getClave() {
		return idSat;
	}
	public String getConcepto() {
		return descripcion;
	}
	
}
