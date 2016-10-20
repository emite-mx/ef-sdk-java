package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TipoContribuyenteSujetoRetencion implements Sat<String>{
	
	ARTISTASDEPORTISTAS("1","Artistas, deportistas y espectáculos públicos"),
	OTRASPERSONASFISICAS("2","Otras personas físicas"),
	PERSONAMORAL("3","Persona moral"),
	FIDEICOMISO("4","Fideicomiso"),
	ASOCIACIONENPARTICIPACION("5","Asociación en participación"),
	ORGANIZACIONESINTERNACIONALESOGOBIERNO("6","Organizaciones Internacionales o de gobierno"),
	ORGANIZACIONESEXENTAS("7","Organizaciones exentas"),
	AGENTESPAGADORES("8","Agentes pagadores"),
	OTROS("9","Otros"),
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	
	TipoContribuyenteSujetoRetencion(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	TipoContribuyenteSujetoRetencion(String idSat,String descripcion,String[] sinonimos){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		
	}

	public static TipoContribuyenteSujetoRetencion busca(Integer metodo) {
		for(TipoContribuyenteSujetoRetencion m:values()){
			if(metodo == Integer.parseInt(m.getIdSat()))
				return m;
		}
		return null;
	}
	
	public static TipoContribuyenteSujetoRetencion busca(String metodo) {
		for(TipoContribuyenteSujetoRetencion m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat,metodo))
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
	
	public static TipoContribuyenteSujetoRetencion unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TipoContribuyenteSujetoRetencion estado =  TipoContribuyenteSujetoRetencion.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de contribuyente sujeto a retención "+metodo+" no se encuentra en el catálogo de Tipos de Contribuyente del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TipoContribuyenteSujetoRetencion v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static void main(String[] args){
		for(TipoContribuyenteSujetoRetencion c:values()){
			System.out.println(c.idSat);
		}
		System.out.println();
		for(TipoContribuyenteSujetoRetencion c:values()){
			System.out.println(c.descripcion);
		}
	}
	
	
}
