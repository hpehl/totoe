package name.pehl.totoe;

import junit.framework.Test;
import junit.framework.TestSuite;
import name.pehl.totoe.client.json.JsonPathTest;
import name.pehl.totoe.client.xml.XmlParserDtdTest;
import name.pehl.totoe.client.xml.XmlParserNsTest;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * @author $Author$
 * @version $Date$ $Revision: 597
 *          $
 */
public class TotoeGwtTestSuite extends GWTTestSuite
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite("GWT tests for Totoe");

        suite.addTestSuite(JsonPathTest.class);
        suite.addTestSuite(XmlParserDtdTest.class);
        suite.addTestSuite(XmlParserNsTest.class);

        return suite;
    }
}
