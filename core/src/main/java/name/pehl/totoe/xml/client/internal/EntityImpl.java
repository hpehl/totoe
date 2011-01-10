package name.pehl.totoe.xml.client.internal;

import name.pehl.totoe.xml.client.Entity;
import name.pehl.totoe.xml.client.Node;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public class EntityImpl extends NodeImpl implements Entity
{
    // ----------------------------------------------------------- constructors

    protected EntityImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // --------------------------------------------------------- public methods

    @Override
    public native String getPublicId() /*-{
        var entity = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return entity.publicId;
    }-*/;


    @Override
    public native String getSystemId() /*-{
        var entity = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return entity.systemId;
    }-*/;


    @Override
    public native String getNotationName()/*-{
        var entity = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return entity.notationName;
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
