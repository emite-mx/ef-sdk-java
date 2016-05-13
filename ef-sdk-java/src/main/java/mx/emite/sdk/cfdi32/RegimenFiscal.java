package mx.emite.sdk.cfdi32;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.enums.sat.adaptadores.RegimenesFiscalesAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "t_Regimen")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegimenFiscal{

	@XmlAttribute(name = "Regimen")
	@XmlJavaTypeAdapter(RegimenesFiscalesAdapter.class)
	@NotNull
	protected RegimenesFiscales Regimen;

	
}
