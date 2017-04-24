package mx.emite.sdk.cfdi32.complementos.cce11;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.adaptadores.PaisesSatAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PropietarioCE11 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1601024712068212744L;

	@XmlAttribute(name="NumRegIdTrib")
	@Size(min=6,max=40)
	@NotNull
	private String numRegIdTrib;
	
	@XmlAttribute(name="ResidenciaFiscal")
	@XmlJavaTypeAdapter(PaisesSatAdapter.class)
	@NotNull
	protected Paises residenciaFiscal;
}
