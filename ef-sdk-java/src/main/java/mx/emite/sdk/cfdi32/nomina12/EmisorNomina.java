package mx.emite.sdk.cfdi32.nomina12;

import java.io.Serializable;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Curp;
import mx.emite.sdk.cfdi32.anotaciones.RegistroPatronal;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Emisor")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * Nodo condicional para expresar la información del contribuyente emisor del comprobante de nómina.
 * @author enrique
 *
 */
public class EmisorNomina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763388884710804785L;

	/**
	 *  curp Atributo condicional para expresar la CURP del emisor del comprobante de nómina cuando es una persona física.
	 */
	@XmlAttribute(name="Curp")
	@Curp
	protected String curp;
	
	/**
	 *  registroPatronal Atributo condicional para expresar el registro patronal, clave de ramo - pagaduría o la que le asigne la institución de seguridad social al patrón, a 20 posiciones máximo. Se debe ingresar cuando se cuente con él, o se esté obligado conforme a otras disposiciones distintas a las fiscales.
	 */
	@XmlAttribute(name="RegistroPatronal")
	@RegistroPatronal
	protected String registroPatronal;
	
	/**
	 *  rfcPatronOrigen Atributo opcional para expresar el RFC de la persona que fungió como patrón cuando el pago al trabajador se realice a través de un tercero como vehículo o herramienta de pago.
	 */
	@XmlAttribute(name="RfcPatronOrigen")
	@Rfc
	protected String rfcPatronOrigen;
	
	/**
	 * Nodo condicional para que las entidades adheridas al Sistema Nacional de Coordinación Fiscal realicen la identificación del origen de los recursos utilizados en el pago de nómina del personal que presta o desempeña un servicio personal subordinado en las dependencias de la entidad federativa, del municipio o demarcación territorial de la Ciudad de México, así como en sus respectivos organismos autónomos y entidades paraestatales y paramunicipales
	 */
	@XmlElement(namespace="http://www.sat.gob.mx/nomina12",name="EntidadSNCF")
	@Valid
	private EntidadSNCF entidadSncf;
	
}
