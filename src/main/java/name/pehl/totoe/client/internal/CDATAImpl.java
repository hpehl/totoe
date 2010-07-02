package name.pehl.totoe.client.internal;

import name.pehl.totoe.client.CDATA;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class CDATAImpl extends NodeImpl implements CDATA
{
    // ----------------------------------------------------------- constructors

    protected CDATAImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // ------------------------------------------------------------------- text

    /**
     * Retunrs the value of this CDATA.
     * 
     * @return the value of this CDATA.
     * @see name.pehl.totoe.client.HasText#getText()
     */
    @Override
    public String getText()
    {
        return XmlParserUtils.getNodeValue(jso);
    }
}
