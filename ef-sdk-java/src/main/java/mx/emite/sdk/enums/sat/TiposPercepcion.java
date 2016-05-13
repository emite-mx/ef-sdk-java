package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposPercepcion implements Sat{
	
	SUELDOSSALARIOSRAYASYJORNALES("001","Sueldos, Salarios  Rayas y Jornales"),
	AGUINALDO("002","Gratificación Anual (Aguinaldo)"),
	PTU("003","Participación de los Trabajadores en las Utilidades PTU"),
	REEMBOLSODEGASTOSMEDICOSYHOSPITALARIOS("004","Reembolso de Gastos Médicos Dentales y Hospitalarios"),
	FONDODEAHORRO("005","Fondo de Ahorro"),
	CAJADEAHORRO("006","Caja de ahorro"),
	CONTRIBUCIONESACARGODELTRABAJADORPAGADASPORELPATRON("009","Contribuciones a Cargo del Trabajador Pagadas por el Patrón"),
	PREMIOSPORPUNTUALIDAD("010","Premios por puntualidad"),
	PRIMADESEGURODEVIDA("011","Prima de Seguro de vida"),
	SEGURODEGASTOSMEDICOSMAYORES("012","Seguro de Gastos Médicos Mayores"),
	CUOTASSINDICALESPAGADASPORELPATRON("013","Cuotas Sindicales Pagadas por el Patrón"),
	SUBSIDIOSPORINCAPACIDAD("014","Subsidios por incapacidad"),
	BECASTRABAJADORESHIJOS("015","Becas para trabajadores y/o hijos"),
	OTROS("016","Otros"),
	SUBSIDIOPARAELEMPLEO("017","Subsidio para el empleo"),
	HORASEXTRA("019","Horas extra"),
	PRIMADOMINICAL("020","Prima dominical"),
	PRIMAVACACIONAL("021","Prima vacacional"),
	PRIMAANTIGUEDAD("022","Prima por antigüedad"),
	PAGOSSEPARACIÓN("023","Pagos por separación"),
	SEGURODERETIRO("024","Seguro de retiro"),
	INDEMNIZACIONES("025","Indemnizaciones"),
	REEMBOLSOPORFUNERAL("026","Reembolso por funeral"),
	CUOTASDESEGURIDADSOCIAL("027","Cuotas de seguridad social pagadas por el patrón"),
	COMISIONES("028","Comisiones"),
	VALESDEDESPENSA("029","Vales de despensa"),
	VALESDERESTAURANTE("030","Vales de restaurante"),
	VALESDEGASOLINA("031","Vales de gasolina"),
	VALESDEROPA("032","Vales de ropa"),
	AYUDAPARARENTA("033","Ayuda para renta"),
	AYUDAPARAARTICULOSESCOLARES("034","Ayuda para artículos escolares"),
	AYUDAPARAANTEOJOS("035","Ayuda para anteojos"),
	AYUDAPARATRANSPORTE("036","Ayuda para transporte"),
	AYUDAPARAGASTOSDEFUNERAL("037","Ayuda para gastos de funeral"),
	OTROSINGRESOSPORSALARIOS("038","Otros ingresos por salarios"),
	JUBILACIONESPENSIONESHABERESDERETIRO("039","Jubilaciones, pensiones o haberes de retiro"),
	INGRESOPAGADOPORENTIDADESFEDERATIVASCONINGRESOSPROPIOS("040","Ingreso pagado por Entidades federativas, municipios, o demarcaciones territoriales del Distrito Federal, organismos autónomos y entidades paraestatales y paramunicipales  con ingresos propios."),
	INGRESOPORENTIDADESFEDERATIVASCONINGRESOSFEDERALES("041","Ingreso por Entidades federativas, municipios, o demarcaciones territoriales   del   Distrito  Federal,  organismos autónomos  y  entidades paraestatales y paramunicipales con ingresos federales."),
	INGRESOPAGADOPORENTIDADESFEDERATIVASCONINGRESOSPROPIOSYFEDERALES("042","Ingreso pagado por Entidades federativas, municipios, o demarcaciones territoriales del Distrito Federal, organismos autónomos y entidades paraestatales y paramunicipales con ingresos propios y federales."),
	VIATICOSYGASTOSDEVIAJE("043","Viáticos y Gastos de Viaje"),
	JUBILACIONESPENSIONESOHABERESDERETIROENPARCIALIDADES("044","Jubilaciones, pensiones o haberes de retiro en parcialidades"),
	INGRESOSENACCIONESOTITULOSVALORQUEREPRESENTANBIENES("045","Ingresos en acciones o títulos valor que representan bienes"),
	
	
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposPercepcion(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposPercepcion(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposPercepcion busca(String metodo) {
		for(TiposPercepcion m:values()){
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
	
	public static TiposPercepcion unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposPercepcion estado =  TiposPercepcion.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de percepción "+metodo+" no se encuentra en el catálogo de Tipos de Percepciones del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposPercepcion v) throws Exception {
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
	
}
