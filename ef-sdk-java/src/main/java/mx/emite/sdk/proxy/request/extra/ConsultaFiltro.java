package mx.emite.sdk.proxy.request.extra;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.cfdi32.anotaciones.Uuid;
import mx.emite.sdk.enums.EstadoTimbre;
import mx.emite.sdk.enums.TipoTimbres;
import mx.emite.sdk.serializers.FechaSerializer;


@Data
@NoArgsConstructor @AllArgsConstructor
public class ConsultaFiltro {

	@NotNull 
	private TipoTimbres tipoTimbre;

	@NotNull
	private EstadoTimbre estado;
	
	@NotNull
	@JsonSerialize(using=FechaSerializer.class)
	private LocalDate rango1;
	
	@NotNull
	@JsonSerialize(using=FechaSerializer.class)
	private LocalDate rango2;
	
	//private String sucursal;
	
	@Rfc
	private String receptor;
	
	@Uuid
	private String uuid;
	
	
	private String serie;
	
	
	private String folio;
	
	private Integer pagina=1;
	
	public static ConsultaFiltroBuilder builder() {
		return new ConsultaFiltroBuilder();
	}
	
	
	public static class ConsultaFiltroBuilder {
		private TipoTimbres tipoTimbre=TipoTimbres.CFDI;
		private EstadoTimbre estado=EstadoTimbre.TODAS;
		private LocalDate rango1;
		private LocalDate rango2;
		//private String sucursal;
		private String receptor;
		private String uuid;
		private String serie;
		private String folio;
		private Integer pagina=1;
		
		/**
		 * @param tipoTimbre por default CFDI
		 * @return builder
		 */
		public ConsultaFiltroBuilder tipoTimbre(TipoTimbres tipoTimbre) {
		this.tipoTimbre=tipoTimbre;
		return this;
		}
		/**
		 * @param estado del timbre o comprobante
		 * @return builder
		 */
		public ConsultaFiltroBuilder estado(EstadoTimbre estado) {
		this.estado=estado;
		return this;
		}
		/**
		 * Rango de fechas de la consulta
		 * @param rango1 fecha inicial de la consulta
		 * @param rango2 fecha final de la consulta
		 * @return builder
		 */
		public ConsultaFiltroBuilder rango(LocalDate rango1,LocalDate rango2) {
		this.rango1=rango1;
		this.rango2=rango2;
		return this;
		}
		/**
		 *  sucursal en caso de emisores con manejo de sucursales
		 * builder
		public ConsultaFiltroBuilder sucursal(String sucursal) {
		this.sucursal=sucursal;
		return this;
		}
		/**
		 * @param receptor RFC del receptor
		 * @return builder
		 */
		public ConsultaFiltroBuilder receptor(String receptor) {
		this.receptor=receptor;
		return this;
		} 
		/**
		 * @param uuid del timbre o comprobante
		 * @return builder
		 */
		public ConsultaFiltroBuilder uuid(String uuid) {
		this.uuid=uuid;
		return this;
		}
		/**
		 * @param serie del timbre o comprobante
		 * @return builder
		 */
		public ConsultaFiltroBuilder serie(String serie) {
		this.serie=serie;
		return this;
		}
		/**
		 * @param pagina
		 * @return builder
		 */
		public ConsultaFiltroBuilder serie(Integer pagina) {
		this.pagina=pagina;
		return this;
		}
		/**
		 * @param folio del timbre o comprobante
		 * @return builder
		 */
		public ConsultaFiltroBuilder folio(String folio) {
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
	
	this.receptor=builder.receptor;
	this.uuid=builder.uuid;
	this.serie=builder.serie;
	this.folio=builder.folio;
	if(builder.pagina!=null)
		this.pagina=builder.pagina;
	else
		this.pagina=1;
	
	}
}
