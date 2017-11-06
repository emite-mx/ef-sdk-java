package mx.emite.sdk.cfdi33;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.enums.sat.cfdi33.TiposFactor33;
import mx.emite.sdk.enums.sat.cfdi33.TiposImpuesto33;

@Data
@Builder
public class Traslado33Agrupa {

	private TiposImpuesto33 tipo;
	private BigDecimal tasaOCuota;
	private TiposFactor33 factor;
	
	
	
}
