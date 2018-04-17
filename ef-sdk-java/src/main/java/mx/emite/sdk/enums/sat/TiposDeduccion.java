package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposDeduccion implements Sat<String>{
	
	IMSS("001","Seguridad social"),
	ISR("002","ISR"),
	APORTACIONESARETIROCESANTIAYVEJEZ("003","Aportaciones a retiro, cesantía en edad avanzada y vejez."),
	OTROS("004","Otros"),
	APORTACIONESAFONDODEVIVIENDA("005","Aportaciones a Fondo de vivienda"),
	DESCUENTOPORINCAPACIDAD("006","Descuento por incapacidad"),
	PENSIONALIMENTICIA("007","Pensión alimenticia"),
	RENTA("008","Renta"),
	PRESTAMOSINFONAVIT("009","Préstamos provenientes del Fondo Nacional de la Vivienda para los Trabajadores"),
	PAGOPORCREDITODEVIVIENDA("010","Pago por crédito de vivienda"),
	PAGODEABONOSINFONACOT("011","Pago de abonos INFONACOT"),
	ANTICIPODESALARIOS("012","Anticipo de salarios"),
	PAGOSHECHOSCONEXCESOALTRABAJADOR("013","Pagos hechos con exceso al trabajador"),
	ERRORES("014","Errores"),
	PERDIDAS("015","Pérdidas"),
	AVERIAS("016","Averías"),
	ADQUISICIONDEARTICULOSPRODUCIDOSPORLAEMPRESA("017","Adquisición de artículos producidos por la empresa o establecimiento"),
	CUOTASDECAJASDEAHORRO("018","Cuotas para la constitución y fomento de sociedades cooperativas y de cajas de ahorro"),
	CUOTASSINDICALES("019","Cuotas sindicales"),
	AUSENCIA("020","Ausencia (Ausentismo)"),
	CUOTASOBREROPATRONALES("021","Cuotas obrero patronales"),
	IMPUESTOSLOCALES("022","Impuestos Locales"),
	APORTACIONESVOLUNTARIAS("023","Aportaciones voluntarias"),
	AJUSTEENGRATIFICACIONANUALEXENTO("024","Ajuste en Gratificación Anual (Aguinaldo) Exento"),
	AJUSTEENGRATIFICACIONANUALGRAVADO("025","Ajuste en Gratificación Anual (Aguinaldo) Gravado"),
	AJUSTEENPARDELOSTRABENLASUTILIDADESPTUEXENTO("026","Ajuste en Participación de los Trabajadores en las Utilidades PTU Exento"),
	AJUSTEENPARDELOSTRABENLASUTILIDADESPTUGRAVADO("027","Ajuste en Participación de los Trabajadores en las Utilidades PTU Gravado"),
	AJUSTEENREEMBOLSODEGASTOSMEDICOSEXENTO("028","Ajuste en Reembolso de Gastos Médicos Dentales y Hospitalarios Exento"),
	AJUSTEENFONDODEAHORROEXENTO("029","Ajuste en Fondo de ahorro Exento"),
	AJUSTEENCAJADEAHORROEXENTO("030","Ajuste en Caja de ahorro Exento"),
	AJUSTEENCONTRIBACARGODELTRABPAGPORELPATEXENTO("031","Ajuste en Contribuciones a Cargo del Trabajador Pagadas por el Patrón Exento"),
	AJUSTEENPREMIOSPORPUNTUALIDADGRAVADO("032","Ajuste en Premios por puntualidad Gravado"),
	AJUSTEENPRIMADESEGURODEVIDAEXENTO("033","Ajuste en Prima de Seguro de vida Exento"),
	AJUSTEENSEGURODEGASTOSMÉDICOSMAYORESEXENTO("034","Ajuste en Seguro de Gastos Médicos Mayores Exento"),
	AJUSTEENCUOTASSINDICALESPAGADASPORELPATRONEXENTO("035","Ajuste en Cuotas Sindicales Pagadas por el Patrón Exento"),
	AJUSTEENSUBSIDIOSPORINCAPACIDADEXENTO("036","Ajuste en Subsidios por incapacidad Exento"),
	AJUSTEENBECASPARATRABAJADORESYOHIJOSEXENTO("037","Ajuste en Becas para trabajadores y/o hijos Exento"),
	AJUSTEENHORASEXTRAEXENTO("038","Ajuste en Horas extra Exento"),
	AJUSTEENHORASEXTRAGRAVADO("039","Ajuste en Horas extra Gravado"),
	AJUSTEENPRIMADOMINICALEXENTO("040","Ajuste en Prima dominical Exento"),
	AJUSTEENPRIMADOMINICALGRAVADO("041","Ajuste en Prima dominical Gravado"),
	AJUSTEENPRIMAVACACIONALEXENTO("042","Ajuste en Prima vacacional Exento"),
	AJUSTEENPRIMAVACACIONALGRAVADO("043","Ajuste en Prima vacacional Gravado"),
	AJUSTEENPRIMAPORANTIGUEDADEXENTO("044","Ajuste en Prima por antigüedad Exento"),
	AJUSTEENPRIMAPORANTIGUEDADGRAVADO("045","Ajuste en Prima por antigüedad Gravado"),
	AJUSTEENPAGOSPORSEPARACIONEXENTO("046","Ajuste en Pagos por separación Exento"),
	AJUSTEENPAGOSPORSEPARACIONGRAVADO("047","Ajuste en Pagos por separación Gravado"),
	AJUSTEENSEGURODERETIROEXENTO("048","Ajuste en Seguro de retiro Exento"),
	AJUSTEENINDEMNIZACIONESEXENTO("049","Ajuste en Indemnizaciones Exento"),
	AJUSTEENINDEMNIZACIONESGRAVADO("050","Ajuste en Indemnizaciones Gravado"),
	AJUSTEENREEMBOLSOPORFUNERALEXENTO("051","Ajuste en Reembolso por funeral Exento"),
	AJUSTEENCUOTASDESEGURIDADSOCIALPAGADASPORELPATRONEXENTO("052","Ajuste en Cuotas de seguridad social pagadas por el patrón Exento"),
	AJUSTEENCOMISIONESGRAVADO("053","Ajuste en Comisiones Gravado"),
	AJUSTEENVALESDEDESPENSAEXENTO("054","Ajuste en Vales de despensa Exento"),
	AJUSTEENVALESDERESTAURANTEEXENTO("055","Ajuste en Vales de restaurante Exento"),
	AJUSTEENVALESDEGASOLINAEXENTO("056","Ajuste en Vales de gasolina Exento"),
	AJUSTEENVALESDEROPAEXENTO("057","Ajuste en Vales de ropa Exento"),
	AJUSTEENAYUDAPARARENTAEXENTO("058","Ajuste en Ayuda para renta Exento"),
	AJUSTEENAYUDAPARAARTICULOSESCOLARESEXENTO("059","Ajuste en Ayuda para artículos escolares Exento"),
	AJUSTEENAYUDAPARAANTEOJOSEXENTO("060","Ajuste en Ayuda para anteojos Exento"),
	AJUSTEENAYUDAPARATRANSPORTEEXENTO("061","Ajuste en Ayuda para transporte Exento"),
	AJUSTEENAYUDAPARAGASTOSDEFUNERALEXENTO("062","Ajuste en Ayuda para gastos de funeral Exento"),
	AJUSTEENOTROSINGRESOSPORSALARIOSEXENTO("063","Ajuste en Otros ingresos por salarios Exento"),
	AJUSTEENOTROSINGRESOSPORSALARIOSGRAVADO("064","Ajuste en Otros ingresos por salarios Gravado"),
	AJUSTEENJUBILACIONESPENSIONESOHABERESDERETIROEXENTO("065","Ajuste en Jubilaciones, pensiones o haberes de retiro Exento"),
	AJUSTEENJUBILACIONESPENSIONESOHABERESDERETIROGRAVADO("066","Ajuste en Jubilaciones, pensiones o haberes de retiro Gravado"),
	AJUSTEENPAGOSPORSEPARACIONACUMULABLE("067","Ajuste en Pagos por separación Acumulable"),
	AJUSTEENPAGOSPORSEPARACIONNOACUMULABLE("068","Ajuste en Pagos por separación No acumulable"),
	AJUSTEENJUBILACIONESPENSIONESOHABERESDERETIROACUMULABLE("069","Ajuste en Jubilaciones, pensiones o haberes de retiro Acumulable"),
	AJUSTEENJUBILACIONESPENSIONESOHABERESDERETIRONOACUMULABLE("070","Ajuste en Jubilaciones, pensiones o haberes de retiro No acumulable"),
	AJUSTEENSUBSIDIOPARAELEMPLEO("071","Ajuste en Subsidio para el empleo (efectivamente entregado al trabajador)"),
	AJUSTEENINGRESOSENACCIONESOTITULOSVALORQUEREPRESENTANBIENESEXENTO("072","Ajuste en Ingresos en acciones o títulos valor que representan bienes Exento"),
	AJUSTEENINGRESOSENACCIONESOTITULOSVALORQUEREPRESENTANBIENESGRAVADO("073","Ajuste en Ingresos en acciones o títulos valor que representan bienes Gravado"),
	AJUSTEENALIMENTACIONEXENTO("074","Ajuste en Alimentación Exento"),
	AJUSTEENALIMENTACIONGRAVADO("075","Ajuste en Alimentación Gravado"),
	AJUSTEENHABITACIONEXENTO("076","Ajuste en Habitación Exento"),
	AJUSTEENHABITACIONGRAVADO("077","Ajuste en Habitación Gravado"),
	AJUSTEENPREMIOSPORASISTENCIA("078","Ajuste en Premios por asistencia"),
	AJUSTEENPAGOSDISTINTOSALOSLISTADOSYQUENODEBENCONSIDERARSECOMOINGRESOPORSUELDOS("079","Ajuste en Pagos distintos a los listados y que no deben considerarse como ingreso por sueldos, salarios o ingresos asimilados."),
	AJUSTEENVIATICOSNOCOMPROBADOS("080","Ajuste en Viáticos no comprobados"),
	AJUSTEENVIATICOSANTICIPADOS("081","Ajuste en Viáticos anticipados"),
	AJUSTEENFONDODEAHORROGRAVADO("082","Ajuste en Fondo de ahorro Gravado"),
	AJUSTEENCAJADEAHORROGRAVADO("083","Ajuste en Caja de ahorro Gravado"),
	AJUSTEENPRIMADESEGURODEVIDAGRAVADO("084","Ajuste en Prima de Seguro de vida Gravado"),
	AJUSTEENSEGURODEGASTOSMEDICOSMAYORESGRAVADO("085","Ajuste en Seguro de Gastos Médicos Mayores Gravado"),
	AJUSTEENSUBSIDIOSPORINCAPACIDADGRAVADO("086","Ajuste en Subsidios por incapacidad Gravado"),
	AJUSTEENBECASPARATRABAJADORESYOHIJOSGRAVADO("087","Ajuste en Becas para trabajadores y/o hijos Gravado"),
	AJUSTEENSEGURODERETIROGRAVADO("088","Ajuste en Seguro de retiro Gravado"),
	AJUSTEENVALESDEDESPENSAGRAVADO("089","Ajuste en Vales de despensa Gravado"),
	AJUSTEENVALESDERESTAURANTEGRAVADO("090","Ajuste en Vales de restaurante Gravado"),
	AJUSTEENVALESDEGASOLINAGRAVADO("091","Ajuste en Vales de gasolina Gravado"),
	AJUSTEENVALESDEROPAGRAVADO("092","Ajuste en Vales de ropa Gravado"),
	AJUSTEENAYUDAPARARENTAGRAVADO("093","Ajuste en Ayuda para renta Gravado"),
	AJUSTEENAYUDAPARAARTICULOSESCOLARESGRAVADO("094","Ajuste en Ayuda para artículos escolares Gravado"),
	AJUSTEENAYUDAPARAANTEOJOSGRAVADO("095","Ajuste en Ayuda para anteojos Gravado"),
	AJUSTEENAYUDAPARATRANSPORTEGRAVADO("096","Ajuste en Ayuda para transporte Gravado"),
	AJUSTEENAYUDAPARAGASTOSDEFUNERALGRAVADO("097","Ajuste en Ayuda para gastos de funeral Gravado"),
	AJUSTEAINGRESOSASIMILADOSASALARIOSGRAVADOS("098","Ajuste a ingresos asimilados a salarios gravados"),
	AJUSTEAINGRESOSPORSUELDOSYSALARIOSGRAVADOS("099","Ajuste a ingresos por sueldos y salarios gravados"),
	AJUSTEAVIATICOSEXENTOS("100","Ajuste en Viáticos Exentos"),
	ISRANTERIOR("101","ISR Retenido de ejercicio anterior")
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposDeduccion(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposDeduccion(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}
	
	public static void main(String[] args){
		int indice=65;
		for(TiposDeduccion p:values()){
			int clave = Integer.parseInt(p.getClave());
			
			if(clave>21){
				System.out.println("insert into h_sat_nomina values("+(indice++)+",'"+p.getClave()+"','"+p.getDescripcion()+"',0,0,0,'D',null);");
			}
			
		}
	}

	public static TiposDeduccion busca(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		for(TiposDeduccion m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
			else if(m.sinonimos!=null){
				for(String s:m.sinonimos){
					if(Utilerias.compara(s,metodo))
						return m;
				}
			}
		}
		return null;
	}
	
	public static TiposDeduccion unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposDeduccion estado =  TiposDeduccion.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de deducción "+metodo+" no se encuentra en el catálogo de Tipos de Deducciones del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposDeduccion v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public boolean in(TiposDeduccion... tipos){
		for(TiposDeduccion t:tipos){
			if(this.equals(t)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean notin(TiposDeduccion... tipos){
		return !in(tipos);
	}
	

	public String getClave() {
		return idSat;
	}
	public String getConcepto() {
		return descripcion;
	}
	
	public boolean esIsr(){
		return this.equals(ISR);
	}

	public boolean esIncapacidad() {
		return this.equals(DESCUENTOPORINCAPACIDAD);
	}
	@Override
	public String getIdString() {
		return idSat;
	}
}
