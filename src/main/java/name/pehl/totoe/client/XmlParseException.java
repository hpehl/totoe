package name.pehl.totoe.client;

/**
 * Exception thrown by {@link XmlParser#parse(String)} methods.
 * 
 * @author $Author$
 * @version $Date$ $Revision$
 */
public class XmlParseException extends RuntimeException
{
    public XmlParseException()
    {
    }


    public XmlParseException(String message)
    {
        super(message);
    }


    public XmlParseException(Throwable cause)
    {
        super(cause);
    }


    public XmlParseException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
