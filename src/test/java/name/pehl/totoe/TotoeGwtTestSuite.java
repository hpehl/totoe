package name.pehl.totoe;

import junit.framework.Test;
import junit.framework.TestSuite;
import name.pehl.totoe.client.TotoeTest;

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

        suite.addTestSuite(TotoeTest.class);

        return suite;
    }
}
