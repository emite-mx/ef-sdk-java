package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum EntidadesFederativas implements Sat<String>{
	
	AGUASCALIENTES("01","Aguascalientes"),
	BAJACALIFORNIA("02","Baja California"),
	BAJACALIFORNIASUR("03","Baja California Sur"),
	CAMPECHE("04","Campeche"),
	COAHUILA("05","Coahuila"),
	COLIMA("06","Colima"),
	CHIAPAS("07","Chiapas"),
	CHIHUAHUA("08","Chihuahua"),
	DISTRITOFEDERAL("09","Distrito Federal"),
	DURANGO("10","Durango"),
	GUANAJUATO("11","Guanajuato"),
	GUERRERO("12","Guerrero"),
	HIDALGO("13","Hidalgo"),
	JALISCO("14","Jalisco"),
	MEXICO("15","México"),
	MICHOACAN("16","Michoacán"),
	MORELOS("17","Morelos"),
	NAYARIT("18","Nayarit"),
	NUEVOLEON("19","Nuevo León"),
	OAXACA("20","Oaxaca"),
	PUEBLA("21","Puebla"),
	QUERETARO("22","Querétaro"),
	QUINTANAROO("23","Quintana Roo"),
	SANLUISPOTOSI("24","San Luis Potosí"),
	SINALOA("25","Sinaloa"),
	SONORA("26","Sonora"),
	TABASCO("27","Tabasco"),
	TAMAULIPAS("28","Tamaulipas"),
	TLAXCALA("29","Tlaxcala"),
	VERACRUZ("30","Veracruz"),
	YUCATAN("31","Yucatán"),
	ZACATECAS("32","Zacatecas"),
	 
	
	;
	
	final String idSat;
	final String descripcion;
	
	
	
	EntidadesFederativas(final String idsat,String descripcion){
		this.idSat=idsat;
		this.descripcion=descripcion;

	}
	
	
	/**
	 * Busca una unidad de medida de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return unidadesMedida valor del enum de acuerdo a la unidad de medida
	 */
	public static EntidadesFederativas id(String idSat) {
		for(EntidadesFederativas m:values()){
			if(m.idSat.equalsIgnoreCase(idSat))
				return m;
		}
		return null;
	}

	public static EntidadesFederativas busca(String metodo) {
		for(EntidadesFederativas m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
			
		}
		return null;
	}


	
	public static EntidadesFederativas unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final EntidadesFederativas estado =  EntidadesFederativas.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La entidad federativa "+metodo+" no se encuentra en el catálogo de entidades federativas del SAT ");
		else
			return estado;
	}
	
	
	public static String marshall(EntidadesFederativas v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
}
