package mx.emite.sdk.enums.sat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum RegimenesFiscales implements Sat<Integer>{
	
	GENERALDELEYPERSONASMORALES(601,"General de Ley Personas Morales",false,true),
	PERSONASMORALESCONFINESNOLUCRATIVOS(603,"Personas Morales con Fines no Lucrativos",false,true),
	SUELDOSYSALARIOSEINGRESOSASIMILADOSASALARIOS(605,"Sueldos y Salarios e Ingresos Asimilados a Salarios",true,false),
	ARRENDAMIENTO(606,"Arrendamiento",true,false),
	DEMASINGRESOS(608,"Demás ingresos",true,false),
	CONSOLIDACION(609,"Consolidación",false,true),
	RESIDENTESENELEXTRANJEROSINESTABLECIMIENTOPERMANENTEENMEXICO(610,"Residentes en el Extranjero sin Establecimiento Permanente en México",true,false),
	INGRESOSPORDIVIDENDOSSOCIOSYACCIONISTAS(611,"Ingresos por Dividendos (socios y accionistas)",true,false),
	PERSONASFISICASCONACTIVIDADESEMPRESARIALESYPROFESIONALES(612,"Personas Fisicas con Actividades Empresariales y Profesionales",true,false),
	INGRESOSPORINTERESES(614,"Ingresos por intereses",true,false),
	SINOBLIGACIONESFISCALES(616,"Sin obligaciones fiscales",true,false),
	SOCIEDADESCOOPERATIVASDEPRODUCCIONQUEOPTANPORDIFERIRSUSINGRESOS(620,"Sociedades Cooperativas de Producción que optan por diferir sus ingresos",false,false),
	INCORPORACIONFISCAL(621,"Incorporación Fiscal",true,false),
	ACTIVIDADESAGRICOLASGANADERASSILVICOLASYPESQUERAS(622,"Actividades Agrícolas, Ganaderas, Silvícolas y Pesqueras",true,true),
	OPCIONALPARAGRUPOSDESOCIEDADES(623,"Opcional para Grupos de Sociedades",false,true),
	COORDINADOS(624,"Coordinados",false,true),
	ENAJENACIONBIENES(607,"Régimen de Enajenación o Adquisición de Bienes",false,true),
	PREMIOS(615,"Régimen de los ingresos por obtención de premios",true,false),
	;
	
	final Integer idSat;
	final String descripcion;
	final Boolean fisicas,morales;
	
	RegimenesFiscales(Integer idSat,String descripcion,Boolean fisicas,Boolean morales){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.fisicas=fisicas;
		this.morales=morales;
	}

	/**
	 * Busca un regimen de acuerdo a su descripción
	 * @param descripcion de acuerdo al catalogo del SAT
	 * @return RegimenesFiscales valor del enum de acuerdo al regimen
	 */
	public static RegimenesFiscales busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		if(StringUtils.startsWithIgnoreCase(descripcion,"regimen ")||StringUtils.startsWithIgnoreCase(descripcion,"régimen "))
			descripcion = descripcion.substring(8);
		if(StringUtils.startsWithIgnoreCase(descripcion,"regimen de ")||StringUtils.startsWithIgnoreCase(descripcion,"régimen de "))
			descripcion = descripcion.substring(11);
		for(RegimenesFiscales m:values()){
			if(Utilerias.compara(m.descripcion,descripcion))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),descripcion))
				return m;
		}
		return null;
	}
	
	/**
	 * Busca un regimen de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return RegimenesFiscales valor del enum de acuerdo al regimen
	 */
	public static RegimenesFiscales id(Integer idSat) {
		for(RegimenesFiscales m:values()){
			if(m.idSat.equals(idSat))
				return m;
		}
		return null;
	}
	
	public Integer getIdRegimen(){
		return idSat;
	}

	public static RegimenesFiscales[] regimenes() {
		return values();
	}
	
	public static RegimenesFiscales unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final RegimenesFiscales estado =  RegimenesFiscales.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El régimen "+metodo+" no se encuentra en el catálogo de regimenes del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(RegimenesFiscales v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static String marshallIdSat(RegimenesFiscales v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat().toString();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static boolean existe(Integer idSat) {
		for(RegimenesFiscales reg:values()){
			if(reg.getIdSat().equals(idSat))
				return true;
		}
		return false;
	}

	public static List<Integer> ids() {
		return Arrays.asList(values()).stream().map(RegimenesFiscales::getIdSat).collect(Collectors.toList());		
	}

	public static boolean existe(String emisorRegimen) {
		try{
			return existe(Integer.parseInt(emisorRegimen));
		}
		catch(Exception ex){
			return false;
		}
	}
	
	public static RegimenesFiscales getRegimen(String emisorRegimen) {
		try{
		final Integer id = Integer.parseInt(emisorRegimen);
		for(RegimenesFiscales reg:values()){
			if(reg.getIdSat().equals(id))
				return reg;
		}
		return null;
		}
		catch(Exception ex){
			return null;
		}
	}
	
}
