package mx.emite.sdk.cfdi33.complementos.vu10;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
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
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="VehiculoUsado",namespace="http://www.sat.gob.mx/vehiculousado")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehiculoUsado",namespace="http://www.sat.gob.mx/vehiculousado")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class VehiculoUsado extends Complemento33Interface implements Serializable{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -5345726377519034420L;



	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	@XmlAttribute(name="montoAdquisicion")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal montoAdquisicion;
	
	@XmlAttribute(name="montoEnajenacion")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal montoEnajenacion;
	
	@XmlAttribute(name="claveVehicular")
	private String claveVehicular;
	
	@XmlAttribute(name="marca")
	private String marca;
	
	
	@XmlAttribute(name="tipo")
	private String tipo;
	
	@XmlAttribute(name="modelo")
	private String modelo;
	
	@XmlAttribute(name="numeroMotor")
	private String numeroMotor;
	
	@XmlAttribute(name="numeroSerie")
	private String numeroSerie;
	
	@XmlAttribute(name="NIV")
	private String niv;
	
	@XmlAttribute(name="valor")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal valor;
	
	
	@XmlElement(name="InformacionAduanera", namespace = "http://www.sat.gob.mx/vehiculousado")
	@Valid @Singular("informacionaduanera")
	private List<InformacionAduanera> informacionaduaneras;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/vehiculousado http://www.sat.gob.mx/sitio_internet/cfd/vehiculousado/vehiculousado.xsd";
	}

	@Override
	public String getPrefijo() {
		return "vehiculousado";
	}
	
	
}
