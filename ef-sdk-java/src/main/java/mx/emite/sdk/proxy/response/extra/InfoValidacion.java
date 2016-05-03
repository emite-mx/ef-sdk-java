package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class InfoValidacion  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5697692311089637308L;

	private String resultadoValidacion;
	
	private String fechaValidacion;
	
	private EmisorReceptor emisor;
	
	private EmisorReceptor receptor;
	
	private String uuid;
	
	private String servicioSAT;
	
	private String codigoSAT;
	
	private String estadoSAT;
	
	private String folio;
	
	private String fechaEmision;
	
	private String cadenaOriginal;
	
	private String fechaCertificacion;
	
	private String rfcPAC;
	
	private String serie;
	
	private String tipoDeComprobante;
	
	private String moneda;
	
	private BigDecimal subtotal;
	
	private BigDecimal descuento;
	
	private BigDecimal total;
	
	private String tipoCambio;
	
	private BigDecimal version;
	private String traslados;
	private String retenciones;
	private List<String> conceptos;
	
	public String getSerieFolio(){
		if(StringUtils.isEmpty(serie)&&StringUtils.isEmpty(folio))
			return "";
		if(StringUtils.isEmpty(serie)&&StringUtils.isNotEmpty(folio))
			return folio;
		return serie+"-"+folio;
	}
	
}
