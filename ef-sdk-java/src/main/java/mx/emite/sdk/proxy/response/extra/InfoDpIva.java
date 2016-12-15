package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
public class InfoDpIva extends Info implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4907122956313445099L;

	protected String nocertificado;
	
	protected String tipoDocumento;
	
	protected String version;
	
	protected String emisor;
	
	protected String numOperacion;
	
	protected String selloCFD;
	
	protected String dpIva;
	
	protected String ejercicio;
	
	protected String periodo;
	
	protected String tipoDeclaracion;
	
	protected String tipoPeriodo;
	
	@JsonDeserialize(using=ZonedFechaHoraDeserializer.class)
	@JsonSerialize(using=ZonedFechaHoraSerializer.class)
	protected ZonedDateTime fechaTimbrado;	
	
	
}
