package mx.emite.sdk.enums.sat.cfdi33;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Getter
public enum UsosCfdi33 implements Sat<String>{
	
	ADQUISICIONMERCANCIAS("G01","Adquisición de mercancias",true,true),
	DEVOLUCIONESDESCUENTOS("G02","Devoluciones, descuentos o bonificaciones",true,true),
	GASTOSGENERAL("G03","Gastos en general",true,true),
	CONSTRUCCIONES("I01","Construcciones",true,true),
	MOBEQOFPORINVERSIONES("I02","Mobilario y equipo de oficina por inversiones",true,true),
	EQTRANSPORTE("I03","Equipo de transporte",true,true),
	EQCOMPUTO("I04","Equipo de computo y accesorios",true,true),
	HERRAMIENTAS("I05","Dados, troqueles, moldes, matrices y herramental",true,true),
	COMUNICACIONESTELEFONICAS("I06","Comunicaciones telefónicas",true,true),
	COMUNICACIONESSATELITALES("I07","Comunicaciones satelitales",true,true),
	OTRAMAQYEQ("I08","Otra maquinaria y equipo",true,true),
	HONYGASTOSMEDICOS("D01","Honorarios médicos, dentales y gastos hospitalarios.",true,false),
	GASTOSPORINCAPACIDAD("D02","Gastos médicos por incapacidad o discapacidad",true,false),
	GASTOSFUNERALES("D03","Gastos funerales.",true,false),
	DONATIVOS("D04","Donativos.",true,false),
	INTERESESREALES("D05","Intereses reales efectivamente pagados por créditos hipotecarios (casa habitación).",true,false),
	APORTACIONESSAR("D06","Aportaciones voluntarias al SAR.",true,false),
	PRIMASSEGUROSGTOSMEDICOS("D07","Primas por seguros de gastos médicos.",true,false),
	GTOSTRANSPORTACIONESCOLAR("D08","Gastos de transportación escolar obligatoria.",true,false),
	DEPOSITOSENAHORROPENSIONES("D09","Depósitos en cuentas para el ahorro, primas que tengan como base planes de pensiones.",true,false),
	COLEGIATURAS("D10","Pagos por servicios educativos (colegiaturas)",true,false),
	PORDEFINIR("P01","Por definir",true,false),
	;
	
	
	final String idSat;
	final String descripcion;
	final Boolean fisica;
	final Boolean moral;

	UsosCfdi33(String idSat,String descripcion,Boolean fisica,Boolean moral){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.fisica=fisica;
		this.moral=moral;
	}

	public static UsosCfdi33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final UsosCfdi33 estado =  UsosCfdi33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El UsoCFDI  "+metodo+" no se encuentra en el catálogo de c_UsoCFDI del SAT");
		else
			return estado;
	}

	private static UsosCfdi33 busca(String metodo) {
		for(UsosCfdi33 it:values()){
			if(it.getIdSat().equals(metodo))
				return it;
		}
		return null;
	}

	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static String marshall(UsosCfdi33 v) throws Exception {
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

	public static UsosCfdi33 idSat(String idSat) {
		for(UsosCfdi33 it:values()){
			if(it.getIdSat().equals(idSat))
				return it;
		}
		return null;
	}
	
	
}
