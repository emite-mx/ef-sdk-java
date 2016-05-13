package mx.emite.sdk.scot.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;
import mx.emite.sdk.scot.response.extra.Sucursal;

@Getter
@Setter
@ToString(callSuper=true)
public class SucursalesResponse extends ScotResponse {

	
	
	/**
	 * @return lista de sucursales
	 */
	private List<Sucursal> sucursales = new ArrayList<Sucursal>();

	
}
