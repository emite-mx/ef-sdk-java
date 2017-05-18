package mx.emite.sdk.cfdi33.complementos.ecc11;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConceptoEstadoDeCuentaCombustibleEcc11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class ConceptoEstadoDeCuentaCombustible implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8984802833003375123L;

	@XmlAttribute(name="Identificador")
	private String identificador;
    
	@XmlAttribute(name="Fecha",required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@NotNull
	protected LocalDateTime fecha;

	@XmlAttribute(name="Rfc")
	private String rfc;
	
	@XmlAttribute(name="ClaveEstacion")
	private String claveEstacion;
	
	@XmlAttribute(name="Cantidad")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal cantidad;
	
	@XmlAttribute(name="NoIdentificacion")
	private String noIdentificacion;
	
	@XmlAttribute(name="Unidad")
	private BigDecimal unidad;
	
	@XmlAttribute(name="NombreCombustible")
	private String nombreCombustible;
	
	@XmlAttribute(name="FolioOperacion")
	private String folioOperacion;
	
	@XmlAttribute(name="ValorUnitario")
	private String valorUnitario;
	
	@XmlAttribute(name="Importe")
	private BigDecimal importe;
	
	@XmlElement(namespace="http://www.sat.gob.mx/EstadoDeCuentaCombustible",name="Traslados")
	private Traslados traslados;
	
	
}
