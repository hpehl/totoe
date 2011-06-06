package name.pehl.totoe.xml.client.internal;

import java.util.ArrayList;
import java.util.List;

import name.pehl.totoe.commons.client.WhitespaceHandling;
import name.pehl.totoe.xml.client.HasChildren;
import name.pehl.totoe.xml.client.HasText;
import name.pehl.totoe.xml.client.Node;
import name.pehl.totoe.xml.client.NodeType;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Collection of static helper methods used by the different node
 * implementations.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 174
 *          $
 */
final class XmlParserUtils
{
    /**
     * Private constructor to ensure that the class acts as a true utility class
     * i.e. it isn't instantiable and extensible.
     */
    private XmlParserUtils()
    {
    }


    // --------------------------------------------------------------- children

    static <T extends Node> List<T> getChildren(JavaScriptObject node)
    {
        return getChildren(node, null);
    }


    @SuppressWarnings("unchecked")
    static <T extends Node> List<T> getChildren(JavaScriptObject node, NodeType nodeType)
    {
        List<T> result = new ArrayList<T>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();
        int internalNodeType = nodeType != null ? nodeType.type() : NodeType.UNDEFINED.type();

        getChildrenImpl(node, internalNodeType, jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add((T) NodeFactory.create(jso));
        }
        return result;
    }


    private static native void getChildrenImpl(JavaScriptObject node, int nodeType, List<JavaScriptObject> result) /*-{
		var children = node.childNodes;
		if (children != null && children.length != 0) {
			for ( var i = 0; i < children.length; i++) {
				var addChild = nodeType != -1 ? children[i].nodeType == nodeType
						: true;
				if (addChild) {
					result.@java.util.List::add(Ljava/lang/Object;)(children[i]);
				}
			}
		}
    }-*/;


    static boolean hasChildren(JavaScriptObject node)
    {
        return hasChildrenImpl(node);
    }


    static boolean hasChildren(JavaScriptObject node, NodeType nodeType)
    {
        return !getChildren(node, nodeType).isEmpty();
    }


    private static native boolean hasChildrenImpl(JavaScriptObject node) /*-{
		return node.hasChildNodes();
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


    static String stripWhitespace(String value, WhitespaceHandling whitespaceHandling)
    {
        String stripped = value;
        if (stripped != null && stripped.length() != 0)
        {
            int start = 0;
            int length = stripped.length();
            String strip = null;
            switch (whitespaceHandling)
            {
                case REMOVE_NEWLINE:
                    strip = "\n\r";
                    break;
                case REMOVE_WHITESPACE:
                    strip = " \t";
                    break;
                case REMOVE:
                    strip = " \n\r\t";
                    break;
                default:
                    break;
            }
            if (strip != null)
            {
                while (start != length && strip.indexOf(stripped.charAt(start)) != -1)
                {
                    start++;
                }
                stripped = stripped.substring(start);
                int end = stripped.length();
                while (end != 0 && strip.indexOf(stripped.charAt(end - 1)) != -1)
                {
                    end--;
                }
                stripped = stripped.substring(0, end);
            }
        }
        return stripped;
    }
}
