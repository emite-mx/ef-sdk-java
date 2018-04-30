package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.serializers.FechaDeserializer;
import mx.emite.sdk.serializers.FechaSerializer;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
@ApiObject(description="infovalidacionlistanegra")
public class InfoValidacionListaNegra implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -857008416981283721L;
	@ApiObjectField(description="rfc en lista negra")
	private String rfc;
	@ApiObjectField(description="razon social")
	private String razonSocial;
	
	@ApiObjectField(description="tipo de lista negra",allowedvalues= {"I - Incumplidos", "O - Operaciones Simuladas","N - No localizados"})
	private String tipo;
	@ApiObjectField(description="situación fiscal ")
	private String situacion;
	@JsonSerialize(using=FechaSerializer.class)
	@JsonDeserialize(using=FechaDeserializer.class)
	@ApiObjectField(description="fecha de la situación fiscal")
	private LocalDate fecha;
	@ApiObjectField(description="mensaje adicional")
	private String mensaje;

	@JsonIgnore
	public String getErrorCompleto() {
		return StringUtils.join("rfc:",rfc," tipo:",tipo," situación:",situacion," mensaje: ",mensaje);
	}
	
	@JsonIgnore
	public String getErrorCompleto(final String rfc, final String razonSocial) {
		return StringUtils.join("Rfc:",rfc," Razón Social:",razonSocial, " Situación:",situacion," \"",mensaje,"\"");
	}

	
	private final static String[] tiposLn = new String[] {"I","O","N"};
	private final static String[] mensajeLn = new String[] {"Incumplidos","Operaciones Simuladas","No Localizados"};
	
	public static InfoValidacionListaNegra dummy(String r) {
		int indice = new Random().nextInt(tiposLn.length);
		return InfoValidacionListaNegra.builder()
				.rfc(r)
				.razonSocial("PRUEBA VALIDACION "+r)
				.tipo(tiposLn[indice])
				.fecha(LocalDate.now())
				.mensaje(mensajeLn[indice])
				.build();				
	}
	
}