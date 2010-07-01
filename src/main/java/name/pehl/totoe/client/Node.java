package name.pehl.totoe.client;

import java.util.List;

/**
 * Base interface for DOM nodes. Methods for iterating over and accessing values
 * from nodes are supplied here.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 623
 *          $
 */
public interface Node
{
    // ------------------------------------------------------- basic attributes

    /**
     * Returns the name of this node.
     * 
     * @return the name of this node.
     */
    String getName();


    /**
     * Returns the type of this node.
     * 
     * @return the type of this node.
     */
    NodeType getType();


    // ------------------------------------------- document / parent / siblings

    /**
     * Returns the document this node belongs to.
     * 
     * @return the document this node belongs to.
     */
    Document getDocument();


    /**
     * Returns the parent of this node.
     * 
     * @return the parent of this node or <code>null</code> if this node has no
     *         parent.
     */
    Node getParent();


    /**
     * Returns the previous sibling of this node.
     * 
     * @return the previous sibling of this node or <code>null</code> if this
     *         node has no previous sibling.
     */
    Node getPreviousSibling();


    /**
     * Returns the next sibling of this node.
     * 
     * @return the next sibling of this node or <code>null</code> if this node
     *         has no next sibling.
     */
    Node getNextSibling();


    // ------------------------------------------------------- node(s) by xpath

    /**
     * Returns a list of nodes for the specifed xpath or an empty list if no
     * matching nodes were found.
     * 
     * @param xpath
     * @return The list of nodes matching the xpath or an empty list if no
     *         matching nodes were found.
     */
    List<Node> selectNodes(String xpath);


    /**
     * Returns the node for the specifed xpath or <code>null</code> if no
     * mathing node was found.
     * 
     * @param xpath
     * @return The node matching the xpath or <code>null</code> if no matching
     *         node was found.
     */
    Node selectNode(String xpath);


    // ------------------------------------------------------ value(s) by xpath

    /**
     * Returns the string values for the specified xpath. The nodes selected by
     * the xpath expression must implement {@link HasText}. Returns an empty
     * array if no mathing nodes were found.
     * 
     * @param xpath
     * @return The string values matched by the xpath or an empty array if no
     *         mathing nodes were found.
     */
    String[] selectValues(String xpath);


    /**
     * Returns the string value for the specified xpath. The node selected by
     * the xpath expression must implement {@link HasText}.
     * 
     * @param xpath
     * @return The string value matched by the xpath or <code>null</code> if no
     *         mathing node were found.
     */
    String selectValue(String xpath);
}
