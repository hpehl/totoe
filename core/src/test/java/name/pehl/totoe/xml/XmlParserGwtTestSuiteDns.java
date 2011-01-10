package name.pehl.totoe.xml;

import junit.framework.Test;
import junit.framework.TestSuite;
import name.pehl.totoe.xml.client.XmlParserDnsTest;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * @author $Author$
 * @version $Date$ $Revision: 597
 *          $
 */
public class XmlParserGwtTestSuiteDns extends GWTTestSuite
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite("GWT tests for XmlParser with default namespace");

        suite.addTestSuite(XmlParserDnsTest.class);

        return suite;
    }
}
