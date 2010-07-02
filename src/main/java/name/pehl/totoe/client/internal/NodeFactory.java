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
                    result = new TextImpl(jso);
                    break;
                case CDATA:
                    result = new CDATAImpl(jso);
                    break;
                case ENTITY_REFERENCE:
                    result = new EntityReferenceImpl(jso);
                    break;
                case ENTITY:
                    result = new EntityImpl(jso);
                    break;
                case PROCESSING_INSTRUCTION:
                    result = new ProcessingInstructionImpl(jso);
                    break;
                case COMMENT:
                    result = new CommentImpl(jso);
                    break;
                case DOCUMENT:
                    result = new DocumentImpl(jso);
                    break;
                case DOCUMENT_TYPE:
                    result = new DocumentTypeImpl(jso);
                    break;
                case DOCUMENT_FRAGMENT:
                    result = new DocumentFragmentImpl(jso);
                    break;
                case NOTATION:
                    result = new NotationImpl(jso);
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
