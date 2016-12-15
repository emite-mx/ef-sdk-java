package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;
import mx.emite.sdk.serializers.ZonedFechaHoraDeserializer;
import mx.emite.sdk.serializers.ZonedFechaHoraSerializer;

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
public class InfoRetenciones extends Info implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7689853440147771832L;

	protected String folio;
	@JsonDeserialize(using=ZonedFechaHoraDeserializer.class)
	@JsonSerialize(using=ZonedFechaHoraSerializer.class)
	protected ZonedDateTime fecha;
	protected String nocertificado;
	protected BigDecimal montoTotalOperacion;
	protected String clave;
	protected String version;
	protected String emisor;
	protected String receptor;
	protected String uuid;
	protected String selloCFD;
	
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@JsonSerialize(using=FechaHoraSerializer.class)
	protected LocalDateTime fechaTimbrado;	
	
}
