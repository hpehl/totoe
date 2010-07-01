package name.pehl.totoe.client.internal;

import name.pehl.totoe.client.Node;
import name.pehl.totoe.client.NodeType;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public final class NodeFactory
{
    private NodeFactory()
    {
    }


    /**
     * Creates a new node of the correct type.
     * 
     * @param jso
     *            the DOM JavaScript object
     * @return a {@link Node} instance that corresponds to the DOM object
     */
    @SuppressWarnings("unchecked")
    static <T extends Node> T create(JavaScriptObject jso)
    {
        Node result = null;
        if (jso != null)
        {
            NodeType type = NodeType.typeOf(nativeTypeOf(jso));
            switch (type)
            {
                case ELEMENT:
                    result = new ElementImpl(jso);
                case ATTRIBUTE:
                    result = new AttributeImpl(jso);
                case TEXT:
                    break;
                case CDATA:
                    break;
                case ENTITY_REFERENCE:
                    break;
                case ENTITY:
                    break;
                case PROCESSING_INSTRUCTION:
                    break;
                case COMMENT:
                    break;
                case DOCUMENT:
                    break;
                case DOCUMENT_TYPE:
                    break;
                case DOCUMENT_FRAGMENT:
                    break;
                case NOTATION:
                    break;
                case UNDEFINED:
                default:
                    result = new NodeImpl(jso);
            }
        }
        return (T) result;
    }


    static native int nativeTypeOf(JavaScriptObject jso) /*-{
        var type = jso.nodeType;
        return type == null ? -1 : type;
    }-*/;
}
