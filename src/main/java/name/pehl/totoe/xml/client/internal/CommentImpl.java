package name.pehl.totoe.xml.client.internal;

import name.pehl.totoe.xml.client.Comment;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public class CommentImpl extends NodeImpl implements Comment
{
    // ----------------------------------------------------------- constructors

    protected CommentImpl(JavaScriptObject jso)
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
    public String getTextStripped()
    {
        return XmlParserUtils.stripWsnl(getText());
    }
}
