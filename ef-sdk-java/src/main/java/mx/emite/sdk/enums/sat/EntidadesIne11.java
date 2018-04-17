
package mx.emite.sdk.enums.sat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EntidadesIne11 implements Sat<String>{

	AGUASCALIENTES("AGU","Aguascalientes"),
	BAJACALIFORNIA("BCN","Baja California"),
	BAJACALIFORNIASUR("BCS","Baja California Sur"),
	CAMPECHE("CAM","Campeche"),
	CHIAPAS("CHP","Chiapas"),
	CHIHUAHUA("CHH","Chihuahua"),
	COAHUILA("COA","Coahuila"),
	COLIMA("COL","Colima"),
	CIRCUNSCRIPCION1("CR1","Circunscripción 1"),
	CIRCUNSCRIPCION2("CR2","Circunscripción 2"),
	CIRCUNSCRIPCION3("CR3","Circunscripción 3"),
	CIRCUNSCRIPCION4("CR4","Circunscripción 4"),
	CIRCUNSCRIPCION5("CR5","Circunscripción 5"),
	CIUDADDEMEXICO("DIF","Ciudad de México"),
	DURANGO("DUR","Durango"),
	GUANAJUATO("GUA","Guanajuato"),
	GUERRERO("GRO","Guerrero"),
	HIDALGO("HID","Hidalgo"),
	JALISCO("JAL","Jalisco"),
	MEXICO("MEX","México"),
	MICHOACAN("MIC","Michoacán"),
	MORELOS("MOR","Morelos"),
	NACIONAL("NAC","Nacional"),
	NAYARIT("NAY","Nayarit"),
	NUEVOLEON("NLE","Nuevo León"),
	OAXACA("OAX","Oaxaca"),
	PUEBLA("PUE","Puebla"),
	QUERETARO("QUE","Querétaro"),
	QUINTANAROO("ROO","Quintana Roo"),
	SANLUISPOTOSI("SLP","San Luis Potosí"),
	SINALOA("SIN","Sinaloa"),
	SONORA("SON","Sonora"),
	TABASCO("TAB","Tabasco"),
	TAMAULIPAS("TAM","Tamaulipas"),
	TLAXCALA("TLA","Tlaxcala"),
	VERACRUZ("VER","Veracruz"),
	YUCATAN("YUC","Yucatán"),
	ZACATECAS("ZAC","Zacatecas"),
	;
	
	private final String idSat,descripcion;
	
	
	EntidadesIne11(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	
		
	}
	
	
	/**
	 * Busca un estado de acuerdo a su descripción
	 * @param descripcion de acuerdo al catalogo del SAT
	 * @return Estados valor del enum de acuerdo al estado
	 */
	public static EntidadesIne11 busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		for(EntidadesIne11 m:values()){
			if(Utilerias.compara(m.descripcion,descripcion))
				return m;
			else if(Utilerias.compara(m.idSat,descripcion))
				return m;
		}
		return null;
	}
	
	/**
	 * Busca un estado de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return Estados valor del enum de acuerdo al estado
	 */
	public static EntidadesIne11 id(String idSat) {
		for(EntidadesIne11 m:values()){
			if(StringUtils.equals(m.idSat,idSat))
				return m;
		}
		return null;
	}

	public String getIdEstado(){
		return idSat;
	}


	public static EntidadesIne11 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final EntidadesIne11 estado =  EntidadesIne11.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El estado "+metodo+" no se encuentra en el catálogo de estados del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(EntidadesIne11 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}



	public static boolean existe(String idSat) {
		for(EntidadesIne11 reg:values()){
			if(reg.getIdSat().equals(idSat))
				return true;
		}
		return false;
	}
	
	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(EntidadesIne11::getIdSat).collect(Collectors.toList());		
	}


	@Override
	public String getIdString() {
		return idSat;
	}


	public boolean in(EntidadesIne11... ents) {
		for(EntidadesIne11 e:ents) {
			if(this.equals(e))
				return true;
		}
		return false;
	}


	
}
