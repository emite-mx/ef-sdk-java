package mx.emite.sdk.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import mx.emite.sdk.NU;

public class Qr33 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7608898287877491544L;

	private final static String urlSat="https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx?";
	
	private final static DecimalFormat nf =  new DecimalFormat("000000000000000000.000000",new DecimalFormatSymbols(NU.local));
	
	public static String getQr(final String uuid,final String rfcEmisor,final String rfcReceptor,final String total,final String sello) throws Exception {
		return getQr(uuid,rfcEmisor,rfcReceptor,new BigDecimal(total),sello);
	}
	
	public static String getQr(final String uuid,final String rfcEmisor,final String rfcReceptor,final BigDecimal total,String sello) throws Exception {
		final StringBuilder sb = new StringBuilder(urlSat)
		.append("Id=").append(uuid)
		.append("&Re=").append(codifica(rfcEmisor))
		.append("&Rr=").append(codifica(rfcReceptor))
		.append("&Tt=").append(nf.format(total))
		.append("&Fe=").append(sello!=null&&sello.length()>8?sello.substring(sello.length()-8):"");
		return sb.toString();
		//final UriComponents uri = UriComponentsBuilder.fromHttpUrl(urlSat).queryParams(params).build();
		//return uri.toUriString();
		/*final UriBuilder uriBuilder = UriBuilder.create("http://foo/path?baz=bar#p1");
		Querybuilder
		
		return String.join("",urlSat,"?&id=",uuid,"&fe=",StringEscapeUtils.escapeXml10(emisor),"&rr=",StringEscapeUtils.escapeXml10(receptor)+"&tt="+Beans.nu().format(new BigDecimal(total),NumeroFormatos.CODIGOBARRAS),
				"&id="+uuid);*/
	}
	
	private static String codifica(String valor) {
		try{
			return URLEncoder.encode(valor,"UTF-8");
			
		}catch(Exception ex){
			return valor;
		}
	}
	
}
