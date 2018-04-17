package mx.emite.sdk.enums.sat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.cfdi33.FormasPago33;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum MetodosPago implements Sat<String>{
	
	EFECTIVO("01","Efectivo",FormasPago33.EFECTIVO),
	CHEQUE("02","Cheque nominativo",FormasPago33.CHEQUENOMINATIVO),
	TRANSFERENCIA("03","Transferencia electrónica de fondos",FormasPago33.TRANSFERENCIAELECTRONICADEFONDOS),
	TARJETASDECREDITO("04","Tarjetas de crédito",FormasPago33.TARJETADECREDITO),
	MONEDEROSELECTRONICOS("05","Monederos electrónicos",FormasPago33.MONEDEROELECTRONICO),
	DINEROELECTRONICO("06","Dinero electrónico",FormasPago33.DINEROELECTRONICO),
	
	VALESDEDESPENSA("08","Vales de despensa",FormasPago33.VALESDEDESPENSA),
	TARJETADEDEBITO("28","Tarjeta de Débito",FormasPago33.TARJETADEDEBITO),
	TARJETADESERVICIO("29","Tarjeta de Servicio",FormasPago33.TARJETADESERVICIOS),
	
	OTROS("99","Por Definir",new String[]{"Otros","No Identificado"},FormasPago33.PORDEFINIR),
	NA("NA","NA",FormasPago33.PORDEFINIR);
	
	//TARJETASDIGITALES(7,"Tarjetas digitales"),
	//BIENES(9,"Bienes"),
		//SERVICIO(10,"Servicio"),
		//PORCUENTADETERCERO(11,"Por cuenta de tercero"),
		//DACIONENPAGO(12,"Dación en pago"),
		//PAGOPORSUBROGACION(13,"Pago por subrogación"),
		//PAGOPORCONSIGNACION(14,"Pago por consignación"),
		//CONDONACION(15,"Condonación"),
		//CANCELACION(16,"Cancelación"),
		//COMPENSACION(17,"Compensación"),
		//NOAPLICA(98,"NA"),
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	final FormasPago33 formaPago;
	
	MetodosPago(String idSat,String descripcion,FormasPago33 formaPago){
		this(idSat,descripcion,null,formaPago);
	}
	
	MetodosPago(String idSat,String descripcion,String[] sinonimos,final FormasPago33 formaPago){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		this.formaPago=formaPago;
	}

	/**
	 * Busca una formapago de acuerdo a su descripción
	 * @param descripcion de acuerdo al catalogo del SAT
	 * @return FormasPago valor del enum de acuerdo a la forma de pago
	 */
	public static MetodosPago busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		for(MetodosPago m:values()){
			final Integer clavedesc = sacaInt(descripcion);
			if(clavedesc!=null){
				if(m.idSat.equals(descripcion)){
					return m;
				}
			}
			if(Utilerias.compara(m.descripcion,descripcion))
				return m;
			
			else if(m.sinonimos!=null){
				for(String s:m.sinonimos){
					if(Utilerias.compara(s,descripcion))
						return m;
				}
			}
		}
		return null;
	}
	
	public static MetodosPago buscaSinNulo(String descripcion) {
		final MetodosPago fd = busca(descripcion);
		if(fd==null)
			return MetodosPago.OTROS;
		else
			return fd;
	}
	
	private static Integer sacaInt(String descripcion) {
		try{
			return Integer.parseInt(descripcion);
		}
		catch(Exception ex){
			return null;
		}
	}

	
	
	/**
	 * Busca una formapago de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return formapago valor del enum de acuerdo a la forma de pago
	 */
	@Deprecated
	public static MetodosPago id(Integer idSat) {
		for(MetodosPago m:values()){
			if(m.idSat.equals(idSat <10?"0"+idSat:idSat))
				return m;
		}
		return null;
	}
	
	public static MetodosPago getMetodoPago(String idSat) {
		if(StringUtils.isEmpty(idSat))
			return null;
		for(MetodosPago m:values()){
			if(m.idSat.equals(idSat))
				return m;
		}
		return null;
	}
	
	public String getIdMetodoPago(){
		return idSat;
	}

	public static MetodosPago[] metodospago() {
		
		return values();
	}
	
	public static MetodosPago unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final MetodosPago estado =  MetodosPago.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El método de pago "+metodo+" no se encuentra en el catálogo de métodos de pago del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(MetodosPago v) throws Exception {
		if(v==null)
			return null;
		return v.marshall();
	}
	
	private String marshall(){
		return idSat;
	}
	
	private String getIdSatString(){
		return marshall();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(MetodosPago::getIdSatString).collect(Collectors.toList());		
	}
	
	public static List<String> idsint() {
		return Arrays.asList(values()).stream().map(MetodosPago::getIdSat).collect(Collectors.toList());		
	}
	@Override
	public String getIdString() {
		return idSat;
	}	
}
