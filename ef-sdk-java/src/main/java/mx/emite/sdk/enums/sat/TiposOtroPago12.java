package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposOtroPago12 implements Sat<String>{
	
	DEVOLUCIONISR("001","Devolución de ISR"),
	SUBSIDIO("002","Subsidio efectivamente entregado al trabajador"),
	VIATICOS("003","Viáticos"),
	COMPENSACION("004","Aplicación de saldo a favor por compensación anual"),
	REINTEGROISRRETENIDO("005","Reintegro de ISR retenido en exceso de ejercicio anterior"),
	OTROS("999","Pagos distintos a los listados y que no deben considerarse como ingreso por sueldos")
	;
	
	final String idSat;
	final String descripcion;
	
	TiposOtroPago12(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;		
		
	}
	
	public static void main(String[] args){
		int indice=144;
		for(TiposOtroPago12 p:values()){
				System.out.println("insert into h_sat_nomina values("+(indice++)+",'"+p.getIdSat()+"','"+p.getDescripcion()+"',0,0,0,'O',null);");
		}
	}

	public static TiposOtroPago12 busca(String metodo) {
		for(TiposOtroPago12 m:values()){
			if(Utilerias.compara(m.idSat,metodo))
				return m;
		}
		return null;
	}
	
	public static TiposOtroPago12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposOtroPago12 estado =  TiposOtroPago12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de otros pagos "+metodo+" no se encuentra en el catálogo de Tipos de Otros Pagos del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposOtroPago12 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static TiposOtroPago12 busca(Integer tipoRiesgo) {
		if(tipoRiesgo==null)
			return null;
		for(TiposOtroPago12 t:values()){
			if(t.getIdSat().equals(tipoRiesgo<100?tipoRiesgo<10?"0"+tipoRiesgo:"00"+tipoRiesgo:tipoRiesgo.toString()))
				return t;
		}
		return null;
	}
	
	public boolean esSubsidioAlEmpleo(){
		return this.equals(SUBSIDIO);
	}
	
	public boolean esCompensacionSaldos(){
		//return this.equals(COMPENSACION) || this.equals(REINTEGROISRRETENIDO);
		return this.equals(COMPENSACION);
	}
	  
	public boolean esViaticos(){
		return this.equals(VIATICOS);
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}

	public static TiposOtroPago12 idSat(String idSat) {
		if(idSat==null)
			return null;
		for(TiposOtroPago12 t:values()){
			if(t.getIdSat().equals(idSat))
				return t;
		}
		return null;
	}
}

