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

@Data
public class InfoValidacion  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5697692311089637308L;

	private Boolean valida=false;
	
	private String serie;
	private String folio;
	private String tipoDeComprobante;
	private String moneda;
	private String subtotal;
	private String descuento;
	private String total;
	private String tipoCambio;
	private String traslados;
	private String retenciones;
	private List<String> conceptos=new ArrayList<>();
	
	private BigDecimal version=BigDecimal.valueOf(3.2);
	private String rfcEmisor;
	private String rfcReceptor;
	
	private InfoValidacionEmisorReceptor emisor;
	private InfoValidacionEmisorReceptor receptor;
	
	private String uuid;
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime fechaInicio;
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime fechaFin;
	private Long milis;
	private String tipoComprobante;
	
	private String estadoSat;
	private String mensajeSat;
	private String traza;
	private String qr;
	
	private InfoValidacionPartida cfdi = new InfoValidacionPartida(true);
	private List<String> complementos = new ArrayList<>();
	private List<String> addendas = new ArrayList<>();
	private InfoValidacionPartida tfd = new InfoValidacionPartida(false);
	private List<InfoValidacionError> errores = new ArrayList<>();
	
	
	public String getSerieFolio(){
		if(StringUtils.isEmpty(serie)&&StringUtils.isEmpty(folio))
			return "";
		if(StringUtils.isEmpty(serie)&&StringUtils.isNotEmpty(folio))
			return folio;
		return serie+"-"+folio;
	}
	
}
