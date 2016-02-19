package mx.emite.sdk.proxy.request.extra;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.cfdi32.anotaciones.Uuid;
import mx.emite.sdk.enums.EstadoTimbre;
import mx.emite.sdk.enums.TiposTimbres;
import mx.emite.sdk.utils.FechaSerializer;


@Data
public class ConsultaFiltro {

	@NotNull 
	private TiposTimbres tipoTimbre;

	@NotNull
	private EstadoTimbre estado;
	
	@NotNull
	@JsonSerialize(using=FechaSerializer.class)
	private LocalDate rango1;
	
	@NotNull
	@JsonSerialize(using=FechaSerializer.class)
	private LocalDate rango2;
	
	private String sucursal;
	
	@Rfc
	private String receptor;
	
	@Uuid
	private String uuid;
	
	
	private String serie;
	
	
	private Integer folio;
	
	public static ConsultaFiltroBuilder builder() {
		return new ConsultaFiltroBuilder();
	}
	
	
	public static class ConsultaFiltroBuilder {
		private TiposTimbres tipoTimbre=TiposTimbres.CFDI;
		private EstadoTimbre estado=EstadoTimbre.TODAS;
		private LocalDate rango1;
		private LocalDate rango2;
		private String sucursal;
		private String receptor;
		private String uuid;
		private String serie;
		private Integer folio;
		
		/**
		 * @param tipoTimbre por default CFDI
		 * 
		 */
		public ConsultaFiltroBuilder tipoTimbre(TiposTimbres tipoTimbre) {
		this.tipoTimbre=tipoTimbre;
		return this;
		}
		/**
		 * @param estado del timbre o comprobante
		 * 
		 */
		public ConsultaFiltroBuilder estado(EstadoTimbre estado) {
		this.estado=estado;
		return this;
		}
		/**
		 * Rango de fechas de la consulta
		 * @param rango1 fecha inicial de la consulta
		 * @param rango2 fecha final de la consulta
		 * 
		 */
		public ConsultaFiltroBuilder rango(LocalDate rango1,LocalDate rango2) {
		this.rango1=rango1;
		this.rango2=rango2;
		return this;
		}
		/**
		 * @param sucursal en caso de emisores con manejo de sucursales
		 * 
		 */
		public ConsultaFiltroBuilder sucursal(String sucursal) {
		this.sucursal=sucursal;
		return this;
		}
		/**
		 * @param receptor RFC del receptor
		 * 
		 */
		public ConsultaFiltroBuilder receptor(String receptor) {
		this.receptor=receptor;
		return this;
		}
		/**
		 * @param uuid del timbre o comprobante
		 * 
		 */
		public ConsultaFiltroBuilder uuid(String uuid) {
		this.uuid=uuid;
		return this;
		}
		/**
		 * @param serie del timbre o comprobante
		 * 
		 */
		public ConsultaFiltroBuilder serie(String serie) {
		this.serie=serie;
		return this;
		}
		/**
		 * @param folio del timbre o comprobante
		 * 
		 */
		public ConsultaFiltroBuilder folio(Integer folio) {
		this.folio=folio;
		return this;
		}
		public ConsultaFiltro build(){
		return new ConsultaFiltro(this);
		}
		}
	
	private ConsultaFiltro(ConsultaFiltroBuilder builder){
	this.tipoTimbre=builder.tipoTimbre;
	this.estado=builder.estado;
	this.rango1=builder.rango1;
	this.rango2=builder.rango2;
	this.sucursal=builder.sucursal;
	this.receptor=builder.receptor;
	this.uuid=builder.uuid;
	this.serie=builder.serie;
	this.folio=builder.folio;
	}
}
