package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposPercepcion12 implements Sat<String>{
	
	SUELDOSSALARIOSRAYASYJORNALES("001","Sueldos, Salarios  Rayas y Jornales",TIPOPERCEPCION.SUELDOS),
	AGUINALDO("002","Gratificación Anual (Aguinaldo)",TIPOPERCEPCION.SUELDOS),
	PTU("003","Participación de los Trabajadores en las Utilidades PTU",TIPOPERCEPCION.SUELDOS),
	REEMBOLSODEGASTOSMEDICOSYHOSPITALARIOS("004","Reembolso de Gastos Médicos Dentales y Hospitalarios",TIPOPERCEPCION.SUELDOS),
	FONDODEAHORRO("005","Fondo de Ahorro",TIPOPERCEPCION.SUELDOS),
	CAJADEAHORRO("006","Caja de ahorro",TIPOPERCEPCION.SUELDOS),
	CONTRIBUCIONESACARGODELTRABAJADORPAGADASPORELPATRON("009","Contribuciones a Cargo del Trabajador Pagadas por el Patrón",TIPOPERCEPCION.SUELDOS),
	PREMIOSPORPUNTUALIDAD("010","Premios por puntualidad",TIPOPERCEPCION.SUELDOS),
	PRIMADESEGURODEVIDA("011","Prima de Seguro de vida",TIPOPERCEPCION.SUELDOS),
	SEGURODEGASTOSMEDICOSMAYORES("012","Seguro de Gastos Médicos Mayores",TIPOPERCEPCION.SUELDOS),
	CUOTASSINDICALESPAGADASPORELPATRON("013","Cuotas Sindicales Pagadas por el Patrón",TIPOPERCEPCION.SUELDOS),
	SUBSIDIOSPORINCAPACIDAD("014","Subsidios por incapacidad",TIPOPERCEPCION.SUELDOS),
	BECASTRABAJADORESHIJOS("015","Becas para trabajadores y/o hijos",TIPOPERCEPCION.SUELDOS),
	//OTROS("016","Otros",TIPOPERCEPCION.SUELDOS),
	//SUBSIDIOPARAELEMPLEO("017","Subsidio para el empleo"),
	HORASEXTRA("019","Horas extra",TIPOPERCEPCION.SUELDOS),
	PRIMADOMINICAL("020","Prima dominical",TIPOPERCEPCION.SUELDOS),
	PRIMAVACACIONAL("021","Prima vacacional",TIPOPERCEPCION.SUELDOS),
	PRIMAANTIGUEDAD("022","Prima por antigüedad",TIPOPERCEPCION.SEPARACIONINDEMNIZACION),
	PAGOSSEPARACION("023","Pagos por separación",TIPOPERCEPCION.SEPARACIONINDEMNIZACION),
	SEGURODERETIRO("024","Seguro de retiro",TIPOPERCEPCION.SUELDOS),
	INDEMNIZACIONES("025","Indemnizaciones",TIPOPERCEPCION.SEPARACIONINDEMNIZACION),
	REEMBOLSOPORFUNERAL("026","Reembolso por funeral",TIPOPERCEPCION.SUELDOS),
	CUOTASDESEGURIDADSOCIAL("027","Cuotas de seguridad social pagadas por el patrón",TIPOPERCEPCION.SUELDOS),
	COMISIONES("028","Comisiones",TIPOPERCEPCION.SUELDOS),
	VALESDEDESPENSA("029","Vales de despensa",TIPOPERCEPCION.SUELDOS),
	VALESDERESTAURANTE("030","Vales de restaurante",TIPOPERCEPCION.SUELDOS),
	VALESDEGASOLINA("031","Vales de gasolina",TIPOPERCEPCION.SUELDOS),
	VALESDEROPA("032","Vales de ropa",TIPOPERCEPCION.SUELDOS),
	AYUDAPARARENTA("033","Ayuda para renta",TIPOPERCEPCION.SUELDOS),
	AYUDAPARAARTICULOSESCOLARES("034","Ayuda para artículos escolares",TIPOPERCEPCION.SUELDOS),
	AYUDAPARAANTEOJOS("035","Ayuda para anteojos",TIPOPERCEPCION.SUELDOS),
	AYUDAPARATRANSPORTE("036","Ayuda para transporte",TIPOPERCEPCION.SUELDOS),
	AYUDAPARAGASTOSDEFUNERAL("037","Ayuda para gastos de funeral",TIPOPERCEPCION.SUELDOS),
	OTROSINGRESOSPORSALARIOS("038","Otros ingresos por salarios",TIPOPERCEPCION.SUELDOS),
	JUBILACIONESPENSIONESHABERESDERETIRO("039","Jubilaciones, pensiones o haberes de retiro",TIPOPERCEPCION.JUBILACION),
	//INGRESOPAGADOPORENTIDADESFEDERATIVASCONINGRESOSPROPIOS("040","Ingreso pagado por Entidades federativas, municipios, o demarcaciones territoriales del Distrito Federal, organismos autónomos y entidades paraestatales y paramunicipales  con ingresos propios."),
	//INGRESOPORENTIDADESFEDERATIVASCONINGRESOSFEDERALES("041","Ingreso por Entidades federativas, municipios, o demarcaciones territoriales   del   Distrito  Federal,  organismos autónomos  y  entidades paraestatales y paramunicipales con ingresos federales."),
	//INGRESOPAGADOPORENTIDADESFEDERATIVASCONINGRESOSPROPIOSYFEDERALES("042","Ingreso pagado por Entidades federativas, municipios, o demarcaciones territoriales del Distrito Federal, organismos autónomos y entidades paraestatales y paramunicipales con ingresos propios y federales."),
	//VIATICOSYGASTOSDEVIAJE("043","Viáticos y Gastos de Viaje"),
	JUBILACIONESPENSIONESOHABERESDERETIROENPARCIALIDADES("044","Jubilaciones, pensiones o haberes de retiro en parcialidades",TIPOPERCEPCION.JUBILACION),
	INGRESOSENACCIONESOTITULOSVALORQUEREPRESENTANBIENES("045","Ingresos en acciones o títulos valor que representan bienes",TIPOPERCEPCION.SUELDOS),
	ASIMILADOSASALARIOS("046","Ingresos asimilados a salarios",TIPOPERCEPCION.SUELDOS),
	ALIMENTACION("047","Alimentación",TIPOPERCEPCION.SUELDOS),
	HABITACION("048","Habitación",TIPOPERCEPCION.SUELDOS),
	PREMIOSASISTENCIA("049","Premios por asistencia",TIPOPERCEPCION.SUELDOS),
	VIATICOS("050","Viáticos",TIPOPERCEPCION.SUELDOS),
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	final TIPOPERCEPCION tipo;
	
	TiposPercepcion12(String idSat,String descripcion,TIPOPERCEPCION tipo){
		this(idSat,descripcion,null,tipo);
	}
	
	TiposPercepcion12(String idSat,String descripcion,String[] sinonimos,TIPOPERCEPCION tipo){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		this.tipo=tipo;
		
	}
	
	public static void main(String[] args){
		for(TiposPercepcion12 p:values()){
			System.out.println("update h_sat_nomina set tipopercepcion='"+p.getTipo().getAbrevia()+"' where clave_sat='"+p.getClave()+"' and tipoconcepto='P';");
			
			
		}
	}

	public static TiposPercepcion12 busca(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		
		for(TiposPercepcion12 m:values()){
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
	
	public static TiposPercepcion12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposPercepcion12 estado =  TiposPercepcion12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de percepción "+metodo+" no se encuentra en el catálogo de Tipos de Percepciones del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposPercepcion12 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public String getClave() {
		return idSat;
	}
	public String getConcepto() {
		return descripcion;
	}
	
	public boolean esSueldo(){
		return this.tipo.equals(TIPOPERCEPCION.SUELDOS);
	}
	
	public boolean llevaTotalSueldo(){
		return this.tipo.equals(TIPOPERCEPCION.SUELDOS);
	}
	
	public boolean esSeparacionIndemnizacion(){
		return this.tipo.equals(TIPOPERCEPCION.SEPARACIONINDEMNIZACION);
	}
	
	public boolean esJubilacion(){
		return this.tipo.equals(TIPOPERCEPCION.JUBILACION);
	}
	
	public boolean esJubilacionUnaExhibicion(){
		return this.equals(JUBILACIONESPENSIONESHABERESDERETIRO);
	}
	
	public boolean esJubilacionParcialidades(){
		return this.equals(JUBILACIONESPENSIONESOHABERESDERETIROENPARCIALIDADES);
	}
	
	public static enum TIPOPERCEPCION{
		SUELDOS("S"),SEPARACIONINDEMNIZACION("I"),JUBILACION("J");
		
		@Getter final String abrevia;
		TIPOPERCEPCION(String abrevia){
			this.abrevia=abrevia;
		}
	}

	public boolean esAcciones() {
		return this.equals(INGRESOSENACCIONESOTITULOSVALORQUEREPRESENTANBIENES);
	}
	
	public boolean esHorasExtra() {
		return this.equals(HORASEXTRA);
	}
	
	public boolean esIncapacidad() {
		return this.equals(SUBSIDIOSPORINCAPACIDAD);
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}

	public static TiposPercepcion12 idSat(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		
		for(TiposPercepcion12 m:values()){
			if(StringUtils.equals(m.idSat, metodo))
				return m;
			
		}
		return null;
	}
}
