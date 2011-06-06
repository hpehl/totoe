package name.pehl.totoe.xml.client.internal;

import java.util.ArrayList;
import java.util.List;

import name.pehl.totoe.commons.client.WhitespaceHandling;
import name.pehl.totoe.xml.client.Document;
import name.pehl.totoe.xml.client.HasText;
import name.pehl.totoe.xml.client.Node;
import name.pehl.totoe.xml.client.NodeType;
import name.pehl.totoe.xml.client.XPathException;

import com.google.gwt.core.client.JavaScriptException;
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


    // --------------------------------------------------------- object methods

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
    @Override
    public int hashCode()
    {
        return jso.hashCode();
    }


    /**
     * Returns a string representation containing the internal
     * {@link JavaScriptObject} and the result of {@link #serialize()}.
     * 
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return new StringBuilder().append(jso).append(": ").append(serialize()).toString();
    }


    // ------------------------------------------------------- basic attributes

    @Override
    public native String getName() /*-{
		var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		return node.nodeName;
    }-*/;


    @Override
    public NodeType getType()
    {
        return NodeType.typeOf(NodeFactory.nativeTypeOf(jso));
    }


    // ------------------------------------------------------------- namespaces

    // The following properties are not supported in IE so they are not part
    // of this node implementation. If you need them feel free to uncomment
    // them.
    // @Override
    // public native String getLocalName() /*-{
    // var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
    // return node.localName;
    // }-*/;

    // @Override
    // public native String getNamespacePrefix() /*-{
    // var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
    // return node.prefix;
    // }-*/;

    // @Override
    // public native String getNamespaceUri() /*-{
    // var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
    // return node.namespaceURI;
    // }-*/;

    // ------------------------------------------- document / parent / siblings

    @Override
    public Document getDocument()
    {
        JavaScriptObject documentJso = getDocumentImpl();
        return NodeFactory.create(documentJso);
    }


    private native JavaScriptObject getDocumentImpl()
    /*-{
		var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		return node.ownerDocument;
    }-*/;


    @Override
    public Node getParent()
    {
        JavaScriptObject parentJso = getParentImpl();
        return NodeFactory.create(parentJso);
    }


    private native JavaScriptObject getParentImpl()
    /*-{
		var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		return node.parentNode;
    }-*/;


    @Override
    public Node getPreviousSibling()
    {
        JavaScriptObject previousSiblingJso = getPreviousSiblingImpl();
        return NodeFactory.create(previousSiblingJso);
    }


    private native JavaScriptObject getPreviousSiblingImpl()
    /*-{
		var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		return node.previousSibling;
    }-*/;


    @Override
    public Node getNextSibling()
    {
        JavaScriptObject nextSiblingJso = getNextSiblingImpl();
        return NodeFactory.create(nextSiblingJso);
    }


    private native JavaScriptObject getNextSiblingImpl()
    /*-{
		var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		return node.nextSibling;
    }-*/;


    // ------------------------------------------------------- node(s) by xpath

    @Override
    public List<Node> selectNodes(String xpath)
    {
        try
        {
            List<Node> result = new ArrayList<Node>();
            List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();
            selectNodesImpl(xpath, jsos);
            for (JavaScriptObject currentJso : jsos)
            {
                result.add(NodeFactory.create(currentJso));
            }
            return result;
        }
        catch (JavaScriptException e)
        {
            throw new XPathException(e.getMessage(), e);
        }
    }


    private native void selectNodesImpl(String xpath, List<JavaScriptObject> result)
    /*-{
		var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		try {
			var nodes = node.selectNodes(xpath);
			if (nodes != null && nodes.length != 0) {
				for ( var i = 0; i < nodes.length; i++) {
					result.@java.util.List::add(Ljava/lang/Object;)(nodes[i]);
				}
			}
		} catch (e) {
			throw new Error(e);
		}
    }-*/;


    @Override
    public Node selectNode(String xpath)
    {
        try
        {
            return NodeFactory.create(selectNodeImpl(xpath));
        }
        catch (JavaScriptException e)
        {
            throw new XPathException(e.getMessage(), e);
        }
    }


    private native JavaScriptObject selectNodeImpl(String xpath)
    /*-{
		var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		try {
			var singleNode = node.selectSingleNode(xpath);
			return singleNode;
		} catch (e) {
			throw new Error(e);
		}
    }-*/;


    // ------------------------------------------------------ value(s) by xpath

    @Override
    public String[] selectValues(String xpath)
    {
        return selectValues(xpath, WhitespaceHandling.PRESERVE);
    }


    @Override
    public String[] selectValues(String xpath, WhitespaceHandling whitespaceHandling)
    {
        try
        {
            List<Node> nodes = selectNodes(xpath);
            List<String> result = new ArrayList<String>();
            for (Node node : nodes)
            {
                if (node instanceof HasText)
                {
                    HasText textNode = (HasText) node;
                    String text = textNode.getText(whitespaceHandling);
                    result.add(text);
                }
            }
            return result.toArray(new String[] {});
        }
        catch (JavaScriptException e)
        {
            throw new XPathException(e.getMessage(), e);
        }
    }


    @Override
    public String selectValue(String xpath)
    {
        return selectValue(xpath, WhitespaceHandling.PRESERVE);
    }


    @Override
    public String selectValue(String xpath, WhitespaceHandling whitespaceHandling)
    {
        try
        {
            Node singleNode = selectNode(xpath);
            if (singleNode instanceof HasText)
            {
                HasText textNode = (HasText) singleNode;
                String text = textNode.getText(whitespaceHandling);
                return text;
            }
            return null;
        }
        catch (JavaScriptException e)
        {
            throw new XPathException(e.getMessage(), e);
        }
    }


    // -------------------------------------------------------------- serialize

    @Override
    public String serialize()
    {
        return serializeImpl();
    }


    private native String serializeImpl()
    /*-{
		var node = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
		return new $wnd.XMLSerializer().serializeToString(node);
    }-*/;
}
