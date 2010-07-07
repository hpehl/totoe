package name.pehl.totoe.client.internal;

import java.util.List;

import name.pehl.totoe.client.DocumentFragment;
import name.pehl.totoe.client.Node;
import name.pehl.totoe.client.NodeType;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public class DocumentFragmentImpl extends NodeImpl implements DocumentFragment
{
    // ----------------------------------------------------------- constructors

    protected DocumentFragmentImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // ----------------------------------------------------------------- parent

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
