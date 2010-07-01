package name.pehl.totoe.client;

import java.util.List;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public interface Document extends Node, HasChildren
{
    /**
     * Returns the root element.
     * 
     * @return the root element.
     */
    Element getRoot();


    /**
     * Returns the element which has the specified id.
     * 
     * @param id
     * @return the element which has the specified id or <code>null</code> if no
     *         element was found.
     */
    Element getElementById(String id);


    /**
     * Returns the elements with the specifed name.
     * 
     * @return the elements with the specifed name or an empty list if no such
     *         elements were found.
     */
    List<Element> getElementsByName();
}
