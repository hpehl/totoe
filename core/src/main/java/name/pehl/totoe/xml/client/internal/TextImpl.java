package name.pehl.totoe.xml.client.internal;

import name.pehl.totoe.xml.client.Text;
import name.pehl.totoe.xml.client.WhitespaceHandling;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision: 174
 *          $
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
     * Retunrs the value of this Text.
     * 
     * @return the value of this Text.
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
