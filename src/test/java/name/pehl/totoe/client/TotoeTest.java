package name.pehl.totoe.client;

import static name.pehl.totoe.client.TotoeResources.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * @author $Author$
 * @version $Date$ $Revision: 629
 *          $
 */
public class TotoeTest extends GWTTestCase
{
    static final String NAMESPACES_STRING = "xmlns:default=\"http://code.google.com/p/totoe\" "
            + "xmlns:foo=\"http://code.google.com/p/totoe/foo\" " 
            + "xmlns:bar=\"http://code.google.com/p/totoe/bar\"";
    static final Map<String, String> NAMESPACES_MAP = new HashMap<String, String>();
    static
    {
        NAMESPACES_MAP.put("default", "http://code.google.com/p/totoe");
        NAMESPACES_MAP.put("foo", "http://code.google.com/p/totoe/foo");
        NAMESPACES_MAP.put("bar", "http://code.google.com/p/totoe/bar");
    }


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


    public void testParseWithNamespacesAsMap()
    {
        String xml = TotoeResources.INSTANCE.swissArmyKnife().getText();
        XmlParser xmlParser = new XmlParser();
        Document document = xmlParser.parse(xml, NAMESPACES_MAP);

        assertDocument(document);
        assertDocumentType(document, document.getDocumentType());
        assertRootElement(document, document.getRoot());
        assertIdAttribute(document, document.getRoot(), document.getRoot().getAttribute(ID));
    }


    public void testParseWithNamespacesAsString()
    {
        String xml = TotoeResources.INSTANCE.swissArmyKnife().getText();
        XmlParser xmlParser = new XmlParser();
        Document document = xmlParser.parse(xml, NAMESPACES_STRING);

        assertDocument(document);
        assertDocumentType(document, document.getDocumentType());
        assertRootElement(document, document.getRoot());
        assertIdAttribute(document, document.getRoot(), document.getRoot().getAttribute(ID));
    }


    private void assertDocument(Document document)
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


    private void assertDocumentType(Document document, DocumentType documentType)
    {
        // Basic stuff
        assertNotNull(documentType);
        assertEquals(SWISS_ARMY_KNIFE, documentType.getName());
        assertEquals(NodeType.DOCUMENT_TYPE, documentType.getType());
        assertEquals(document, documentType.getDocument());

        // parent / siblings
        assertNull(documentType.getParent());
        assertNull(documentType.getPreviousSibling());
        assertNull(documentType.getNextSibling());

        // document type specific
        assertNull(documentType.getPublicId());
        assertNull(documentType.getSystemId());
        assertTrue(documentType.getEntities().isEmpty());
        assertTrue(documentType.getNotations().isEmpty());
    }


    private void assertRootElement(Document document, Element rootElement)
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
        assertEquals(4, rootElement.getAttributes().size()); // incl. namespaces
        assertEquals(4, rootElement.getAttributeValues().size());
        assertNotNull(rootElement.getAttribute(ID));
        assertEquals(ASIN, rootElement.getAttributeValue(ID));
    }


    private void assertIdAttribute(Document document, Element element, Attribute idAttribute)
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
