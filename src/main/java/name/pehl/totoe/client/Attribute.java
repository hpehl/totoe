package name.pehl.totoe.client;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface Attribute extends Node, HasText
{
    /**
     * Returns the element this attribute belongs to.
     * 
     * @userAgent Not available in IE 6 and 7
     * @return the element this attribute belongs to.
     */
    Element getElement();
}
