package name.pehl.totoe;

import junit.framework.Test;
import junit.framework.TestSuite;
import name.pehl.totoe.client.XmlParserDtdTest;

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
        TestSuite suite = new TestSuite("GWT tests for totoe");

        suite.addTestSuite(XmlParserDtdTest.class);
        // There are some strange errors regarding the default namespace.
        // suite.addTestSuite(XmlParserNsTest.class);

        return suite;
    }
}
