package mx.emite.sdk.cfdi33.complementos.implocal10;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="ImpuestosLocales",namespace="http://www.sat.gob.mx/implocal")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImpuestosLocales",namespace="http://www.sat.gob.mx/implocal")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ImpuestosLocales extends Complemento33Interface implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8088831072789943152L;

	@XmlAttribute(name="version")
    private final String version ="1.0";
	
	@XmlAttribute(name="TotaldeRetenciones")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal totaldeRetenciones;
	
	@XmlAttribute(name="TotaldeTraslados")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal totaldeTraslados;
	
	@XmlElement(name="RetencionesLocales", namespace = "http://www.sat.gob.mx/implocal")
	@Valid @Singular("retencion")
	private List<RetencionesLocales> retenciones;
	
	@XmlElement(name="TrasladosLocales", namespace = "http://www.sat.gob.mx/implocal")
	@Valid @Singular("traslado")
	private List<TrasladosLocales> traslados;
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/implocal http://www.sat.gob.mx/sitio_internet/cfd/implocal/implocal.xsd";
	}

	@Override
	public String getPrefijo() {
		return "implocal";
	}
	
	
}
