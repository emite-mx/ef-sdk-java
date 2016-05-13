package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Bancos implements Sat{

	BANAMEX("002","BANAMEX","Banco Nacional de México, S.A., Institución de Banca Múltiple, Grupo Financiero Banamex"),
	BANCOMEXT("006","BANCOMEXT","Banco Nacional de Comercio Exterior, Sociedad Nacional de Crédito, Institución de Banca de Desarrollo"),
	BANOBRAS("009","BANOBRAS","Banco Nacional de Obras y Servicios Públicos, Sociedad Nacional de Crédito, Institución de Banca de Desarrollo"),
	BBVABANCOMER("012","BBVA BANCOMER","BBVA Bancomer, S.A., Institución de Banca Múltiple, Grupo Financiero BBVA Bancomer"),
	SANTANDER("014","SANTANDER","Banco Santander (México), S.A., Institución de Banca Múltiple, Grupo Financiero Santander"),
	BANJERCITO("019","BANJERCITO","Banco Nacional del Ejército, Fuerza Aérea y Armada, Sociedad Nacional de Crédito, Institución de Banca de Desarrollo"),
	HSBC("021","HSBC","HSBC México, S.A., institución De Banca Múltiple, Grupo Financiero HSBC"),
	BAJIO("030","BAJIO","Banco del Bajío, S.A., Institución de Banca Múltiple"),
	IXE("032","IXE","IXE Banco, S.A., Institución de Banca Múltiple, IXE Grupo Financiero"),
	INBURSA("036","INBURSA","Banco Inbursa, S.A., Institución de Banca Múltiple, Grupo Financiero Inbursa"),
	INTERACCIONES("037","INTERACCIONES","Banco Interacciones, S.A., Institución de Banca Múltiple"),
	MIFEL("042","MIFEL","Banca Mifel, S.A., Institución de Banca Múltiple, Grupo Financiero Mifel"),
	SCOTIABANK("044","SCOTIABANK","Scotiabank Inverlat, S.A."),
	BANREGIO("058","BANREGIO","Banco Regional de Monterrey, S.A., Institución de Banca Múltiple, Banregio Grupo Financiero"),
	INVEX("059","INVEX","Banco Invex, S.A., Institución de Banca Múltiple, Invex Grupo Financiero"),
	BANSI("060","BANSI","Bansi, S.A., Institución de Banca Múltiple"),
	AFIRME("062","AFIRME","Banca Afirme, S.A., Institución de Banca Múltiple"),
	BANORTE("072","BANORTE","Banco Mercantil del Norte, S.A., Institución de Banca Múltiple, Grupo Financiero Banorte"),
	THEROYALBANK("102","THE ROYAL BANK","The Royal Bank of Scotland México, S.A., Institución de Banca Múltiple"),
	AMERICANEXPRESS("103","AMERICAN EXPRESS","American Express Bank (México), S.A., Institución de Banca Múltiple"),
	BAMSA("106","BAMSA","Bank of America México, S.A., Institución de Banca Múltiple, Grupo Financiero Bank of America"),
	TOKYO("108","TOKYO","Bank of Tokyo-Mitsubishi UFJ (México), S.A."),
	JPMORGAN("110","JP MORGAN","Banco J.P. Morgan, S.A., Institución de Banca Múltiple, J.P. Morgan Grupo Financiero"),
	BMONEX("112","BMONEX","Banco Monex, S.A., Institución de Banca Múltiple"),
	VEPORMAS("113","VE POR MAS","Banco Ve Por Mas, S.A. Institución de Banca Múltiple"),
	ING("116","ING","ING Bank (México), S.A., Institución de Banca Múltiple, ING Grupo Financiero"),
	DEUTSCHE("124","DEUTSCHE","Deutsche Bank México, S.A., Institución de Banca Múltiple"),
	CREDITSUISSE("126","CREDIT SUISSE","Banco Credit Suisse (México), S.A. Institución de Banca Múltiple, Grupo Financiero Credit Suisse (México)"),
	AZTECA("127","AZTECA","Banco Azteca, S.A. Institución de Banca Múltiple."),
	AUTOFIN("128","AUTOFIN","Banco Autofin México, S.A. Institución de Banca Múltiple"),
	BARCLAYS("129","BARCLAYS","Barclays Bank México, S.A., Institución de Banca Múltiple, Grupo Financiero Barclays México"),
	COMPARTAMOS("130","COMPARTAMOS","Banco Compartamos, S.A., Institución de Banca Múltiple"),
	BANCOFAMSA("131","BANCO FAMSA","Banco Ahorro Famsa, S.A., Institución de Banca Múltiple"),
	BMULTIVA("132","BMULTIVA","Banco Multiva, S.A., Institución de Banca Múltiple, Multivalores Grupo Financiero"),
	ACTINVER("133","ACTINVER","Banco Actinver, S.A. Institución de Banca Múltiple, Grupo Financiero Actinver"),
	WALMART("134","WAL-MART","Banco Wal-Mart de México Adelante, S.A., Institución de Banca Múltiple"),
	NAFIN("135","NAFIN","Nacional Financiera, Sociedad Nacional de Crédito, Institución de Banca de Desarrollo"),
	INTERBANCO("136","INTERBANCO","Inter Banco, S.A. Institución de Banca Múltiple"),
	BANCOPPEL("137","BANCOPPEL","BanCoppel, S.A., Institución de Banca Múltiple"),
	ABCCAPITAL("138","ABC CAPITAL","ABC Capital, S.A., Institución de Banca Múltiple"),
	UBSBANK("139","UBS BANK","UBS Bank México, S.A., Institución de Banca Múltiple, UBS Grupo Financiero"),
	CONSUBANCO("140","CONSUBANCO","Consubanco, S.A. Institución de Banca Múltiple"),
	VOLKSWAGEN("141","VOLKSWAGEN","Volkswagen Bank, S.A., Institución de Banca Múltiple"),
	CIBANCO("143","CIBANCO","CIBanco, S.A."),
	BBASE("145","BBASE","Banco Base, S.A., Institución de Banca Múltiple"),
	BANSEFI("166","BANSEFI","Banco del Ahorro Nacional y Servicios Financieros, Sociedad Nacional de Crédito, Institución de Banca de Desarrollo"),
	HIPOTECARIAFEDERAL("168","HIPOTECARIA FEDERAL","Sociedad Hipotecaria Federal, Sociedad Nacional de Crédito, Institución de Banca de Desarrollo"),
	MONEXCB("600","MONEXCB","Monex Casa de Bolsa, S.A. de C.V. Monex Grupo Financiero"),
	GBM("601","GBM","GBM Grupo Bursátil Mexicano, S.A. de C.V. Casa de Bolsa"),
	MASARI("602","MASARI","Masari Casa de Bolsa, S.A."),
	VALUE("605","VALUE","Value, S.A. de C.V. Casa de Bolsa"),
	ESTRUCTURADORES("606","ESTRUCTURADORES","Estructuradores del Mercado de Valores Casa de Bolsa, S.A. de C.V."),
	TIBER("607","TIBER","Casa de Cambio Tiber, S.A. de C.V."),
	VECTOR("608","VECTOR","Vector Casa de Bolsa, S.A. de C.V."),
	BYB("610","B&B","B y B, Casa de Cambio, S.A. de C.V."),
	ACCIVAL("614","ACCIVAL","Acciones y Valores Banamex, S.A. de C.V., Casa de Bolsa"),
	MERRILLLYNCH("615","MERRILL LYNCH","Merrill Lynch México, S.A. de C.V. Casa de Bolsa"),
	FINAMEX("616","FINAMEX","Casa de Bolsa Finamex, S.A. de C.V."),
	VALMEX("617","VALMEX","Valores Mexicanos Casa de Bolsa, S.A. de C.V."),
	UNICA("618","UNICA","Unica Casa de Cambio, S.A. de C.V."),
	MAPFRE("619","MAPFRE","MAPFRE Tepeyac, S.A."),
	PROFUTURO("620","PROFUTURO","Profuturo G.N.P., S.A. de C.V., Afore"),
	CBACTINVER("621","CB ACTINVER","Actinver Casa de Bolsa, S.A. de C.V."),
	OACTIN("622","OACTIN","OPERADORA ACTINVER, S.A. DE C.V."),
	SKANDIAVIDA("623","SKANDIA","Skandia Vida, S.A. de C.V."),
	CBDEUTSCHE("626","CBDEUTSCHE","Deutsche Securities, S.A. de C.V. CASA DE BOLSA"),
	ZURICH("627","ZURICH","Zurich Compañía de Seguros, S.A."),
	ZURICHVI("628","ZURICHVI","Zurich Vida, Compañía de Seguros, S.A."),
	SUCASITA("629","SU CASITA","Hipotecaria Su Casita, S.A. de C.V. SOFOM ENR"),
	CBINTERCAM("630","CB INTERCAM","Intercam Casa de Bolsa, S.A. de C.V."),
	CIBOLSA("631","CI BOLSA","CI Casa de Bolsa, S.A. de C.V."),
	BULLTICKCB("632","BULLTICK CB","Bulltick Casa de Bolsa, S.A., de C.V."),
	STERLING("633","STERLING","Sterling Casa de Cambio, S.A. de C.V."),
	FINCOMUN("634","FINCOMUN","Fincomún, Servicios Financieros Comunitarios, S.A. de C.V."),
	HDISEGUROS("636","HDI SEGUROS","HDI Seguros, S.A. de C.V."),
	ORDER("637","ORDER","Order Express Casa de Cambio, S.A. de C.V"),
	AKALA("638","AKALA","Akala, S.A. de C.V., Sociedad Financiera Popular"),
	CBJPMORGAN("640","CB JPMORGAN","J.P. Morgan Casa de Bolsa, S.A. de C.V. J.P. Morgan Grupo Financiero"),
	REFORMA("642","REFORMA","Operadora de Recursos Reforma, S.A. de C.V., S.F.P."),
	STP("646","STP","Sistema de Transferencias y Pagos STP, S.A. de C.V.SOFOM ENR"),
	TELECOMM("647","TELECOMM","Telecomunicaciones de México"),
	EVERCORE("648","EVERCORE","Evercore Casa de Bolsa, S.A. de C.V."),
	SKANDIAFONDOS("649","SKANDIA","Skandia Operadora de Fondos, S.A. de C.V."),
	SEGMTY("651","SEGMTY","Seguros Monterrey New York Life, S.A de C.V"),
	ASEA("652","ASEA","Solución Asea, S.A. de C.V., Sociedad Financiera Popular"),
	KUSPIT("653","KUSPIT","Kuspit Casa de Bolsa, S.A. de C.V."),
	SOFIEXPRESS("655","SOFIEXPRESS","J.P. SOFIEXPRESS, S.A. de C.V., S.F.P."),
	UNAGRA("656","UNAGRA","UNAGRA, S.A. de C.V., S.F.P."),
	OPCIONESEMPRESARIALESDELNOROESTE("659","OPCIONES EMPRESARIALES DEL NOROESTE","OPCIONES EMPRESARIALES DEL NORESTE, S.A. DE C.V., S.F.P."),
	CLS("901","CLS","Cls Bank International"),
	INDEVAL("902","INDEVAL","SD. Indeval, S.A. de C.V."),
	LIBERTAD("670","LIBERTAD","Libertad Servicios Financieros, S.A. De C.V."),
	NA("999","N/A",""),	
	;
	
	private final String idSat,descripcion;
	private final String nombre;
	
	Bancos(String idSat,String descripcion,String nombre){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.nombre=nombre;
		
	}
	
	
	/**
	 * Busca un estado de acuerdo a su descripción
	 * @param descripcion de acuerdo al catalogo del SAT
	 * @return Estados valor del enum de acuerdo al estado
	 */
	public static Bancos busca(String descripcion) {
		for(Bancos m:values()){
			if(Utilerias.compara(m.descripcion,descripcion))
				return m;
			else if(Utilerias.compara(m.idSat,descripcion))
				return m;
		}
		return null;
	}
	
	/**
	 * Busca un estado de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return Estados valor del enum de acuerdo al estado
	 */
	public static Bancos id(String idSat) {
		for(Bancos m:values()){
			if(Utilerias.compara(m.idSat,idSat))
				return m;
		}
		return null;
	}


	
	public String getIdEstado(){
		return idSat;
	}


	public static Bancos unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final Bancos estado =  Bancos.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El banco "+metodo+" no se encuentra en el catálogo de bancos del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(Bancos v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
}
