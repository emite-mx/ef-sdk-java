package mx.emite.sdk.cfdi33.complementos.notpub10;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosUnAdquiriente10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DatosUnAdquiriente implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6374027196044021813L;

	@XmlAttribute(name="Nombre")
	private String nombre;
    
	@XmlAttribute(name="ApellidoPaterno")
	private String apellidoPaterno;
	
	@XmlAttribute(name="ApellidoMaterno")
	private String apellidoMaterno;
	
	@XmlAttribute(name="RFC")
	private String rfc;
	
	@XmlAttribute(name="CURP")
	private String curp;
	
	@XmlAttribute(name="Porcentaje")
	private String porcentaje;
	
}
