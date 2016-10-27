package mx.emite.sdk.cfdi32.comp.ce;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder={"emisor","receptor","percepciones","deducciones","otrosPagos","incapacidades"})
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * 
 * @author enrique
 * Complemento para incorporar la información en el caso de Exportación de Mercancías en definitiva.
 */
public class ComercioExterior11 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2062114616060760096L;

	/**
	 * version Atributo requerido para la expresión de la versión del complemento. 1.2
	 */
	@XmlAttribute(name="Version")
    protected final String version="1.1";
	
	@XmlAttribute(name="MotivoTraslado")
    protected String motivoTraslado;

}
