package name.pehl.totoe.xml.client.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import name.pehl.totoe.xml.client.Document;
import name.pehl.totoe.xml.client.DocumentType;
import name.pehl.totoe.xml.client.Element;
import name.pehl.totoe.xml.client.HasChildren;
import name.pehl.totoe.xml.client.Node;
import name.pehl.totoe.xml.client.NodeType;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision$
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
     * @see name.pehl.totoe.xml.client.internal.NodeImpl#getParent()
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
     * @see name.pehl.totoe.xml.client.internal.NodeImpl#getDocument()
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
        var doc = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return doc.doctype;
    }-*/;


    @Override
    public Element getRoot()
    {
        JavaScriptObject rootJso = getRootImpl();
        return NodeFactory.create(rootJso);
    }


    private native JavaScriptObject getRootImpl() /*-{
        var doc = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return doc.documentElement;
    }-*/;


    @Override
    public Element findById(String id)
    {
        JavaScriptObject elementByIdJso = findByIdImpl(id);
        return NodeFactory.create(elementByIdJso);
    }


    private native JavaScriptObject findByIdImpl(String id) /*-{
        var doc = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return doc.getElementById(id);
    }-*/;


    @Override
    public List<Element> findByName(String name)
    {
        List<Element> result = new ArrayList<Element>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();

        findByNameImpl(name, jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add((Element) NodeFactory.create(jso));
        }
        return result;
    }


    private native JavaScriptObject findByNameImpl(String name, List<JavaScriptObject> result) /*-{
        var doc = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        var nodes = doc.getElementsByTagName(name);
        if (nodes != null && nodes.length != 0)
        {
            for (var i = 0; i < nodes.length; i++) 
            {
                result.@java.util.List::add(Ljava/lang/Object;)(nodes[i]);
            }
        }
    }-*/;


    @Override
    public <T extends Node> List<T> findByType(NodeType type)
    {
        List<T> result = new ArrayList<T>();
        collectNodes(this, result, type);
        return result;
    }


    @SuppressWarnings("unchecked")
    private <T extends Node> void collectNodes(HasChildren start, List<T> nodes, NodeType type)
    {
        for (Node node : start.getChildren())
        {
            if (type == node.getType())
            {
                nodes.add((T) node);
            }
            if (type == NodeType.ATTRIBUTE && node instanceof Element)
            {
                Element element = (Element) node;
                nodes.addAll((Collection<? extends T>) element.getAttributes());
            }
            if (node instanceof HasChildren)
            {
                collectNodes((HasChildren) node, nodes, type);
            }
        }
    }


    // --------------------------------------------------------------- children

    @Override
    public List<Node> getChildren()
    {
        return XmlParserUtils.getChildren(jso);
    }


    @Override
    public <T extends Node> List<T> getChildren(NodeType type)
    {
        return XmlParserUtils.getChildren(jso, type);
    }


    @Override
    public boolean hasChildren()
    {
        return XmlParserUtils.hasChildren(jso);
    }


    @Override
    public boolean hasChildren(NodeType type)
    {
        return XmlParserUtils.hasChildren(jso, type);
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
}
