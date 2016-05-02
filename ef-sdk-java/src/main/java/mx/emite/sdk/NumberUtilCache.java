package mx.emite.sdk;



import java.text.Format;
import java.util.HashMap;
import java.util.Map;

import mx.emite.sdk.NU.NumeroFormatos;


public class NumberUtilCache extends ThreadLocal<Map<NumeroFormatos, Format>> {
	
	
	
	@Override
	protected Map<NumeroFormatos, Format> initialValue() {
		return new HashMap<NumeroFormatos, Format>();
	}

	public Format get(NumeroFormatos tipo) {
		Map<NumeroFormatos, Format> map = get();
		Format sdf = map.get(tipo);
		if (sdf == null) {
			sdf = tipo.getFormato();
			map.put(tipo, sdf);
		}
		return sdf;
	}
};