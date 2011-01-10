package name.pehl.totoe.xml;

import junit.framework.Test;
import junit.framework.TestSuite;
import name.pehl.totoe.xml.client.XmlParserDtdTest;
import name.pehl.totoe.xml.client.XmlParserNsTest;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * @author $Author$
 * @version $Date$ $Revision: 597
 *          $
 */
public class XmlParserGwtTestSuite extends GWTTestSuite
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite("GWT tests for XmlParser");

        suite.addTestSuite(XmlParserDtdTest.class);
        suite.addTestSuite(XmlParserNsTest.class);

        return suite;
    }
}
