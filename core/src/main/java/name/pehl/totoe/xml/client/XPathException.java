package name.pehl.totoe.xml.client;

/**
 * Exception thrown by <code>Node.select*()</code> methods.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 174
 *          $
 */
@SuppressWarnings("serial")
public class XPathException extends RuntimeException
{
    public XPathException()
    {
    }


    public XPathException(String message)
    {
        super(message);
    }


    public XPathException(Throwable cause)
    {
        super(cause);
    }


    public XPathException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
