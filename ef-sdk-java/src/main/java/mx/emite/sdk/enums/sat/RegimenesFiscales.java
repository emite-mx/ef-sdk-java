package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum RegimenesFiscales implements Sat{
	
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
		for(RegimenesFiscales m:values()){
			if(Utilerias.compara(m.descripcion,descripcion))
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
	
}
