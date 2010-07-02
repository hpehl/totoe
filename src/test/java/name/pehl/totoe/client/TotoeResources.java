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

    String SWISS_ARMY_KNIFE = "swissArmyKnife";
    String ID = "id";
    String ASIN = "B001DZTJRQ";
    String DESCRIPTION = "description";
    int ROOT_ELEMENT_CHILDREN = 14;

    // ------------------------------------------------------- deferred binding

    TotoeResources INSTANCE = GWT.create(TotoeResources.class);


    @Source("swissArmyKnifeDtd.xml")
    public TextResource swissArmyKnifeDtd();


    @Source("swissArmyKnifeNs.xml")
    public TextResource swissArmyKnifeNs();
}
