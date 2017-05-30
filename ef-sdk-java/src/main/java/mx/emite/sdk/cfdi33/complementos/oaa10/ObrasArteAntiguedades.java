package mx.emite.sdk.cfdi33.complementos.oaa10;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.adaptadores.ImporteMxnAdapter;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="obrasarteantiguedades",namespace="http://www.sat.gob.mx/arteantiguedades")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obrasarteantiguedades",namespace="http://www.sat.gob.mx/arteantiguedades")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ObrasArteAntiguedades extends Complemento33Interface implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1786578443255138308L;

	@XmlAttribute(name="Version")
    private final String version ="1.0";
	
	@XmlAttribute(name="TipoBien")
	private String tipoBien;
	
	@XmlAttribute(name="OtrosTipoBien")
	private String otrosTipoBien;
	
	@XmlAttribute(name="TituloAdquirido")
	private String tituloAdquirido;
	
	@XmlAttribute(name="OtrosTituloAdquirido")
	private String otrosTituloAdquirido;
	
	@XmlAttribute(name="Subtotal")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal subtotal;
	
	@XmlAttribute(name="IVA")
	@XmlJavaTypeAdapter(ImporteMxnAdapter.class)
	private BigDecimal iva;
	
	@XmlAttribute(name="FechaAdquisicion")
	private String fechaAdquisicion;
	
	@XmlAttribute(name="CaracterísticasDeObraoPieza")
	private String caracteristicasDeObraoPieza;
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/arteantiguedades http://www.sat.gob.mx/sitio_internet/cfd/arteantiguedades/obrasarteantiguedades.xsd";
	}

	@Override
	public String getPrefijo() {
		return "obrasarte";
	}
	
	
}
