package mx.emite.sdk.cfdi33.complementos.ter11;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
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
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParteTerceros11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Parte implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7132003904345540357L;


	@XmlAttribute(name="cantidad")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal cantidad;
	
	
	@XmlAttribute(name="unidad")
	private String unidad;
    
	@XmlAttribute(name="noIdentificacion")
	private String noIdentificacion;
	
	@XmlAttribute(name="descripcion")
	private String descripcion;
	
	@XmlAttribute(name="valorUnitario")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal valorUnitario;
	
	
	@XmlAttribute(name="importe")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal importe;
	
	@XmlElement(name="InformacionAduanera", namespace = "http://www.sat.gob.mx/terceros")
	@Valid @Singular("informacionaduanera")
	private List<InformacionAduanera> informacionaduaneras;
	
}
