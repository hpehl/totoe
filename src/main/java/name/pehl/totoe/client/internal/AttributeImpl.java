package name.pehl.totoe.client.internal;

import name.pehl.totoe.client.Attribute;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class AttributeImpl extends NodeImpl implements Attribute
{
    // ----------------------------------------------------------- constructors

    public AttributeImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    /**
     * Retunrs the value of this attribute.
     * 
     * @return the value of this attribute.
     * @see name.pehl.totoe.client.HasText#getText()
     */
    @Override
    public native String getText() /*-{
        var attribute = this.@name.pehl.totoe.client.internal.NodeImpl::jso;
        return attribute.nodeValue;
    }-*/;
}
