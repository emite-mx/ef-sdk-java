package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntidadSNCF")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo condicional para que las entidades adheridas al Sistema Nacional de Coordinación Fiscal realicen la identificación del origen de los recursos utilizados en el pago de nómina del personal que presta o desempeña un servicio personal subordinado en las dependencias de la entidad federativa, del municipio o demarcación territorial de la Ciudad de México, así como en sus respectivos organismos autónomos y entidades paraestatales y paramunicipales
 * @author enrique
 *
 */
public class EntidadSNCF implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1762832861021245901L;

	/**
	 * origenRecurso Atributo requerido para identificar el origen del recurso utilizado para el pago de nómina del personal que presta o desempeña un servicio personal subordinado o asimilado a salarios en las dependencias.
	 */
	@XmlAttribute(name="OrigenRecurso")
	@NotNull @Size(max=100)
	protected String origenRecurso;
	
	/**
	 * montoRecursoPropio Atributo condicional para expresar el monto del recurso pagado con cargo a sus participaciones u otros ingresos locales (importe bruto de los ingresos propios, es decir total de gravados y exentos), cuando el origen es mixto.
	 */
	@XmlAttribute(name="MontoRecursoPropio")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	@DecimalMin("0")
	protected BigDecimal montoRecursoPropio;
	
	
}
