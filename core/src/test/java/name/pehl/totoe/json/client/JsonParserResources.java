package name.pehl.totoe.json.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author $LastChangedBy$
 * @version $LastChangedRevision$
 */

public interface JsonParserResources extends ClientBundle
{
    // -------------------------------------------------------------- constants

    int UNITS_SIZE = 3;
    String[] UNITS = new String[] {"cm", "g", "gigawatts"};

    String ID_ATTRIBUTE = "id";
    String ASIN = "B001DZTJRQ";
    String DESCRIPTION_ELEMENT = "description";
    String CALL_IT_WHAT_YOU_WILL = "Call it what you will, it's a knife that's unrivaled";
    String NUMBER_ATTRIBUTE = "number";
    String MORE_THAN_YOU_WILL_EVER_NEED = "more than you'll ever need";
    String GIGAWATTS = "gigawatts";

    // ------------------------------------------------------- deferred binding

    JsonParserResources INSTANCE = GWT.create(JsonParserResources.class);


    @Source("swissArmyKnife.json")
    public TextResource swissArmyKnife();
}
