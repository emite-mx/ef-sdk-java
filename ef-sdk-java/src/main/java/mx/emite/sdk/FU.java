package mx.emite.sdk;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import lombok.Getter;

public class FU {
	
		//private  final Logger log =  Logger.getLogger(FU.class);
	 //dateTimeFormat = new SimpleDateFormat
     //cardDateFormat = new SimpleDateFormat("MMyyyy");
	
		public final static ZoneId zona = ZoneId.of("America/Mexico_City");
		public final static TimeZone tz = TimeZone.getTimeZone(zona);
		
		
		public static void main(String[] agrs){
			try{
			String fecha="2015-12-15T14:55:26.6123714";
			
			DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss",new Locale("es","MX")).format(LocalDateTime.parse(fecha,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss",new Locale("es","MX"))).plusDays(5));
			
			if(fecha.indexOf(".")!=-1)
				fecha = fecha.substring(0,fecha.lastIndexOf("."));
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss",new Locale("es","MX"));
			LocalDateTime dt = LocalDateTime.parse(fecha,df);
			System.out.print(df.format(dt));
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		
		private  FechaUtilCache Cache = new FechaUtilCache();
		
		public enum FechaFormatos{
		ISO("yyyy-MM-dd'T'HH:mm:ss"),
		DDMMYYYY("dd/MM/yyyy"),
		DDMMYY("dd/MM/yy"),
		DDMMYYYYHHMM("dd/MM/yyyy HH:mm"),
		DDMMYYYYHHMMSS("dd/MM/yyyy HH:mm:ss"),
		DDMMYYHHMM("dd/MM/yy HH:mm"),
		YYYYMMDD("yyyy-MM-dd"),
		DDMM("dd/MM"),
		AMPM("aa"),
		ISOLARGO("yyyy-MM-dd'T'HH:mm:ss'Z'"),
		ISOLARGO1("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS"),
		ISOLARGO2("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSS"),
		ISOLARGO3("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS"),
		ISOLARGO4("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"),
		ISOLARGO5("yyyy-MM-dd'T'HH:mm:ss.SSSSS"),
		ISOLARGO6("yyyy-MM-dd'T'HH:mm:ss.SSSS"),
		ISOLARGO7("yyyy-MM-dd'T'HH:mm:ss.SSS"),
		ISOLARGO8("yyyy-MM-dd'T'HH:mm:ss.SS"),
		ISOLARGO9("yyyy-MM-dd'T'HH:mm:ss.S"),
		ISOLARGO10("yyyy-MM-dd'T'HH:mm:ss."),
		MMYYYY("MMyyyy"),
		DDMMYYYYSINGUION("ddMMyyyy"),
		YYYYMMDDPAR("(yyyyMMdd)"),
		YYYYMMDDSINGUION("yyyyMMdd"),
		DIASEMANA("EEE-dd",true),
		XLOG("yyyy-MM-dd HH:mm:ss.S"),
		COMPLETO("EEEE dd' de 'MMMM' de 'yyyy"),
		BITACORA("EEEE dd' de 'MMMM"),
		MM_YY("MM/yy"),
		MMYY("MMyy"),
		MM("MM"),
		YY("yy"), 
		DDMMYYYYHHMMSINGUION("ddMMyyyyHHmm"),
		YYYYMMDDHHMMSINGUION("yyyyMMddHHmm"),
		RESUMENMES("MMMM yy"),
		HORAMINUTO("HH:mm"),
		YYYY("yyyy"),
		CRON("mm HH"),
		FECHADIALARGA("EEE dd 'de' MMM 'de' yyyy 'a las' HH:mm"),
		PERIODO("yyyyMM"),
		DD("dd"),
		MES("MMMM"),
		MESANO("MMM yy"),
		YYYYMM("yyyy/MM"),
		YYYYMMDDHHMMSS("yyyy-MM-dd HH:mm:ss"),
		YYYYMMSINGUION("yyyyMM"),
		YYMMDD("yyMMdd"),
		DDMMYYYYPUNTOS("dd.MM.yyyy"), 
		MDDYYYY("M/dd/yyyy")
		;
		//private  SimpleDateFormat dftc = new SimpleDateFormat("dd/MM/yy HH:mm");
		//private  SimpleDateFormat dft = new SimpleDateFormat();
		//private  SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		//private  SimpleDateFormat dfc = new SimpleDateFormat("dd/MM/yy");
		//private  SimpleDateFormat dfcfdi = new SimpleDateFormat("yyyy-MM-dd");
		//private  SimpleDateFormat dfmini = new SimpleDateFormat("dd/MM");
		//private  SimpleDateFormat dftarde = new SimpleDateFormat("aa");
		
		
		
		private String Formato;
		@Getter private boolean mayusculas=false;
		
		FechaFormatos(String formato,boolean mayusculas){
			Formato=formato;	
			this.mayusculas=mayusculas;
		}
		FechaFormatos(String formato){
			this(formato,false);
		}
		
		public String getFormato(){
			return Formato;
		}
		
		}
		
		public  String format(Date fecha,FechaFormatos formato){
			if(fecha==null)
				return null;			
			return format(fecha.toInstant().atZone(zona).toLocalDate(),formato);
		}
		
		public  String format(Date fecha){
			if(fecha==null)
				return null;			
			return format(fecha.toInstant().atZone(zona).toLocalDate(),FechaFormatos.DDMMYYYY);
		}
		
		public  String format(LocalDateTime fecha,FechaFormatos formato){
			if(fecha==null)
				return null;			
			DateTimeFormatter df = getFormat(formato);
			return formato.mayusculas?  WordUtils.capitalize(df.format(fecha)):df.format(fecha);
		}
		
		public  String format(LocalDate fecha,FechaFormatos formato){
			if(fecha==null)
				return null;			
			DateTimeFormatter df = getFormat(formato);
			return formato.mayusculas?  WordUtils.capitalize(df.format(fecha)):df.format(fecha);
		}
		
		public  DateTimeFormatter getFormat(FechaFormatos formato){
			try{
				
				return Cache.get(formato);
			}catch(Exception ex){
				ex.printStackTrace();
				//log.error(ex.getMessage(),ex);
			}
			return DateTimeFormatter.ofPattern("dd/MM/yyyy");
		}
		
		public LocalDate parseDDMMYYYY(String fecha) {
			return parse(fecha,FechaFormatos.DDMMYYYY);
		}
		
		public  LocalDate parse(String fecha,FechaFormatos formato){
			if(StringUtils.isEmpty(fecha))
				return null;
			//DateTimeFormatter df = getFormat(formato);
			return LocalDate.parse(fecha,getFormat(formato));
			
		}
		
		public static Date convierte(LocalDate fecha) {
			if(fecha==null)
				return null;
			return Date.from(fecha.atStartOfDay(zona).toInstant());
		}
		
		public static Date convierte(LocalDateTime fecha) {
			if(fecha==null)
				return null;
			return Date.from(fecha.atZone(zona).toInstant());
		}
		
		/*
		public  Date parse(String fecha,FechaFormatos formato){
			if(fecha==null)
				return null;
			SimpleDateFormat df = getFormat(formato);
			try {
				return df.parse(fecha);
			} catch (ParseException e) {
				log.error(e.getMessage(),e);
			}
			return null;
		}
		
		
	
		public  String format(Date fecha,FechaFormatos formato){
			if(fecha==null)
				return null;			
			SimpleDateFormat df = getFormat(formato);
			return formato.Mayusculas?  WordUtils.capitalize(df.format(fecha)):df.format(fecha);
		}
		
		public  Timestamp parseISO(String fecha) {
			return parseT(fecha,FechaFormatos.ISO);
		}

		public  String formatISO(Timestamp fecha) {
			return format(fecha,FechaFormatos.ISO);
		}
		
		public  Date parseNormal(String fecha) {
			return parse(fecha,FechaFormatos.DDMMYYYY);
		}

		public  String formatNormal(Date fecha) {
			return format(fecha,FechaFormatos.DDMMYYYY);
		}
		
	
		public  Date parseCorta(String fecha) {
			return parse(fecha,FechaFormatos.DDMMYY);
		}

		
		public  Date parseFechaHora(String fecha) {
			return parse(fecha,FechaFormatos.DDMMYYYYHHMM);
		}

		public  String formatFechaHora(Date fecha) {
			return format(fecha,FechaFormatos.DDMMYYYYHHMM);
		}
		
		public  Date parseFechaHoraCorta(String fecha) {
			return parse(fecha,FechaFormatos.DDMMYYHHMM);
		}

		public  String formatFechaHoraCorta(Date fecha) {
			return format(fecha,FechaFormatos.DDMMYYHHMM);
		}
		public  Date parseMini(String fecha) {
			return parse(fecha,FechaFormatos.DDMM);
		}

		
		public  String formatAm(Date fecha) {
			return format(fecha,FechaFormatos.AMPM);
		}
		
		public  String formatAlreves(Date fecha) {
			return format(fecha,FechaFormatos.YYYYMMDD);
		}
		
		public  String formatAlrevesSg(Date fecha) {
			return format(fecha,FechaFormatos.YYYYMMDDSINGUION);
		}
		
		public  String formatSinGuion(Date fecha) {
			return format(fecha,FechaFormatos.DDMMYYYYSINGUION);
		}

		public  Date parseException(String lee, FechaFormatos fu) throws ParseException {
			SimpleDateFormat df = new SimpleDateFormat(fu.getFormato());
			return df.parse(lee);
		}
*/

		public  void salir() {
			try{
			Cache.remove();
			Cache=null;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}

		/*
		
		 */
		
		public String formatHora(LocalDateTime in){
			return format(in,FechaFormatos.DDMMYYHHMM);
		}
		
		
		public String format(LocalDate in){
			return format(in,FechaFormatos.DDMMYYYY);
		}
		
		
		public  LocalDateTime parseT(String fecha,FechaFormatos formato) throws DateTimeParseException{
			if(fecha==null)
				return null;
			//DateTimeFormatter df = getFormat(formato);
			return LocalDateTime.parse(fecha,getFormat(formato));
			//return  Timestamp.valueOf(time);
			
			//	log.error(e.getMessage(),e);
			
			//return null;
		}
		

		public LocalDate parseYYYYMMDD(String fecha) throws DateTimeParseException{
			if(fecha==null)
				return null;
			return LocalDate.parse(fecha,getFormat(FechaFormatos.YYYYMMDD));
		}

		
		public LocalDateTime parseISO(String fecha) {
			return parseT(fecha,FechaFormatos.ISO);
		}
		
		public LocalDateTime parseISOLargo(String fecha) throws DateTimeParseException {
			return parseT(fecha,FechaFormatos.ISOLARGO);
		}
		
		public static LocalDateTime convierte(Date fecha) {
			if(fecha==null)
				return null;
			return LocalDateTime.ofInstant(fecha.toInstant(),zona);			
		}

		public String formatISO(LocalDateTime fecha) {
			return format(fecha, FechaFormatos.ISO);
		}

		
		public String formatLog(LocalDate fecha) {
			return WordUtils.capitalize(format(fecha, FechaFormatos.COMPLETO));
		}
	
		public String formatLogHora(LocalDateTime fecha) {
			return format(fecha, FechaFormatos.HORAMINUTO);
		}
		
		public static LocalDateTime sysdate() {
			return LocalDateTime.now(zona);
		}
		
		public String sysdateISO(){
			return formatISO(LocalDateTime.now());
		}
		
		public static boolean sysdateBetween(LocalDateTime inicio, LocalDateTime fin) {
		    return isBetween(sysdate(), inicio, fin);
		}
		
		public static boolean isBetween(LocalDateTime fecha, LocalDateTime inicio, LocalDateTime fin) {
		    return ((fecha.isAfter(inicio) || fecha.equals(inicio)) && 
		                    (fecha.isBefore(fin) || fecha.equals(fin) ));
		}

		public LocalDateTime convierteUnix(BigDecimal fecha){
			return new Timestamp(fecha.longValue()).toLocalDateTime();
		}

		public static long fechaUnix(LocalDateTime fecha) {
			return Timestamp.valueOf(fecha).getTime()/1000L;			
		}

		public static LocalDate convierteF(java.sql.Date fecha) {
			if(fecha==null)
				return null;
			return fecha.toLocalDate();			
		}

		/*
		public static LocalDateTime sysdate() {
			return convierte(new Date());
		}

		

		public String formatISO(Timestamp date) {
			return format(Timestamp.toLo, formato);
		}*/

				
}
