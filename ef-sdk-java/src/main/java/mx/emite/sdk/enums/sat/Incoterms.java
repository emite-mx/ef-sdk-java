package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum Incoterms implements Sat<String>{
	
	COSTOYFLETE("CFR","Costo y Flete"),
	COSTOSEGUROYFLETE("CIF","Costo, Seguro y Flete"),
	TRANSPORTEPAGADOHASTA("CPT","Transporte Pagado Hasta"),
	TRANSPORTEYSEGUROPAGADOHASTA("CIP","Transporte y Seguro Pagado Hasta"),
	ENTREGADOENFRONTERA("DAF","Entrega en Frontera"),
	ENTREGAENLUGAR("DAP","Entrega en Lugar"),
	ENTREGAENTERMINAL("DAT","Entrega en Terminal"),
	ENTREGASOBREBUQUE("DES","Entraga Sobre Buque"),
	ENTREGAENMUELLE("DEQ","Entrega en Muelle"),
	ENTREGADASDERECHONOPAGADO("DDU","Entregadas Derechos No Pagados"),
	ENTREGADASDERECHOPAGADO("DDP","Entregadas Derechos Pagados"),
	ENFABRICA("EXW","En Fábrica"),
	LIBRETRANSPORTISTA("FCA","Libre Transportista"),
	LIBRECOSTADOBUQUE("FAS","Libre al Costado del Buque"),
	LIBREABORDO("FOB","Libre a Bordo"),
	;
	
	final String idSat;
	final String descripcion;
	
	
	Incoterms(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
		
		
	}

	public static Incoterms busca(String metodo) {
		if(StringUtils.isEmpty(metodo))
			return null;
		for(Incoterms m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
		}
		return null;
	}
	
	public static Incoterms unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final Incoterms estado =  Incoterms.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El incoterm "+metodo+" no se encuentra en el catálogo de Incoterms del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(Incoterms v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat().toString();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static Incoterms getTipoRegimen(String tipoRegimen) {
		if(StringUtils.isEmpty(tipoRegimen))
			return null;
		for(Incoterms m:values()){
			if(m.idSat.equals(tipoRegimen))
				return m;
		}
		return null;
	}
	@Override
	public String getIdString() {
		return idSat;
	}
	
}
