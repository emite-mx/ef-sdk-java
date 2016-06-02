package mx.emite.sdk;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.log4j.Logger;

public class NU {
	
		
		public final static Locale local = new Locale("es","MX");
		public final static  RoundingMode redondeo = RoundingMode.HALF_EVEN;
		public final static MathContext MC = new MathContext(10, redondeo);
		
		private  final Logger log =  Logger.getLogger(NU.class);
	 //dateTimeFormat = new SimpleDateFormat
     //cardDateFormat = new SimpleDateFormat("MMyyyy");
		private  NumberUtilCache Cache = new NumberUtilCache();
		
		
		private enum Tipos{
			TIPO_DINERO,DOUBLE,ENTERO,MONTO, CODIGOBARRAS
		}
		
		public enum NumeroFormatos{
		DINERO(Tipos.TIPO_DINERO,2),
		DOSDECIMALES(Tipos.DOUBLE,2),
		ENTERO5(Tipos.ENTERO,5),
		ENTERO7(Tipos.ENTERO,5),
		LONG(Tipos.ENTERO,7),
		SINDECIMALES(Tipos.DOUBLE,0),
		DINEROSINDECIMALES(Tipos.TIPO_DINERO,0),
		MONTO(Tipos.MONTO,3),
		CANTIDAD5DECIMALES(Tipos.MONTO,5),
		CANTIDAD10DECIMALES(Tipos.MONTO,10),
		PORCENTAJE(Tipos.MONTO,2),
		CODIGOBARRAS(Tipos.CODIGOBARRAS,0),
		ENTERO3(Tipos.ENTERO,3),
		CANTIDAD8DECIMALES(Tipos.MONTO,8),
		CINCODECIMALES(Tipos.DOUBLE,5);
		;
		
		
		//private  SimpleDateFormat dftc = new SimpleDateFormat("dd/MM/yy HH:mm");
		//private  SimpleDateFormat dft = new SimpleDateFormat();
		//private  SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		//private  SimpleDateFormat dfc = new SimpleDateFormat("dd/MM/yy");
		//private  SimpleDateFormat dfcfdi = new SimpleDateFormat("yyyy-MM-dd");
		//private  SimpleDateFormat dfmini = new SimpleDateFormat("dd/MM");
		//private  SimpleDateFormat dftarde = new SimpleDateFormat("aa");
		private  final Tipos tipo;
		private final int decimales;
		NumeroFormatos(Tipos tipo){
			this(tipo,2);				
		}
		
		NumeroFormatos(Tipos tipo,int decimales){
			this.tipo=tipo;			
			this.decimales=decimales;
		}
		
		public Format getFormato(){
			switch(tipo){
			case TIPO_DINERO: return NumberFormat.getCurrencyInstance(local);
			case DOUBLE: 	NumberFormat res = NumberFormat.getInstance(local);
							res.setMinimumFractionDigits(decimales);
							res.setMaximumFractionDigits(decimales);
							res.setGroupingUsed(false);
							return res;
			case ENTERO:	return new DecimalFormat(getCeros(decimales));
			case MONTO:	NumberFormat mf = NumberFormat.getInstance(local);
						mf.setMinimumFractionDigits(2);
						mf.setMaximumFractionDigits(decimales);
						mf.setGroupingUsed(false);
						return mf;
			case CODIGOBARRAS: return new DecimalFormat("0000000000.000000",new DecimalFormatSymbols(local));
								
			}
			return null;
		}

		public String getValorFormato() {
			String res="";
			for(int x=0;x<decimales;x++)
					res+="0";
			return "0."+res;
						
		}	

		}
		
		/*public  Double formatea(double numero, int decimales) {
			nf.setMinimumFractionDigits(decimales);
			nf.setMaximumFractionDigits(decimales);

			return Double.parseDouble(nf.format(numero));
		}*/
		


		public  void salir() {
			try{
			Cache.remove();
			Cache=null;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}

		private static String getCeros(int decimales) {
			String res="";
			for(int x=0;x<decimales;x++)
				res+="0";
			return res;
		}

		private  Format getFormat(NumeroFormatos formato){
			try{
				
				return Cache.get(formato);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
			}
			return new DecimalFormat();
		}

		public  String format(BigDecimal valor,NumeroFormatos formato){
			if(valor==null)
				return null;			
			Format df = getFormat(formato);
			return df.format(valor);
		}
		
		public  String for7(BigDecimal valor){
			return format(valor,NumeroFormatos.ENTERO7);
		}
		
		
		public  BigDecimal parse(String valor,NumeroFormatos formato){
			if(valor==null)
				return null;			
			Format df = getFormat(formato);
			try{
				return new BigDecimal(((NumberFormat)df).parse(valor).toString());
			}
			catch(Exception ex){
				log.error(ex.getMessage(),ex);
				return null;
			}
			 
		}
		
		public  BigDecimal parseNE(String valor,NumeroFormatos formato) throws Exception{
			if(valor==null)
				return null;			
			Format df = getFormat(formato);
			return new BigDecimal(((NumberFormat)df).parse(valor).toString(),MC);
		}
		
		
		public  String format(Integer valor,NumeroFormatos formato){
			if(valor==null)
				return null;			
			Format df = getFormat(formato);
			return df.format(valor);
		}
		public  String format(Long valor,NumeroFormatos formato){
			if(valor==null)
				return null;			
			Format df = getFormat(formato);
			return df.format(valor);
		}

		public  String formatoInt5(Integer cp) {
			return format(cp,NumeroFormatos.ENTERO5);
		}

		public  String formato5(BigDecimal cp) {
			return format(cp,NumeroFormatos.CANTIDAD5DECIMALES);
		}
		
		public  String formato2(BigDecimal cp) {
			return format(cp,NumeroFormatos.DOSDECIMALES);
		}
		
		public  String formatoDouble2(BigDecimal numero) {
			return format(numero,NumeroFormatos.DOSDECIMALES);
		}

		public  String dinero(BigDecimal numero) {
			return format(numero,NumeroFormatos.DINERO);
			
		}
		
		public  String formatoPorcentaje(BigDecimal numero) {
			return format(numero,NumeroFormatos.PORCENTAJE)+"%";
			
		}


		public  String formatoDouble0(BigDecimal numero) {
			return format(numero,NumeroFormatos.SINDECIMALES);
		}
		
		public static  BigDecimal multiplica(BigDecimal n1,BigDecimal n2,int escala){
			return n1.multiply(nvl(n2,BigDecimal.ONE)).setScale(escala,RoundingMode.HALF_UP);
		}
		
		public static BigDecimal divide(BigDecimal n1,BigDecimal n2,int escala){
			return n1.divide(n2,escala,RoundingMode.HALF_UP);
		}

		public  BigDecimal redondea(BigDecimal numero, int i) {
		
			return numero.setScale(i,RoundingMode.HALF_UP);
		}

		public  boolean compara(BigDecimal v1,BigDecimal v2) {			
			return redondea(v1,2).subtract(redondea(v2,2)).abs().compareTo(new BigDecimal(5))<=0;
		}

		public  BigDecimal ceronull(String monto) {
			if(monto==null)
				return BigDecimal.ZERO;
			if(monto.length()==0)
				return BigDecimal.ZERO;
			return new BigDecimal(monto);
		}

		public  String soloNumeros(String telefono) {
			StringBuffer res = new StringBuffer();
			for(int x=0;x<telefono.length();x++){
				if(Character.isDigit(telefono.charAt(x)))
					res.append(telefono.charAt(x));
			}
			
			return res.toString();
		}

		public  BigDecimal red(BigDecimal numero) {
			return parse(format(numero,NumeroFormatos.DOSDECIMALES),NumeroFormatos.DOSDECIMALES);
		}
		
		public  String format7(Long numero) {
			return format(numero,NumeroFormatos.LONG);
		}

		public  BigDecimal redondea2(BigDecimal bigDecimal) {
			return redondea(bigDecimal,2);
		}

		public  BigDecimal red2(BigDecimal bigDecimal) {
			return redondea2(bigDecimal);
		}
		
		public  BigDecimal red3(BigDecimal bigDecimal) {
			return redondea(bigDecimal,3);
		}
		
		public  BigDecimal red5(BigDecimal bigDecimal) {
			return redondea(bigDecimal,5);
		}
		
		
		public  BigDecimal divide(BigDecimal total, BigDecimal tasas) {
			if(total!=null)
				return total.divide(tasas,MC);
				
			return BigDecimal.ZERO;
		}

		public  boolean esMayor(BigDecimal val, BigDecimal maximo) {
			if(val!=null&&maximo!=null)
				return val.compareTo(maximo)==1;
			return false;
		}

		public static  BigDecimal suma(BigDecimal... op1) {
			BigDecimal res = new BigDecimal("0.00");
			for(BigDecimal a:op1)
				res=res.add(nvlcero(a));
			return res;
		}

		public  BigDecimal resta(BigDecimal... op1) {
			BigDecimal res = new BigDecimal("0.00");
			for(BigDecimal a:op1)
				res=res.subtract(nvlcero(a));
			return res;
		}
		
		public static  BigDecimal nvlcero(BigDecimal numero) {
			if(numero==null)
				return BigDecimal.ZERO;
			return numero;
		}

		public  String formatCodigo(BigDecimal total) {
				return format(total, NumeroFormatos.CODIGOBARRAS);
		}

		public  boolean iguales(BigDecimal totalCfd,	BigDecimal totalEgreso, int i) {
			return redondea(totalCfd, 0).compareTo(redondea(totalEgreso,0))==0;
		}

		public  BigDecimal tc(BigDecimal monto, BigDecimal tc) {
			BigDecimal res = divide(monto,tc,3);
			res = red2(res);
			if(res.remainder(BigDecimal.ONE).compareTo(new BigDecimal(".99"))==0){
				res = res.add(new BigDecimal("0.01"));
			}
			
			return res;
		}

		public  BigDecimal convierte(String property) throws Exception{
			if(property==null)
				return BigDecimal.ZERO;
			return new BigDecimal(property);
		}

		
		/*public  BigDecimal calculaTotal(BigDecimal total, E_Impuestos e) throws Exception {
			if(e.getTasa()!=null){
				BigDecimal monto = total;
				//monto = monto.divide(e.getTasa());
				monto = monto.divide(e.getTasa().divide(new BigDecimal(100)),MC);
				return monto;
			}
			return e.getImporte();
		}*/
		
		
		public static  <T> T nvl(T a, T b) {
			return (a == null) ? b : a;
		}

		public static  BigDecimal montoimpuesto(BigDecimal subtotal,	BigDecimal tasa) {
			if(subtotal!=null&&tasa!=null){
				BigDecimal monto = subtotal;
				monto = monto.multiply(tasa);
				monto = monto.divide(new BigDecimal(100),3,redondeo);
				return monto;
			}
			return BigDecimal.ZERO;
		}

		public static int comparaNumeros(final Number x, final Number y) {
		    if(isSpecial(x) || isSpecial(y))
		        return Double.compare(x.doubleValue(), y.doubleValue());
		    else
		        return toBigDecimal(x).compareTo(toBigDecimal(y));
		}

		private static boolean isSpecial(final Number x) {
		    boolean specialDouble = x instanceof Double
		            && (Double.isNaN((Double) x) || Double.isInfinite((Double) x));
		    boolean specialFloat = x instanceof Float
		            && (Float.isNaN((Float) x) || Float.isInfinite((Float) x));
		    return specialDouble || specialFloat;
		}

		private static BigDecimal toBigDecimal(final Number number) {
		    if(number instanceof BigDecimal)
		        return (BigDecimal) number;
		    if(number instanceof BigInteger)
		        return new BigDecimal((BigInteger) number);
		    if(number instanceof Byte || number instanceof Short
		            || number instanceof Integer || number instanceof Long)
		        return new BigDecimal(number.longValue());
		    if(number instanceof Float || number instanceof Double)
		        return new BigDecimal(number.doubleValue());

		    try {
		        return new BigDecimal(number.toString());
		    } catch(final NumberFormatException e) {
		        throw new RuntimeException("The given number (\"" + number
		                + "\" of class " + number.getClass().getName()
		                + ") does not have a parsable string representation", e);
		    }
		}
		
		
		/*public  void main(String[] args){
			final BigDecimal factor = divide(BigDecimal.valueOf(9.2),BigDecimal.valueOf(100),3);
			final BigDecimal tasa = divide(BigDecimal.valueOf(16),BigDecimal.valueOf(100),2);//,3,RoundingMode.HALF_UP);
			BigDecimal primaNeta = new BigDecimal(15622.99);
			BigDecimal derechos = new BigDecimal(450);
			BigDecimal recargos =  multiplica(primaNeta,factor,2);
			BigDecimal impuestos = multiplica(primaNeta.add(derechos).add(recargos),tasa,2);
			//BigDecimal tasa=solicitada.tasa;
			BigDecimal primaTotal=primaNeta.add( derechos).add( recargos).add( impuestos);
			//BigDecimal id_Frecuencia_Cobro=frecuencia.getId_Frecuencia_Cobro();
			System.out.print(primaTotal);
			
		}*/
	
		

		
}
