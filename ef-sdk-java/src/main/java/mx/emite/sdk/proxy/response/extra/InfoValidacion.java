package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;
import mx.emite.sdk.serializers.MontoDeserializer;

@Data
public class InfoValidacion  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5697692311089637308L;

	private String serie;
	private String folio;
	private String moneda;
	@JsonDeserialize(using=MontoDeserializer.class)
	private BigDecimal subtotal;
	@JsonDeserialize(using=MontoDeserializer.class)
	private BigDecimal descuento;
	@JsonDeserialize(using=MontoDeserializer.class)
	private BigDecimal total;
	@JsonDeserialize(using=MontoDeserializer.class)
	private BigDecimal tipoCambio;
	@JsonDeserialize(using=MontoDeserializer.class)
	private BigDecimal traslados;
	@JsonDeserialize(using=MontoDeserializer.class)
	private BigDecimal retenciones;
	
	private List<String> conceptos=new ArrayList<>();
	
	private BigDecimal version=BigDecimal.valueOf(3.2);
	private String rfcEmisor;
	private String rfcReceptor;
	
	private InfoValidacionEmisorReceptor emisor;
	private InfoValidacionEmisorReceptor receptor;
	
	
	private Boolean valida=false;
	private String uuid;
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime fechaInicio;
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime fechaFin;
	private Long milis;
	private String tipoComprobante;
	
	private String traza;
	private String qr;
	
	private InfoValidacionPartida cfdi;
	private InfoValidacionPartida tfd;
	private InfoValidacionSat sat;
	
	private List<String> complementos;
	private List<String> addendas;
	
	private List<InfoValidacionError> errores;
	
	
	public String getSerieFolio(){
		if(StringUtils.isEmpty(serie)&&StringUtils.isEmpty(folio))
			return "";
		if(StringUtils.isEmpty(serie)&&StringUtils.isNotEmpty(folio))
			return folio;
		return serie+"-"+folio;
	}
	
}
