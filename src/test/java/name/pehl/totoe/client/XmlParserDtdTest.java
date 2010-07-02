package name.pehl.totoe.client;

import static name.pehl.totoe.client.TotoeResources.*;

/**
 * @author $Author$
 * @version $Date$ $Revision: 629
 *          $
 */
public class XmlParserDtdTest extends AbstractXmlParserTest
{
    public void testParse()
    {
        String xml = TotoeResources.INSTANCE.swissArmyKnifeDtd().getText();
        XmlParser xmlParser = new XmlParser();
        Document document = xmlParser.parse(xml);

        assertDocument(document);
        assertDocumentType(document, document.getDocumentType());
        assertRootElement(document, document.getRoot());
        assertIdAttribute(document, document.getRoot(), document.getRoot().getAttribute(ID));
    }
    
    
    protected void assertDocumentType(Document document, DocumentType documentType)
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
}
