package mx.emite.sdk.proxy.request.extra;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@ApiObject
public enum CamposNombreArchivo {

	NINGUNO(""),
	FECHA("Fecha (AAAAMMDD)"),
	ANO("Año (AAAA)"),
	MES("Mes (MM)"),
	DIA("Día (DD)"),
	RECEPTOR("Receptor (XAXX010101000)"),
	TIPOTIMBRE("Tipo Timbre"),
	UUID("Uuid (Folio Fiscal)"),
	SERIE("Serie"),
	FOLIO("Folio"),
	SUCURSAL("Sucursal");
	

	private final String descripcion;
	
	private CamposNombreArchivo(final String descripcion) {
		this.descripcion=descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	@JsonCreator
    public static CamposNombreArchivo forValue(String value) {
        if(StringUtils.isEmpty(value))
        	return null;
        for(CamposNombreArchivo t:values()){
        	if(t.name().equalsIgnoreCase(value))
        		return t;
        }
		throw new ApiException(I_Api_Errores.CLIENTE_REQUEST_INVALIDO,value+ " no es un valor válido ["+ Arrays.stream(values()).map(i->i.name()).collect(Collectors.joining(","))+"]");
    }

    @JsonValue
    public String toValue() {
       return this.name();
    }
	
	
}
