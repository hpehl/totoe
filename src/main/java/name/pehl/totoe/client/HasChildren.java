package name.pehl.totoe.client;

import java.util.List;

/**
 * @userAgent There are differences between browsers when reading child nodes
 *            regarding white-spaces and new lines. See <a
 *            href="http://www.w3schools.com/dom/dom_mozilla_vs_ie.asp"
 *            >www.w3schools.com</a> for more information.
 * @author $Author$
 * @version $Date$ $Revision: 43
 *          $
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
     * Returns all nodes which are direct children of the implementing node and
     * which are of the specified type. Returns an empty list if the node has no
     * children.
     * 
     * @param <T>
     *            the instance type to filter for
     * @param type
     *            the node type to filter for
     * @return all nodes which are direct children of the implementing node and
     *         which are of the specified type or an empty list, if the node has
     *         no children.
     */
    <T extends Node> List<T> getChildren(NodeType type);


    /**
     * Returns <code>true</code> if the implementing node has children,
     * <code>false</code> otherwise.
     * 
     * @return <code>true</code> if the implementing node has children,
     *         <code>false</code> otherwise.
     */
    boolean hasChildren();


    /**
     * Returns <code>true</code> if the implementing node has children of the
     * specified type, <code>false</code> otherwise.
     * 
     * @return <code>true</code> if the implementing node has children of the
     *         specified type, <code>false</code> otherwise.
     */
    boolean hasChildren(NodeType type);


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
