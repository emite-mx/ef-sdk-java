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

	public static RegimenesFiscales busca(String metodo) {
		for(RegimenesFiscales m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
		}
		return null;
	}
	
}
