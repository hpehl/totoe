package name.pehl.totoe;

import junit.framework.Test;
import junit.framework.TestSuite;
import name.pehl.totoe.client.XmlParserDnsTest;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * @author $Author$
 * @version $Date$ $Revision: 597
 *          $
 */
public class TotoeGwtTestSuiteDns extends GWTTestSuite
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite("GWT tests for totoe with default namespace");

        suite.addTestSuite(XmlParserDnsTest.class);

        return suite;
    }
}
