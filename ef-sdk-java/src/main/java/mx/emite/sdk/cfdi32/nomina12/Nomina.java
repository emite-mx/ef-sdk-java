package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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
import mx.emite.sdk.enums.sat.TiposNomina;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposNominaAdapter;
import mx.emite.sdk.serializers.LocalDateAdapter;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * 
 * @author enrique
 * Complemento para incorporar al Comprobante Fiscal Digital por Internet (CFDI) la información que ampara conceptos de ingresos por salarios, la prestación de un servicio personal subordinado o conceptos asimilados a salarios (Nómina).
 */
public class Nomina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3108202064459114438L;

	/**
	 * version Atributo requerido para la expresión de la versión del complemento. 1.2
	 */
	@XmlAttribute(name="Version")
    protected final String version="1.2";

	@XmlAttribute(name="TipoNomina")
	@XmlJavaTypeAdapter(TiposNominaAdapter.class)
	@NotNull
	/**
	 * tipoNomina Atributo requerido para indicar el tipo de nómina, puede ser O= Nómina ordinaria o E= Nómina extraordinaria.
	 */
	protected TiposNomina tipoNomina; 
	
	@XmlAttribute(name="FechaPago")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@NotNull
	/**
	 * fechaPago Atributo requerido para la expresión de la fecha efectiva de erogación del gasto. Se expresa en la forma aaaa-mm-dd, de acuerdo con la especificación ISO 8601.
	 */
	protected LocalDate fechaPago; 
	
	/**
	 * fechaInicialPago Atributo requerido para la expresión de la fecha inicial del período de pago. Se expresa en la forma aaaa-mm-dd, de acuerdo con la especificación ISO 8601.
	 */
	@XmlAttribute(name="FechaInicialPago")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	protected LocalDate fechaInicialPago; 
	
	/**
	 * fechaFinalPago Atributo requerido para la expresión de la fecha final del período de pago. Se expresa en la forma aaaa-mm-dd, de acuerdo con la especificación ISO 8601.
	 */
	@XmlAttribute(name="FechaFinalPago")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	protected LocalDate fechaFinalPago; 
	
	/**
	 * numDiasPagados Atributo requerido para la expresión del número o la fracción de días pagados.
	 */
	@XmlAttribute(name="NumDiasPagados")
	@NotNull @DecimalMin("0.001") @DecimalMax("5490.000")
	protected BigDecimal numDiasPagados;
	
	/**
	 * totalPercepciones Atributo condicional para representar la suma de las percepciones.                                                                                                   
	 */
	@XmlAttribute(name="TotalPercepciones")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal totalPercepciones;
	
	/**
	 * totalDeducciones Atributo condicional para representar la suma de las deducciones aplicables.
	 */
	@XmlAttribute(name="TotalDeducciones")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal totalDeducciones;
	
	/**
	 * totalOtrosPagos Atributo condicional para representar la suma de otros pagos.
	 */
	@XmlAttribute(name="TotalOtrosPagos")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal totalOtrosPagos;
	
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Emisor")
	@Valid
	/**
	 * emisor Nodo condicional para expresar la información del contribuyente emisor del comprobante de nómina.
	 */
	private EmisorNomina emisor;
	
	/**
	 * receptor Nodo requerido para precisar la información del contribuyente receptor del comprobante de nómina.
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Receptor")
	@Valid @NotNull
	private ReceptorNomina receptor;
	
	/**
	 * percepciones Nodo condicional para expresar las percepciones aplicables.
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Percepciones")
	private Percepciones percepciones;
	
	/**
	 * deducciones Nodo opcional para expresar las deducciones aplicables.
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Deducciones")
	private Deducciones deducciones;
	
	/**
	 * incapacidades Nodo condicional para expresar información de las incapacidades
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="Incapacidades")
	private Incapacidades incapacidades;
	
	/**
	 * otrosPagos Nodo condicional para expresar otros pagos aplicables.
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina",name="OtrosPagos")
	private OtrosPagos otrosPagos;
	
}
