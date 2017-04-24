package mx.emite.sdk.cfdi33.complementos.cce11;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
import mx.emite.sdk.enums.sat.Incoterms;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.enums.sat.adaptadores.IncotermsAdapter;
import mx.emite.sdk.utils.Complemento33Interface;


@XmlRootElement(name="ComercioExterior",namespace="http://www.sat.gob.mx/ComercioExterior11")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComercioExterior11",namespace="http://www.sat.gob.mx/ComercioExterior11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
/**
 * 
 * @author enrique
 * Complemento para incorporar la información en el caso de Exportación de Mercancías en definitiva.
 */
public class ComercioExterior11 extends Complemento33Interface implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2062114616060760096L;

	/**
	 * version Atributo requerido para la expresión de la versión del complemento. 1.2
	 */
	@XmlAttribute(name="Version")
    private final String version="1.1";
	
	@XmlAttribute(name="MotivoTraslado")
	@Pattern(regexp="(01|02|03|04|05|99){1}",message="Debe de estar en el catálogo c_MotivoTraslado")
    private String motivoTraslado;
	
	@XmlAttribute(name="TipoOperacion")
	@NotNull
	private String tipoOperacion="2";
	
	@XmlAttribute(name="ClaveDePedimento")
	private String claveDePedimento="A1";
	
	@XmlAttribute(name="CertificadoOrigen")
	@Min(value=0) @Max(value=1)
	private Integer certificadoOrigen;
	
	@XmlAttribute(name="NumCertificadoOrigen")
	@Size(min=6,max=40)
	@Pattern(regexp="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}- [a-f0-9A-F]{12}|([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){6,40}",message="Debe de cumplir con el patron [a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}- [a-f0-9A-F]{12}|([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){6,40}")
	private String numCertificadoOrigen;
	
	@XmlAttribute(name="NumeroExportadorConfiable")
	@Size(min=1,max=50)
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]|Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,50}",message="Debe de cumplir con el patron ([A-Z]|[a-z]|[0-9]|Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,50}")
	private String numeroExportadorConfiable;
	
	@XmlAttribute(name="Incoterm")
	@XmlJavaTypeAdapter(IncotermsAdapter.class)
	private Incoterms incoterm;
	
	@XmlAttribute(name="Subdivision")
	@Min(value=0) @Max(value=1)
	private Integer subdivision;

	@XmlAttribute(name="Observaciones")
	@Size(min=1,max=300)
	@Pattern(regexp="([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,300}",message="Debe de cumplir con el patron ([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'| ́|- |:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,300}")
	private String observaciones;
	
	@XmlAttribute(name = "TipoCambioUSD")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@Min(value = 0)
	private BigDecimal tipoCambioUsd;
	
	@XmlAttribute(name = "TotalUSD")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@Min(value = 0)
	private BigDecimal totalUSD;

	@XmlElement(name="Emisor",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid
	private EmisorCE11 emisor;
	
	@XmlElement(name="Propietario",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid @Singular("propietario")
	private List<PropietarioCE11> propietarios;
	
	@XmlElement(name="Receptor",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid 
	private ReceptorCE11 receptor;
	
	@XmlElement(name="Destinatario",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid 
	private DestinatarioCE11 destinatario;
	
	@XmlElement(name="Mercancias",namespace="http://www.sat.gob.mx/ComercioExterior11")
	@Valid 
	private MercanciasCE11 mercancias;
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/ComercioExterior11 http://www.sat.gob.mx/sitio_internet/cfd/ComercioExterior11/ComercioExterior11.xsd";
	}

	@Override
	public String getPrefijo() {
		return "cce11";
	}
	
	
}
