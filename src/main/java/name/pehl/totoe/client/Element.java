package name.pehl.totoe.client;

import java.util.List;
import java.util.Map;

/**
 * The Element interface represents an element in an XML document. Elements may
 * have attributes associated with them. There are methods on the Element
 * interface to retrieve either an {@linkplain Attribute attribute instance} or
 * attribute value by name.
 * 
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface Element extends Node, HasChildren, HasText
{
    /**
     * Returns the specifed attribute.
     * 
     * @w3cDiff This method refers to the method <code>getAttributeNode()</code>
     *          in the DOM Level 2 specification.
     * @param name
     *            The name of the attribute
     * @return the attribute or <code>null</code> if no such attribute was
     *         found.
     */
    Attribute getAttribute(String name);


    /**
     * Returns the value of the specifed attribute.
     * 
     * @w3cDiff This method refers to the method <code>getAttribute()</code> in
     *          the DOM Level 2 specification.
     * @param name
     *            The name of the attribute
     * @return the value of the attribute or <code>null</code> if no such
     *         attribute was found.
     */
    String getAttributeValue(String name);


    /**
     * Returns <code>true</code> if the element has the specified attribute,
     * <code>false</code> otherwise.
     * 
     * @return <code>true</code> if the element has the specified attribute,
     *         <code>false</code> otherwise.
     */
    boolean hasAttribute(String name);


    /**
     * Returns all attributes.
     * 
     * @return all attributes or an empty list if no attributes are given.
     */
    List<Attribute> getAttributes();


    /**
     * Returns all attribute values with the name as key and the value as value.
     * 
     * @return all attribute values or an empty map if no attributes are given.
     */
    Map<String, String> getAttributeValues();


    /**
     * Returns <code>true</code> if the element has attributes,
     * <code>false</code> otherwise.
     * 
     * @return <code>true</code> if the element has attributes,
     *         <code>false</code> otherwise.
     */
    boolean hasAttributes();
}
