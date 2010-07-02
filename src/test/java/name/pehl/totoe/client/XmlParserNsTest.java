package name.pehl.totoe.client;

import static name.pehl.totoe.client.TotoeResources.ID;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-07-02 15:52:54 +0200 (Fr, 02. Jul 2010) $ $Revision: 629
 *          $
 */
public class XmlParserNsTest extends AbstractXmlParserTest
{
    static final String NAMESPACES_STRING = "xmlns:default=\"http://code.google.com/p/totoe\" "
            + "xmlns:foo=\"http://code.google.com/p/totoe/foo\" " + "xmlns:bar=\"http://code.google.com/p/totoe/bar\" "
            + "xmlns:bttf=\"http://en.wikipedia.org/wiki/Back_to_the_Future\"";
    static final Map<String, String> NAMESPACES_MAP = new HashMap<String, String>();
    static
    {
        NAMESPACES_MAP.put("default", "http://code.google.com/p/totoe");
        NAMESPACES_MAP.put("foo", "http://code.google.com/p/totoe/foo");
        NAMESPACES_MAP.put("bar", "http://code.google.com/p/totoe/bar");
        NAMESPACES_MAP.put("bttf", "http://en.wikipedia.org/wiki/Back_to_the_Future");
    }


    public void testParseWithNamespacesAsMap()
    {
        String xml = TotoeResources.INSTANCE.swissArmyKnifeNs().getText();
        XmlParser xmlParser = new XmlParser();
        Document document = xmlParser.parse(xml, NAMESPACES_MAP);

        assertDocument(document);
        assertRootElement(document, document.getRoot());
        assertIdAttribute(document, document.getRoot(), document.getRoot().getAttribute(ID));
    }


    public void testParseWithNamespacesAsString()
    {
        String xml = TotoeResources.INSTANCE.swissArmyKnifeNs().getText();
        XmlParser xmlParser = new XmlParser();
        Document document = xmlParser.parse(xml, NAMESPACES_STRING);

        assertDocument(document);
        assertRootElement(document, document.getRoot());
        assertIdAttribute(document, document.getRoot(), document.getRoot().getAttribute(ID));
    }
}
