package name.pehl.totoe.xml.client.internal;

import name.pehl.totoe.xml.client.Node;
import name.pehl.totoe.xml.client.Notation;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public class NotationImpl extends NodeImpl implements Notation
{
    // ----------------------------------------------------------- constructors

    protected NotationImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // --------------------------------------------------------- public methods

    @Override
    public native String getPublicId() /*-{
        var notation = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return notation.publicId;
    }-*/;


    @Override
    public native String getSystemId() /*-{
        var notation = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return notation.systemId;
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
}
