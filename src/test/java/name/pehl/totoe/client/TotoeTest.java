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
    static final String NAMESPACES_STRING = "xmlns=\"http://code.google.com/p/totoe\" " +
    		"xmlns:foo=\"http://code.google.com/p/totoe/foo\" " +
    		"xmlns:bar=\"http://code.google.com/p/totoe/bar\"";
    static final Map<String, String> NAMESPACES_MAP = new HashMap<String, String>();
    static
    {
        NAMESPACES_MAP.put("default", "http://code.google.com/p/totoe");
        NAMESPACES_MAP.put("foo", "http://code.google.com/p/totoe/foo");
        NAMESPACES_MAP.put("bar", "http://code.google.com/p/totoe/foo");
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

    
    public void testParse()
    {
        Node document = parse();

        // Document node
        assertEquals(NodeType.DOCUMENT, document.getNodeType());
        assertNull(document.getNodeValue());
        List<Node> children = document.getChildNodes();
        assertEquals(1, children.size());

        // Root node
        Node root = children.get(0);
        assertEquals(ROOT_NAME, root.getNodeName());
        assertEquals(NodeType.ELEMENT, root.getNodeType());
        assertNull(root.getNodeValue());
        assertEquals(ASIN, root.getAttribute("id"));
    }


    public void testSelect()
    {

    }


    private Node parse()
    {
        String xml = TotoeResources.INSTANCE.swissArmyKnife().getText();
        XmlParser xmlParser = XmlParserFactory.getXmlParser();
        Node document = xmlParser.parse(xml, NAMESPACES_STRING);
        return document;
    }
}
