package mx.emite.sdk.utils;

import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

@Deprecated
public class ComplementoWriter extends DelegatingXMLStreamWriter {

	  private static final NamespaceContext emptyNamespaceContext = new NamespaceContext() {

	    @Override
	    public String getNamespaceURI(String prefix) {
	      return "";
	    }

	    @Override
	    public String getPrefix(String namespaceURI) {
	      return "";
	    }

	    @Override
	    public Iterator<String> getPrefixes(String namespaceURI) {
	      return null;
	    }

	  };

	  public static XMLStreamWriter filter(Writer writer,boolean escribirNs,final Map<String, String> namespaces) throws XMLStreamException {
	    return new ComplementoWriter(XMLOutputFactory.newInstance().createXMLStreamWriter(writer),escribirNs,namespaces);
	  }

	  public ComplementoWriter(XMLStreamWriter writer,boolean escribirNs,final Map<String, String> namespaces) {
	    super(writer,escribirNs,namespaces);
	  }

	  @Override
	  public NamespaceContext getNamespaceContext() {
	    return emptyNamespaceContext;
	  }

	}