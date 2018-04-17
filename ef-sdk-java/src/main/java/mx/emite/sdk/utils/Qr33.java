package mx.emite.sdk.utils;

import java.io.Serializable;
import java.math.BigDecimal;
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
	
	public static void main(String[] agrs) {
		
		//System.out.println("BM&910702B15".replaceAll("&", "&amp;"));
		
	}
	
	public static String getQr(final String uuid,final String rfcEmisor,final String rfcReceptor,final BigDecimal total,String selloEmisor) throws Exception {
		//https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx?id=C76CEEC9-843F-4A71-9678-50FCD10604E5&re=PAGJ780918RS4&rr=UPM980921RI2&tt=3527.34&fe=P+a/Dw==
		final StringBuilder sb = new StringBuilder(urlSat)
		.append("id=").append(uuid)
		.append("&re=").append(rfcEmisor.replaceAll("&", "&amp;"))
		.append("&rr=").append(rfcReceptor.replaceAll("&", "&amp;"))
		.append("&tt=").append(nf.format(total))
		.append("&fe=").append(selloEmisor!=null&&selloEmisor.length()>8?selloEmisor.substring(selloEmisor.length()-8):"");
		return sb.toString();
		//final UriComponents uri = UriComponentsBuilder.fromHttpUrl(urlSat).queryParams(params).build();
		//return uri.toUriString();
		/*final UriBuilder uriBuilder = UriBuilder.create("http://foo/path?baz=bar#p1");
		Querybuilder
		
		return String.join("",urlSat,"?&id=",uuid,"&fe=",StringEscapeUtils.escapeXml10(emisor),"&rr=",StringEscapeUtils.escapeXml10(receptor)+"&tt="+Beans.nu().format(new BigDecimal(total),NumeroFormatos.CODIGOBARRAS),
				"&id="+uuid);*/
	}
	
	/*private static String codifica(String valor) {
		try{
			return URLEncoder.encode(valor,"UTF-8");
			
		}catch(Exception ex){
			return valor;
		}
	}*/
	
}
