package name.pehl.totoe.xml.client.internal;

import name.pehl.totoe.commons.client.WhitespaceHandling;
import name.pehl.totoe.xml.client.Attribute;
import name.pehl.totoe.xml.client.Element;
import name.pehl.totoe.xml.client.Node;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision: 174
 *          $
 */
public class AttributeImpl extends NodeImpl implements Attribute
{
    // ----------------------------------------------------------- constructors

    protected AttributeImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // ------------------------------------------------------- basic attributes

    @Override
    public Element getElement()
    {
        JavaScriptObject elementJso = getElementImpl();
        return NodeFactory.create(elementJso);
    }


    private native JavaScriptObject getElementImpl()/*-{
		var attribute = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		return attribute.ownerElement;
    }-*/;


    // ----------------------------------------------------------------- parent

    /**
     * Always returns <code>null</code>.
     * 
     * @return <code>null</code>
     * @see name.pehl.totoe.xml.client.internal.NodeImpl#getParent()
     */
    @Override
    public Node getParent()
    {
        return null;
    }


    /**
     * Always returns <code>null</code>.
     * 
     * @return <code>null</code>
     * @see name.pehl.totoe.xml.client.internal.NodeImpl#getPreviousSibling()
     */
    @Override
    public Node getPreviousSibling()
    {
        return null;
    }


    /**
     * @return
     * @see name.pehl.totoe.xml.client.internal.NodeImpl#getNextSibling()
     */
    @Override
    public Node getNextSibling()
    {
        return null;
    }


    // ------------------------------------------------------------------- text

    /**
     * Retunrs the value of this attribute.
     * 
     * @return the value of this attribute.
     * @see name.pehl.totoe.xml.client.HasText#getText()
     */
    @Override
    public native String getText()/*-{
		var attribute = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		return attribute.value;
    }-*/;


    @Override
    public String getText(WhitespaceHandling whitespaceHandling)
    {
        return XmlParserUtils.stripWhitespace(getText(), whitespaceHandling);
    }
}
