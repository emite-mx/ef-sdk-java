package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposOtroPago implements Sat<String>{
	
	DEVOLUCIONISR("001","Devolución de ISR"),
	SUBSIDIO("002","Subsidio efectivamente entregado al trabajador"),
	VIATICOS("003","Viáticos"),
	COMPENSACION("004","Aplicación de saldo a favor por compensación anual"),
	OTROS("999","Pagos distintos a los listados y que no deben considerarse como ingreso por sueldos")
	;
	
	final String idSat;
	final String descripcion;
	
	TiposOtroPago(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;		
		
	}

	public static TiposOtroPago busca(String metodo) {
		for(TiposOtroPago m:values()){
			if(Utilerias.compara(m.idSat,metodo))
				return m;
		}
		return null;
	}
	
	public static TiposOtroPago unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposOtroPago estado =  TiposOtroPago.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de otros pagos "+metodo+" no se encuentra en el catálogo de Tipos de Otros Pagos del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposOtroPago v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static TiposOtroPago busca(Integer tipoRiesgo) {
		if(tipoRiesgo==null)
			return null;
		for(TiposOtroPago t:values()){
			if(t.getIdSat().equals(tipoRiesgo<100?tipoRiesgo<10?"0"+tipoRiesgo:"00"+tipoRiesgo:tipoRiesgo.toString()))
				return t;
		}
		return null;
	}
	
	public boolean esSubsidioAlEmpleo(){
		return this.equals(SUBSIDIO);
	}
	
	public boolean esCompensasionSaldos(){
		return this.equals(COMPENSACION);
	}
	
	public boolean esViaticos(){
		return this.equals(VIATICOS);
	}
}

