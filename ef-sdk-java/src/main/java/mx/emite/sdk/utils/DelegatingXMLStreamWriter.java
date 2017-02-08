package mx.emite.sdk.utils;


import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class DelegatingXMLStreamWriter implements XMLStreamWriter {
    
	private final boolean escribirNs;
	
	private final Map<String, String> namespaces;
	
	protected final XMLStreamWriter delegate;
    
    public DelegatingXMLStreamWriter(XMLStreamWriter del,boolean escribirNs, final Map<String, String> namespaces) {
        delegate = del;
        this.escribirNs=escribirNs;
        this.namespaces=namespaces;
    }
    
    @Override
	public void close() throws XMLStreamException {
        delegate.close();
    }

    @Override
	public void flush() throws XMLStreamException {
        delegate.flush();
    }

    @Override
	public NamespaceContext getNamespaceContext() {
        return delegate.getNamespaceContext();
    }

    
    
    
    @Override
	public String getPrefix(String uri) throws XMLStreamException {
        return delegate.getPrefix(uri);
    }

    @Override
	public Object getProperty(String name) throws IllegalArgumentException {
        return delegate.getProperty(name);
    }

    @Override
	public void setDefaultNamespace(String uri) throws XMLStreamException {
        delegate.setDefaultNamespace(uri);
    }

    @Override
	public void setNamespaceContext(NamespaceContext ctx) throws XMLStreamException {
        delegate.setNamespaceContext(ctx);
    }

    @Override
	public void setPrefix(String pfx, String uri) throws XMLStreamException {
        delegate.setPrefix(pfx, uri);
    }

    @Override
	public void writeAttribute(String prefix, String uri, 
                               String local, String value) throws XMLStreamException {
        delegate.writeAttribute(prefix, uri, local, value);
    }

    @Override
	public void writeAttribute(String uri, String local, String value) throws XMLStreamException {
        delegate.writeAttribute(uri, local, value);
    }

    @Override
	public void writeAttribute(String local, String value) throws XMLStreamException {
        delegate.writeAttribute(local, value);
    }

    @Override
	public void writeCData(String cdata) throws XMLStreamException {
        delegate.writeCData(cdata);
    }

    @Override
	public void writeCharacters(char[] arg0, int arg1, int arg2) throws XMLStreamException {
        delegate.writeCharacters(arg0, arg1, arg2);
    }

    @Override
	public void writeCharacters(String text) throws XMLStreamException {
        delegate.writeCharacters(text);
    }

    @Override
	public void writeComment(String text) throws XMLStreamException {
        delegate.writeComment(text);
    }

    @Override
	public void writeDefaultNamespace(String uri) throws XMLStreamException {
        delegate.writeDefaultNamespace(uri);
    }

    @Override
	public void writeDTD(String dtd) throws XMLStreamException {
        delegate.writeDTD(dtd);
    }

    @Override
	public void writeEmptyElement(String prefix, String local, String uri) throws XMLStreamException {
        delegate.writeEmptyElement(prefix, local, uri);
    }

    @Override
	public void writeEmptyElement(String uri, String local) throws XMLStreamException {
        delegate.writeEmptyElement(uri, local);
    }

    @Override
	public void writeEmptyElement(String localName) throws XMLStreamException {
        delegate.writeEmptyElement(localName);
    }

    @Override
	public void writeEndDocument() throws XMLStreamException {
        delegate.writeEndDocument();
    }

    @Override
	public void writeEndElement() throws XMLStreamException {
        delegate.writeEndElement();
    }

    @Override
	public void writeEntityRef(String ent) throws XMLStreamException {
        delegate.writeEntityRef(ent);
    }

    @Override
	public void writeNamespace(String prefix, String uri) throws XMLStreamException {
        if(escribirNs){
        	delegate.writeNamespace(prefix, uri);
	        if(namespaces!=null){
	        	for(Entry<String, String> n:namespaces.entrySet()){
	        		delegate.writeNamespace(n.getKey(), n.getValue());
	        	}
	        	namespaces.clear();
	        }
        }
    }

    @Override
	public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
        delegate.writeProcessingInstruction(target, data);
    }

    @Override
	public void writeProcessingInstruction(String target) throws XMLStreamException {
        delegate.writeProcessingInstruction(target);
    }

    @Override
	public void writeStartDocument() throws XMLStreamException {
        delegate.writeStartDocument();
    }

    @Override
	public void writeStartDocument(String encoding, String ver) throws XMLStreamException {
        delegate.writeStartDocument(encoding, ver);
    }

    @Override
	public void writeStartDocument(String ver) throws XMLStreamException {
        delegate.writeStartDocument(ver);
    }

    @Override
	public void writeStartElement(String prefix, String local, String uri) throws XMLStreamException {
        delegate.writeStartElement(prefix, local, uri);
    }

    @Override
	public void writeStartElement(String uri, String local) throws XMLStreamException {
        delegate.writeStartElement(uri, local);
    }

    @Override
	public void writeStartElement(String local) throws XMLStreamException {
        delegate.writeStartElement(local);
    }


}
