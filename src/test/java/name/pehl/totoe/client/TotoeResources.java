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

    int UNITS_SIZE = 3;
    String[] UNITS = new String[] {"cm", "g", "gigawatts"};

    String SWISS_ARMY_KNIFE_ELEMENT = "swissArmyKnife";
    String ID_ATTRIBUTE = "id";
    String ASIN = "B001DZTJRQ";
    String DESCRIPTION_ELEMENT = "description";
    String CALL_IT_WHAT_YOU_WILL = "Call it what you will, it's a knife that's unrivaled";
    String NUMBER_ATTRIBUTE = "number";
    String MORE_THAN_YOU_WILL_EVER_NEED = "more than you'll ever need";
    String GIGAWATTS = "gigawatts";

    // ------------------------------------------------------- deferred binding

    TotoeResources INSTANCE = GWT.create(TotoeResources.class);


    @Source("swissArmyKnifeDtd.xml")
    public TextResource swissArmyKnifeDtd();


    @Source("swissArmyKnifeNs.xml")
    public TextResource swissArmyKnifeNs();
}
