package name.pehl.totoe.client;

import static name.pehl.totoe.client.TotoeResources.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-07-02 15:52:54 +0200 (Fr, 02. Jul 2010) $ $Revision: 629
 *          $
 */
public class XmlParserNsTest extends AbstractXmlParserTest
{
    static final String NAMESPACES_STRING = "xmlns:dns=\"http://code.google.com/p/totoe\" "
            + "xmlns:foo=\"http://code.google.com/p/totoe/foo\" " + "xmlns:bar=\"http://code.google.com/p/totoe/bar\" "
            + "xmlns:bttf=\"http://en.wikipedia.org/wiki/Back_to_the_Future\"";
    static final Map<String, String> NAMESPACES_MAP = new HashMap<String, String>();
    static
    {
        NAMESPACES_MAP.put("dns", "http://code.google.com/p/totoe");
        NAMESPACES_MAP.put("foo", "http://code.google.com/p/totoe/foo");
        NAMESPACES_MAP.put("bar", "http://code.google.com/p/totoe/bar");
        NAMESPACES_MAP.put("bttf", "http://en.wikipedia.org/wiki/Back_to_the_Future");
    }


    public void testParseWithNamespacesAsMap()
    {
        String xml = TotoeResources.INSTANCE.swissArmyKnifeNs().getText();
        Document document = new XmlParser().parse(xml, NAMESPACES_MAP);
        assertDocument(document);
        assertRootElement(document, document.getRoot());
        assertIdAttribute(document, document.getRoot(), document.getRoot().getAttribute(ID_ATTRIBUTE));
    }


    public void testParseWithNamespacesAsString()
    {
        Document document = parse();
        assertDocument(document);
        assertRootElement(document, document.getRoot());
        assertIdAttribute(document, document.getRoot(), document.getRoot().getAttribute(ID_ATTRIBUTE));
    }


    public void testSelectNodes()
    {
        Document document = parse();
        List<Node> functions = document.selectNodes("/dns:swissArmyKnife/default:functions");
        assertFunctionsNodes(functions);

        Element root = document.getRoot();
        functions = root.selectNodes("dns:functions");
        assertFunctionsNodes(functions);
    }


    public void testSelectNode()
    {
        Document document = parse();
        Node functions = document.selectNode("//dns:functions");
        assertFunctionsNode(functions);

        Element root = document.getRoot();
        functions = root.selectNode("dns:functions");
        assertFunctionsNode(functions);
    }


    public void testSelectDescriptionText()
    {
        Document document = parse();
        Node description = document.selectNode("//dns:description/text()");
        assertDescriptionText(description);
    }


    public void testSelectValues()
    {
        // There's only one unit attribute without a namespace!
        Document document = parse();
        String[] units = document.selectValues("//@unit");
        assertNotNull(units);
        assertEquals(1, units.length);
        assertUnitValue(units[0]);
    }


    public void testSelectValue()
    {
        Document document = parse();
        String units = document.selectValue("//bttf:power/@unit");
        assertUnitValue(units);
    }


    public void testNamespaceAttributes()
    {
        Document document = parse();
        Node weight = document.selectNode("//bar:weight");
        assertNotNull(weight);
        assertEquals("weight", weight.getLocalName());
        assertEquals("bar", weight.getNamespacePrefix());
        assertEquals("http://code.google.com/p/totoe/bar", weight.getNamespaceUri());

        Attribute unit = ((Element) weight).getAttribute("bar:unit");
        assertEquals("unit", unit.getLocalName());
        assertEquals("bar", unit.getNamespacePrefix());
        assertEquals("http://code.google.com/p/totoe/bar", unit.getNamespaceUri());
    }


    private Document parse()
    {
        String xml = TotoeResources.INSTANCE.swissArmyKnifeNs().getText();
        return new XmlParser().parse(xml, NAMESPACES_STRING);
    }
}
