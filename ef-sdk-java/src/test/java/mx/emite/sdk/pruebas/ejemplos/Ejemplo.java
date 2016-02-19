package mx.emite.sdk.pruebas.ejemplos;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;

public abstract class Ejemplo {

	protected Properties props = new Properties();
	
	@Before
	public void doBeforeEachTest() {
		ConsoleAppender ca = new ConsoleAppender();
		ca.setWriter(new OutputStreamWriter(System.out));
		ca.setLayout(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c:%L - %m%n"));
		ca.setName("consola");
	    Logger.getRootLogger().addAppender(ca);
	    try(InputStream in = Ejemplo.class.getResourceAsStream("/pruebas.properties")){
	    	props.load(in);
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	    
	}
	
	
	
	
}
