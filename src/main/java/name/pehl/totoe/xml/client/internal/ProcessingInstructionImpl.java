package name.pehl.totoe.xml.client.internal;

import name.pehl.totoe.xml.client.ProcessingInstruction;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public class ProcessingInstructionImpl extends NodeImpl implements ProcessingInstruction
{
    // ----------------------------------------------------------- constructors

    protected ProcessingInstructionImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // --------------------------------------------------------- public methods

    @Override
    public native String getTarget()/*-{
        var pi = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return pi.target;
    }-*/;


    // ------------------------------------------------------------------- text

    @Override
    public native String getText()/*-{
        var pi = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return pi.data;
    }-*/;


    @Override
    public String getTextStripped()
    {
        return XmlParserUtils.stripWsnl(getText());
    }
}
