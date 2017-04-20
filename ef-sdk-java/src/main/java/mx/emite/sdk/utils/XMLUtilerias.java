package mx.emite.sdk.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLUtilerias {

	public static String format(String xml)  {
		try{ 
			final Source xmlInput = new StreamSource(new StringReader(xml));
	        final StreamResult xmlOutput = new StreamResult(new StringWriter());
	        final Transformer transformer = TransformerFactory.newInstance().newTransformer(); // An identity transformer
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        transformer.transform(xmlInput, xmlOutput);
	        return xmlOutput.getWriter().toString();	
		} catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
