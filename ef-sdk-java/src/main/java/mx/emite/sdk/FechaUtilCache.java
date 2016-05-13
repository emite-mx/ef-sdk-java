package mx.emite.sdk;




import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import mx.emite.sdk.FU.FechaFormatos;


public class FechaUtilCache extends ThreadLocal<Map<FechaFormatos, DateTimeFormatter>> {
	
	
	
	@Override
	protected Map<FechaFormatos, DateTimeFormatter> initialValue() {
		return new HashMap<FechaFormatos, DateTimeFormatter>();
	}

	public DateTimeFormatter get(FechaFormatos tipo) {
		Map<FechaFormatos, DateTimeFormatter> map = get();
		DateTimeFormatter sdf = map.get(tipo);
		if (sdf == null) {
			sdf = DateTimeFormatter.ofPattern(tipo.getFormato(),new Locale("es","MX"));
			map.put(tipo, sdf);
		}
		return sdf;
	}
};