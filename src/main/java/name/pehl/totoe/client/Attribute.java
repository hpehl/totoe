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
     * @return the element this attribute belongs to.
     */
    Element getElement();
}
