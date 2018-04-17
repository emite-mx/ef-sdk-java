package mx.emite.sdk.cfdi33.complementos.ine11;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
import mx.emite.sdk.enums.sat.EntidadesIne11;
import mx.emite.sdk.enums.sat.adaptadores.EntidadesIne11Adapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Entidad11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Entidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1058590517809506107L;

	@XmlAttribute(name="ClaveEntidad")
	@XmlJavaTypeAdapter(EntidadesIne11Adapter.class)
	@NotNull
    private EntidadesIne11 claveEntidad;
	
	@XmlAttribute(name="Ambito")
	@Pattern(regexp="(Local|Federal){1}",message="Debe de estar en el catálogo t_Ambito")
	private String ambito;
		 
	 
	@XmlElement(namespace="http://www.sat.gob.mx/ine",name="Contabilidad")
	@Valid @Singular("contabilidad")
	private List<Contabilidad> contabilidades;
	
    
	
}
