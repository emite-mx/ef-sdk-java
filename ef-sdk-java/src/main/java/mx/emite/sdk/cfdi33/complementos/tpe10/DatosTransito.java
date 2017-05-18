package mx.emite.sdk.cfdi33.complementos.tpe10;

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
@XmlType(name = "DatosTransito10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class DatosTransito implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 7777164198598933120L;

	@XmlAttribute(name="Via")
	private String via;
    
	@XmlAttribute(name="TipoId")
	private String tipoId;
	
	@XmlAttribute(name="NumeroId")
	private String numeroId;
	
	@XmlAttribute(name="Nacionalidad")
	private String nacionalidad;
	
	@XmlAttribute(name="EmpresaTransporte")
	private String empresaTransporte;
	
	@XmlAttribute(name="IdTransporte")
	private String idTransporte;
	
}
