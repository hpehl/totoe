package name.pehl.totoe.client;

/**
 * The Attribute interface represents an attribute in an {@link Element} object.
 * <p>
 * Attribute objects inherit the {@link Node} interface, but since they are not
 * actually child nodes of the element they describe, the DOM does not consider
 * them part of the document tree. Thus, the {@link Node} methods
 * {@link Node#getParent()}, {@link Node#getPreviousSibling()}, and
 * {@link Node#getNextSibling()} all return <code>null</code> for Attribute
 * instances.
 * <p>
 * Attribute extends {@link HasText}. To get the value of the attribute use {@link HasText#getText()}.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 43
 *          $
 */
public interface Attribute extends Node, HasText
{
    /**
     * Returns the element this attribute belongs to.
     * 
     * @userAgent Not available in IE6 and 7
     * @return the element this attribute belongs to.
     */
    Element getElement();
}
