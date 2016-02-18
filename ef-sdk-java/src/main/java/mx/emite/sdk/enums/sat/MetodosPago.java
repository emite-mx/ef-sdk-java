package mx.emite.sdk.enums.sat;

import lombok.Getter;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum MetodosPago implements Sat{
	
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
	
	
	MetodosPago(Integer idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	}

	public static MetodosPago busca(String metodo) {
		for(MetodosPago m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
		}
		return null;
	}
	
}
