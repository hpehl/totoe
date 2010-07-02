package name.pehl.totoe.client.internal;

import name.pehl.totoe.client.Text;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class TextImpl extends NodeImpl implements Text
{
    // ----------------------------------------------------------- constructors

    protected TextImpl(JavaScriptObject jso)
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
