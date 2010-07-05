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


    // ------------------------------------------------------------- namespaces

    // The following properties are not supported in IE so they are not part
    // of the official node interface. If you need them feel free to uncomment
    // them.
    /**
     * Returns the local part of the qualified name of this node. If no
     * namespace is bound to this node this returns the same as
     * {@link #getName()}.
     * 
     * @return Returns the local part of the qualified name of this node.
     */
    String getLocalName();


    /**
     * The namespace prefix of this node, or <code>null</code> if it is
     * unspecified.
     * 
     * @return the namespace prefix of this node, or <code>null</code> if it is
     *         unspecified.
     */
    String getNamespacePrefix();


    /**
     * The namespace URI of this node, or <code>null</code> if it is
     * unspecified.
     * 
     * @return the namespace URI of this node, or <code>null</code> if it is
     *         unspecified.
     */
    String getNamespaceUri();


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
     * @userAgent There are differences between browsers regarding white-spaces
     *            and new lines. See <a
     *            href="http://www.w3schools.com/dom/dom_mozilla_vs_ie.asp"
     *            >http://www.w3schools.com/dom/dom_mozilla_vs_ie.asp</a> for
     *            more information.
     * @return the previous sibling of this node or <code>null</code> if this
     *         node has no previous sibling.
     */
    Node getPreviousSibling();


    /**
     * Returns the next sibling of this node.
     * 
     * @userAgent There are differences between browsers regarding white-spaces
     *            and new lines. See <a
     *            href="http://www.w3schools.com/dom/dom_mozilla_vs_ie.asp"
     *            >http://www.w3schools.com/dom/dom_mozilla_vs_ie.asp</a> for
     *            more information.
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
     * @return the list of nodes matching the xpath or an empty list if no
     *         matching nodes were found.
     * @throws XPathException
     *             if the XPath expression could not be evaluated (e.g. no
     *             namespace URI was found for a given prefix).
     */
    List<Node> selectNodes(String xpath) throws XPathException;


    /**
     * Returns the node for the specifed xpath or <code>null</code> if no
     * mathing node was found.
     * 
     * @param xpath
     * @return the node matching the xpath or <code>null</code> if no matching
     *         node was found.
     * @throws XPathException
     *             if the XPath expression could not be evaluated (e.g. no
     *             namespace URI was found for a given prefix).
     */
    Node selectNode(String xpath) throws XPathException;


    // ------------------------------------------------------ value(s) by xpath

    /**
     * Returns the string values for the specified xpath. The nodes selected by
     * the xpath expression must implement {@link HasText}. Returns an empty
     * array if no mathing nodes were found.
     * 
     * @param xpath
     * @return the string values matched by the xpath or an empty array if no
     *         mathing nodes were found.
     * @throws XPathException
     *             if the XPath expression could not be evaluated (e.g. no
     *             namespace URI was found for a given prefix).
     */
    String[] selectValues(String xpath) throws XPathException;


    /**
     * Returns the string value for the specified xpath. The node selected by
     * the xpath expression must implement {@link HasText}.
     * 
     * @param xpath
     * @return the string value matched by the xpath or <code>null</code> if no
     *         mathing node were found.
     * @throws XPathException
     *             if the XPath expression could not be evaluated (e.g. no
     *             namespace URI was found for a given prefix).
     */
    String selectValue(String xpath) throws XPathException;


    // -------------------------------------------------------------- serialize

    /**
     * Serializes this node as a string.
     * 
     * @return the string representation of this node.
     */
    public String serialize();
}
