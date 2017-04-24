package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;

/**
 *  <h1>InfoCfdi</h1>
 *	Objeto que contiene los principales atributos del Cfdi timbrado
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class InfoCfdi extends Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6270940941390076313L;
	private String serie;
	private String folio;
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@JsonSerialize(using=FechaHoraSerializer.class)
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
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@JsonSerialize(using=FechaHoraSerializer.class)
	private LocalDateTime fechaTimbrado;	
	
	
}
