package name.pehl.totoe.client.internal;

import java.util.ArrayList;
import java.util.List;

import name.pehl.totoe.client.Document;
import name.pehl.totoe.client.HasText;
import name.pehl.totoe.client.Node;
import name.pehl.totoe.client.NodeType;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision: 623
 *          $
 */
public class NodeImpl implements Node
{
    protected JavaScriptObject jso;


    // ----------------------------------------------------------- constructors

    /**
     * Construct a new instance of this class using the specified
     * {@link JavaScriptObject}.
     * 
     * @param jso
     */
    protected NodeImpl(JavaScriptObject jso)
    {
        this.jso = jso;
    }


    // -------------------------------------------------------- object identity

    /**
     * Based on the underlying {@link JavaScriptObject}.
     * 
     * @param o
     *            the other object being tested for equality.
     * @return true if the two objects are equal.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o instanceof NodeImpl)
        {
            return jso == ((NodeImpl) o).jso;
        }
        return false;
    }


    /**
     * Based on the underlying {@link JavaScriptObject}.
     * 
     * @return the hashcode based on the underlying {@link JavaScriptObject}.
     */
    public int hashCode()
    {
        return jso.hashCode();
    }


    // ------------------------------------------------------- basic attributes

    @Override
    public native String getName() /*-{
        var node = this.@name.pehl.totoe.client.internal.NodeImpl::jso;
        return node.nodeName;
    }-*/;


    @Override
    public NodeType getType()
    {
        return NodeType.typeOf(NodeFactory.nativeTypeOf(jso));
    }


    // ------------------------------------------- document / parent / siblings

    @Override
    public Document getDocument()
    {
        JavaScriptObject documentJso = getDocumentImpl();
        return NodeFactory.create(documentJso);
    }


    public native JavaScriptObject getDocumentImpl() /*-{
        var node = this.@name.pehl.totoe.client.internal.NodeImpl::jso;
        return node.ownerDocument;
    }-*/;


    @Override
    public Node getParent()
    {
        JavaScriptObject parentJso = getParentImpl();
        return NodeFactory.create(parentJso);
    }


    public native JavaScriptObject getParentImpl() /*-{
        var node = this.@name.pehl.totoe.client.internal.NodeImpl::jso;
        return node.parentNode;
    }-*/;


    @Override
    public Node getPreviousSibling()
    {
        JavaScriptObject previousSiblingJso = getPreviousSiblingImpl();
        return NodeFactory.create(previousSiblingJso);
    }


    public native JavaScriptObject getPreviousSiblingImpl() /*-{
        var node = this.@name.pehl.totoe.client.internal.NodeImpl::jso;
        return node.previousSibling;
    }-*/;


    @Override
    public Node getNextSibling()
    {
        JavaScriptObject nextSiblingJso = getNextSiblingImpl();
        return NodeFactory.create(nextSiblingJso);
    }


    public native JavaScriptObject getNextSiblingImpl() /*-{
        var node = this.@name.pehl.totoe.client.internal.NodeImpl::jso;
        return node.nextSibling;
    }-*/;


    // ------------------------------------------------------- node(s) by xpath

    @Override
    public List<Node> selectNodes(String xpath)
    {
        List<Node> result = new ArrayList<Node>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();

        selectNodesImpl(xpath, jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add(NodeFactory.create(jso));
        }
        return result;
    }


    private native void selectNodesImpl(String xpath, List<JavaScriptObject> result) /*-{
        var node = this.@name.pehl.totoe.client.internal.NodeImpl::jso;
        var nodes = node.selectNodes(xpath);
        if (nodes != null && nodes.length != 0)
        {
            for (var i = 0; i < nodes.length; i++) 
            {
                result.@java.util.List::add(Ljava/lang/Object;)(nodes[i]);
            }
        }
    }-*/;


    @Override
    public Node selectNode(String xpath)
    {
        return NodeFactory.create(selectNodeImpl(xpath));
    }


    private native JavaScriptObject selectNodeImpl(String xpath) /*-{
        var node = this.@name.pehl.totoe.client.internal.NodeImpl::jso;
        var singleNode = node.selectSingleNode(xpath);
        return singleNode;
    }-*/;


    // ------------------------------------------------------ value(s) by xpath

    @Override
    public String[] selectValues(String xpath)
    {
        List<Node> nodes = selectNodes(xpath);
        List<String> result = new ArrayList<String>();
        for (Node currentNode : nodes)
        {
            if (currentNode instanceof HasText)
            {
                result.add(((HasText) currentNode).getText());
            }
        }
        return result.toArray(new String[] {});
    }


    @Override
    public String selectValue(String xpath)
    {
        Node singleNode = selectNode(xpath);
        if (singleNode instanceof HasText)
        {
            return ((HasText) singleNode).getText();
        }
        return null;
    }
}
