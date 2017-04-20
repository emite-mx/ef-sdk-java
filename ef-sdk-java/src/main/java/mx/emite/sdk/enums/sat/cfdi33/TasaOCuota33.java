package mx.emite.sdk.enums.sat.cfdi33;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public enum TasaOCuota33 {

	IVA0("0.000000",false,null,new BigDecimal("0.000000"),TiposImpuesto33.IVA,TiposFactor33.TASA,true,true),
	IVA16("0.160000",false,null,new BigDecimal("0.160000"),TiposImpuesto33.IVA,TiposFactor33.TASA,true,true),
	IVA16R("0.160000",true,new BigDecimal("0.000000"),new BigDecimal("0.160000"),TiposImpuesto33.IVA,TiposFactor33.TASA,false,true),
	IEPS265("0.265000",false,null,new BigDecimal("0.265000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS300("0.300000",false,null,new BigDecimal("0.300000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS530("0.530000",false,null,new BigDecimal("0.530000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS500("0.500000",false,null,new BigDecimal("0.500000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS1600("1.600000",false,null,new BigDecimal("1.600000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS304("0.304000",false,null,new BigDecimal("0.304000"),TiposImpuesto33.IEPS,TiposFactor33.TASA,true,true),
	IEPS350("0.350000",false,null,new BigDecimal("0.350000"),TiposImpuesto33.IEPS,TiposFactor33.CUOTA,true,true),
	IEPS059("0.059100",false,null,new BigDecimal("0.059100"),TiposImpuesto33.IEPS,TiposFactor33.CUOTA,true,true),
	IEPS3("3.000000",false,null,new BigDecimal("3.000000"),TiposImpuesto33.IEPS,TiposFactor33.CUOTA,true,true),
	IEPS298("0.298800",false,null,new BigDecimal("0.298800"),TiposImpuesto33.IEPS,TiposFactor33.CUOTA,true,true),
	
	;

	private final String idSat;
	private final boolean esRango;
	private final BigDecimal valorMinimo,valorMaximo;
	private final TiposImpuesto33 impuesto;
	private final TiposFactor33 factor;
	private final boolean traslado,retencion;
	
	TasaOCuota33(String idSat,boolean esRango,BigDecimal minimo,BigDecimal maximo,TiposImpuesto33 tipo,TiposFactor33 factor,boolean traslado,boolean retencion){
		this.idSat=idSat;
		this.esRango=esRango;
		this.valorMinimo=minimo;
		this.valorMaximo=maximo;
		this.impuesto=tipo;
		this.factor=factor;
		this.traslado=traslado;
		this.retencion=retencion;
	}

	public static TasaOCuota33 buscaTasa(BigDecimal tasaOCuota, boolean esTraslado) {
		for(TasaOCuota33 tc:values()){
			if(tc.getValorMaximo().compareTo(tasaOCuota)==0 && tasaOCuota.scale()==6){
				if(esTraslado&&tc.isTraslado())
					return tc;
				if(!esTraslado&&tc.isRetencion())
					return tc;
			}
		}
		return null;
	}
}
