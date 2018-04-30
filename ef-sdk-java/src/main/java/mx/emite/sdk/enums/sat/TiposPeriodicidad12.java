package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposPeriodicidad12 implements Sat<String>{
	
	DIARIO("01","Diario",TiposNomina12.ORDINARIA),
	SEMANAL("02","Semanal",TiposNomina12.ORDINARIA),
	CATORCENAL("03","Catorcenal",TiposNomina12.ORDINARIA),
	QUINCENAL("04","Quincenal",TiposNomina12.ORDINARIA),
	MENSUAL("05","Mensual",TiposNomina12.ORDINARIA),
	BIMESTRAL("06","Bimestral",TiposNomina12.ORDINARIA),
	UNIDADOBRA("07","Unidad Obra",new String[]{"Unidad_obra"},TiposNomina12.ORDINARIA),
	COMISION("08","Comisión",TiposNomina12.ORDINARIA),
	PRECIOALZADO("09","Precio Alzado",new String[]{"Precio_alzado"},TiposNomina12.ORDINARIA),
	DECENAL("10","Decenal",TiposNomina12.ORDINARIA),
	OTRAPERIODICIDAD("99","Otra Periodicidad",new String[]{"OtraPeriodicidad"},TiposNomina12.EXTRAORDINARIA), 
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	final TiposNomina12 tipoNomina;
	
	public static void main(String[] args){
		for(TiposPeriodicidad12 p:values()){
				System.out.println("insert into h_sat_periodicidad values('"+p.getIdSat()+"','"+p.getDescripcion()+"','"+(p.getTipoNomina().name().charAt(0))+"');");
		}
	}

	
	TiposPeriodicidad12(String idSat,String descripcion,TiposNomina12 tipo){
		this(idSat,descripcion,null,tipo);
	}
	
	
	
	TiposPeriodicidad12(String idSat,String descripcion,String[] sinonimos,TiposNomina12 tipo){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		this.tipoNomina=tipo;
	}

	public static TiposPeriodicidad12 busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		for(TiposPeriodicidad12 m:values()){
			if(m.idSat.equals(descripcion))
				return m;
			else if(Utilerias.compara(m.descripcion,descripcion))
				return m;
			else if(m.sinonimos!=null){
				for(String s:m.sinonimos){
					if(Utilerias.compara(s,descripcion))
						return m;
				}
			}
		}
		return null;
	}
	
	public static TiposPeriodicidad12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposPeriodicidad12 estado =  TiposPeriodicidad12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de periodicidad "+metodo+" no se encuentra en el catálogo de Tipos de Periodicidad del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposPeriodicidad12 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static TiposPeriodicidad12 getTipoPeriodicidad(String periodicidad) {
		if(StringUtils.isEmpty(periodicidad))
			return null;
		for(TiposPeriodicidad12 m:values()){
			if(m.idSat.equals(periodicidad))
				return m;
			
		}
		return null;
	}
	@Override
	public String getIdString() {
		return idSat;
	}
	
	@Override
	public String toString(){
		return descripcion;
	}


	public static TiposPeriodicidad12 idSat(String periodicidad) {
		if(StringUtils.isEmpty(periodicidad))
			return null;
		for(TiposPeriodicidad12 m:values()){
			if(m.idSat.equals(periodicidad))
				return m;
			
		}
		return null;
	}
	

	public static String descripcion(String idSat){
		if(idSat==null) return "";
		final TiposPeriodicidad12 rf = idSat(idSat);
		if(rf!=null)
			return  idSat.concat(" - ").concat(rf.getDescripcion());
		return idSat;
	}
}
