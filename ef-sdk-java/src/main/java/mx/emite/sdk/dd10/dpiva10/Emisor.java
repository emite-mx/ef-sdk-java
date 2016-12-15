package mx.emite.sdk.dd10.dpiva10;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.anotaciones.Curp;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emisor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1742688160059542513L;


	@XmlAttribute(name="ERFC",required = true)
	@NotNull  @Rfc
	protected String rfc;
	
	@XmlAttribute(name="EDenORazSoc")
	private String razonSocial;
	
	@XmlAttribute(name="ECURP",required = true)
	@Curp
	protected String curp;

	@XmlAttribute(name="EApellPat",required = true)
	protected String paterno;
	
	@XmlAttribute(name="EApellMat",required = true)
	protected String materno;
	
	@XmlAttribute(name="ENombre",required = true)
	protected String nombre;
	
}
