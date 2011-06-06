package name.pehl.totoe.client;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * @author $LastChangedBy$
 * @version $LastChangedRevision$
 */
public abstract class AbstractTotoeTest extends GWTTestCase
{
    public static final String NULL_STRING = null;
    public static final String EMPTY_STRING = "";
    public static final String BLANK_STRING = "          ";
    public static final String INVALID_STRING = "________invalid________";


    @Override
    public String getModuleName()
    {
        return "name.pehl.totoe.TotoeTest";
    }


    @Override
    protected void gwtSetUp() throws Exception
    {
        System.out.println("Running " + getClass().getName() + "." + getName() + "()");
    }
}
