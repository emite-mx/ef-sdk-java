package mx.emite.sdk.cfdi33.complementos.rsv10;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehiculoUsadoEnajenadoPermAlFab10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class VehiculoUsadoEnajenadoPermAlFab implements Serializable {




	/**
	 * 
	 */
	private static final long serialVersionUID = -8181851306060822190L;

	@XmlAttribute(name="PrecioVehUsado")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal precioVehUsado;
	
	@XmlAttribute(name="TipoVeh")
	private String tipoVeh;
	
	@XmlAttribute(name="Marca")
	private String marca;
	
	@XmlAttribute(name="TipooClase")
	private String tipooClase;
	
	@XmlAttribute(name="Año")
	private Integer ano;
	
	@XmlAttribute(name="Modelo")
	private String modelo;
	
	@XmlAttribute(name="NIV")
	private String niv;
	
	@XmlAttribute(name="NumSerie")
	private String numSerie;
	
	@XmlAttribute(name="NumPlacas")
	private String numPlacas;
	
	
	@XmlAttribute(name="NumMotor")
	private String numMotor;
	
	@XmlAttribute(name="NumFolTarjCir")
	private String numFolTarjCir;
	
	@XmlAttribute(name="NumFolAvisoint")
	private String numFolAvisoint;
	
	@XmlAttribute(name="NumPedIm")
	private String numPedIm;
	
	@XmlAttribute(name="Aduana")
	private String aduana;
	
	@XmlAttribute(name="FechaRegulVeh")
	private String fechaRegulVeh;
	
	@XmlAttribute(name="Foliofiscal")
	private String foliofiscal;
	
}
