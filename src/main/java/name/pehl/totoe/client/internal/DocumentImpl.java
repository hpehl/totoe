package name.pehl.totoe.client.internal;

import java.util.ArrayList;
import java.util.List;

import name.pehl.totoe.client.Document;
import name.pehl.totoe.client.DocumentType;
import name.pehl.totoe.client.Element;
import name.pehl.totoe.client.HasText;
import name.pehl.totoe.client.Node;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class DocumentImpl extends NodeImpl implements Document
{
    // ----------------------------------------------------------- constructors

    protected DocumentImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // ------------------------------------------------------ document specific

    /**
     * Always returns <code>null</code>.
     * 
     * @return <code>null</code>
     * @see name.pehl.totoe.client.internal.NodeImpl#getParent()
     */
    @Override
    public Node getParent()
    {
        return null;
    }


    /**
     * Returns this document
     * 
     * @return this
     * @see name.pehl.totoe.client.internal.NodeImpl#getDocument()
     */
    @Override
    public Document getDocument()
    {
        return this;
    }


    @Override
    public DocumentType getDocumentType()
    {
        JavaScriptObject documentTypeJso = getDocumentTypeImpl();
        return NodeFactory.create(documentTypeJso);
    }


    private native JavaScriptObject getDocumentTypeImpl() /*-{
        var doc = this.@name.pehl.totoe.client.internal.DocumentImpl::jso;
        return doc.doctype;
    }-*/;


    @Override
    public Element getRoot()
    {
        JavaScriptObject rootJso = getRootImpl();
        return NodeFactory.create(rootJso);
    }


    private native JavaScriptObject getRootImpl() /*-{
        var doc = this.@name.pehl.totoe.client.internal.DocumentImpl::jso;
        return doc.documentElement;
    }-*/;


    @Override
    public Element getElementById(String id)
    {
        JavaScriptObject elementByIdJso = getElementByIdImpl(id);
        return NodeFactory.create(elementByIdJso);
    }


    private native JavaScriptObject getElementByIdImpl(String id) /*-{
        var doc = this.@name.pehl.totoe.client.internal.DocumentImpl::jso;
        return doc.getElementById(id);
    }-*/;


    @Override
    public List<Element> getElementsByName(String name)
    {
        List<Element> result = new ArrayList<Element>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();

        getElementsByNameImpl(name, jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add((Element) NodeFactory.create(jso));
        }
        return result;
    }


    private native JavaScriptObject getElementsByNameImpl(String name, List<JavaScriptObject> result) /*-{
        var doc = this.@name.pehl.totoe.client.internal.DocumentImpl::jso;
        var nodes = doc.getElementsByTagName(name);
        if (nodes != null && nodes.length != 0)
        {
            for (var i = 0; i < nodes.length; i++) 
            {
                result.@java.util.List::add(Ljava/lang/Object;)(nodes[i]);
            }
        }
    }-*/;


    // --------------------------------------------------------------- children

    @Override
    public List<Node> getChildren()
    {
        return XmlParserUtils.getChildren(jso);
    }


    @Override
    public boolean hasChildren()
    {
        return XmlParserUtils.hasChildren(jso);
    }


    @Override
    public Node getFirstChild()
    {
        return XmlParserUtils.getFirstChild(jso);
    }


    @Override
    public Node getLastChild()
    {
        return XmlParserUtils.getLastChild(jso);
    }


    // ------------------------------------------------------------------- text

    /**
     * Returns the text of the first child in case the first child implements
     * {@link HasText}. In all other cases this method returns <code>null</code>
     * .
     * 
     * @return the text of the first child in case the first child implements
     *         {@link HasText}, <code>null</code> otherwise.
     * @see name.pehl.totoe.client.HasText#getText()
     */
    @Override
    public String getText()
    {
        return XmlParserUtils.getTextFromFirstChild(this);
    }
}
