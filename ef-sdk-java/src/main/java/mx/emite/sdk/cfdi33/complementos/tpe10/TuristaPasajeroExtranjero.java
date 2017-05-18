package mx.emite.sdk.cfdi33.complementos.tpe10;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
import mx.emite.sdk.serializers.LocalDateTimeAdapter;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="TuristaPasajeroExtranjero",namespace="http://www.sat.gob.mx/TuristaPasajeroExtranjero")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TuristaPasajeroExtranjero",namespace="http://www.sat.gob.mx/TuristaPasajeroExtranjero")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class TuristaPasajeroExtranjero extends Complemento33Interface implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5927917655969220051L;

	@XmlAttribute(name="version")
    private final String version ="1.0";
	
	@XmlAttribute(name="fechadeTransito",required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@NotNull
	protected LocalDateTime fechadeTransito;

	@XmlAttribute(name="tipoTransito")
    private String tipoTransito;
	
	
	@XmlElement(name="datosTransito", namespace = "http://www.sat.gob.mx/TuristaPasajeroExtranjero")
	@Valid 
	private DatosTransito datosTransito;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/leyendasFiscales http://www.sat.gob.mx/sitio_internet/cfd/TuristaPasajeroExtranjero/TuristaPasajeroExtranjero.xsd";
	}

	@Override
	public String getPrefijo() {
		return "tpe";
	}
	
	
}
