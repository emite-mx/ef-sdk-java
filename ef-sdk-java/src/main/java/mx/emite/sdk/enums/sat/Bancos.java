package mx.emite.sdk.enums.sat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Bancos implements Sat<String>{

	BANAMEX("002","BANAMEX","Banco Nacional de México, S.A."),
	BANCOMEXT("006","BANCOMEXT","Banco Nacional de Comercio Exterior"),
	BANOBRAS("009","BANOBRAS","Banco Nacional de Obras y Servicios Públicos"),
	BBVABANCOMER("012","BBVA BANCOMER","BBVA Bancomer, S.A."),
	SANTANDER("014","SANTANDER","Banco Santander (México), S.A."),
	BANJERCITO("019","BANJERCITO","Banco Nacional del Ejército"),
	HSBC("021","HSBC","HSBC México, S.A."),
	BAJIO("030","BAJIO","Banco del Bajío, S.A."),
	IXE("032","IXE","IXE Banco, S.A."),
	INBURSA("036","INBURSA","Banco Inbursa, S.A."),
	INTERACCIONES("037","INTERACCIONES","Banco Interacciones, S.A."),
	MIFEL("042","MIFEL","Banca Mifel, S.A."),
	SCOTIABANK("044","SCOTIABANK","Scotiabank Inverlat, S.A."),
	BANREGIO("058","BANREGIO","Banco Regional de Monterrey, S.A."),
	INVEX("059","INVEX","Banco Invex, S.A."),
	BANSI("060","BANSI","Bansi, S.A."),
	AFIRME("062","AFIRME","Banca Afirme, S.A."),
	BANORTE("072","BANORTE","Banco Mercantil del Norte, S.A."),
	THEROYALBANK("102","THE ROYAL BANK","The Royal Bank of Scotland México, S.A."),
	AMERICANEXPRESS("103","AMERICAN EXPRESS","American Express Bank (México), S.A."),
	BAMSA("106","BAMSA","Bank of America México, S.A."),
	TOKYO("108","TOKYO","Bank of Tokyo-Mitsubishi UFJ (México), S.A."),
	JPMORGAN("110","JP MORGAN","Banco J.P. Morgan, S.A."),
	BMONEX("112","BMONEX","Banco Monex, S.A."),
	VEPORMAS("113","VE POR MAS","Banco Ve Por Mas, S.A."),
	ING("116","ING","ING Bank (México), S.A."),
	DEUTSCHE("124","DEUTSCHE","Deutsche Bank México, S.A."),
	CREDITSUISSE("126","CREDIT SUISSE","Banco Credit Suisse (México), S.A."),
	AZTECA("127","AZTECA","Banco Azteca, S.A."),
	AUTOFIN("128","AUTOFIN","Banco Autofin México, S.A."),
	BARCLAYS("129","BARCLAYS","Barclays Bank México, S.A."),
	COMPARTAMOS("130","COMPARTAMOS","Banco Compartamos, S.A."),
	BANCOFAMSA("131","BANCO FAMSA","Banco Ahorro Famsa, S.A."),
	BMULTIVA("132","BMULTIVA","Banco Multiva, S.A."),
	ACTINVER("133","ACTINVER","Banco Actinver, S.A."),
	WALMART("134","WAL-MART","Banco Wal-Mart de México Adelante, S.A."),
	NAFIN("135","NAFIN","Nacional Financiera"),
	INTERBANCO("136","INTERBANCO","Inter Banco, S.A."),
	BANCOPPEL("137","BANCOPPEL","BanCoppel, S.A."),
	ABCCAPITAL("138","ABC CAPITAL","ABC Capital, S.A."),
	UBSBANK("139","UBS BANK","UBS Bank México, S.A."),
	CONSUBANCO("140","CONSUBANCO","Consubanco, S.A."),
	VOLKSWAGEN("141","VOLKSWAGEN","Volkswagen Bank, S.A."),
	CIBANCO("143","CIBANCO","CIBanco, S.A."),
	BBASE("145","BBASE","Banco Base, S.A."),
	BANSEFI("166","BANSEFI","Banco del Ahorro Nacional y Servicios Financieros"),
	HIPOTECARIAFEDERAL("168","HIPOTECARIA FEDERAL","Sociedad Hipotecaria Federal"),
	MONEXCB("600","MONEXCB","Monex, S.A. de C.V."),
	GBM("601","GBM","GBM Grupo Bursátil Mexicano, S.A. de C.V."),
	MASARI("602","MASARI","Masari, S.A."),
	VALUE("605","VALUE","Value, S.A. de C.V."),
	ESTRUCTURADORES("606","ESTRUCTURADORES","Estructuradores del Mercado de Valores, S.A. de C.V."),
	TIBER("607","TIBER","Casa de Cambio Tiber, S.A. de C.V."),
	VECTOR("608","VECTOR","Vector, S.A. de C.V."),
	BYB("610","B&B","B y B, Casa de Cambio, S.A. de C.V."),
	ACCIVAL("614","ACCIVAL","Acciones y Valores Banamex, S.A. de C.V."),
	MERRILLLYNCH("615","MERRILL LYNCH","Merrill Lynch México, S.A. de C.V."),
	FINAMEX("616","FINAMEX","Casa de Bolsa Finamex, S.A. de C.V."),
	VALMEX("617","VALMEX","Valores Mexicanos, S.A. de C.V."),
	UNICA("618","UNICA","Unica Casa de Cambio, S.A. de C.V."),
	MAPFRE("619","MAPFRE","MAPFRE Tepeyac, S.A."),
	PROFUTURO("620","PROFUTURO","Profuturo G.N.P., S.A. de C.V."),
	CBACTINVER("621","CB ACTINVER","Actinver, S.A. de C.V."),
	OACTIN("622","OACTIN","OPERADORA ACTINVER, S.A. DE C.V."),
	SKANDIAVIDA("623","SKANDIA","Skandia Vida, S.A. de C.V."),
	CBDEUTSCHE("626","CBDEUTSCHE","Deutsche Securities, S.A. de C.V."),
	ZURICH("627","ZURICH","Zurich Compañía de Seguros, S.A."),
	ZURICHVI("628","ZURICHVI","Zurich Vida, Compañía de Seguros, S.A."),
	SUCASITA("629","SU CASITA","Hipotecaria Su Casita, S.A. de C.V."),
	CBINTERCAM("630","CB INTERCAM","Intercam, S.A. de C.V."),
	CIBOLSA("631","CI BOLSA","CI, S.A. de C.V."),
	BULLTICKCB("632","BULLTICK CB","Bulltick, S.A., de C.V."),
	STERLING("633","STERLING","Sterling Casa de Cambio, S.A. de C.V."),
	FINCOMUN("634","FINCOMUN","Fincomún, Servicios Financieros Comunitarios, S.A. de C.V."),
	HDISEGUROS("636","HDI SEGUROS","HDI Seguros, S.A. de C.V."),
	ORDER("637","ORDER","Order Express Casa de Cambio, S.A. de C.V"),
	AKALA("638","AKALA","Akala, S.A. de C.V., Sociedad Financiera Popular"),
	CBJPMORGAN("640","CB JPMORGAN","J.P. Morgan, S.A. de C.V."),
	REFORMA("642","REFORMA","Operadora de Recursos Reforma, S.A. de C.V."),
	STP("646","STP","Sistema de Transferencias y Pagos STP, S.A. de C.V."),
	TELECOMM("647","TELECOMM","Telecomunicaciones de México"),
	EVERCORE("648","EVERCORE","Evercore, S.A. de C.V."),
	SKANDIAFONDOS("649","SKANDIA","Skandia Operadora de Fondos, S.A. de C.V."),
	SEGMTY("651","SEGMTY","Seguros Monterrey New York Life, S.A de C.V"),
	ASEA("652","ASEA","Solución Asea, S.A. de C.V."),
	KUSPIT("653","KUSPIT","Kuspit, S.A. de C.V."),
	SOFIEXPRESS("655","SOFIEXPRESS","J.P. SOFIEXPRESS, S.A. de C.V."),
	UNAGRA("656","UNAGRA","UNAGRA, S.A. de C.V."),
	OPCIONESEMPRESARIALESDELNOROESTE("659","OPCIONES EMPRESARIALES DEL NOROESTE","OPCIONES EMPRESARIALES DEL NORESTE, S.A. DE C.V."),
	CLS("901","CLS","Cls Bank International"),
	INDEVAL("902","INDEVAL","SD. Indeval, S.A. de C.V."),
	LIBERTAD("670","LIBERTAD","Libertad Servicios Financieros, S.A. De C.V."),
	NA("999","N/A",""),	
	;
	
	private final String idSat,descripcion;
	private final String nombre;
	
	private final static List<Bancos> bancos = ordenaBancos();
	
	Bancos(String idSat,String descripcion,String nombre){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.nombre=nombre;
		
	}
	
	
	private static List<Bancos> ordenaBancos() {
		final List<Bancos> res = Arrays.asList(values());
		res.sort(Comparator.comparing(Bancos::getDescripcion));
		return res;
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
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}


	public static Bancos getBanco(String banco) {
		if(StringUtils.isEmpty(banco))
			return null;
		for(Bancos m:values()){
			if(m.idSat.equals(banco))
				return m;
		}
		return null;
	}
	
	public static String getDescripcion(String banco) {
		final Bancos b = getBanco(banco);
		if(b!=null)
			return b.getNombre().toUpperCase();
		return null;
		
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}
	
	public static List<Bancos> bancos() {
		return bancos;
		
	}
	
}
