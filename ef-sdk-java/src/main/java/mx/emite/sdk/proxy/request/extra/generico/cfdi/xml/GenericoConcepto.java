package mx.emite.sdk.proxy.request.extra.generico.cfdi.xml;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.NU;
import mx.emite.sdk.enums.sat.UnidadesMedida;
import mx.emite.sdk.enums.sat.adaptadores.UnidadesMedidaAdapter;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class GenericoConcepto {

	@XmlAttribute(name="noIdentificacion")
	private String noIdentificacion;
	
	
	@XmlAttribute(name="cantidad")
	@NotNull @Digits(integer=24,fraction=6)
	private BigDecimal cantidad;
	
	@XmlAttribute(name="unidad")
	@XmlJavaTypeAdapter(UnidadesMedidaAdapter.class)
	@NotNull
	private UnidadesMedida unidad;
	
	
	@XmlAttribute(name="descripcion")
	@NotNull
	private String descripcion;
	
	
	@XmlAttribute(name="precioUnitario")
	@NotNull @Digits(integer=24,fraction=6)
	private BigDecimal precioUnitario;
	
	/*@XmlAttribute(name="iva")
	@NotNull @Digits(integer=24,fraction=6)
	private BigDecimal iva;
	*/
	
	/*@XmlAttribute(name="importe")
	@NotNull @Digits(integer=24,fraction=6)
	private BigDecimal importe;*/
	
	@XmlAttribute(name="tasaIva")
	@Digits(integer=24,fraction=6)
	private BigDecimal tasaIva;
	
	@XmlAttribute(name="tasaRetIsr")
	@Digits(integer=24,fraction=6)
	private BigDecimal tasaRetIsr;
	
	@XmlAttribute(name="tasaRetIva")
	@Digits(integer=24,fraction=6)
	private BigDecimal tasaRetIva;
	
	@XmlTransient
	@Digits(integer=24,fraction=6)
	private BigDecimal retIsr;
	
	@XmlTransient
	@Digits(integer=24,fraction=6)
	private BigDecimal retIva;
	
	
	public BigDecimal getImporte(){
		return NU.multiplica(cantidad, precioUnitario, 6);
	}
	
	
	
	public BigDecimal getIva(){
		if(tasaIva==null)
			return BigDecimal.ZERO;
		if(tasaIva.compareTo(BigDecimal.ZERO)==0)
			return BigDecimal.ZERO;
		return  NU.divide(NU.multiplica(getImporte(), tasaIva, 6),BigDecimal.valueOf(100),6);
	}
	
	public BigDecimal getIvaRetenido(){
		if(retIva!=null)
			return retIva;
		if(tasaRetIva==null)
			return BigDecimal.ZERO;
		if(tasaRetIva.compareTo(BigDecimal.ZERO)==0)
			return BigDecimal.ZERO;
		return  NU.divide(NU.multiplica(getImporte(), tasaRetIva, 6),BigDecimal.valueOf(100),6);
	}
	
	public BigDecimal getIsr(){
		if(retIsr!=null)
			return retIsr;
		if(tasaRetIsr==null)
			return BigDecimal.ZERO;
		if(tasaRetIsr.compareTo(BigDecimal.ZERO)==0)
			return BigDecimal.ZERO;
		return  NU.divide(NU.multiplica(getImporte(), tasaRetIsr, 6),BigDecimal.valueOf(100),6);
	}
	
	public BigDecimal getTotalImpuestosTrasladados(){
		return getIva();
	}
	
	public BigDecimal getTotalImpuestosRetenidos(){
		return getIvaRetenido().add(getIsr());
	}
	
}
