package mx.emite.sdk.enums.sat.cfdi33;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import com.google.common.collect.Lists;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Getter
public enum MetodosPago33 implements Sat<String>{
	
	UNASOLAEXHIBICION("PUE","Pago en una sola exhibición"),
	INICIALYPARCIALIDADES("PIP","Pago inicial y parcialidades"),
	PARCIALIDADESODIFERIDO("PPD","Pago en parcialidades o diferido"),
	
	
	;
	
	
	final String idSat;
	final String descripcion;
	
	MetodosPago33(String idSat,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
	
	}

	public static MetodosPago33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final MetodosPago33 estado =  MetodosPago33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El MetodoPago  "+metodo+" no se encuentra en el catálogo de MetodoPago del SAT");
		else
			return estado;
	}

	private static MetodosPago33 busca(String metodo) {
		for(MetodosPago33 it:values()){
			if(it.getIdSat().equals(metodo))
				return it;
		}
		return null;
	}

	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static String marshall(MetodosPago33 v) throws Exception {
		if(v==null)
			return null;
		return v.marshall();
	}
	
	private String marshall(){
		return idSat;
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}

	public static MetodosPago33 idSat(String tipoDeComprobante) {
		for(MetodosPago33 it:values()){
			if(it.getIdSat().equals(tipoDeComprobante))
				return it;
		}
		return null;
	}
	
	public boolean in(MetodosPago33... lista){
		for(MetodosPago33 tc:lista){
			if(this.equals(tc))
				return true;
		}
		return false;
	}
	
	public boolean requiereComplementoPago(){
		return  in(INICIALYPARCIALIDADES);
	}
	
	public static List<MetodosPago33> combo(){
		return Lists.newArrayList(values()).stream().sorted(Comparator.comparing(MetodosPago33::getIdSat)).collect(Collectors.toList());
	}

	public String getCombo() {
		return idSat.concat(" - ").concat(descripcion);
	}
	
	/*
		
	
	
	
	
	private String getIdSatString(){
		return marshall();
	}
	
	

	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(FormasPago33::getIdSatString).collect(Collectors.toList());		
	}
	*/
	
}
