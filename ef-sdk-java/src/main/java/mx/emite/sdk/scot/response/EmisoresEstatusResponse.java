package mx.emite.sdk.scot.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;
import mx.emite.sdk.scot.response.extra.CuentasPorPagar;
import mx.emite.sdk.scot.response.extra.Documentos;

@Getter
@Setter
@ToString(callSuper=true)
public class EmisoresEstatusResponse extends ScotResponse {

	
	/**
	 * @return csd Si el emisor cuenta con csd la variable csd será verdadera, de lo contrario falsa
	 */
	private Boolean csd;

	/**
	 * @return noCertificado No. de certificado del CSD
	 */
	private String noCertificado;
	
	/**
	 * @return vencimiento Fecha de vencimiento del certificado
	 */
	private String vencimiento;
	
	/**
	 * @return habilitado Si el emisor esta habilitado o no
	 */
	private Boolean habilitado;
	
	/**
	 * @return liberado Si el emisor puede timbrar o no
	 */
	private Boolean liberado;
	
	/**
	 * @return contrasena Contraseña de consumo
	 */
	private String contrasena;
	
	/**
	 * @return cuentasporpagar Lista de cuentas por pagar del emisor
	 */
	private List<CuentasPorPagar> cuentasporpagar = new ArrayList<>();
	
	/**
	 * @return documentos Lista de documentos del emisor
	 */
	private List<Documentos> documentos = new ArrayList<>();
	
	@JsonIgnore
	public Boolean getAlertas(){
		return !habilitado||!liberado||!csd||cuentasporpagar.stream().filter(i->i.getVencida()).findAny().isPresent()
				||documentos.stream().filter(d->d.getAprobado()==false).findAny().isPresent();
		
	}
	
	
	
}
