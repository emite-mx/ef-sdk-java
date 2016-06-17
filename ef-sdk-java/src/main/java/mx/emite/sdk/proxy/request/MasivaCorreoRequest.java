package mx.emite.sdk.proxy.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.proxy.request.extra.CamposNombreArchivo;
import mx.emite.sdk.proxy.request.extra.ConsultaFiltro;
import mx.emite.sdk.proxy.request.extra.CorreoParametros;


@ToString
@Getter
@Builder
@AllArgsConstructor
public class MasivaCorreoRequest{


	/**
	 * Usuario del <b>Emisor</b> 
	 * -- SETTER --
	 * @param usuario Usuario del <b>Emisor</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull private String usuario;
	@NotNull private String contrasena;
	
	private String sucursal;
	
	@NotNull
	private Boolean xml;
	
	@NotNull
	private Boolean pdf;
	
	@NotNull
	private Boolean acuses;
	
	@NotNull
	private Boolean excel;
	
	@Valid @NotNull
	private ConsultaFiltro filtro;
	
	@NotEmpty @Valid
	private List<CamposNombreArchivo> folder;
	
	@NotEmpty @Valid
	private List<CamposNombreArchivo> archivo;
	
	@Valid @NotNull
	private CorreoParametros correo;
	
	
	
	public MasivaCorreoRequest() {
		super();
	}


	
	

	 
	
}
