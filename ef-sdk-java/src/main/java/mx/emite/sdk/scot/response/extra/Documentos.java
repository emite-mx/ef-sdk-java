package mx.emite.sdk.scot.response.extra;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;

/**
 *  <h1>Documentos</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
@Data
public class Documentos {

	/**
	 * @return idTipoDocumento Tipo de documento
	 */
	private Integer idTipoDocumento;

	/**
	 * @return descripcion Descripcion del documento
	 */
	private String descripcion;
	
	/**
	 * @return observaciones de acuerdo al tipo de documento
	 */
	private String observaciones;
	
	/**
	 * @return fechaAlta Fecha de Alta de Documento en formato ISO
	 */
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@JsonSerialize(using=FechaHoraSerializer.class)
	private LocalDateTime fechaAlta;
	
	/**
	 * @return fechaAprobacion Fecha de Aprobacion de Documento en formato ISO
	 */
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@JsonSerialize(using=FechaHoraSerializer.class)
	private LocalDateTime fechaAprobacion;
	
	/**
	 * @return aprobado Si el documento esta aprobado
	 */
	private Boolean aprobado;
	
	/**
	 * @return url Url de descarga de documento valido por 24 horas
	 */
	private String url;
	
		
	
	
}
