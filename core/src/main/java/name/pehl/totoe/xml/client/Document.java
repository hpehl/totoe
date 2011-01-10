package name.pehl.totoe.xml.client;

import java.util.List;

/**
 * The Document interface represents the entire XML document. Conceptually, it
 * is the root of the document tree, and provides the primary access to the
 * document's data.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 78
 *          $
 */
public interface Document extends Node, HasChildren
{
    /**
     * Returns the root element.
     * 
     * @w3cDiff This method refers to the property <code>documentElement</code>
     *          in the DOM Level 2 specification.
     * @return the root element.
     */
    Element getRoot();


    /**
     * Returns the element which has the specified id.
     * 
     * @w3cDiff This method refers to the method <code>getelementById</code> in
     *          the DOM Level 2 specification.
     * @param id
     * @return the element which has the specified id or <code>null</code> if no
     *         element was found.
     */
    Element findById(String id);


    /**
     * Returns the elements with the specifed name.
     * 
     * @w3cDiff This method refers to the method <code>getElementsByName</code> in
     *          the DOM Level 2 specification.
     * @return the elements with the specifed name or an empty list if no such
     *         elements were found.
     */
    List<Element> findByName(String name);


    /**
     * Returns all nodes with the specifed type.
     * 
     * @param <T>
     *            the instance type to filter for
     * @param type
     *            the node type to filter for
     * @return all nodes with the specifed type or an empty list if no such
     *         nodes were found.
     */
    <T extends Node> List<T> findByType(NodeType type);


    /**
     * Returns the document type declaration associated with this document. For
     * documents without a document type declaration this returns
     * <code>null</code>.
     * 
     * @return
     */
    DocumentType getDocumentType();
}
