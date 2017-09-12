package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
import lombok.Singular;
import mx.emite.sdk.cfdi32.anotaciones.Antiguedad;
import mx.emite.sdk.cfdi32.anotaciones.Curp;
import mx.emite.sdk.cfdi32.anotaciones.NumEmpleado;
import mx.emite.sdk.cfdi32.anotaciones.NumSeguridadSocial;
import mx.emite.sdk.enums.sat.Bancos;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.TiposContrato12;
import mx.emite.sdk.enums.sat.TiposJornada;
import mx.emite.sdk.enums.sat.TiposPeriodicidad;
import mx.emite.sdk.enums.sat.TiposRegimen12;
import mx.emite.sdk.enums.sat.TiposRiesgo;
import mx.emite.sdk.enums.sat.adaptadores.BancosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.EstadosAdapter;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposContrato12Adapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposJornadaIdSatAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposPeriodicidadAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposRegimen12Adapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposRiesgoIdSatAdapter;
import mx.emite.sdk.serializers.LocalDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Receptor")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo requerido para precisar la información del contribuyente receptor del comprobante de nómina.
 * @author enrique
 *
 */
public class ReceptorNomina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5667951849798399855L;

	/**
	 *  curp Atributo requerido para expresar la CURP del receptor del comprobante de nómina.
	 */
	@XmlAttribute(name="Curp")
	@Curp @NotNull
	protected String curp;
	
	/**
	 *  numSeguridadSocial Atributo condicional para expresar el número de seguridad social del trabajador. Se debe ingresar cuando se cuente con él, o se esté obligado conforme a otras disposiciones distintas a las fiscales.
	 */
	@XmlAttribute(name="NumSeguridadSocial")
	@NumSeguridadSocial
	@Size(min=1,max=15)
	protected String numSeguridadSocial;
	
	/**
	 * fechaInicioRelLaboral Atributo condicional para expresar la fecha de inicio de la relación laboral entre el empleador y el empleado. Se expresa en la forma aaaa-mm-dd, de acuerdo con la especificación ISO 8601. Se debe ingresar cuando se cuente con él, o se esté obligado conforme a otras disposiciones distintas a las fiscales.
	 */
	@XmlAttribute(name="FechaInicioRelLaboral")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	protected LocalDate fechaInicioRelLaboral; 
	
	/**
	 *  antiguedad Atributo condicional para expresar el número de semanas o el periodo de años, meses y días que el empleado ha mantenido relación laboral con el empleador. Se debe ingresar cuando se cuente con él, o se esté obligado conforme a otras disposiciones distintas a las fiscales.
	 */
	@XmlAttribute(name="Antigüedad")
	@Antiguedad
	protected String antiguedad;
	
	/**
	 * tipoContrato Atributo requerido para expresar el tipo de contrato que tiene el trabajador.
	 */
	@XmlAttribute(name="TipoContrato")
	@XmlJavaTypeAdapter(TiposContrato12Adapter.class)
	@NotNull
	protected TiposContrato12 tipoContrato; 
	
	/**
	 * sindicalizado Atributo opcional para indicar si el trabajador está asociado a un sindicato. Si se omite se asume que no está asociado a algún sindicato.
	 */
	@XmlAttribute(name="Sindicalizado")
	@Pattern(regexp="(Sí|No)",message="Sindicalizado debe ser SI o NO")
	private String sindicalizado;
	
	/**
	 * tipoJornada Atributo condicional para expresar el tipo de jornada que cubre el trabajador. Se debe ingresar cuando se esté obligado conforme a otras disposiciones distintas a las fiscales.
	 */
	@XmlAttribute(name="TipoJornada")
	@XmlJavaTypeAdapter(TiposJornadaIdSatAdapter.class)
	protected TiposJornada tipoJornada; 
	
	/**
	 * tipoRegimen Atributo requerido para la expresión de la clave del régimen por el cual se tiene contratado al trabajador, conforme con el catálogo publicado en el portal del SAT en internet.
	 */
	@XmlAttribute(name="TipoRegimen")
	@XmlJavaTypeAdapter(TiposRegimen12Adapter.class)
	@NotNull
	protected TiposRegimen12 tipoRegimen; 
	
	/**
	 * numEmpleado Atributo requerido para expresar el número de empleado de 1 a 15 posiciones.
	 */
	@XmlAttribute(name="NumEmpleado")
	@NotNull @Size(min=1,max=15)
	@NumEmpleado
    protected String numEmpleado;
	
	/**
	 * departamento Atributo opcional para la expresión del departamento o área a la que pertenece el trabajador.
	 */
	@XmlAttribute(name="Departamento")
	@Pattern(regexp="^[^|]{1,100}$"
	,message="Departamento contiene caractéres incorrectos ")
	protected String departamento;
	
	/**
	 * puesto Atributo opcional para la expresión del puesto asignado al empleado o actividad que realiza.
	 */
	@XmlAttribute(name="Puesto")
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|&quot;|%|&amp;|&apos;|´|-|:|;|&gt;|=|&lt;|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,100}",message="Puesto contiene caractéres incorrectos")
	protected String puesto;

	/**
	 * riesgoPuesto Atributo opcional para expresar la clave conforme a la Clase en que deben inscribirse los patrones, de acuerdo con las actividades que desempeñan sus trabajadores, según lo previsto en el artículo 196 del Reglamento en Materia de Afiliación Clasificación de Empresas, Recaudación y Fiscalización, o conforme con la normatividad del Instituto de Seguridad Social del trabajador. Catálogo publicado en el Portal del SAT en internet. Se debe ingresar cuando se cuente con él, o se esté obligado conforme a otras disposiciones distintas a las fiscales.
	 */
	@XmlAttribute(name="RiesgoPuesto")
	@XmlJavaTypeAdapter(TiposRiesgoIdSatAdapter.class)
	protected TiposRiesgo riesgoPuesto; 
	
	/**
	 * periodicidadPago Atributo requerido para la forma en que se establece el pago del salario.
	 */
	@XmlAttribute(name="PeriodicidadPago")
	@XmlJavaTypeAdapter(TiposPeriodicidadAdapter.class)
	@NotNull
	protected TiposPeriodicidad periodicidadPago; 
	
	/**
	 * banco Atributo condicional para la expresión de la clave del Banco conforme al catálogo, donde se realiza el depósito de nómina.
	 */
	@XmlAttribute(name="Banco")
	@XmlJavaTypeAdapter(BancosAdapter.class)
	protected Bancos banco; 
	
	/**
	 * cuentaBancaria Atributo condicional para la expresión de la cuenta bancaria a 11 posiciones o número de teléfono celular a 10 posiciones o número de tarjeta de crédito, débito o servicios a 15 ó 16 posiciones o la CLABE a 18 posiciones o número de monedero electrónico, donde se realiza el depósito de nómina.
	 */
	@XmlAttribute(name="CuentaBancaria")
	@Pattern(regexp="[0-9]{10,18}",message="CuentaBancaria debe de cumplir con el patrón [0-9]{10,18}")
	protected String cuentaBancaria;
	
	/**
	 * salarioBaseCotApor Atributo opcional para expresar la retribución otorgada al trabajador, que se integra por los pagos hechos en efectivo por cuota diaria, gratificaciones, percepciones, alimentación, habitación, primas, comisiones, prestaciones en especie y cualquiera otra cantidad o prestación que se entregue al trabajador por su trabajo, sin considerar los conceptos que se excluyen de conformidad con el Artículo 27 de la Ley del Seguro Social, o la integración de los pagos conforme la normatividad del Instituto de Seguridad Social del trabajador. (Se emplea para pagar las cuotas y aportaciones de Seguridad Social). Se debe ingresar cuando se esté obligado conforme a otras disposiciones distintas a las fiscales.
	 */
	@XmlAttribute(name="SalarioBaseCotApor")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal salarioBaseCotApor; 
	
	/**
	 * salarioDiarioIntegrado Atributo opcional para expresar el salario que se integra con los pagos hechos en efectivo por cuota diaria, gratificaciones, percepciones, habitación, primas, comisiones, prestaciones en especie y cualquier otra cantidad o prestación que se entregue al trabajador por su trabajo, de conformidad con el Art. 84 de la Ley Federal del Trabajo. (Se utiliza para el cálculo de las indemnizaciones).Se debe ingresar cuando se esté obligado conforme a otras disposiciones distintas a las fiscales.
	 */
	@XmlAttribute(name="SalarioDiarioIntegrado")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal salarioDiarioIntegrado; 
	

	/**
	 * claveEntFed Atributo requerido para expresar la clave de la entidad federativa en donde el receptor del recibo prestó el servicio, conforme al catálogo de estados publicado en el Portal del SAT.
	 */
	@XmlAttribute(name="ClaveEntFed")
	@XmlJavaTypeAdapter(EstadosAdapter.class)
	@NotNull
	protected Estados claveEntFed; 
	
	
	/**
	 * subcontratacion Nodo condicional para expresar la lista de las personas que los subcontrataron.
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="SubContratacion")
	@Valid @Singular(value="subcontratacion")
	protected List<Subcontratacion> subcontrataciones; 
	
	
}
