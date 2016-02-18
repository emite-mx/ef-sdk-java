package mx.emite.sdk.proxy.response.extra;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import mx.emite.sdk.utils.FechaDeserializer;

/**
 *  <h1>InfoCfdi</h1>
 *	Objeto que contiene los principales atributos del Cfdi timbrado
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
@Data
public class InfoCfdi{

	private String serie;
	private Integer folio;
	@JsonDeserialize(using=FechaDeserializer.class)
	private LocalDateTime fecha;
	private String moneda; 
	private String tc;
	private String nocertificado;
	private BigDecimal total;
	private String tipo;
	private String version;
	private String emisor;
	private String receptor;
	private String uuid;
	private String selloCFD;
	@JsonDeserialize(using=FechaDeserializer.class)
	private LocalDateTime fechaTimbrado;	
	
	
}
