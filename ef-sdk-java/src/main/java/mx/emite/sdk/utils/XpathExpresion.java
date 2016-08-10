package mx.emite.sdk.utils;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import lombok.Getter;

public class XpathExpresion extends ThreadLocal<XPathExpression> implements XPathExpression {

    /** XPath expression */
    @Getter private final String expression;

    /** Namespace context. */
    private final NamespaceContext context;

    /**
     * Creates a new instance from an XPath expression and namespace context.
     *
     * @param xPath XPath expression.
     * @param context Namespace context for handling namespace prefix to URI mappings.
     */
    public XpathExpresion(final String xPath, final NamespaceContext context) {
        this.expression = xPath;
        this.context = context;
    }

    public XpathExpresion(final String xPath) {
        this.expression = xPath;
        this.context = null;
    }
    
    @Override
	public Object evaluate(final Object o, final QName qName) throws XPathExpressionException {
        return get().evaluate(o, qName);
    }

    @Override
	public String evaluate(final Object o) throws XPathExpressionException {
        return get().evaluate(o);
    }

    @Override
	public Object evaluate(final InputSource inputSource, final QName qName) throws XPathExpressionException {
        return get().evaluate(inputSource, qName);
    }

    @Override
	public String evaluate(final InputSource inputSource) throws XPathExpressionException {
        return get().evaluate(inputSource);
    }

    /**
     * Evaluates the XPath expression and returns the result coerced to a string.
     *
     * @param o Object on which to evaluate the expression; typically a DOM node.
     *
     * @return Evaluation result as a string.
     *
     * @throws XPathExpressionException On XPath evaluation errors.
     */
    public String evaluateAsString(final Object o) throws XPathExpressionException {
        return (String) evaluate(o, XPathConstants.STRING);
    }

    /**
     * Evaluates the XPath expression and returns the result coerced to a node list.
     *
     * @param o Object on which to evaluate the expression; typically a DOM node.
     *
     * @return Evaluation result as a node list.
     *
     * @throws XPathExpressionException On XPath evaluation errors.
     */
    public NodeList evaluateAsNodeList(final Object o) throws XPathExpressionException {
        return (NodeList) evaluate(o, XPathConstants.NODESET);
    }

    @Override
    protected XPathExpression initialValue() {
        try {
            final XPath xPath = XPathFactory.newInstance().newXPath();
            if(context!=null)
            	xPath.setNamespaceContext(context);
            
            return xPath.compile(expression);
        } catch (XPathExpressionException e) {
            throw new IllegalArgumentException("Invalid XPath expression");
        }
    }
}