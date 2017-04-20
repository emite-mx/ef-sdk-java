package mx.emite.sdk.enums.sat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

public enum Paises implements Sat<String>{
	
	MEXICO("MEX","México","[0-9]{5}","[A-Z&Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]","TLCAN"),
	AFGANISTAN("AFG","Afganistán",null,null,null),
	ISLASALAND("ALA","Islas Åland",null,null,null),
	ALBANIA("ALB","Albania",null,null,null),
	ALEMANIA("DEU","Alemania",null,null,"Unión Europea"),
	ANDORRA("AND","Andorra",null,null,null),
	ANGOLA("AGO","Angola",null,null,null),
	ANGUILA("AIA","Anguila",null,null,null),
	ANTARTIDA("ATA","Antártida",null,null,null),
	ANTIGUAYBARBUDA("ATG","Antigua y Barbuda",null,null,null),
	ARABIASAUDITA("SAU","Arabia Saudita",null,null,null),
	ARGELIA("DZA","Argelia",null,null,null),
	ARGENTINA("ARG","Argentina",null,null,null),
	ARMENIA("ARM","Armenia",null,null,null),
	ARUBA("ABW","Aruba",null,null,null),
	AUSTRALIA("AUS","Australia",null,null,null),
	AUSTRIA("AUT","Austria",null,null,"Unión Europea"),
	AZERBAIYAN("AZE","Azerbaiyán",null,null,null),
	BAHAMASLAS("BHS","Bahamas (las)",null,null,null),
	BANGLADES("BGD","Bangladés",null,null,null),
	BARBADOS("BRB","Barbados",null,null,null),
	BAREIN("BHR","Baréin",null,null,null),
	BELGICA("BEL","Bélgica",null,null,"Unión Europea"),
	BELICE("BLZ","Belice",null,null,null),
	BENIN("BEN","Benín",null,null,null),
	BERMUDAS("BMU","Bermudas",null,null,null),
	BIELORRUSIA("BLR","Bielorrusia",null,null,null),
	MYANMAR("MMR","Myanmar",null,null,null),
	BOLIVIAESTADOPLURINACIONALDE("BOL","Bolivia, Estado Plurinacional de",null,null,null),
	BOSNIAYHERZEGOVINA("BIH","Bosnia y Herzegovina",null,null,null),
	BOTSUANA("BWA","Botsuana",null,null,null),
	BRASIL("BRA","Brasil",null,null,null),
	BRUNEIDARUSSALAM("BRN","Brunéi Darussalam",null,null,null),
	BULGARIA("BGR","Bulgaria",null,null,"Unión Europea"),
	BURKINAFASO("BFA","Burkina Faso",null,null,null),
	BURUNDI("BDI","Burundi",null,null,null),
	BUTAN("BTN","Bután",null,null,null),
	CABOVERDE("CPV","Cabo Verde",null,null,null),
	CAMBOYA("KHM","Camboya",null,null,null),
	CAMERUN("CMR","Camerún",null,null,null),
	CANADA("CAN","Canadá","[A-Z][0-9][A-Z] [0-9][A-Z][0-9]","[0-9]{9}","TLCAN"),
	CATAR("QAT","Catar",null,null,null),
	BONAIRESANEUSTAQUIOYSABA("BES","Bonaire, San Eustaquio y Saba",null,null,null),
	CHAD("TCD","Chad",null,null,null),
	CHILE("CHL","Chile",null,null,null),
	CHINA("CHN","China",null,null,null),
	CHIPRE("CYP","Chipre",null,null,"Unión Europea"),
	COLOMBIA("COL","Colombia",null,null,null),
	COMORAS("COM","Comoras",null,null,null),
	COREALAREPUBLICADEMOCRATICAPOPULARDE("PRK","Corea (la República Democrática Popular de)",null,null,null),
	COREALAREPUBLICADE("KOR","Corea (la República de)",null,null,null),
	COTEDIVOIRE("CIV","Côte d'Ivoire",null,null,null),
	COSTARICA("CRI","Costa Rica",null,null,null),
	CROACIA("HRV","Croacia",null,null,"Unión Europea"),
	CUBA("CUB","Cuba",null,null,null),
	CURACAO("CUW","Curaçao",null,null,null),
	DINAMARCA("DNK","Dinamarca",null,null,"Unión Europea"),
	DOMINICA("DMA","Dominica",null,null,null),
	ECUADOR("ECU","Ecuador",null,null,null),
	EGIPTO("EGY","Egipto",null,null,null),
	ELSALVADOR("SLV","El Salvador",null,null,null),
	EMIRATOSARABESUNIDOSLOS("ARE","Emiratos Árabes Unidos (Los)",null,null,null),
	ERITREA("ERI","Eritrea",null,null,null),
	ESLOVAQUIA("SVK","Eslovaquia",null,null,"Unión Europea"),
	ESLOVENIA("SVN","Eslovenia",null,null,"Unión Europea"),
	ESPANA("ESP","España",null,null,"Unión Europea"),
	ESTADOSUNIDOSLOS("USA","Estados Unidos (los)","[0-9]{5}(-[0-9]{4})?","[0-9]{9}","TLCAN"),
	ESTONIA("EST","Estonia",null,null,"Unión Europea"),
	ETIOPIA("ETH","Etiopía",null,null,null),
	FILIPINASLAS("PHL","Filipinas (las)",null,null,null),
	FINLANDIA("FIN","Finlandia",null,null,"Unión Europea"),
	FIYI("FJI","Fiyi",null,null,null),
	FRANCIA("FRA","Francia",null,null,"Unión Europea"),
	GABON("GAB","Gabón",null,null,null),
	GAMBIALA("GMB","Gambia (La)",null,null,null),
	GEORGIA("GEO","Georgia",null,null,null),
	GHANA("GHA","Ghana",null,null,null),
	GIBRALTAR("GIB","Gibraltar",null,null,null),
	GRANADA("GRD","Granada",null,null,null),
	GRECIA("GRC","Grecia",null,null,"Unión Europea"),
	GROENLANDIA("GRL","Groenlandia",null,null,null),
	GUADALUPE("GLP","Guadalupe",null,null,null),
	GUAM("GUM","Guam",null,null,null),
	GUATEMALA("GTM","Guatemala",null,null,null),
	GUAYANAFRANCESA("GUF","Guayana Francesa",null,null,null),
	GUERNSEY("GGY","Guernsey",null,null,null),
	GUINEA("GIN","Guinea",null,null,null),
	GUINEABISAU("GNB","Guinea-Bisáu",null,null,null),
	GUINEAECUATORIAL("GNQ","Guinea Ecuatorial",null,null,null),
	GUYANA("GUY","Guyana",null,null,null),
	HAITI("HTI","Haití",null,null,null),
	HONDURAS("HND","Honduras",null,null,null),
	HONGKONG("HKG","Hong Kong",null,null,null),
	HUNGRIA("HUN","Hungría",null,null,"Unión Europea"),
	INDIA("IND","India",null,null,null),
	INDONESIA("IDN","Indonesia",null,null,null),
	IRAK("IRQ","Irak",null,null,null),
	IRANLAREPUBLICAISLAMICADE("IRN","Irán (la República Islámica de)",null,null,null),
	IRLANDA("IRL","Irlanda",null,null,"Unión Europea"),
	ISLABOUVET("BVT","Isla Bouvet",null,null,null),
	ISLADEMAN("IMN","Isla de Man",null,null,null),
	ISLADENAVIDAD("CXR","Isla de Navidad",null,null,null),
	ISLANORFOLK("NFK","Isla Norfolk",null,null,null),
	ISLANDIA("ISL","Islandia",null,null,null),
	ISLASCAIMANLAS("CYM","Islas Caimán (las)",null,null,null),
	ISLASCOCOSKEELING("CCK","Islas Cocos (Keeling)",null,null,null),
	ISLASCOOKLAS("COK","Islas Cook (las)",null,null,null),
	ISLASFEROELAS("FRO","Islas Feroe (las)",null,null,null),
	GEORGIADELSURYLASISLASSANDWICHDELSUR("SGS","Georgia del sur y las islas sandwich del sur",null,null,null),
	ISLAHEARDEISLASMCDONALD("HMD","Isla Heard e Islas McDonald",null,null,null),
	ISLASMALVINASLAS("FLK","Islas Malvinas [Falkland] (las)",null,null,null),
	ISLASMARIANASDELNORTELAS("MNP","Islas Marianas del Norte (las)",null,null,null),
	ISLASMARSHALLLAS("MHL","Islas Marshall (las)",null,null,null),
	PITCAIRN("PCN","Pitcairn",null,null,null),
	ISLASSALOMONLAS("SLB","Islas Salomón (las)",null,null,null),
	ISLASTURCASYCAICOSLAS("TCA","Islas Turcas y Caicos (las)",null,null,null),
	ISLASDEULTRAMARMENORESDEESTADOSUNIDOSLAS("UMI","Islas de Ultramar Menores de Estados Unidos (las)",null,null,null),
	ISLASVIRGENESBRITANICAS("VGB","Islas Vírgenes (Británicas)",null,null,null),
	ISLASVIRGENESEEUU("VIR","Islas Vírgenes (EE.UU.)",null,null,null),
	ISRAEL("ISR","Israel",null,null,null),
	ITALIA("ITA","Italia",null,null,"Unión Europea"),
	JAMAICA("JAM","Jamaica",null,null,null),
	JAPON("JPN","Japón",null,null,null),
	JERSEY("JEY","Jersey",null,null,null),
	JORDANIA("JOR","Jordania",null,null,null),
	KAZAJISTAN("KAZ","Kazajistán",null,null,null),
	KENIA("KEN","Kenia",null,null,null),
	KIRGUISTAN("KGZ","Kirguistán",null,null,null),
	KIRIBATI("KIR","Kiribati",null,null,null),
	KUWAIT("KWT","Kuwait",null,null,null),
	LAOLAREPUBLICADEMOCRATICAPOPULAR("LAO","Lao, (la) República Democrática Popular",null,null,null),
	LESOTO("LSO","Lesoto",null,null,null),
	LETONIA("LVA","Letonia",null,null,"Unión Europea"),
	LIBANO("LBN","Líbano",null,null,null),
	LIBERIA("LBR","Liberia",null,null,null),
	LIBIA("LBY","Libia",null,null,null),
	LIECHTENSTEIN("LIE","Liechtenstein",null,null,null),
	LITUANIA("LTU","Lituania",null,null,"Unión Europea"),
	LUXEMBURGO("LUX","Luxemburgo",null,null,"Unión Europea"),
	MACAO("MAC","Macao",null,null,null),
	MADAGASCAR("MDG","Madagascar",null,null,null),
	MALASIA("MYS","Malasia",null,null,null),
	MALAUI("MWI","Malaui",null,null,null),
	MALDIVAS("MDV","Maldivas",null,null,null),
	MALI("MLI","Malí",null,null,null),
	MALTA("MLT","Malta",null,null,"Unión Europea"),
	MARRUECOS("MAR","Marruecos",null,null,null),
	MARTINICA("MTQ","Martinica",null,null,null),
	MAURICIO("MUS","Mauricio",null,null,null),
	MAURITANIA("MRT","Mauritania",null,null,null),
	MAYOTTE("MYT","Mayotte",null,null,null),
	
	MICRONESIALOSESTADOSFEDERADOSDE("FSM","Micronesia (los Estados Federados de)",null,null,null),
	MOLDAVIALAREPUBLICADE("MDA","Moldavia (la República de)",null,null,null),
	MONACO("MCO","Mónaco",null,null,null),
	MONGOLIA("MNG","Mongolia",null,null,null),
	MONTENEGRO("MNE","Montenegro",null,null,null),
	MONTSERRAT("MSR","Montserrat",null,null,null),
	MOZAMBIQUE("MOZ","Mozambique",null,null,null),
	NAMIBIA("NAM","Namibia",null,null,null),
	NAURU("NRU","Nauru",null,null,null),
	NEPAL("NPL","Nepal",null,null,null),
	NICARAGUA("NIC","Nicaragua",null,null,null),
	NIGEREL("NER","Níger (el)",null,null,null),
	NIGERIA("NGA","Nigeria",null,null,null),
	NIUE("NIU","Niue",null,null,null),
	NORUEGA("NOR","Noruega",null,null,null),
	NUEVACALEDONIA("NCL","Nueva Caledonia",null,null,null),
	NUEVAZELANDA("NZL","Nueva Zelanda",null,null,null),
	OMAN("OMN","Omán",null,null,null),
	PAISESBAJOSLOS("NLD","Países Bajos (los)",null,null,"Unión Europea"),
	PAKISTAN("PAK","Pakistán",null,null,null),
	PALAOS("PLW","Palaos",null,null,null),
	PALESTINAESTADODE("PSE","Palestina, Estado de",null,null,null),
	PANAMA("PAN","Panamá",null,null,null),
	PAPUANUEVAGUINEA("PNG","Papúa Nueva Guinea",null,null,null),
	PARAGUAY("PRY","Paraguay",null,null,null),
	PERU("PER","Perú",null,null,null),
	POLINESIAFRANCESA("PYF","Polinesia Francesa",null,null,null),
	POLONIA("POL","Polonia",null,null,"Unión Europea"),
	PORTUGAL("PRT","Portugal",null,null,"Unión Europea"),
	PUERTORICO("PRI","Puerto Rico",null,null,null),
	REINOUNIDOEL("GBR","Reino Unido (el)",null,null,"Unión Europea"),
	REPUBLICACENTROAFRICANALA("CAF","República Centroafricana (la)",null,null,null),
	REPUBLICACHECALA("CZE","República Checa (la)",null,null,"Unión Europea"),
	MACEDONIALAANTIGUAREPUBLICAYUGOSLAVADE("MKD","Macedonia (la antigua República Yugoslava de)",null,null,null),
	CONGO("COG","Congo",null,null,null),
	CONGOLAREPUBLICADEMOCRATICADEL("COD","Congo (la República Democrática del)",null,null,null),
	REPUBLICADOMINICANALA("DOM","República Dominicana (la)",null,null,null),
	REUNION("REU","Reunión",null,null,null),
	RUANDA("RWA","Ruanda",null,null,null),
	RUMANIA("ROU","Rumania",null,null,"Unión Europea"),
	RUSIALAFEDERACIONDE("RUS","Rusia, (la) Federación de",null,null,null),
	SAHARAOCCIDENTAL("ESH","Sahara Occidental",null,null,null),
	SAMOA("WSM","Samoa",null,null,null),
	SAMOAAMERICANA("ASM","Samoa Americana",null,null,null),
	SANBARTOLOME("BLM","San Bartolomé",null,null,null),
	SANCRISTOBALYNIEVES("KNA","San Cristóbal y Nieves",null,null,null),
	SANMARINO("SMR","San Marino",null,null,null),
	SANMARTINPARTEFRANCESA("MAF","San Martín (parte francesa)",null,null,null),
	SANPEDROYMIQUELON("SPM","San Pedro y Miquelón",null,null,null),
	SANVICENTEYLASGRANADINAS("VCT","San Vicente y las Granadinas",null,null,null),
	SANTAHELENAASCENSIONYTRISTANDEACUNA("SHN","Santa Helena, Ascensión y Tristán de Acuña",null,null,null),
	SANTALUCIA("LCA","Santa Lucía",null,null,null),
	SANTOTOMEYPRINCIPE("STP","Santo Tomé y Príncipe",null,null,null),
	SENEGAL("SEN","Senegal",null,null,null),
	SERBIA("SRB","Serbia",null,null,null),
	SEYCHELLES("SYC","Seychelles",null,null,null),
	SIERRALEONA("SLE","Sierra leona",null,null,null),
	SINGAPUR("SGP","Singapur",null,null,null),
	SINTMAARTENPARTEHOLANDESA("SXM","Sint Maarten (parte holandesa)",null,null,null),
	SIRIALAREPUBLICAARABE("SYR","Siria, (la) República Árabe",null,null,null),
	SOMALIA("SOM","Somalia",null,null,null),
	SRILANKA("LKA","Sri Lanka",null,null,null),
	SUAZILANDIA("SWZ","Suazilandia",null,null,null),
	SUDAFRICA("ZAF","Sudáfrica",null,null,null),
	SUDANEL("SDN","Sudán (el)",null,null,null),
	SUDANDELSUR("SSD","Sudán del Sur",null,null,null),
	SUECIA("SWE","Suecia",null,null,"Unión Europea"),
	SUIZA("CHE","Suiza",null,null,null),
	SURINAM("SUR","Surinam",null,null,null),
	SVALBARDYJANMAYEN("SJM","Svalbard y Jan Mayen",null,null,null),
	TAILANDIA("THA","Tailandia",null,null,null),
	TAIWANPROVINCIADECHINA("TWN","Taiwán (Provincia de China)",null,null,null),
	TANZANIAREPUBLICAUNIDADE("TZA","Tanzania, República Unida de",null,null,null),
	TAYIKISTAN("TJK","Tayikistán",null,null,null),
	TERRITORIOBRITANICODELOCEANOINDICOEL("IOT","Territorio Británico del Océano Índico (el)",null,null,null),
	TERRITORIOSAUSTRALESFRANCESESLOS("ATF","Territorios Australes Franceses (los)",null,null,null),
	TIMORLESTE("TLS","Timor-Leste",null,null,null),
	TOGO("TGO","Togo",null,null,null),
	TOKELAU("TKL","Tokelau",null,null,null),
	TONGA("TON","Tonga",null,null,null),
	TRINIDADYTOBAGO("TTO","Trinidad y Tobago",null,null,null),
	TUNEZ("TUN","Túnez",null,null,null),
	TURKMENISTAN("TKM","Turkmenistán",null,null,null),
	TURQUIA("TUR","Turquía",null,null,null),
	TUVALU("TUV","Tuvalu",null,null,null),
	UCRANIA("UKR","Ucrania",null,null,null),
	UGANDA("UGA","Uganda",null,null,null),
	URUGUAY("URY","Uruguay",null,null,null),
	UZBEKISTAN("UZB","Uzbekistán",null,null,null),
	VANUATU("VUT","Vanuatu",null,null,null),
	SANTASEDEESTADODELACIUDADDELVATICANOLA("VAT","Santa Sede[Estado de la Ciudad del Vaticano] (la)",null,null,null),
	VENEZUELAREPUBLICABOLIVARIANADE("VEN","Venezuela, República Bolivariana de",null,null,null),
	VIETNAM("VNM","Viet Nam",null,null,null),
	WALLISYFUTUNA("WLF","Wallis y Futuna",null,null,null),
	YEMEN("YEM","Yemen",null,null,null),
	YIBUTI("DJI","Yibuti",null,null,null),
	ZAMBIA("ZMB","Zambia",null,null,null),
	ZIMBABUE("ZWE","Zimbabue",null,null,null),
	PAISESNODECLARADOS("ZZZ","Países no declarados",null,null,null)
	
	
	;
	
	private final String idSat,descripcionPais,patronCp,patronIdTributaria;
	private final boolean ue,tlcan;
	
	/*Paises(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}*/
	
	public static void main(String[] args){
		Paises[] todos = Paises.values();
				Arrays.sort(todos,new Comparator<Paises>() {
			@Override
			public int compare(Paises o1, Paises o2) {
				return o1.getDescripcionPais().compareTo(o2.getDescripcionPais());
			}
		});
		
		for(Paises p:todos){
			if(p.tlcan||p.ue){
				System.out.print("Paises."+p.name()+",");
			}
			
		}
	}
	
	Paises(String idSat,String descripcion,String patronCp,String patronIdTributaria,String agrupacion){
		this.idSat=idSat;
		this.descripcionPais=descripcion;
		this.patronCp=patronCp;
		this.patronIdTributaria=patronIdTributaria;
		if(StringUtils.isEmpty(agrupacion)){
			ue=false;
			tlcan=false;
		}
		else{
			ue = StringUtils.equals(agrupacion, "Unión Europea");
			tlcan= StringUtils.equals(agrupacion, "TLCAN");
		}
	}
	
	public String valor(){
		return name();
	}
	
	@Override
	public String getDescripcion(){
		return descripcionPais;
	}
	
	/**
	 * Busca un país de acuerdo a su descripción
	 * @param descripcion de acuerdo al catalogo del SAT
	 * @return Paises valor del enum de acuerdo al pais
	 */
	public static Paises busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		for(Paises m:values()){
			if(Utilerias.compara(m.descripcionPais,descripcion))
				return m;
			else if(Utilerias.compara(m.idSat,descripcion))
				return m;
		}
		return null;
	}

	/**
	 * Busca un país de acuerdo a su id del SAT
	 * @param idPais de acuerdo al catalogo del SAT
	 * @return Paises valor del enum de acuerdo al pais
	 */
	public static Paises id(String idPais) {
		for(Paises m:values()){
			if(Utilerias.compara(m.idSat,idPais))
				return m;
		}
		return null;
	}

	public static Paises[] principales() {
		return new Paises[]{Paises.MEXICO,Paises.ESTADOSUNIDOSLOS,Paises.CANADA};
	}
	
	public static Paises[] principalesUe() {
		return new Paises[]{Paises.MEXICO,Paises.ESTADOSUNIDOSLOS,Paises.CANADA,Paises.ALEMANIA,Paises.AUSTRIA,Paises.BULGARIA,Paises.BELGICA,Paises.CHIPRE,Paises.CROACIA,Paises.DINAMARCA,Paises.ESLOVAQUIA,Paises.ESLOVENIA,Paises.ESPANA,Paises.ESTONIA,Paises.FINLANDIA,Paises.FRANCIA,Paises.GRECIA,Paises.HUNGRIA,Paises.IRLANDA,Paises.ITALIA,Paises.LETONIA,Paises.LITUANIA,Paises.LUXEMBURGO,Paises.MALTA,Paises.PAISESBAJOSLOS,Paises.POLONIA,Paises.PORTUGAL,Paises.REINOUNIDOEL,Paises.REPUBLICACHECALA,Paises.RUMANIA,Paises.SUECIA};
	}
	
	public String getIdPais(){
		return idSat;
	}

	@Override
	public String getIdSat() {
		return idSat;
	}

	public String getDescripcionPais() {
		return descripcionPais;
	}
	
	public static Paises unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final Paises estado =  Paises.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El pais "+metodo+" no se encuentra en el catálogo de paises SAT");
		else
			return estado;
	}
	
	
	public static String marshall(Paises v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static String marshallSat(Paises v) throws Exception {
		if(v==null)
			return null;
		return v.getIdPais();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static Paises getDefault() {
		return Paises.MEXICO;
	}

	public static boolean existe(String idSat) {
		for(Paises m:values()){
			if(m.getIdSat().equals(idSat))
				return true;
		}
		return false;
	}
	
	public String getPatronCp(){
		return patronCp;
	}
	
	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(Paises::getIdSat).collect(Collectors.toList());		
	}

	public String getPatronIdTributaria() {
		return patronIdTributaria;
	}

	
	public boolean esUnionEuropea() {
		return ue;
	}
	
	public boolean esTLCAN() {
		return tlcan;
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}

	public static Paises idSat(String idSat) {
		for(Paises m:values()){
			if(m.getIdSat().equals(idSat))
				return m;
		}
		return null;
	}
}
