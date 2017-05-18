package mx.emite.sdk.cfdi33.complementos.leyfisc10;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="LeyendasFiscales",namespace="http://www.sat.gob.mx/leyendasFiscales")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LeyendasFiscales",namespace="http://www.sat.gob.mx/leyendasFiscales")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class LeyendasFiscales extends Complemento33Interface implements Serializable{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -5345726377519034420L;



	@XmlAttribute(name="version")
    private final String version ="1.0";
	

	
	@XmlElement(name="Leyenda", namespace = "http://www.sat.gob.mx/leyendasFiscales")
	@Valid @Singular("leyenda")
	private List<Leyenda> leyendas;
	
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/leyendasFiscales http://www.sat.gob.mx/sitio_internet/cfd/leyendasFiscales/leyendasFisc.xsd";
	}

	@Override
	public String getPrefijo() {
		return "leyendasFisc";
	}
	
	
}
