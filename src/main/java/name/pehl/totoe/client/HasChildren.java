package name.pehl.totoe.client;

import java.util.List;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public interface HasChildren
{
    /**
     * Returns all nodes which are direct children of the specified node.
     * Returns an empty list if the node has no children.
     * 
     * @return all nodes which are direct children of the specified node or an
     *         empty list, if the node has no children.
     */
    List<Node> getChildren();


    /**
     * Returns the first child of this node.
     * 
     * @return the first child of this node or <code>null</code> if this node
     *         has no children.
     */
    Node getFirstChild();


    /**
     * Returns the last child of this node.
     * 
     * @return the last child of this node or <code>null</code> if this node has
     *         no children.
     */
    Node getLastChild();
}
