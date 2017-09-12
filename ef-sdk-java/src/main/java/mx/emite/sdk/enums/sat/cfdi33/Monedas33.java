package mx.emite.sdk.enums.sat.cfdi33;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Getter
public enum Monedas33 implements Sat<String>{
	
	MXN("MXN","Peso Mexicano",2,0.352742445236724),
	USD("USD","Dolar americano",2,0.352742445236724),
	EUR("EUR","Euro",2,0.39672087279239),
	AED("AED","Dirham de EAU",2,0.352742445236724),
	AFN("AFN","Afghani",2,0.352742445236724),
	ALL("ALL","Lek",2,0.352742445236724),
	AMD("AMD","Dram armenio",2,0.352742445236724),
	ANG("ANG","Florín antillano neerlandés",2,0.352742445236724),
	AOA("AOA","Kwanza",2,0.352742445236724),
	ARS("ARS","Peso Argentino",2,0.629721772651321),
	AUD("AUD","Dólar Australiano",2,0.436901209159141),
	AWG("AWG","Aruba Florin",2,0.352742445236724),
	AZN("AZN","Azerbaijanian Manat",2,0.352742445236724),
	BAM("BAM","Convertibles marca",2,0.352742445236724),
	BBD("BBD","Dólar de Barbados",2,0.352742445236724),
	BDT("BDT","Taka",2,0.352742445236724),
	BGN("BGN","Lev búlgaro",2,0.352742445236724),
	BHD("BHD","Dinar de Bahrein",3,0.352742445236724),
	BIF("BIF","Burundi Franc",0,0.352742445236724),
	BMD("BMD","Dólar de Bermudas",2,0.352742445236724),
	BND("BND","Dólar de Brunei",2,0.352742445236724),
	BOB("BOB","Boliviano",2,0.353625258849321),
	BOV("BOV","Mvdol",2,0.352742445236724),
	BRL("BRL","Real brasileño",2,0.509556451999528),
	BSD("BSD","Dólar de las Bahamas",2,0.352742445236724),
	BTN("BTN","Ngultrum",2,0.352742445236724),
	BWP("BWP","Pula",2,0.352742445236724),
	BYR("BYR","Rublo bielorruso",0,0.352742445236724),
	BZD("BZD","Dólar de Belice",2,0.362979960016213),
	CAD("CAD","Dolar Canadiense",2,0.31494390158765),
	CDF("CDF","Franco congoleño",2,0.352742445236724),
	CHE("CHE","WIR Euro",2,0.352742445236724),
	CHF("CHF","Franco Suizo",2,0.494670117054094),
	CHW("CHW","Franc WIR",2,0.352742445236724),
	CLF("CLF","Unidad de Fomento",4,0.352742445236724),
	CLP("CLP","Peso chileno",0,0.446786779502429),
	CNY("CNY","Yuan Renminbi",2,0.277564845995828),
	COP("COP","Peso Colombiano",2,0.332248557734335),
	COU("COU","Unidad de Valor real",2,0.352742445236724),
	CRC("CRC","Colón costarricense",2,0.311959319801703),
	CUC("CUC","Peso Convertible",2,0.352742445236724),
	CUP("CUP","Peso Cubano",2,0.362979960016214),
	CVE("CVE","Cabo Verde Escudo",2,0.352742445236724),
	CZK("CZK","Corona checa",2,0.416334175667417),
	DJF("DJF","Franco de Djibouti",0,0.352742445236724),
	DKK("DKK","Corona danesa",2,0.398750728222186),
	DOP("DOP","Peso Dominicano",2,0.508078961420075),
	DZD("DZD","Dinar argelino",2,0.303262598072916),
	EGP("EGP","Libra egipcia",2,0.340492272284569),
	ERN("ERN","Nakfa",2,0.352742445236724),
	ETB("ETB","Birr etíope",2,0.352742445236724),
	FJD("FJD","Dólar de Fiji",2,0.354643691147613),
	FKP("FKP","Libra malvinense",2,0.352742445236724),
	GBP("GBP","Libra Esterlina",2,0.287969717061674),
	GEL("GEL","Lari",2,0.352742445236724),
	GHS("GHS","Cedi de Ghana",2,0.352742445236724),
	GIP("GIP","Libra de Gibraltar",2,0.352742445236724),
	GMD("GMD","Dalasi",2,0.352742445236724),
	GNF("GNF","Franco guineano",0,0.352742445236724),
	GTQ("GTQ","Quetzal",2,0.35653159361199),
	GYD("GYD","Dólar guyanés",2,0.351785052747086),
	HKD("HKD","Dolar De Hong Kong",2,0.353161965300373),
	HNL("HNL","Lempira",2,0.276419223373733),
	HRK("HRK","Kuna",2,0.352742445236724),
	HTG("HTG","Gourde",2,0.352742445236724),
	HUF("HUF","Florín",2,0.375905790474456),
	IDR("IDR","Rupia",2,0.347786255646005),
	ILS("ILS","Nuevo Shekel Israelí",2,0.330582456192405),
	INR("INR","Rupia india",2,0.295397850815415),
	IQD("IQD","Dinar iraquí",3,0.586089265308866),
	IRR("IRR","Rial iraní",2,0.352742445236724),
	ISK("ISK","Corona islandesa",0,0.352742445236724),
	JMD("JMD","Dólar Jamaiquino",2,0.281001946982178),
	JOD("JOD","Dinar jordano",3,0.352742445236724),
	JPY("JPY","Yen",0,0.572682303832548),
	KES("KES","Chelín keniano",2,0.302136242413111),
	KGS("KGS","Som",2,0.352742445236724),
	KHR("KHR","Riel",2,0.352742445236724),
	KMF("KMF","Franco Comoro",0,0.352742445236724),
	KPW("KPW","Corea del Norte ganó",2,0.352742445236724),
	KRW("KRW","Won",0,0.353767614332004),
	KWD("KWD","Dinar kuwaití",3,0.327060682084407),
	KYD("KYD","Dólar de las Islas Caimán",2,0.352742445236724),
	KZT("KZT","Tenge",2,0.352742445236724),
	LAK("LAK","Kip",2,0.352742445236724),
	LBP("LBP","Libra libanesa",2,0.352742445236724),
	LKR("LKR","Rupia de Sri Lanka",2,0.352742445236724),
	LRD("LRD","Dólar liberiano",2,0.352742445236724),
	LSL("LSL","Loti",2,0.352742445236724),
	LYD("LYD","Dinar libio",3,0.352742445236724),
	MAD("MAD","Dirham marroquí",2,0.358811092281766),
	MDL("MDL","Leu moldavo",2,0.352742445236724),
	MGA("MGA","Ariary malgache",2,0.352742445236724),
	MKD("MKD","Denar",2,0.352742445236724),
	MMK("MMK","Kyat",2,0.352742445236724),
	MNT("MNT","Tugrik",2,0.352742445236724),
	MOP("MOP","Pataca",2,0.352742445236724),
	MRO("MRO","Ouguiya",2,0.352742445236724),
	MUR("MUR","Rupia de Mauricio",2,0.352742445236724),
	MVR("MVR","Rupia",2,0.352742445236724),
	MWK("MWK","Kwacha",2,0.352742445236724),
	MXV("MXV","México Unidad de Inversión (UDI)",2,0.352742445236724),
	MYR("MYR","Ringgit malayo",2,0.266974085521927),
	MZN("MZN","Mozambique Metical",2,0.352742445236724),
	NAD("NAD","Dólar de Namibia",2,0.352742445236724),
	NGN("NGN","Naira",2,0.309794139945863),
	NIO("NIO","Córdoba Oro",2,0.352742445236724),
	NOK("NOK","Corona noruega",2,0.339456927475235),
	NPR("NPR","Rupia nepalí",2,0.352742445236724),
	NZD("NZD","Dólar de Nueva Zelanda",2,0.447641493440927),
	OMR("OMR","Rial omaní",3,0.352742445236724),
	PAB("PAB","Balboa",2,0.352742445236724),
	PEN("PEN","Nuevo Sol",2,0.28888497390075),
	PGK("PGK","Kina",2,0.352742445236724),
	PHP("PHP","Peso filipino",2,0.295977140186533),
	PKR("PKR","Rupia de Pakistán",2,0.352742445236724),
	PLN("PLN","Zloty",2,0.386492746681686),
	PYG("PYG","Guaraní",0,0.365789978216704),
	QAR("QAR","Qatar Rial",2,0.352742445236724),
	RON("RON","Leu rumano",2,0.35881075582858),
	RSD("RSD","Dinar serbio",2,0.352742445236724),
	RUB("RUB","Rublo ruso",2,0.351895919908846),
	RWF("RWF","Franco ruandés",0,0.352742445236724),
	SAR("SAR","Riyal saudí",2,0.351727634700162),
	SBD("SBD","Dólar de las Islas Salomón",2,0.352742445236724),
	SCR("SCR","Rupia de Seychelles",2,0.352742445236724),
	SDG("SDG","Libra sudanesa",2,0.352742445236724),
	SEK("SEK","Corona sueca",2,0.384311966867772),
	SGD("SGD","Dolar De Singapur",2,0.353931590142105),
	SHP("SHP","Libra de Santa Helena",2,0.352742445236724),
	SLL("SLL","Leona",2,0.352742445236724),
	SOS("SOS","Chelín somalí",2,0.352742445236724),
	SRD("SRD","Dólar de Suriname",2,0.352742445236724),
	SSP("SSP","Libra sudanesa Sur",2,0.352742445236724),
	STD("STD","Dobra",2,0.352742445236724),
	SVC("SVC","Colon El Salvador",2,0.352742445236724),
	SYP("SYP","Libra Siria",2,0.352742445236724),
	SZL("SZL","Lilangeni",2,0.352742445236724),
	THB("THB","Baht",2,0.371799266808341),
	TJS("TJS","Somoni",2,0.352742445236724),
	TMT("TMT","Turkmenistán nuevo manat",2,0.352742445236724),
	TND("TND","Dinar tunecino",3,0.352742445236724),
	TOP("TOP","Pa'anga",2,0.352742445236724),
	TRY("TRY","Lira turca",2,0.353388670891485),
	TTD("TTD","Dólar de Trinidad y Tobago",2,0.285292691870894),
	TWD("TWD","Nuevo dólar de Taiwán",2,0.300870290155189),
	TZS("TZS","Shilling tanzano",2,0.352742445236724),
	UAH("UAH","Hryvnia",2,0.508387405683213),
	UGX("UGX","Shilling de Uganda",0,0.352742445236724),
	USN("USN","Dólar estadounidense (día siguiente)",2,0.352742445236724),
	UYI("UYI","Peso Uruguay en Unidades Indexadas (URUIURUI)",0,0.352742445236724),
	UYU("UYU","Peso Uruguayo",2,0.317871497279116),
	UZS("UZS","Uzbekistán Sum",2,0.352742445236724),
	VEF("VEF","Bolívar",2,1.52771210091442),
	VND("VND","Dong",0,0.300617608153373),
	VUV("VUV","Vatu",0,0.352742445236724),
	WST("WST","Tala",2,0.352742445236724),
	XAF("XAF","Franco CFA BEAC",0,0.352742445236724),
	XAG("XAG","Plata",0,0.352742445236724),
	XAU("XAU","Oro",0,0.352742445236724),
	XBA("XBA","Unidad de Mercados de Bonos Unidad Europea Composite (EURCO)",0,0.352742445236724),
	XBB("XBB","Unidad Monetaria de Bonos de Mercados Unidad Europea (UEM-6)",0,0.352742445236724),
	XBC("XBC","Mercados de Bonos Unidad Europea unidad de cuenta a 9 (UCE-9)",0,0.352742445236724),
	XBD("XBD","Mercados de Bonos Unidad Europea unidad de cuenta a 17 (UCE-17)",0,0.352742445236724),
	XCD("XCD","Dólar del Caribe Oriental",2,0.352742445236724),
	XDR("XDR","DEG (Derechos Especiales de Giro)",0,0.36813419592436),
	XOF("XOF","Franco CFA BCEAO",0,0.352742445236724),
	XPD("XPD","Paladio",0,0.352742445236724),
	XPF("XPF","Franco CFP",0,0.352742445236724),
	XPT("XPT","Platino",0,0.352742445236724),
	XSU("XSU","Sucre",0,0.352742445236724),
	XTS("XTS","Códigos reservados específicamente para propósitos de prueba",0,0),
	XUA("XUA","Unidad ADB de Cuenta",0,0.352742445236724),
	XXX("XXX","Los códigos asignados para las transacciones en que intervenga ninguna moneda",0,0),
	YER("YER","Rial yemení",2,0.352742445236724),
	ZAR("ZAR","Rand",2,0.540140950966442),
	ZMW("ZMW","Kwacha zambiano",2,0.352742445236724),
	ZWL("ZWL","Zimbabwe Dólar",2,0.352742445236724),
	
	;
	
	
	final String idSat;
	final String descripcion;
	final Integer decimales;
	final BigDecimal porcentajeVariacion;
	
	Monedas33(String idSat,String descripcion,int decimales,double porcentajeVariacion){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.decimales=decimales;
		this.porcentajeVariacion=  /*porcentajeVariacion==0?new BigDecimal("0.000"): new BigDecimal("5.000");*/
				BigDecimal.valueOf(porcentajeVariacion).setScale(15,RoundingMode.HALF_EVEN);
		
	}

	public static Monedas33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final Monedas33 estado =  Monedas33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La Moneda  "+metodo+" no se encuentra en el catálogo de monedas del SAT");
		else
			return estado;
	}

	private static Monedas33 busca(String metodo) {
		for(Monedas33 it:values()){
			if(it.getIdSat().equals(metodo))
				return it;
		}
		return null;
	}

	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static String marshall(Monedas33 v) throws Exception {
		if(v==null)
			return null;
		return v.marshall();
	}
	
	private String marshall(){
		return idSat;
	}
	
	public static boolean existe(String mon) {
		for(Monedas33 m:values()){
			if(m.idSat.equals(mon))
				return true;
		}
		
		return false;
	}

	public static Monedas33 idSat(String idSat) {
		for(Monedas33 m:values()){
			if(m.idSat.equals(idSat))
				return m;
		}
		return null;
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}
	
	public boolean in(Monedas33...monedas){
		for(Monedas33 m:monedas){
			if(this.equals(m))
				return true;
		}
		return false;
	}

	public boolean notin(Monedas33...monedas){
		return !in(monedas);
	}
	
	public boolean esPesos() {
		return this.equals(MXN);
	}

	public boolean esXXX() {
		return this.equals(XXX);
	}
	
	public boolean requiereTc() {
		return notin(MXN,XXX);
	}

	public boolean consultable() {
		return in(USD,EUR,CAD,JPY,GBP);
	}
	/*
		
	
	
	
	
	private String getIdSatString(){
		return marshall();
	}
	
	

	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(FormasPago33::getIdSatString).collect(Collectors.toList());		
	}
	*/
	
}
