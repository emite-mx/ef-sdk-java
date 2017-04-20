package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum ClavesRetenciones implements Sat<String>{
	
	
	SERVICIOSPROFESIONALES ("01","Servicios profesionales"),
	REGALIASPORDERECHOAUTOR("02","Regalías por derechos de autor"),
	AUTOTRANSPORTETERRESTRECARGA("03","Autotransporte terrestre de carga"),
	SERVICIOSPRESTADOSCOMISIONISTAS("04","Servicios prestados por comisionistas"),
	ARRENDAMIENTO ("05","Arrendamiento"),
	ENAJENACIONDEACCIONES("06","Enajenación de acciones"),
	ENAJENACIONLIEPS("07","Enajenación de bienes objeto de la LIEPS"),
	ENAJENACIONBIENESINMUEBLES("08","Enajenación de bienes inmuebles consignada en escritura pública"),
	ENAJENACIONOTROSBIENES ("09","Enajenación de otros bienes, no consignada en escritura pública"),
	ADQUISICIONDESPERDICIOSINDUSTRIALES("10","Adquisición de desperdicios industriales"),
	ADQUISICIONBIENESESCRITURAPUBLICA("11","Adquisición de bienes consignada en escritura pública"),
	ADQUISICIONOTROSBIENESNOCONSIGNADA("12","Adquisición de otros bienes, no consignada en escritura pública"),
	OTROSRETIROSAFORE("13","Otros retiros de AFORE"),
	DIVIDENDOSOUTILIDADESDISTRIBUIDAS("14","Dividendos o utilidades distribuidas"),
	REMANENTEDISTRIBUIBLE("15","Remanente distribuible"),
	INTERESES("16","Intereses"),
	ARRENDAMIENTOENFIDEICOMISO("17","Arrendamiento en fideicomiso"),
	PAGOSREALIZADOSARESIDENTESEXTRANJERO("18","Pagos realizados a favor de residentes en el extranjero"),
	ENAJENACIONDEACCIONESENBOLSAVALORES("19","Enajenación de acciones u operaciones en bolsa de valores"),
	OBTENCIONDEPREMIOS("20","Obtención de premios"),
	FIDEICOMISOSSINACTIVIDADEMPRESARIAL("21","Fideicomisos que no realizan actividades empresariales"),
	PLANESPERSONALESDERETIRO("22","Planes personales de retiro"),
	INTERESESREALESDEDUCIBLESCREDITOSHIPOTECARIOS("23","Intereses reales deducibles por créditos hipotecarios"),
	OPERACIONESFINANCIERASDERIVADASDECAPITAL("24","Operaciones Financieras Derivadas de Capital"),
	OTROS("25","Otro tipo de retenciones"),
	
	
	;
	
	final String idSat;
	final String descripcion;
	
	
	
	ClavesRetenciones(final String idsat,String descripcion){
		this.idSat=idsat;
		this.descripcion=descripcion;

	}
	
	
	/**
	 * Busca una clave de retencion de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return clavesRetenciones valor del enum de acuerdo a la clave de retencion
	 */
	public static ClavesRetenciones id(String idSat) {
		for(ClavesRetenciones m:values()){
			if(m.idSat.equalsIgnoreCase(idSat))
				return m;
		}
		return null;
	}

	public static ClavesRetenciones busca(String metodo) {
		for(ClavesRetenciones m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
			
		}
		return null;
	}


	
	public static ClavesRetenciones unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final ClavesRetenciones estado =  ClavesRetenciones.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La clave de retención "+metodo+" no se encuentra en el catálogo de claves de retención del SAT ");
		else
			return estado;
	}
	
	
	public static String marshall(ClavesRetenciones v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static void main(String[] args){
		for(ClavesRetenciones c:values()){
			System.out.println(c.idSat);
		}
		System.out.println();
		for(ClavesRetenciones c:values()){
			System.out.println(c.descripcion);
		}
	}
	@Override
	public String getIdString() {
		return idSat;
	}
}
