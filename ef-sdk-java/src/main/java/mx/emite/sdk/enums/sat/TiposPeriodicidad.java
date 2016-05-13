package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposPeriodicidad implements Sat{
	
	DIARIO("01","Diario"),
	SEMANAL("02","Semanal"),
	CATORCENAL("03","Catorcenal"),
	QUINCENAL("04","Quincenal"),
	MENSUAL("05","Mensual"),
	BIMESTRAL("06","Bimestral"),
	UNIDADOBRA("07","Unidad Obra",new String[]{"Unidad_obra"}),
	COMISION("08","Comisión"),
	PRECIOALZADO("09","Precio Alzado",new String[]{"Precio_alzado"}),
	OTRAPERIODICIDAD("99","Otra Periodicidad",new String[]{"OtraPeriodicidad"}),
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposPeriodicidad(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposPeriodicidad(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposPeriodicidad busca(String metodo) {
		for(TiposPeriodicidad m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(m.sinonimos!=null){
				for(String s:m.sinonimos){
					if(Utilerias.compara(s,metodo))
						return m;
				}
			}
		}
		return null;
	}
	
	public static TiposPeriodicidad unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposPeriodicidad estado =  TiposPeriodicidad.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de periodicidad "+metodo+" no se encuentra en el catálogo de Tipos de Periodicidad del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposPeriodicidad v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	
}
