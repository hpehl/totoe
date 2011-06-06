package name.pehl.totoe.xml.client.internal;

import name.pehl.totoe.commons.client.WhitespaceHandling;
import name.pehl.totoe.xml.client.CDATA;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision: 174
 *          $
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
     * @see name.pehl.totoe.xml.client.HasText#getText()
     */
    @Override
    public String getText()
    {
        return XmlParserUtils.getNodeValue(jso);
    }


    @Override
    public String getText(WhitespaceHandling whitespaceHandling)
    {
        return XmlParserUtils.stripWhitespace(getText(), whitespaceHandling);
    }
}
