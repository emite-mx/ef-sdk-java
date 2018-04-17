package mx.emite.sdk.ef.request;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class FacturaEmiteConcepto {

	/**
	 * @param claveConcepto Clave de concepto a facturar
	 */
	@NotEmpty @Size(max=50)
	private String claveConcepto;
	
	/**
	 * @param concepto Concepto a facturar
	 */
	@NotEmpty @Size(max=200)
	private String concepto;
	
	/**
	 * @param cantidad Cantidad 
	 */
	@NotNull @Digits(integer = 10, fraction = 2)
	private BigDecimal cantidad;
	
	/**
	 * @param pu Precio unitario sin IVA
	 */
	@NotNull @Digits(integer = 10, fraction = 2)
	private BigDecimal pu;

	@Size(min=8,max=8) 
	private String idclaveprodserv;
	
	@Size(min=3,max=3) 
	private String claveUnidad;
	
}
