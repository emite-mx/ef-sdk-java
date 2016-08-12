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
	
	GENERALDELEYPERSONASMORALES(601,"General de Ley Personas Morales"),
	PERSONASMORALESCONFINESNOLUCRATIVOS(603,"Personas Morales con Fines no Lucrativos"),
	SUELDOSYSALARIOSEINGRESOSASIMILADOSASALARIOS(605,"Sueldos y Salarios e Ingresos Asimilados a Salarios"),
	ARRENDAMIENTO(606,"Arrendamiento"),
	DEMASINGRESOS(608,"Demás ingresos"),
	CONSOLIDACION(609,"Consolidación"),
	RESIDENTESENELEXTRANJEROSINESTABLECIMIENTOPERMANENTEENMEXICO(610,"Residentes en el Extranjero sin Establecimiento Permanente en México"),
	INGRESOSPORDIVIDENDOSSOCIOSYACCIONISTAS(611,"Ingresos por Dividendos (socios y accionistas)"),
	PERSONASFISICASCONACTIVIDADESEMPRESARIALESYPROFESIONALES(612,"Personas Fisicas con Actividades Empresariales y Profesionales"),
	INGRESOSPORINTERESES(614,"Ingresos por intereses"),
	SINOBLIGACIONESFISCALES(616,"Sin obligaciones fiscales"),
	SOCIEDADESCOOPERATIVASDEPRODUCCIONQUEOPTANPORDIFERIRSUSINGRESOS(620,"Sociedades Cooperativas de Producción que optan por diferir sus ingresos"),
	INCORPORACIONFISCAL(621,"Incorporación Fiscal"),
	ACTIVIDADESAGRICOLASGANADERASSILVICOLASYPESQUERAS(622,"Actividades Agrícolas, Ganaderas, Silvícolas y Pesqueras"),
	OPCIONALPARAGRUPOSDESOCIEDADES(623,"Opcional para Grupos de Sociedades"),
	COORDINADOS(624,"Coordinados"),
	;
	
	final Integer idSat;
	final String descripcion;
	
	
	RegimenesFiscales(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
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
	
}
