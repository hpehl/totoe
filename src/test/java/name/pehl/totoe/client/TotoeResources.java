package name.pehl.totoe.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author $LastChangedBy$
 * @version $LastChangedRevision$
 */

public interface TotoeResources extends ClientBundle
{
    // -------------------------------------------------------------- constants

    String ROOT_NAME = "swissArmyKnife";
    String ASIN = "B001DZTJRQ";

    // ------------------------------------------------------- deferred binding

    TotoeResources INSTANCE = GWT.create(TotoeResources.class);


    @Source("swissArmyKnife.xml")
    public TextResource swissArmyKnife();
}
