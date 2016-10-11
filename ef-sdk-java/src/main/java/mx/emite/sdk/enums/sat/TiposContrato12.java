package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposContrato12 implements Sat<String>{
	
	TIEMPOINDETERMINADO("01","Contrato de trabajo por tiempo indeterminado"),
	POROBRADETERMINADA("02","Contrato de trabajo para obra determinada"),
	PORTIEMPODETERMINADO("03","Contrato de trabajo por tiempo determinado"),
	PORTEMPORADA("04","Contrato de trabajo por temporada"),
	APRUEBA("05","Contrato de trabajo sujeto a prueba"),
	CAPACITACIONINICIAL("06","Contrato de trabajo con capacitación inicial"),
	PORHORA("07","Modalidad de contratación por pago de hora laborada"),
	PORCOMISION("08","Modalidad de trabajo por comisión laboral"),
	SINRELACION("09","Modalidades de contratación donde no existe relación de trabajo"),
	JUBILACION("10","Jubilación, pensión, retiro."),
	OTROCONTRATO("99","Otro Contrato"),
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TiposContrato12(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TiposContrato12(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TiposContrato12 busca(String metodo) {
		for(TiposContrato12 m:values()){
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
	
	public static TiposContrato12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposContrato12 estado =  TiposContrato12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de contrato "+metodo+" no se encuentra en el catálogo de Tipos de Contrato del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposContrato12 v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	
}
