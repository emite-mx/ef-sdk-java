package mx.emite.sdk.cfdi32.nomina;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Nomina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5981864123311911619L;

	@XmlAttribute
    protected final String Version="1.1";

	@XmlAttribute(name="RegistroPatronal")
    protected String registroPatronal;
	
	@XmlAttribute(name="NumEmpleado")
    protected String numEmpleado;
	
	@XmlAttribute(name="CURP")
	protected String curp; 
	
	@XmlAttribute(name="TipoRegimen")
	@XmlJavaTypeAdapter(TiposRegimenAdapter.class)
	@NotNull
	protected TiposRegimen tipoRegimen; 
	
	@XmlAttribute(name="NumSeguridadSocial")
	protected String numSeguridadSocial; 
	
	@XmlAttribute(name="FechaPago")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@NotNull
	protected LocalDate fechaPago; 
	
	@XmlAttribute(name="FechaInicialPago")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	protected LocalDate fechaInicialPago; 
	
	@XmlAttribute(name="FechaFinalPago")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	protected LocalDate fechaFinalPago; 
	
	@XmlAttribute(name="NumDiasPagados")
	protected Integer numDiasPagados; 
	
	@XmlAttribute(name="Departamento")
	protected String departamento; 
	
	@XmlAttribute(name="CLABE")
	protected String clabe;
	
	@XmlAttribute(name="Banco")
	@XmlJavaTypeAdapter(BancosAdapter.class)
	protected Bancos banco; 
	
	@XmlAttribute(name="FechaInicioRelLaboral")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	protected LocalDate fechaInicioRelLaboral; 
	
	@XmlAttribute(name="Antiguedad")
	protected String antiguedad; 
	
	@XmlAttribute(name="Puesto")
	protected String puesto; 
	
	@XmlAttribute(name="TipoContrato")
	@XmlJavaTypeAdapter(TiposContratoAdapter.class)
	protected TiposContrato tipoContrato; 
	
	@XmlAttribute(name="TipoJornada")
	@XmlJavaTypeAdapter(TiposJornadaAdapter.class)
	protected TiposJornada tipoJornada; 
	
	@XmlAttribute(name="PeriodicidadPago")
	@XmlJavaTypeAdapter(TiposPeriodicidadAdapter.class)
	@NotNull
	protected TiposPeriodicidad periodicidadPago; 
	
	@XmlAttribute(name="SalarioBaseCotApor")
	protected String salarioBaseCotApor; 
	
	@XmlAttribute(name="RiesgoPuesto")
	@XmlJavaTypeAdapter(TiposRiesgoAdapter.class)
	protected TiposRiesgo riesgoPuesto; 
	
	@XmlAttribute(name="SalarioDiarioIntegrado")
	protected String salarioDiarioIntegrado;
	
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Percepciones")
	private Percepciones percepciones;
	
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Deducciones")
	private Deducciones deducciones;
	
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="HorasExtras")
	private HorasExtras horasExtras;
	
	
	
	
}
