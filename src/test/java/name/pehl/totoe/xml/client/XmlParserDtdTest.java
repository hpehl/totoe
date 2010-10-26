package name.pehl.totoe.xml.client;

import static name.pehl.totoe.xml.client.XmlParserResources.*;

import java.util.List;

import name.pehl.totoe.xml.client.Document;
import name.pehl.totoe.xml.client.DocumentType;
import name.pehl.totoe.xml.client.Element;
import name.pehl.totoe.xml.client.Node;
import name.pehl.totoe.xml.client.NodeType;
import name.pehl.totoe.xml.client.XmlParser;

/**
 * @author $Author$
 * @version $Date$ $Revision: 629
 *          $
 */
public class XmlParserDtdTest extends AbstractXmlParserTest
{
    public void testParse()
    {
        Document document = parse();
        assertDocument(document);
        assertDocumentType(document, document.getDocumentType());
        assertRootElement(document, document.getRoot());
        assertIdAttribute(document, document.getRoot(), document.getRoot().getAttribute(ID_ATTRIBUTE));
    }


    protected void assertDocumentType(Document document, DocumentType documentType)
    {
        // Basic stuff
        assertNotNull(documentType);
        assertEquals(SWISS_ARMY_KNIFE_ELEMENT, documentType.getName());
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


    public void testSelectNodes()
    {
        Document document = parse();
        List<Node> functions = document.selectNodes("//functions");
        assertFunctionsNodes(functions);

        Element root = document.getRoot();
        functions = root.selectNodes("functions");
        assertFunctionsNodes(functions);
    }


    public void testSelectNode()
    {
        Document document = parse();
        Node functions = document.selectNode("//functions");
        assertFunctionsNode(functions);

        Element root = document.getRoot();
        functions = root.selectNode("functions");
        assertFunctionsNode(functions);
    }


    public void testSelectDescriptionText()
    {
        Document document = parse();
        Node description = document.selectNode("//description/text()");
        assertDescriptionText(description);
    }


    public void testSelectValues()
    {
        Document document = parse();
        String[] units = document.selectValues("//@unit");
        assertNotNull(units);
        assertEquals(UNITS_SIZE, units.length);
        for (int i = 0; i < UNITS_SIZE; i++)
        {
            assertEquals(UNITS[i], units[i]);
        }
    }


    public void testSelectValue()
    {
        Document document = parse();
        String units = document.selectValue("//power/@unit");
        assertUnitValue(units);
    }


    private Document parse()
    {
        String xml = XmlParserResources.INSTANCE.swissArmyKnifeDtd().getText();
        return new XmlParser().parse(xml);
    }
}
