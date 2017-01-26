package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum Monedas implements Sat<String>{
	MXN("MXN","Peso Mexicano",2,new String[]{"PESOS","M.N.","MN"}),
	USD("USD","Dolar americano",2,new String[]{"DOLARES"}),
	EUR("EUR","Euro",2,new String[]{"EUROS"}),
	AED("AED","Dirham de EAU",2),
	AFN("AFN","Afghani",2),
	ALL("ALL","Lek",2),
	AMD("AMD","Dram armenio",2),
	ANG("ANG","Florín antillano neerlandés",2),
	AOA("AOA","Kwanza",2),
	ARS("ARS","Peso Argentino",2),
	AUD("AUD","Dólar Australiano",2),
	AWG("AWG","Aruba Florin",2),
	AZN("AZN","Azerbaijanian Manat",2),
	BAM("BAM","Convertibles marca",2),
	BBD("BBD","Dólar de Barbados",2),
	BDT("BDT","Taka",2),
	BGN("BGN","Lev búlgaro",2),
	BHD("BHD","Dinar de Bahrein",3),
	BIF("BIF","Burundi Franc",0),
	BMD("BMD","Dólar de Bermudas",2),
	BND("BND","Dólar de Brunei",2),
	BOB("BOB","Boliviano",2),
	BOV("BOV","Mvdol",2),
	BRL("BRL","Real brasileño",2),
	BSD("BSD","Dólar de las Bahamas",2),
	BTN("BTN","Ngultrum",2),
	BWP("BWP","Pula",2),
	BYR("BYR","Rublo bielorruso",0),
	BZD("BZD","Dólar de Belice",2),
	CAD("CAD","Dolar Canadiense",2),
	CDF("CDF","Franco congoleño",2),
	CHE("CHE","WIR Euro",2),
	CHF("CHF","Franco Suizo",2),
	CHW("CHW","Franc WIR",2),
	CLF("CLF","Unidad de Fomento",4),
	CLP("CLP","Peso chileno",0),
	CNY("CNY","Yuan Renminbi",2),
	COP("COP","Peso Colombiano",2),
	COU("COU","Unidad de Valor real",2),
	CRC("CRC","Colón costarricense",2),
	CUC("CUC","Peso Convertible",2),
	CUP("CUP","Peso Cubano",2),
	CVE("CVE","Cabo Verde Escudo",2),
	CZK("CZK","Corona checa",2),
	DJF("DJF","Franco de Djibouti",0),
	DKK("DKK","Corona danesa",2),
	DOP("DOP","Peso Dominicano",2),
	DZD("DZD","Dinar argelino",2),
	EGP("EGP","Libra egipcia",2),
	ERN("ERN","Nakfa",2),
	ETB("ETB","Birr etíope",2),
	FJD("FJD","Dólar de Fiji",2),
	FKP("FKP","Libra malvinense",2),
	GBP("GBP","Libra Esterlina",2),
	GEL("GEL","Lari",2),
	GHS("GHS","Cedi de Ghana",2),
	GIP("GIP","Libra de Gibraltar",2),
	GMD("GMD","Dalasi",2),
	GNF("GNF","Franco guineano",0),
	GTQ("GTQ","Quetzal",2),
	GYD("GYD","Dólar guyanés",2),
	HKD("HKD","Dolar De Hong Kong",2),
	HNL("HNL","Lempira",2),
	HRK("HRK","Kuna",2),
	HTG("HTG","Gourde",2),
	HUF("HUF","Florín",2),
	IDR("IDR","Rupia",2),
	ILS("ILS","Nuevo Shekel Israelí",2),
	INR("INR","Rupia india",2),
	IQD("IQD","Dinar iraquí",3),
	IRR("IRR","Rial iraní",2),
	ISK("ISK","Corona islandesa",0),
	JMD("JMD","Dólar Jamaiquino",2),
	JOD("JOD","Dinar jordano",3),
	JPY("JPY","Yen",0),
	KES("KES","Chelín keniano",2),
	KGS("KGS","Som",2),
	KHR("KHR","Riel",2),
	KMF("KMF","Franco Comoro",0),
	KPW("KPW","Corea del Norte ganó",2),
	KRW("KRW","Won",0),
	KWD("KWD","Dinar kuwaití",3),
	KYD("KYD","Dólar de las Islas Caimán",2),
	KZT("KZT","Tenge",2),
	LAK("LAK","Kip",2),
	LBP("LBP","Libra libanesa",2),
	LKR("LKR","Rupia de Sri Lanka",2),
	LRD("LRD","Dólar liberiano",2),
	LSL("LSL","Loti",2),
	LYD("LYD","Dinar libio",3),
	MAD("MAD","Dirham marroquí",2),
	MDL("MDL","Leu moldavo",2),
	MGA("MGA","Ariary malgache",2),
	MKD("MKD","Denar",2),
	MMK("MMK","Kyat",2),
	MNT("MNT","Tugrik",2),
	MOP("MOP","Pataca",2),
	MRO("MRO","Ouguiya",2),
	MUR("MUR","Rupia de Mauricio",2),
	MVR("MVR","Rupia",2),
	MWK("MWK","Kwacha",2),
	
	MXV("MXV","México Unidad de Inversión (UDI)",2),
	MYR("MYR","Ringgit malayo",2),
	MZN("MZN","Mozambique Metical",2),
	NAD("NAD","Dólar de Namibia",2),
	NGN("NGN","Naira",2),
	NIO("NIO","Córdoba Oro",2),
	NOK("NOK","Corona noruega",2),
	NPR("NPR","Rupia nepalí",2),
	NZD("NZD","Dólar de Nueva Zelanda",2),
	OMR("OMR","Rial omaní",3),
	PAB("PAB","Balboa",2),
	PEN("PEN","Nuevo Sol",2),
	PGK("PGK","Kina",2),
	PHP("PHP","Peso filipino",2),
	PKR("PKR","Rupia de Pakistán",2),
	PLN("PLN","Zloty",2),
	PYG("PYG","Guaraní",0),
	QAR("QAR","Qatar Rial",2),
	RON("RON","Leu rumano",2),
	RSD("RSD","Dinar serbio",2),
	RUB("RUB","Rublo ruso",2),
	RWF("RWF","Franco ruandés",0),
	SAR("SAR","Riyal saudí",2),
	SBD("SBD","Dólar de las Islas Salomón",2),
	SCR("SCR","Rupia de Seychelles",2),
	SDG("SDG","Libra sudanesa",2),
	SEK("SEK","Corona sueca",2),
	SGD("SGD","Dolar De Singapur",2),
	SHP("SHP","Libra de Santa Helena",2),
	SLL("SLL","Leona",2),
	SOS("SOS","Chelín somalí",2),
	SRD("SRD","Dólar de Suriname",2),
	SSP("SSP","Libra sudanesa Sur",2),
	STD("STD","Dobra",2),
	SVC("SVC","Colon El Salvador",2),
	SYP("SYP","Libra Siria",2),
	SZL("SZL","Lilangeni",2),
	THB("THB","Baht",2),
	TJS("TJS","Somoni",2),
	TMT("TMT","Turkmenistán nuevo manat",2),
	TND("TND","Dinar tunecino",3),
	TOP("TOP","Pa'anga",2),
	TRY("TRY","Lira turca",2),
	TTD("TTD","Dólar de Trinidad y Tobago",2),
	TWD("TWD","Nuevo dólar de Taiwán",2),
	TZS("TZS","Shilling tanzano",2),
	UAH("UAH","Hryvnia",2),
	UGX("UGX","Shilling de Uganda",0),
	
	USN("USN","Dólar estadounidense (día siguiente)",2),
	UYI("UYI","Peso Uruguay en Unidades Indexadas (URUIURUI)",0),
	UYU("UYU","Peso Uruguayo",2),
	UZS("UZS","Uzbekistán Sum",2),
	VEF("VEF","Bolívar",2),
	VND("VND","Dong",0),
	VUV("VUV","Vatu",0),
	WST("WST","Tala",2),
	XAF("XAF","Franco CFA BEAC",0),
	XAG("XAG","Plata",0),
	XAU("XAU","Oro",0),
	XBA("XBA","Unidad de Mercados de Bonos Unidad Europea Composite (EURCO)",0),
	XBB("XBB","Unidad Monetaria de Bonos de Mercados Unidad Europea (UEM-6)",0),
	XBC("XBC","Mercados de Bonos Unidad Europea unidad de cuenta a 9 (UCE-9)",0),
	XBD("XBD","Mercados de Bonos Unidad Europea unidad de cuenta a 17 (UCE-17)",0),
	XCD("XCD","Dólar del Caribe Oriental",2),
	XDR("XDR","DEG (Derechos Especiales de Giro)",0),
	XOF("XOF","Franco CFA BCEAO",0),
	XPD("XPD","Paladio",0),
	XPF("XPF","Franco CFP",0),
	XPT("XPT","Platino",0),
	XSU("XSU","Sucre",0),
	XTS("XTS","Códigos reservados específicamente para propósitos de prueba",0),
	XUA("XUA","Unidad ADB de Cuenta",0),
	XXX("XXX","Los códigos asignados para las transacciones en que intervenga ninguna moneda",0),
	YER("YER","Rial yemení",2),
	ZAR("ZAR","Rand",2),
	ZMW("ZMW","Kwacha zambiano",2),
	ZWL("ZWL","Zimbabwe Dólar",2);
	
	private final String idSat,descripcionMoneda;
	private final Integer decimales;
	private final String[] sinonimos;
	
	Monedas(String idSat,String descripcion,Integer decimales){
		this(idSat,descripcion,decimales,null);
	}
	
	Monedas(String idSat,String descripcion,Integer decimales,String[] sinonimos){
		this.idSat=idSat;
		this.descripcionMoneda=descripcion;
		this.decimales=decimales;
		this.sinonimos=sinonimos;
	}
	
	public String getCombo(){
		return idSat.concat(" (").concat(descripcionMoneda).concat(")");
	}
	
	@Override
	public String getDescripcion(){
		return idSat;
	}
	
	public static Monedas busca(String metodo) {
		for(Monedas m:values()){
			if(Utilerias.compara(m.idSat,metodo))
				return m;
			else if(Utilerias.compara(m.descripcionMoneda, metodo)){
				return m;
			}
			else if(m.sinonimos!=null){
				for(String s:m.sinonimos){
					if(Utilerias.compara(s, metodo))
						return m;
				}
			}
		}
		return null;
	}
	
	public static Monedas unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final Monedas estado =  Monedas.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La moneda del comprobante "+metodo+" no se encuentra en el catálogo de monedas SAT (ISO 4217)");
		else
			return estado;
	}
	
	
	public static String marshall(Monedas v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static boolean existe(String mon) {
		for(Monedas m:values()){
			if(m.idSat.equals(mon))
				return true;
		}
		return false;
	}
	
	
}
