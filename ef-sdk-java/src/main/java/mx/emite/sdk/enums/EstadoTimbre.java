package mx.emite.sdk.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;


public enum EstadoTimbre{
	TIMBRADAS,CANCELADAS, TODAS;
	
	@JsonCreator
    public static EstadoTimbre forValue(String value) {
        if(StringUtils.isEmpty(value))
        	return null;
        for(EstadoTimbre t:values()){
        	if(t.name().equalsIgnoreCase(value))
        		return t;
        }
        throw new ApiException(I_Api_Errores.CLIENTE_REQUEST_INVALIDO,value+ " no es un valor válido ["+ Arrays.stream(values()).map(i->i.name()).collect(Collectors.joining(","))+"]");
    }

    @JsonValue
    public String toValue() {
       return this.name();
    }
    public boolean in(EstadoTimbre... v){
    	for(EstadoTimbre a:v){
    		if(this.equals(a))
    			return true;
    	}
    	return false;
    }
    public boolean notin(EstadoTimbre... v){
    	return !in(v);
    }
}