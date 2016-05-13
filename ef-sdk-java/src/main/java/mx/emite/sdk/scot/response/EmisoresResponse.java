package mx.emite.sdk.scot.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;
import mx.emite.sdk.scot.response.extra.Emisor;

@Getter
@Setter
@ToString(callSuper=true)
public class EmisoresResponse extends ScotResponse {

	/**
	 * @return lista de emisores
	 */
	private List<Emisor> emisores= new ArrayList<Emisor>();

	
	
	
}
