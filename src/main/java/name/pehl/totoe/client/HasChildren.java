package name.pehl.totoe.client;

import java.util.List;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface HasChildren
{
    /**
     * Returns all nodes which are direct children of the implementing node.
     * Returns an empty list if the node has no children.
     * 
     * @return all nodes which are direct children of the implementing node or
     *         an empty list, if the node has no children.
     */
    List<Node> getChildren();


    /**
     * Returns <code>true</code> if the implementing node has children,
     * <code>false</code> otherwise.
     * 
     * @return <code>true</code> if the implementing node has children,
     *         <code>false</code> otherwise.
     */
    boolean hasChildren();


    /**
     * Returns the first child of the implementing node.
     * 
     * @return the first child of this node or <code>null</code> if the node has
     *         no children.
     */
    Node getFirstChild();


    /**
     * Returns the last child of the implementing node.
     * 
     * @return the last child of the implementing node or <code>null</code> if
     *         the node has no children.
     */
    Node getLastChild();
}
