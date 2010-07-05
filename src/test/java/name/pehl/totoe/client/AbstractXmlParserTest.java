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
        List<Element> elementsByName = document.getElementsByName(DESCRIPTION_ELEMENT);
        assertEquals(1, elementsByName.size());
        assertEquals(DESCRIPTION_ELEMENT, elementsByName.get(0).getName());
        List<Node> nodesByType = document.getNodesByType(NodeType.COMMENT);
        assertEquals(2, nodesByType.size());
    }


    protected void assertRootElement(Document document, Element rootElement)
    {
        // Basic stuff
        assertNotNull(rootElement);
        assertEquals(SWISS_ARMY_KNIFE_ELEMENT, rootElement.getName());
        assertEquals(NodeType.ELEMENT, rootElement.getType());
        assertNotNull(rootElement.getText());
        assertEquals(document, rootElement.getDocument());

        // parent / child / siblings
        assertEquals(document, rootElement.getParent());
        assertTrue(rootElement.hasChildren());
        assertNotNull(rootElement.getFirstChild());
        assertNotNull(rootElement.getLastChild());
        assertNull(rootElement.getPreviousSibling());
        assertNull(rootElement.getNextSibling());
        // IE counts 6, FF 14 children :-(
        assertTrue(rootElement.hasChildren());
        assertTrue(rootElement.getChildren().size() > 5);

        // attributes
        assertTrue(rootElement.hasAttributes());
        assertTrue(rootElement.hasAttribute(ID_ATTRIBUTE));
        assertNotNull(rootElement.getAttribute(ID_ATTRIBUTE));
        assertEquals(ASIN, rootElement.getAttributeValue(ID_ATTRIBUTE));
    }


    protected void assertIdAttribute(Document document, Element element, Attribute idAttribute)
    {
        // Basic stuff
        assertNotNull(idAttribute);
        assertEquals(ID_ATTRIBUTE, idAttribute.getName());
        assertEquals(NodeType.ATTRIBUTE, idAttribute.getType());
        assertEquals(ASIN, idAttribute.getText());
        assertEquals(document, idAttribute.getDocument());

        // parent / siblings
        assertNull(idAttribute.getParent());
        assertNull(idAttribute.getPreviousSibling());
        assertNull(idAttribute.getNextSibling());
    }


    protected void assertFunctionsNodes(List<Node> functions)
    {
        assertNotNull(functions);
        assertEquals(1, functions.size());
        assertFunctionsNode(functions.get(0));
    }


    protected void assertFunctionsNode(Node functions)
    {
        assertNotNull(functions);
        assertTrue(functions instanceof Element);
        Element functionsElement = (Element) functions;
        assertEquals(NodeType.ELEMENT, functionsElement.getType());
        assertTrue(functionsElement.hasChildren());
        assertTrue(functionsElement.hasAttributes());
        assertTrue(functionsElement.hasAttribute(NUMBER_ATTRIBUTE));
        assertEquals(MORE_THAN_YOU_WILL_EVER_NEED, functionsElement.getAttributeValue(NUMBER_ATTRIBUTE));
    }


    protected void assertDescriptionText(Node description)
    {
        assertNotNull(description);
        assertTrue(description instanceof CDATA);
        CDATA descriptionCDATA = (CDATA) description;
        assertEquals(NodeType.CDATA, descriptionCDATA.getType());
        assertTrue(descriptionCDATA.getText().contains(CALL_IT_WHAT_YOU_WILL));
    }


    protected void assertUnitValue(String unit)
    {
        assertNotNull(unit);
        assertEquals(GIGAWATTS, unit);
    }
}
