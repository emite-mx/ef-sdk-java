package mx.emite.sdk.dd10.dpiva10;

import java.io.Serializable;
import java.time.LocalDate;
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
import mx.emite.sdk.serializers.LocalDateAdapter;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder={"totales","provnacionales"})
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class DpIva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8916757315652050969L;

	@XmlElement(namespace="http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/TipoDPIVA/1",name="Totales")
	@Valid
	private Totales totales;
	
	@XmlElement(namespace="http://esquemas.clouda.sat.gob.mx/archivos/DoctosDigitales/TipoDPIVA/1",name="ProvNacional")
	@Valid @Singular("provnacional")
	private List<ProvNacional> provnacionales;
	
	@XmlAttribute(name="Version")
    protected final String version="1.0";
	
	@XmlAttribute(name="DPIVA")
    protected String dpIva;
	
	@XmlAttribute(name="Ejercicio")
    protected Integer ejercicio;
	
	@XmlAttribute(name="Periodo")
    protected String periodo;
	
	@XmlAttribute(name="TipoDec")
    protected Integer tipoDec;
	
	@XmlAttribute(name="TipoPerid")
    protected String tipoPerid;
	
	@XmlAttribute(name="FolioAnt")
    protected String folioAnt;
	
	@XmlAttribute(name="FechPresAnt")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	protected LocalDate fechaPresAnt;
	

	
}
