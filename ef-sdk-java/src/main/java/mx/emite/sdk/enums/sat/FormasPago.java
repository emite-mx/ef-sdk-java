package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum FormasPago implements Sat{
	
	EFECTIVO(1,"Efectivo"),
	CHEQUE(2,"Cheque"),
	TRANSFERENCIA(3,"Transferencia"),
	TARJETASDECREDITO(4,"Tarjetas de crédito"),
	MONEDEROSELECTRONICOS(5,"Monederos electrónicos"),
	DINEROELECTRONICO(6,"Dinero electrónico"),
	TARJETASDIGITALES(7,"Tarjetas digitales"),
	VALESDEDESPENSA(8,"Vales de despensa"),
	BIENES(9,"Bienes"),
	SERVICIO(10,"Servicio"),
	PORCUENTADETERCERO(11,"Por cuenta de tercero"),
	DACIONENPAGO(12,"Dación en pago"),
	PAGOPORSUBROGACION(13,"Pago por subrogación"),
	PAGOPORCONSIGNACION(14,"Pago por consignación"),
	CONDONACION(15,"Condonación"),
	CANCELACION(16,"Cancelación"),
	COMPENSACION(17,"Compensación"),
	OTRO(99,"Otro");
	
	final Integer idSat;
	final String descripcion;
	
	
	FormasPago(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	/**
	 * Busca una formapago de acuerdo a su descripción
	 * @param descripcion de acuerdo al catalogo del SAT
	 * @return FormasPago valor del enum de acuerdo a la forma de pago
	 */
	public static FormasPago busca(String descripcion) {
		for(FormasPago m:values()){
			if(Utilerias.compara(m.descripcion,descripcion))
				return m;
		}
		return null;
	}
	
	/**
	 * Busca una formapago de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return formapago valor del enum de acuerdo a la forma de pago
	 */
	public static FormasPago id(Integer idSat) {
		for(FormasPago m:values()){
			if(m.idSat.equals(idSat))
				return m;
		}
		return null;
	}
	
	public Integer getIdFormaPago(){
		return idSat;
	}

	public static FormasPago[] formaspago() {
		
		return values();
	}
	
}
