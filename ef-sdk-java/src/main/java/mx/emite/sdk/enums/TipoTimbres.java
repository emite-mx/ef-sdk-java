package mx.emite.sdk.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@ApiObject
public enum TipoTimbres {
	
	TODOS(0,"TODOS",true),
	CFDI(1,"CFDI",false),
	NOMINA(2,"NOMINA",false),
	RETENCIONES(3,"RETENCIONES",false),
	PSRDD(4,"PSRDD",false),
	CONTABILIDAD(5,"CONTABILIDAD",false),
	VALIDACION(6,"VALIDACION",false),
	
	;
	
	private Integer id;
	private String titulo;
	private Boolean universal;
	
	TipoTimbres(Integer val,String titulo,Boolean universal){
		this.id=val;
		this.titulo=titulo;
		this.universal=universal;
		
	}
	public static TipoTimbres getTipo(Integer estatus) {
		for(TipoTimbres e:values()){
			if(e.id.equals(estatus))
				return e;
		}
		return null;
	}
	
	
	public Integer getId() {
		return id;
	}

	
	public String getDescripcion() {
		return titulo;
	}
	@Override
	public String toString() {
		return titulo;
	}
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public Boolean getUniversal() {
		return universal;
	}
	public void setUniversal(Boolean universal) {
		this.universal = universal;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public boolean compara(String compara) {
		return id==null?false:compara==null?false:id.equals(Integer.parseInt(compara));
	}
	public static String[] listaQuita(TipoTimbres... erroren) {
		String[] res = new String[values().length-erroren.length];
		int x=0;
		for(TipoTimbres t:values()){
			if(!t.in(erroren)){
				res[x] = t.name();
				x++;
			}
		}		
		return res;
	}
	
	public boolean in(TipoTimbres... erroren) {
		for(TipoTimbres t:erroren){
			if(this.equals(t))
				return true;
		}
		return false;
	}
	
	public static TipoTimbres[] getSintodos(){
		final TipoTimbres[] res = new TipoTimbres[values().length-1];
		for(int x=1;x<values().length;x++)
			res[x-1]=values()[x];
		return res;
	}
	
	public static TipoTimbres cargaTipo(TipoTimbres tipoTimbre,TipoTimbres erroren) throws ApiException{
		return cargaTipo(tipoTimbre.name(),erroren);
	}
	
	public static TipoTimbres cargaTipo(String tipoTimbre,TipoTimbres erroren) throws ApiException{
		for(TipoTimbres t:TipoTimbres.values()){
			if(t.name().equalsIgnoreCase(tipoTimbre)){
				if(t.equals(erroren))
					throw new ApiException(I_Api_Errores.SCOT_EMITE_TIPO_INCORRECTO,Arrays.toString(TipoTimbres.listaQuita(erroren)));
				return t;
			}
		}
		throw new ApiException(I_Api_Errores.SCOT_EMITE_TIPO_TIMBRE);
	}
	public boolean notin(TipoTimbres... todos) {
		return !in(todos);
	}
	public boolean cobroMultiple() {
		switch(this){
		case CFDI:
		case CONTABILIDAD:
		case NOMINA:
		case PSRDD:
		case RETENCIONES:
		case TODOS:
			return false;
			
		case VALIDACION:
			return true;
		
		}
		return false;
	}
	public boolean validaEmisor() {
		switch(this){
		case CFDI:
		case CONTABILIDAD:
		case NOMINA:
		case PSRDD:
		case RETENCIONES:
		case TODOS:
			return true;
			
		case VALIDACION:
			return false;
		
		}
		return true;
	}
	public boolean llevaHash() {
		switch(this){
		case NOMINA:
		case CFDI:
		case RETENCIONES:
			return true;
		case CONTABILIDAD:
		case PSRDD:
		case TODOS:
		case VALIDACION:
			return false;
		}
		return false;
	}
	
	@JsonCreator
    public static TipoTimbres forValue(String value) {
        if(StringUtils.isEmpty(value))
        	return null;
        for(TipoTimbres t:values()){
        	if(t.name().equalsIgnoreCase(value))
        		return t;
        }
		throw new ApiException(I_Api_Errores.CLIENTE_REQUEST_INVALIDO,value+ " no es un valor válido ["+ Arrays.stream(values()).map(i->i.name()).collect(Collectors.joining(","))+"]");
    }

    @JsonValue
    public String toValue() {
       return this.name();
    }
	
    
    public static TipoTimbres[] consultables(){
		final TipoTimbres[] res = new TipoTimbres[values().length-1];
		for(int x=1;x<values().length;x++)
			res[x-1]=values()[x];
		return res;
	}
	
	
}