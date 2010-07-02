package name.pehl.totoe.client;

import static name.pehl.totoe.client.TotoeResources.*;

import java.util.List;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */
public abstract class AbstractXmlParserTest extends GWTTestCase
{
    @Override
    public String getModuleName()
    {
        return "name.pehl.totoe.TotoeTest";
    }


    @Override
    protected void gwtSetUp() throws Exception
    {
        System.out.println("Running " + getClass().getName());
    }


    protected void assertDocument(Document document)
    {
        // Basic stuff
        assertNotNull(document);
        assertEquals("#document", document.getName());
        assertEquals(NodeType.DOCUMENT, document.getType());
        assertSame(document, document.getDocument());

        // parent / child / siblings
        assertNull(document.getParent());
        assertTrue(document.hasChildren());
        assertEquals(1, document.getChildren().size());
        assertNotNull(document.getFirstChild());
        assertNotNull(document.getLastChild());
        assertNull(document.getPreviousSibling());
        assertNull(document.getNextSibling());

        // document specific
        List<Element> elementsByName = document.getElementsByName(DESCRIPTION);
        assertEquals(1, elementsByName.size());
        assertEquals(DESCRIPTION, elementsByName.get(0).getName());
        List<Node> nodesByType = document.getNodesByType(NodeType.COMMENT);
        assertEquals(2, nodesByType.size());
    }


    protected void assertRootElement(Document document, Element rootElement)
    {
        // Basic stuff
        assertNotNull(rootElement);
        assertEquals(SWISS_ARMY_KNIFE, rootElement.getName());
        assertEquals(NodeType.ELEMENT, rootElement.getType());
        assertNotNull(rootElement.getText());
        assertEquals(document, rootElement.getDocument());

        // parent / child / siblings
        assertEquals(document, rootElement.getParent());
        assertTrue(rootElement.hasChildren());
        assertEquals(ROOT_ELEMENT_CHILDREN, rootElement.getChildren().size());
        assertNotNull(rootElement.getFirstChild());
        assertNotNull(rootElement.getLastChild());
        assertNull(rootElement.getPreviousSibling());
        assertNull(rootElement.getNextSibling());

        // attributes
        assertTrue(rootElement.hasAttributes());
        assertTrue(rootElement.hasAttribute(ID));
        assertNotNull(rootElement.getAttribute(ID));
        assertEquals(ASIN, rootElement.getAttributeValue(ID));
    }


    protected void assertIdAttribute(Document document, Element element, Attribute idAttribute)
    {
        // Basic stuff
        assertNotNull(idAttribute);
        assertEquals(ID, idAttribute.getName());
        assertEquals(NodeType.ATTRIBUTE, idAttribute.getType());
        assertEquals(ASIN, idAttribute.getText());
        assertEquals(document, idAttribute.getDocument());
        assertEquals(element, idAttribute.getElement());

        // parent / siblings
        assertNull(idAttribute.getParent());
        assertNull(idAttribute.getPreviousSibling());
        assertNull(idAttribute.getNextSibling());
    }
}
