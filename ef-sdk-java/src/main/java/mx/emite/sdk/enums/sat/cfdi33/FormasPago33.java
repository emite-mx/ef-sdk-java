package mx.emite.sdk.enums.sat.cfdi33;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Getter
public enum FormasPago33 implements Sat<String>{
	
	
	EFECTIVO("01","Efectivo",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	CHEQUENOMINATIVO("02","Cheque nominativo",Boolean.TRUE,null,null,null,"[0-9]{11}|[0-9]{18}",null,null,"[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}",Boolean.FALSE,Boolean.TRUE),
	TRANSFERENCIAELECTRONICADEFONDOS("03","Transferencia electrónica de fondos",Boolean.TRUE,null,null,null,"[0-9]{10}|[0-9]{16}|[0-9]{18}",null,null,"[0-9]{10}|[0-9]{18}",null,Boolean.TRUE),
	TARJETADECREDITO("04","Tarjeta de crédito",Boolean.TRUE,null,null,null,"[0-9]{16}",null,null,"[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}",Boolean.FALSE,Boolean.TRUE),
	MONEDEROELECTRONICO("05","Monedero electrónico",Boolean.TRUE,null,null,null,"[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}",null,null,"[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}",Boolean.FALSE,Boolean.FALSE),
	DINEROELECTRONICO("06","Dinero electrónico",Boolean.TRUE,null,null,null,"[0-9]{10}",Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	VALESDEDESPENSA("08","Vales de despensa",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	DACIONENPAGO("12","Dación en pago",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	PAGOPORSUBROGACION("13","Pago por subrogación",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	PAGOPORCONSIGNACION("14","Pago por consignación",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	CONDONACION("15","Condonación",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	COMPENSACION("17","Compensación",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	NOVACION("23","Novación",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	CONFUSION("24","Confusión",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	REMISIONDEDEUDA("25","Remisión de deuda",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	PRESCRIPCIONOCADUCIDAD("26","Prescripción o caducidad",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	ASATISFACCIONDELACREEDOR("27","A satisfacción del acreedor",Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE,null,Boolean.FALSE,Boolean.FALSE),
	TARJETADEDEBITO("28","Tarjeta de débito",Boolean.TRUE,null,null,null,"[0-9]{16}",null,null,"[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}",Boolean.FALSE,Boolean.TRUE),
	TARJETADESERVICIOS("29","Tarjeta de servicios",Boolean.TRUE,null,null,null,"[0-9]{15,16}",null,null,"[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}",Boolean.FALSE,Boolean.TRUE),
	PORDEFINIR("99","Por definir",null,null,null,null,null,null,null,null,null,null),
	
	;
	
	
	final String idSat;
	final String descripcion;
	final Boolean bancarizado;
	final Boolean numeroOperacion;
	final Boolean rfcEmisorOrdenante;
	final Boolean cuentaOrdenante;
	final String patronOrdenante;
	final Boolean rfcEmisorBeneficiario;
	final Boolean cuentaBeneficiario;
	final String patronBeneficiario;
	final Boolean tipoCadenaPago;
	final Boolean nombreBancoEmisor;
	
	FormasPago33(String idSat,String descripcion,Boolean bancarizado,Boolean numeroOperacion,Boolean rfcEmisorOrdenante,Boolean cuentaOrdenante,String patronOrdenante,Boolean rfcEmisorBeneficiario,Boolean cuentaBeneficiario,String patronBeneficiario,Boolean tipoCadenaPago,Boolean nombreBancoEmisor){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.bancarizado=bancarizado;
		this.numeroOperacion=numeroOperacion;
		this.rfcEmisorOrdenante=rfcEmisorOrdenante;
		this.cuentaOrdenante=cuentaOrdenante;
		this.patronOrdenante=patronOrdenante;
		this.rfcEmisorBeneficiario=rfcEmisorBeneficiario;
		this.cuentaBeneficiario=cuentaBeneficiario;
		this.patronBeneficiario=patronBeneficiario;
		this.tipoCadenaPago=tipoCadenaPago;
		this.nombreBancoEmisor=nombreBancoEmisor;
	}

	public static FormasPago33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final FormasPago33 estado =  FormasPago33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La FormaPago  "+metodo+" no se encuentra en el catálogo de formas de pago del SAT");
		else
			return estado;
	}

	private static FormasPago33 busca(String metodo) {
		for(FormasPago33 it:values()){
			if(it.getIdSat().equals(metodo))
				return it;
		}
		return null;
	}

	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static String marshall(FormasPago33 v) throws Exception {
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
	
	/*
		
	
	
	
	
	private String getIdSatString(){
		return marshall();
	}
	
	

	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(FormasPago33::getIdSatString).collect(Collectors.toList());		
	}
	*/
	
}
