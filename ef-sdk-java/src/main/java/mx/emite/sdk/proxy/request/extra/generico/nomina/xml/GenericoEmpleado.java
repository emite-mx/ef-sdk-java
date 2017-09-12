package mx.emite.sdk.proxy.request.extra.generico.nomina.xml;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Curp;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.enums.sat.Bancos;
import mx.emite.sdk.enums.sat.TiposContrato;
import mx.emite.sdk.enums.sat.TiposJornada;
import mx.emite.sdk.enums.sat.TiposPeriodicidad;
import mx.emite.sdk.enums.sat.TiposRegimen;
import mx.emite.sdk.enums.sat.TiposRiesgo;
import mx.emite.sdk.enums.sat.adaptadores.BancosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposContratoAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposJornadaAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposPeriodicidadAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposRegimenAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposRiesgoAdapter;
import mx.emite.sdk.serializers.LocalDateAdapter;


@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@XmlRootElement(name="GenericoEmpleadoNomina")
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericoEmpleado {

	@XmlAttribute(name="rfc")
	@NotNull @Rfc
	private String rfc;
	
	@XmlAttribute(name="nombre")
	@NotNull @Size(min=10,max=100)
	private String nombre;
	
	@XmlAttribute(name="curp")
	@Curp @NotNull 
	private String curp;
	
	@XmlAttribute(name="tipoContrato")
	@XmlJavaTypeAdapter(TiposContratoAdapter.class)
	private TiposContrato tipoContrato;
	
	@XmlAttribute(name="tipoJornada")
	@XmlJavaTypeAdapter(TiposJornadaAdapter.class)
	private TiposJornada tipoJornada;
	
	@XmlAttribute(name="tipoPeriodicidad")
	@XmlJavaTypeAdapter(TiposPeriodicidadAdapter.class)
	private TiposPeriodicidad tipoPeriodicidad;
	
	@XmlAttribute(name="tipoRiesgo")
	@XmlJavaTypeAdapter(TiposRiesgoAdapter.class)
	private TiposRiesgo tipoRiesgo;
	
	@XmlAttribute(name="tipoRegimen")
	@XmlJavaTypeAdapter(TiposRegimenAdapter.class)
	@NotNull
	private TiposRegimen tipoRegimen;
	
	@XmlAttribute(name="numSeguridadSocial")
	@Size(max=15)
	private String numSeguridadSocial;
	
	
	
	@XmlAttribute(name="numEmpleado")
	@Size(max=50)
	private String numEmpleado;
	
	@XmlAttribute(name="departamento")
	@Size(max=100)
	private String departamento;
	
	@XmlAttribute(name="puesto")
	@Size(max=100)
	private String puesto;
	
	
	@XmlAttribute(name="salarioDiarioIntegrado")
	@Digits(integer=24,fraction=6)
	@NotNull 
	private BigDecimal salarioDiarioIntegrado;
	
	@XmlAttribute(name="salarioBaseCotApor")
	@Digits(integer=24,fraction=6)
	@NotNull 
	private BigDecimal salarioBaseCotApor;
	
	
	
	@XmlAttribute(name="fechaInicioRelacionLaboral")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate fechaInicioRelacionLaboral;
	
	
	
	@XmlAttribute(name="banco")
	@XmlJavaTypeAdapter(BancosAdapter.class)
	private Bancos banco;
	
	@XmlAttribute(name="clabe")
	@Size(min=18,max=18)
	private String clabe;
	
	
	
	
	
	
	
	
	
}
