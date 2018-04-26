package mx.emite.sdk.enums.sat.cfdi33;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.enums.sat.Sat;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Getter
public enum Paises33 implements Sat<String>{
	
	MEX("MEX","México","[A-Z&Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]"),
	USA("USA","Estados Unidos (los)","[0-9]{9}"),
	CAN("CAN","Canadá","[0-9]{9}"),
	DEU("DEU","Alemania"),
	AUT("AUT","Austria"),
	BEL("BEL","Bélgica"),
	BGR("BGR","Bulgaria"),
	ESP("ESP","España"),
	FRA("FRA","Francia"),
	ITA("ITA","Italia"),
	POL("POL","Polonia"),
	PRT("PRT","Portugal"),
	CHE("CHE","Suiza"),
	GBR("GBR","Reino Unido (el)"),
	
	AFG("AFG","Afganistán"),
	ALA("ALA","Islas Åland"),
	ALB("ALB","Albania"),
	
	AND("AND","Andorra"),
	AGO("AGO","Angola"),
	AIA("AIA","Anguila"),
	ATA("ATA","Antártida"),
	ATG("ATG","Antigua y Barbuda"),
	SAU("SAU","Arabia Saudita"),
	DZA("DZA","Argelia"),
	ARG("ARG","Argentina"),
	ARM("ARM","Armenia"),
	ABW("ABW","Aruba"),
	AUS("AUS","Australia"),
	
	AZE("AZE","Azerbaiyán"),
	BHS("BHS","Bahamas (las)"),
	BGD("BGD","Bangladés"),
	BRB("BRB","Barbados"),
	BHR("BHR","Baréin"),

	BLZ("BLZ","Belice"),
	BEN("BEN","Benín"),
	BMU("BMU","Bermudas"),
	BLR("BLR","Bielorrusia"),
	MMR("MMR","Myanmar"),
	BOL("BOL","Bolivia, Estado Plurinacional de"),
	BIH("BIH","Bosnia y Herzegovina"),
	BWA("BWA","Botsuana"),
	BRA("BRA","Brasil"),
	BRN("BRN","Brunéi Darussalam"),

	BFA("BFA","Burkina Faso"),
	BDI("BDI","Burundi"),
	BTN("BTN","Bután"),
	CPV("CPV","Cabo Verde"),
	KHM("KHM","Camboya"),
	CMR("CMR","Camerún"),
	QAT("QAT","Catar"),
	BES("BES","Bonaire, San Eustaquio y Saba"),
	TCD("TCD","Chad"),
	CHL("CHL","Chile"),
	CHN("CHN","China"),
	CYP("CYP","Chipre"),
	COL("COL","Colombia"),
	COM("COM","Comoras"),
	PRK("PRK","Corea (la República Democrática Popular de)"),
	KOR("KOR","Corea (la República de)"),
	CIV("CIV","Côte d'Ivoire"),
	CRI("CRI","Costa Rica"),
	HRV("HRV","Croacia"),
	CUB("CUB","Cuba"),
	CUW("CUW","Curaçao"),
	DNK("DNK","Dinamarca"),
	DMA("DMA","Dominica"),
	ECU("ECU","Ecuador"),
	EGY("EGY","Egipto"),
	SLV("SLV","El Salvador"),
	ARE("ARE","Emiratos Árabes Unidos (Los)"),
	ERI("ERI","Eritrea"),
	SVK("SVK","Eslovaquia"),
	SVN("SVN","Eslovenia"),
	
	
	EST("EST","Estonia"),
	ETH("ETH","Etiopía"),
	PHL("PHL","Filipinas (las)"),
	FIN("FIN","Finlandia"),
	FJI("FJI","Fiyi"),

	GAB("GAB","Gabón"),
	GMB("GMB","Gambia (La)"),
	GEO("GEO","Georgia"),
	GHA("GHA","Ghana"),
	GIB("GIB","Gibraltar"),
	GRD("GRD","Granada"),
	GRC("GRC","Grecia"),
	GRL("GRL","Groenlandia"),
	GLP("GLP","Guadalupe"),
	GUM("GUM","Guam"),
	GTM("GTM","Guatemala"),
	GUF("GUF","Guayana Francesa"),
	GGY("GGY","Guernsey"),
	GIN("GIN","Guinea"),
	GNB("GNB","Guinea-Bisáu"),
	GNQ("GNQ","Guinea Ecuatorial"),
	GUY("GUY","Guyana"),
	HTI("HTI","Haití"),
	HND("HND","Honduras"),
	HKG("HKG","Hong Kong"),
	HUN("HUN","Hungría"),
	IND("IND","India"),
	IDN("IDN","Indonesia"),
	IRQ("IRQ","Irak"),
	IRN("IRN","Irán (la República Islámica de)"),
	IRL("IRL","Irlanda"),
	BVT("BVT","Isla Bouvet"),
	IMN("IMN","Isla de Man"),
	CXR("CXR","Isla de Navidad"),
	NFK("NFK","Isla Norfolk"),
	ISL("ISL","Islandia"),
	CYM("CYM","Islas Caimán (las)"),
	CCK("CCK","Islas Cocos (Keeling)"),
	COK("COK","Islas Cook (las)"),
	FRO("FRO","Islas Feroe (las)"),
	SGS("SGS","Georgia del sur y las islas sandwich del sur"),
	HMD("HMD","Isla Heard e Islas McDonald"),
	FLK("FLK","Islas Malvinas [Falkland] (las)"),
	MNP("MNP","Islas Marianas del Norte (las)"),
	MHL("MHL","Islas Marshall (las)"),
	PCN("PCN","Pitcairn"),
	SLB("SLB","Islas Salomón (las)"),
	TCA("TCA","Islas Turcas y Caicos (las)"),
	UMI("UMI","Islas de Ultramar Menores de Estados Unidos (las)"),
	VGB("VGB","Islas Vírgenes (Británicas)"),
	VIR("VIR","Islas Vírgenes (EE.UU.)"),
	ISR("ISR","Israel"),

	JAM("JAM","Jamaica"),
	JPN("JPN","Japón"),
	JEY("JEY","Jersey"),
	JOR("JOR","Jordania"),
	KAZ("KAZ","Kazajistán"),
	KEN("KEN","Kenia"),
	KGZ("KGZ","Kirguistán"),
	KIR("KIR","Kiribati"),
	KWT("KWT","Kuwait"),
	LAO("LAO","Lao, (la) República Democrática Popular"),
	LSO("LSO","Lesoto"),
	LVA("LVA","Letonia"),
	LBN("LBN","Líbano"),
	LBR("LBR","Liberia"),
	LBY("LBY","Libia"),
	LIE("LIE","Liechtenstein"),
	LTU("LTU","Lituania"),
	LUX("LUX","Luxemburgo"),
	MAC("MAC","Macao"),
	MDG("MDG","Madagascar"),
	MYS("MYS","Malasia"),
	MWI("MWI","Malaui"),
	MDV("MDV","Maldivas"),
	MLI("MLI","Malí"),
	MLT("MLT","Malta"),
	MAR("MAR","Marruecos"),
	MTQ("MTQ","Martinica"),
	MUS("MUS","Mauricio"),
	MRT("MRT","Mauritania"),
	MYT("MYT","Mayotte"),
	
	FSM("FSM","Micronesia (los Estados Federados de)"),
	MDA("MDA","Moldavia (la República de)"),
	MCO("MCO","Mónaco"),
	MNG("MNG","Mongolia"),
	MNE("MNE","Montenegro"),
	MSR("MSR","Montserrat"),
	MOZ("MOZ","Mozambique"),
	NAM("NAM","Namibia"),
	NRU("NRU","Nauru"),
	NPL("NPL","Nepal"),
	NIC("NIC","Nicaragua"),
	NER("NER","Níger (el)"),
	NGA("NGA","Nigeria"),
	NIU("NIU","Niue"),
	NOR("NOR","Noruega"),
	NCL("NCL","Nueva Caledonia"),
	NZL("NZL","Nueva Zelanda"),
	OMN("OMN","Omán"),
	NLD("NLD","Países Bajos (los)"),
	PAK("PAK","Pakistán"),
	PLW("PLW","Palaos"),
	PSE("PSE","Palestina, Estado de"),
	PAN("PAN","Panamá"),
	PNG("PNG","Papúa Nueva Guinea"),
	PRY("PRY","Paraguay"),
	PER("PER","Perú"),
	PYF("PYF","Polinesia Francesa"),

	PRI("PRI","Puerto Rico"),
	
	CAF("CAF","República Centroafricana (la)"),
	CZE("CZE","República Checa (la)"),
	MKD("MKD","Macedonia (la antigua República Yugoslava de)"),
	COG("COG","Congo"),
	COD("COD","Congo (la República Democrática del)"),
	DOM("DOM","República Dominicana (la)"),
	REU("REU","Reunión"),
	RWA("RWA","Ruanda"),
	ROU("ROU","Rumania"),
	RUS("RUS","Rusia, (la) Federación de"),
	ESH("ESH","Sahara Occidental"),
	WSM("WSM","Samoa"),
	ASM("ASM","Samoa Americana"),
	BLM("BLM","San Bartolomé"),
	KNA("KNA","San Cristóbal y Nieves"),
	SMR("SMR","San Marino"),
	MAF("MAF","San Martín (parte francesa)"),
	SPM("SPM","San Pedro y Miquelón"),
	VCT("VCT","San Vicente y las Granadinas"),
	SHN("SHN","Santa Helena, Ascensión y Tristán de Acuña"),
	LCA("LCA","Santa Lucía"),
	STP("STP","Santo Tomé y Príncipe"),
	SEN("SEN","Senegal"),
	SRB("SRB","Serbia"),
	SYC("SYC","Seychelles"),
	SLE("SLE","Sierra leona"),
	SGP("SGP","Singapur"),
	SXM("SXM","Sint Maarten (parte holandesa)"),
	SYR("SYR","Siria, (la) República Árabe"),
	SOM("SOM","Somalia"),
	LKA("LKA","Sri Lanka"),
	SWZ("SWZ","Suazilandia"),
	ZAF("ZAF","Sudáfrica"),
	SDN("SDN","Sudán (el)"),
	SSD("SSD","Sudán del Sur"),
	SWE("SWE","Suecia"),
	
	SUR("SUR","Surinam"),
	SJM("SJM","Svalbard y Jan Mayen"),
	THA("THA","Tailandia"),
	TWN("TWN","Taiwán (Provincia de China)"),
	TZA("TZA","Tanzania, República Unida de"),
	TJK("TJK","Tayikistán"),
	IOT("IOT","Territorio Británico del Océano Índico (el)"),
	ATF("ATF","Territorios Australes Franceses (los)"),
	TLS("TLS","Timor-Leste"),
	TGO("TGO","Togo"),
	TKL("TKL","Tokelau"),
	TON("TON","Tonga"),
	TTO("TTO","Trinidad y Tobago"),
	TUN("TUN","Túnez"),
	TKM("TKM","Turkmenistán"),
	TUR("TUR","Turquía"),
	TUV("TUV","Tuvalu"),
	UKR("UKR","Ucrania"),
	UGA("UGA","Uganda"),
	URY("URY","Uruguay"),
	UZB("UZB","Uzbekistán"),
	VUT("VUT","Vanuatu"),
	VAT("VAT","Santa Sede[Estado de la Ciudad del Vaticano] (la)"),
	VEN("VEN","Venezuela, República Bolivariana de"),
	VNM("VNM","Viet Nam"),
	WLF("WLF","Wallis y Futuna"),
	YEM("YEM","Yemen"),
	DJI("DJI","Yibuti"),
	ZMB("ZMB","Zambia"),
	ZWE("ZWE","Zimbabue"),
	ZZZ("ZZZ","Países no declarados"),
	;
	
	
	final String idSat;
	final String descripcion;
	final Pattern patronIdTributaria;
	
	Paises33(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	Paises33(String idSat,String descripcion,String idregtributaria){
		this.idSat=idSat;
		this.descripcion=descripcion;		
		this.patronIdTributaria = idregtributaria==null?null:Pattern.compile(idregtributaria);
		
	}

	public static Paises33 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final Paises33 estado =  Paises33.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El Pais  "+metodo+" no se encuentra en el catálogo de c_Pais del SAT");
		else
			return estado;
	}

	private static Paises33 busca(String metodo) {
		for(Paises33 it:values()){
			if(it.getIdSat().equals(metodo))
				return it;
		}
		return null;
	}

	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	public static String marshall(Paises33 v) throws Exception {
		if(v==null)
			return null;
		return v.marshall();
	}
	
	private String marshall(){
		return idSat;
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}
	
	public static Paises33 idSat(String idSat) {
		return busca(idSat);
	}
	
	public static String descripcion(String idSat){
		if(idSat==null) return "";
		final Paises33 rf = idSat(idSat);
		if(rf!=null)
			return  idSat.concat(" - ").concat(rf.getDescripcion());
		return idSat;
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
