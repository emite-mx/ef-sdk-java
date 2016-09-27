package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

public enum PaisesRetencion implements Sat<String>{
	
	MEXICO("MX","México",484,"MEX"),
	ESTADOS_UNIDOS_DE_AMERICA("US","Estados Unidos de América",840,"USA"),
	CANADA("CA","Canadá",124,"CAN"),
	ANDORRA("AD","Andorra",20,"AND"),
	EMIRATOS_ARABES_UNIDOS("AE","Emiratos Árabes Unidos",784,"ARE"),
	AFGANISTAN("AF","Afganistán",4,"AFG"),
	ANTIGUA_Y_BARBUDA("AG","Antigua y Barbuda",28,"ATG"),
	ANGUILA("AI","Anguila",660,"AIA"),
	ALBANIA("AL","Albania",8,"ALB"),
	ARMENIA("AM","Armenia",51,"ARM"),
	ANTILLAS_NEERLANDESAS("AN","Antillas Neerlandesas",530,"ANT"),
	ANGOLA("AO","Angola",24,"AGO"),
	ANTARTIDA("AQ","Antártida",10,"ATA"),
	ARGENTINA("AR","Argentina",32,"ARG"),
	SAMOA_AMERICANA("AS","Samoa Americana",16,"ASM"),
	AUSTRIA("AT","Austria",40,"AUT"),
	AUSTRALIA("AU","Australia",36,"AUS"),
	ARUBA("AW","Aruba",533,"ABW"),
	ISLAS_ALAND("AX","Islas Áland",248,"ALA"),
	AZERBAIYAN("AZ","Azerbaiyán",31,"AZE"),
	BOSNIA_Y_HERZEGOVINA("BA","Bosnia y Herzegovina",70,"BIH"),
	BARBADOS("BB","Barbados",52,"BRB"),
	BANGLADESH("BD","Bangladesh",50,"BGD"),
	BELGICA("BE","Bélgica",56,"BEL"),
	BURKINA_FASO("BF","Burkina Faso",854,"BFA"),
	BULGARIA("BG","Bulgaria",100,"BGR"),
	BAHREIN("BH","Bahréin",48,"BHR"),
	BURUNDI("BI","Burundi",108,"BDI"),
	BENIN("BJ","Benin",204,"BEN"),
	SAN_BARTOLOME("BL","San Bartolomé",652,"BLM"),
	BERMUDAS("BM","Bermudas",60,"BMU"),
	BRUNEI("BN","Brunéi",96,"BRN"),
	BOLIVIA("BO","Bolivia",68,"BOL"),
	BRASIL("BR","Brasil",76,"BRA"),
	BAHAMAS("BS","Bahamas",44,"BHS"),
	BHUTAN("BT","Bhután",64,"BTN"),
	ISLA_BOUVET("BV","Isla Bouvet",74,"BVT"),
	BOTSUANA("BW","Botsuana",72,"BWA"),
	BELARUS("BY","Belarús",112,"BLR"),
	BELICE("BZ","Belice",84,"BLZ"),
	ISLAS_COCOS("CC","Islas Cocos",166,"CCK"),
	REPUBLICA_CENTRO_AFRICANA("CF","República Centro-Africana",140,"CAF"),
	CONGO("CG","Congo",178,"COG"),
	SUIZA("CH","Suiza",756,"CHE"),
	COSTA_DE_MARFIL("CI","Costa de Marfil",384,"CIV"),
	ISLAS_COOK("CK","Islas Cook",184,"COK"),
	CHILE("CL","Chile",152,"CHL"),
	CAMERUN("CM","Camerún",120,"CMR"),
	CHINA("CN","China",156,"CHN"),
	COLOMBIA("CO","Colombia",170,"COL"),
	COSTA_RICA("CR","Costa Rica",188,"CRI"),
	CUBA("CU","Cuba",192,"CUB"),
	CABO_VERDE("CV","Cabo Verde",132,"CPV"),
	ISLAS_CHRISTMAS("CX","Islas Christmas",162,"CXR"),
	CHIPRE("CY","Chipre",196,"CYP"),
	REPUBLICA_CHECA("CZ","República Checa",203,"CZE"),
	ALEMANIA("DE","Alemania",276,"DEU"),
	YIBUTI("DJ","Yibuti",262,"DJI"),
	DINAMARCA("DK","Dinamarca",208,"DNK"),
	DOMINICA("DM","Domínica",212,"DMA"),
	REPUBLICA_DOMINICANA("DO","República Dominicana",214,"DOM"),
	ARGEL("DZ","Argel",12,"DZA"),
	ECUADOR("EC","Ecuador",218,"ECU"),
	ESTONIA("EE","Estonia",233,"EST"),
	EGIPTO("EG","Egipto",818,"EGY"),
	SAHARA_OCCIDENTAL("EH","Sahara Occidental",732,"ESH"),
	ERITREA("ER","Eritrea",232,"ERI"),
	ESPANA("ES","España",724,"ESP"),
	ETIOPIA("ET","Etiopía",231,"ETH"),
	FINLANDIA("FI","Finlandia",246,"FIN"),
	FIJI("FJ","Fiji",242,"FJI"),
	ISLAS_MALVINAS("FK","Islas Malvinas",238,"KLK"),
	MICRONESIA("FM","Micronesia",583,"FSM"),
	ISLAS_FAROE("FO","Islas Faroe",234,"FRO"),
	FRANCIA("FR","Francia",250,"FRA"),
	GABON("GA","Gabón",266,"GAB"),
	REINO_UNIDO("GB","Reino Unido",826,"GBR"),
	GRANADA("GD","Granada",308,"GRD"),
	GEORGIA("GE","Georgia",268,"GEO"),
	GUAYANA_FRANCESA("GF","Guayana Francesa",254,"GUF"),
	GUERNSEY("GG","Guernsey",831,"GGY"),
	GHANA("GH","Ghana",288,"GHA"),
	GIBRALTAR("GI","Gibraltar",292,"GIB"),
	GROENLANDIA("GL","Groenlandia",304,"GRL"),
	GAMBIA("GM","Gambia",270,"GMB"),
	GUINEA("GN","Guinea",324,"GIN"),
	GUADALUPE("GP","Guadalupe",312,"GLP"),
	GUINEA_ECUATORIAL("GQ","Guinea Ecuatorial",226,"GNQ"),
	GRECIA("GR","Grecia",300,"GRC"),
	GEORGIA_DEL_SUR_E_ISLAS_SANDWICH_DEL_SUR("GS","Georgia del Sur e Islas Sandwich del Sur",239,"SGS"),
	GUATEMALA("GT","Guatemala",320,"GTM"),
	GUAM("GU","Guam",316,"GUM"),
	GUINEA_BISSAU("GW","Guinea-Bissau",624,"GNB"),
	GUAYANA("GY","Guayana",328,"GUY"),
	HONG_KONG("HK","Hong Kong",344,"HKG"),
	ISLAS_HEARD_Y_MCDONALD("HM","Islas Heard y McDonald",334,"HMD"),
	HONDURAS("HN","Honduras",340,"HND"),
	CROACIA("HR","Croacia",191,"HRV"),
	HAITI("HT","Haití",332,"HTI"),
	HUNGRIA("HU","Hungría",348,"HUN"),
	INDONESIA("ID","Indonesia",360,"IDN"),
	IRLANDA("IE","Irlanda",372,"IRL"),
	ISRAEL("IL","Israel",376,"ISR"),
	ISLA_DE_MAN("IM","Isla de Man",833,"IMN"),
	INDIA("IN","India",356,"IND"),
	TERRITORIO_BRITANICO_DEL_OCEANO_INDICO("IO","Territorio Británico del Océano Índico",86,"IOT"),
	IRAK("IQ","Irak",368,"IRQ"),
	IRAN("IR","Irán",364,"IRN"),
	ISLANDIA("IS","Islandia",352,"ISL"),
	ITALIA("IT","Italia",380,"ITA"),
	JERSEY("JE","Jersey",832,"JEY"),
	JAMAICA("JM","Jamaica",388,"JAM"),
	JORDANIA("JO","Jordania",400,"JOR"),
	JAPON("JP","Japón",392,"JPN"),
	KENIA("KE","Kenia",404,"KEN"),
	KIRGUISTAN("KG","Kirguistán",417,"KGZ"),
	CAMBOYA("KH","Camboya",116,"KHM"),
	KIRIBATI("KI","Kiribati",296,"KIR"),
	COMOROS("KM","Comoros",174,"COM"),
	SAN_CRISTOBAL_Y_NIEVES("KN","San Cristóbal y Nieves",659,"KNA"),
	COREA_DEL_NORTE("KP","Corea del Norte",408,"PRK"),
	COREA_DEL_SUR("KR","Corea del Sur",410,"KOR"),
	KUWAIT("KW","Kuwait",414,"KWT"),
	ISLAS_CAIMAN("KY","Islas Caimán",136,"CYM"),
	KAZAJSTAN("KZ","Kazajstán",398,"KAZ"),
	LAOS("LA","Laos",418,"LAO"),
	LIBANO("LB","Líbano",422,"LBN"),
	SANTA_LUCIA("LC","Santa Lucía",662,"LCA"),
	LIECHTENSTEIN("LI","Liechtenstein",438,"LIE"),
	SRI_LANKA("LK","Sri Lanka",144,"LKA"),
	LIBERIA("LR","Liberia",430,"LBR"),
	LESOTHO("LS","Lesotho",426,"LSO"),
	LITUANIA("LT","Lituania",440,"LTU"),
	LUXEMBURGO("LU","Luxemburgo",442,"LUX"),
	LETONIA("LV","Letonia",428,"LVA"),
	LIBIA("LY","Libia",434,"LBY"),
	MARRUECOS("MA","Marruecos",504,"MAR"),
	MONACO("MC","Mónaco",492,"MCO"),
	MOLDOVA("MD","Moldova",498,"MDA"),
	MONTENEGRO("ME","Montenegro",499,"MNE"),
	MADAGASCAR("MG","Madagascar",450,"MDG"),
	ISLAS_MARSHALL("MH","Islas Marshall",584,"MHL"),
	MACEDONIA("MK","Macedonia",807,"MKD"),
	MALI("ML","Mali",466,"MLI"),
	MYANMAR("MM","Myanmar",104,"MMR"),
	MONGOLIA("MN","Mongolia",496,"MNG"),
	MACAO("MO","Macao",446,"MAC"),
	MARTINICA("MQ","Martinica",474,"MTQ"),
	MAURITANIA("MR","Mauritania",478,"MRT"),
	MONTSERRAT("MS","Montserrat",500,"MSR"),
	MALTA("MT","Malta",470,"MLT"),
	MAURICIO("MU","Mauricio",480,"MUS"),
	MALDIVAS("MV","Maldivas",462,"MDV"),
	MALAWI("MW","Malawi",454,"MWI"),
	
	MALASIA("MY","Malasia",458,"MYS"),
	MOZAMBIQUE("MZ","Mozambique",508,"MOZ"),
	NAMIBIA("NA","Namibia",516,"NAM"),
	NUEVA_CALEDONIA("NC","Nueva Caledonia",540,"NCL"),
	NIGER("NE","Níger",562,"NER"),
	ISLAS_NORKFOLK("NF","Islas Norkfolk",574,"NFK"),
	NIGERIA("NG","Nigeria",566,"NGA"),
	NICARAGUA("NI","Nicaragua",558,"NIC"),
	PAISES_BAJOS("NL","Países Bajos",528,"NLD"),
	NORUEGA("NO","Noruega",578,"NOR"),
	NEPAL("NP","Nepal",524,"NPL"),
	NAURU("NR","Nauru",520,"NRU"),
	NIUE("NU","Niue",570,"NIU"),
	NUEVA_ZELANDA("NZ","Nueva Zelanda",554,"NZL"),
	OMAN("OM","Omán",512,"OMN"),
	PANAMA("PA","Panamá",591,"PAN"),
	PERU("PE","Perú",604,"PER"),
	POLINESIA_FRANCESA("PF","Polinesia Francesa",258,"PYF"),
	PAPUA_NUEVA_GUINEA("PG","Papúa Nueva Guinea",598,"PNG"),
	FILIPINAS("PH","Filipinas",608,"PHL"),
	PAKISTAN("PK","Pakistán",586,"PAK"),
	POLONIA("PL","Polonia",616,"POL"),
	SAN_PEDRO_Y_MIQUELON("PM","San Pedro y Miquelón",666,"SPM"),
	ISLAS_PITCAIRN("PN","Islas Pitcairn",612,"PCN"),
	PUERTO_RICO("PR","Puerto Rico",630,"PRI"),
	PALESTINA("PS","Palestina",275,"PSE"),
	PORTUGAL("PT","Portugal",620,"PRT"),
	ISLAS_PALAOS("PW","Islas Palaos",585,"PLW"),
	PARAGUAY("PY","Paraguay",600,"PRY"),
	QATAR("QA","Qatar",634,"QAT"),
	REUNION("RE","Reunión",638,"REU"),
	RUMANIA("RO","Rumanía",642,"ROU"),
	SERBIA_Y_MONTENEGRO("RS","Serbia y Montenegro",688,"SRB"),
	RUSIA("RU","Rusia",643,"RUS"),
	RUANDA("RW","Ruanda",646,"RWA"),
	ARABIA_SAUDITA("SA","Arabia Saudita",682,"SAU"),
	ISLAS_SOLOMON("SB","Islas Solomón",90,"SLB"),
	SEYCHELLES("SC","Seychelles",690,"SYC"),
	SUDAN("SD","Sudán",736,"SDN"),
	SUECIA("SE","Suecia",752,"SWE"),
	SINGAPUR("SG","Singapur",702,"SGP"),
	SANTA_ELENA("SH","Santa Elena",654,"SHN"),
	ESLOVENIA("SI","Eslovenia",705,"SVN"),
	ISLAS_SVALBARD_Y_JAN_MAYEN("SJ","Islas Svalbard y Jan Mayen",744,"SJM"),
	ESLOVAQUIA("SK","Eslovaquia",703,"SVK"),
	SIERRA_LEONA("SL","Sierra Leona",694,"SLE"),
	SAN_MARINO("SM","San Marino",674,"SMR"),
	SENEGAL("SN","Senegal",686,"SEN"),
	SOMALIA("SO","Somalia",706,"SOM"),
	SURINAM("SR","Surinam",740,"SUR"),
	SANTO_TOME_Y_PRINCIPE("ST","Santo Tomé y Príncipe",678,"STP"),
	EL_SALVADOR("SV","El Salvador",222,"SLV"),
	SIRIA("SY","Siria",760,"SYR"),
	SUAZILANDIA("SZ","Suazilandia",748,"SWZ"),
	ISLAS_TURCAS_Y_CAICOS("TC","Islas Turcas y Caicos",796,"TCA"),
	CHAD("TD","Chad",148,"TCD"),
	TERRITORIOS_AUSTRALES_FRANCESES("TF","Territorios Australes Franceses",260,"ATF"),
	TOGO("TG","Togo",768,"TGO"),
	TAILANDIA("TH","Tailandia",764,"THA"),
	TANZANIA("TH","Tanzania",834,"TZA"),
	TAYIKISTAN("TJ","Tayikistán",762,"TJK"),
	TOKELAU("TK","Tokelau",772,"TKL"),
	TIMOR_LESTE("TL","Timor-Leste",626,"TLS"),
	TURKMENISTAN("TM","Turkmenistán",795,"TKM"),
	TUNEZ("TN","Túnez",788,"TUN"),
	TONGA("TO","Tonga",776,"TON"),
	TURQUIA("TR","Turquía",792,"TUR"),
	TRINIDAD_Y_TOBAGO("TT","Trinidad y Tobago",780,"TTO"),
	TUVALU("TV","Tuvalu",798,"TUV"),
	TAIWAN("TW","Taiwán",158,"TWN"),
	UCRANIA("UA","Ucrania",804,"UKR"),
	UGANDA("UG","Uganda",800,"UGA"),
	URUGUAY("UY","Uruguay",858,"URY"),
	UZBEKISTAN("UZ","Uzbekistán",860,"UZB"),
	CIUDAD_DEL_VATICANO("VA","Ciudad del Vaticano",336,"VAT"),
	SAN_VICENTE_Y_LAS_GRANADINAS("VC","San Vicente y las Granadinas",670,"VCT"),
	VENEZUELA("VE","Venezuela",862,"VEN"),
	ISLAS_VIRGENES_BRITANICAS("VG","Islas Vírgenes Británicas",92,"VGB"),
	ISLAS_VIRGENES_DE_LOS_ESTADOS_UNIDOS_DE_AMERICA("VI","Islas Vírgenes de los Estados Unidos de América",850,"VIR"),
	VIETNAM("VN","Vietnam",704,"VNM"),
	VANUATU("VU","Vanuatu",548,"VUT"),
	WALLIS_Y_FUTUNA("WF","Wallis y Futuna",876,"WLF"),
	SAMOA("WS","Samoa",882,"WSM"),
	YEMEN("YE","Yemen",887,"YEM"),
	MAYOTTE("YT","Mayotte",175,"MYT"),
	SUDAFRICA("ZA","Sudáfrica",710,"ZAF"),
	
	
	;
	
	private final String idSat,descripcionPais,iso3166_3;
	private final int iso3166;
	
	PaisesRetencion(String idSat,String descripcion,int iso3166,String iso3166_3){
		this.idSat=idSat;
		this.descripcionPais=descripcion;
		this.iso3166=iso3166;
		this.iso3166_3=iso3166_3;
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
	public static PaisesRetencion busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		for(PaisesRetencion m:values()){
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
	public static PaisesRetencion id(String idPais) {
		for(PaisesRetencion m:values()){
			if(Utilerias.compara(m.idSat,idPais))
				return m;
		}
		return null;
	}

	public static PaisesRetencion[] principales() {
		return new PaisesRetencion[]{PaisesRetencion.MEXICO,PaisesRetencion.ESTADOS_UNIDOS_DE_AMERICA,PaisesRetencion.CANADA};
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
	
	public static PaisesRetencion unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final PaisesRetencion estado =  PaisesRetencion.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El pais "+metodo+" no se encuentra en el catálogo de paises SAT");
		else
			return estado;
	}
	
	
	public static String marshall(PaisesRetencion v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static PaisesRetencion getDefault() {
		return PaisesRetencion.MEXICO; 
	}

	public String getIso3166_3() {
		return iso3166_3;
	}

	public int getIso3166() {
		return iso3166;
	}
	
	public static void main(String[] args){
		for(PaisesRetencion c:values()){
			System.out.println(c.idSat);
		}
		System.out.println();
		for(PaisesRetencion c:values()){
			System.out.println(c.descripcionPais);
		}
	}
	
	
}
