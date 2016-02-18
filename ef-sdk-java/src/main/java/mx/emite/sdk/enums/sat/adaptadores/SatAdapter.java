package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import mx.emite.sdk.enums.sat.Sat;

public abstract class SatAdapter<S extends Object, T extends Sat> extends XmlAdapter<S,T> {

	

	@Override
	public abstract T unmarshal(S metodo) throws Exception;

	@SuppressWarnings("unchecked")
	@Override
	public S marshal(T metodo) throws Exception {
		if(metodo==null)
			return null;
	    return (S)metodo.getDescripcion();
	  }
	}
 