package name.pehl.totoe.client.internal;

import java.util.ArrayList;
import java.util.List;

import name.pehl.totoe.client.HasChildren;
import name.pehl.totoe.client.HasText;
import name.pehl.totoe.client.Node;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Collection of static helper methods used by the different node
 * implementations.
 * 
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
final class XmlParserUtils
{
    private XmlParserUtils()
    {
    }


    // --------------------------------------------------------------- children

    static List<Node> getChildren(JavaScriptObject node)
    {
        List<Node> result = new ArrayList<Node>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();

        getChildrenImpl(node, jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add(NodeFactory.create(jso));
        }
        return result;
    }


    static native boolean hasChildren(JavaScriptObject node) /*-{
        return node.hasChildNodes();
    }-*/;


    private static native void getChildrenImpl(JavaScriptObject node, List<JavaScriptObject> result) /*-{
        var children = node.childNodes;
        if (children != null && children.length != 0)
        {
            for (var i = 0; i < children.length; i++) 
            {
                result.@java.util.List::add(Ljava/lang/Object;)(children[i]);
            }
        }
    }-*/;


    static Node getFirstChild(JavaScriptObject node)
    {
        JavaScriptObject firstChildJso = getFirstChildImpl(node);
        return NodeFactory.create(firstChildJso);
    }


    private static native JavaScriptObject getFirstChildImpl(JavaScriptObject node) /*-{
        return node.firstChild;
    }-*/;


    static Node getLastChild(JavaScriptObject node)
    {
        JavaScriptObject lastChildJso = getLastChildImpl(node);
        return NodeFactory.create(lastChildJso);
    }


    private static native JavaScriptObject getLastChildImpl(JavaScriptObject node) /*-{
        return node.lastChild;
    }-*/;


    // ------------------------------------------------------------------- text

    static native String getNodeValue(JavaScriptObject node) /*-{
        return node.nodeValue;
    }-*/;


    /**
     * Returns the text of the first child in case the first child implements
     * {@link HasText}. In all other cases this method returns <code>null</code>
     * .
     * 
     * @param hasChildrenNode
     *            The node with children.
     * @return the text of the first child in case the first child implements
     *         {@link HasText}, <code>null</code> otherwise.
     */
    static String getTextFromFirstChild(HasChildren hasChildrenNode)
    {
        Node firstChild = hasChildrenNode.getFirstChild();
        if (firstChild != null && firstChild instanceof HasText)
        {
            return ((HasText) firstChild).getText();
        }
        return null;
    }
}
