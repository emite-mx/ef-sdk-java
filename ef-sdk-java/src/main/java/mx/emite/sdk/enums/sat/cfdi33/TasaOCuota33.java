package mx.emite.sdk.enums.sat.cfdi33;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import lombok.Getter;

@Getter
public enum TasaOCuota33 {

	IVA0(false,null,new BigDecimal("0.000000"),TiposImpuesto33.IVA,TiposFactor33.TASA,true,false),
	IVA16(false,null,new BigDecimal("0.160000"),TiposImpuesto33.IVA,TiposFactor33.TASA,true,false),
	IVA16R(true,new BigDecimal("0.000000"),new BigDecimal("0.160000"),TiposImpuesto33.IVA,TiposFactor33.TASA,false,true),
	IEPS265(false,null,new BigDecimal("0.265000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS300(false,null,new BigDecimal("0.300000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS530(false,null,new BigDecimal("0.530000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS500(false,null,new BigDecimal("0.500000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS1600(false,null,new BigDecimal("1.600000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS304(false,null,new BigDecimal("0.304000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS350(false,null,new BigDecimal("0.250000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	
	IEPS09(false,null,new BigDecimal("0.090000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS08(false,null,new BigDecimal("0.080000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS07(false,null,new BigDecimal("0.070000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS06(false,null,new BigDecimal("0.060000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS03(false,null,new BigDecimal("0.030000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,false),
	IEPS00(false,null,new BigDecimal("0.000000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,false),
	
	IEPS4377(true,new BigDecimal("0.000000"),new BigDecimal("43.770000"),TiposImpuesto33.IEPS,TiposFactor33.CUOTA,true,true),
	
	IEPS298(true,new BigDecimal("0.000000"),new BigDecimal("0.350000"),TiposImpuesto33.ISR,TiposFactor33.TASA,false,true),
	
	;

	//private final String idSat;
	private final boolean esRango;
	private final BigDecimal valorMinimo,valorMaximo;
	private final TiposImpuesto33 impuesto;
	private final TiposFactor33 factor;
	private final boolean traslado,retencion;
	
	TasaOCuota33(boolean esRango,BigDecimal minimo,BigDecimal maximo,TiposImpuesto33 tipo,TiposFactor33 factor,boolean traslado,boolean retencion){
		
		this.esRango=esRango;
		this.valorMinimo=minimo;
		this.valorMaximo=maximo;
		this.impuesto=tipo;
		this.factor=factor;
		this.traslado=traslado;
		this.retencion=retencion;
	}

	public static TasaOCuota33 buscaTasa(boolean esTraslado,final BigDecimal tasaOCuota,final TiposImpuesto33 tipo,final TiposFactor33 factor) {
		final Optional<TasaOCuota33> tasas = Arrays.asList(values()).stream().filter(i->i.esTasa(esTraslado,tasaOCuota,tipo,factor)).findAny();
		if(tasas.isPresent())
			return tasas.get();
		return null;
		
		/*for(TasaOCuota33 tc:values()){
			if(tc.getValorMinimo()!=null){
				if(tc.getValorMinimo().compareTo(tasaOCuota)>=0 && tc.getValorMaximo().compareTo(tasaOCuota)<=0 && tasaOCuota.scale()==6){
					if(esTraslado&&tc.isTraslado())
						return tc;
					if(!esTraslado&&tc.isRetencion())
						return tc;
				}
			}
			
			else
			if(tc.getValorMaximo().compareTo(tasaOCuota)==0 && tasaOCuota.scale()==6){
				if(esTraslado&&tc.isTraslado())
					return tc;
				if(!esTraslado&&tc.isRetencion())
					return tc;
			}
		}
		return null;*/
	}

	private boolean esTasa(boolean esTraslado, BigDecimal tasaOCuota, TiposImpuesto33 tipo, TiposFactor33 factor) {
		if(tasaOCuota==null)
			return false;
		if(!this.impuesto.equals(tipo))
			return false;
		if(!this.factor.equals(factor))
			return false;
		if(esTraslado && !this.traslado)
			return false;
		if(!esTraslado && !this.retencion)
			return false;
		if(tasaOCuota.scale()!=6)
			return false;
		
		if(this.valorMinimo==null){
			//valor fijo
			if(this.getValorMaximo().compareTo(tasaOCuota)!=0) 
				return false;			
		}
		else{
			return dentroRango(tasaOCuota,this.getValorMinimo(),this.getValorMaximo());
		}
		
		return true;
	}
	
	/*public static void main(String[] args){
		System.out.println(dentroRango(new BigDecimal(-1),new BigDecimal("0.000000"),new BigDecimal("0.160000")));
		System.out.println(dentroRango(new BigDecimal(0),new BigDecimal("0.000000"),new BigDecimal("0.160000")));
		System.out.println(dentroRango(new BigDecimal("0.16"),new BigDecimal("0.000000"),new BigDecimal("0.160000")));
		System.out.println(dentroRango(new BigDecimal("0.161"),new BigDecimal("0.000000"),new BigDecimal("0.160000")));
		System.out.println(dentroRango(new BigDecimal("0.1"),new BigDecimal("0.000000"),new BigDecimal("0.160000")));
	}*/
	
	private static boolean dentroRango(final BigDecimal valor,final BigDecimal minimo,final BigDecimal maximo){
		if(valor.compareTo(minimo)<0)
			return false;
		if(valor.compareTo(maximo)>0)
			return false;
		return true;
	}

	
	
}
