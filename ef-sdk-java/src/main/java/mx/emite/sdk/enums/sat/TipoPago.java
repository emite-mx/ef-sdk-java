package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import  mx.emite.sdk.enums.sat.cfdi33.MetodosPago33;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoPago implements Sat<Integer>{
	
	PAGOENUNASOLAEXHIBICION(1,"Pago En Una Sola Exhibición",new String[]{"Pago En Una Sola Exhibicion"},MetodosPago33.UNASOLAEXHIBICION),
	PAGOENPARCIALIDADES(2,"Pago En Parcialidades",MetodosPago33.PARCIALIDADESODIFERIDO),
	;
	
	final Integer idSat;
	final String descripcion;
	final String[] sinonimos;
	final MetodosPago33 sat;
	
	TipoPago(Integer idSat,String descripcion,final MetodosPago33 sat){
		this(idSat,descripcion,null,sat);
	}
	TipoPago(Integer idSat,String descripcion,String[] sinonimos,final MetodosPago33 sat){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		this.sat=sat;
	}

	/**
	 * Busca una forma de pago de acuerdo a su descripcion
	 * @param descripcion pago en una sola exhibición o pago en parcialidades
	 * @return FormasPago valor del enum de acuerdo a la descripcion
	 */
	public static TipoPago busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		for(TipoPago m:values()){
			if(Utilerias.compara(m.descripcion,descripcion))
				return m;
			else if(m.sinonimos!=null){
				for(String s:m.sinonimos){
					if(Utilerias.compara(s,descripcion))
						return m;
				}
			}
		}
		return null;
	}

	/**
	 * Busca una forma de pago de acuerdo a su id
	 * @param idTipoPago 1 o 2
	 * @return FormasPago valor del enum de acuerdo al id
	 */
	public static TipoPago id(Integer idTipoPago) {
		for(TipoPago m:values()){
			if(m.idSat.equals(idTipoPago))
				return m;
		}
		return null;
	}
	
	public Integer getIdTipoPago(){
		return idSat;
	}
	
	public static TipoPago unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TipoPago tipoPago =  TipoPago.busca(metodo);		
		if(tipoPago==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de pago "+metodo+" no se encuentra en el catálogo de tipos de pago del SAT");
		else
			return tipoPago;
	}
	
	
	public static String marshall(TipoPago v) throws Exception {
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
	public MetodosPago33 getSat() {
		return sat;
	}

	
}
