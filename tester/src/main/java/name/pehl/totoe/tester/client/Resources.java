package name.pehl.totoe.tester.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;

/**
 * @author $LastChangedBy: harald.pehl $
 * @version $LastChangedRevision: 178 $
 */

public interface Resources extends ClientBundle
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

    // --------------------------------------------------------------- examples

    String EXAMPLE_JSONPATH = "$.functions[?(@.name.match(/flux/))][0].value";
    String EXAMPLE_XPATH = "//dns:functions/bttf:fluxCapacitor/bttf:power/@unit";
    String EXAMPLE_NAMESPACES = "xmlns:dns=\"http://code.google.com/p/totoe\" "
            + "xmlns:foo=\"http://code.google.com/p/totoe/foo\" " + "xmlns:bar=\"http://code.google.com/p/totoe/bar\" "
            + "xmlns:bttf=\"http://en.wikipedia.org/wiki/Back_to_the_Future\"";

    // ------------------------------------------------------- deferred binding

    Resources INSTANCE = GWT.create(Resources.class);


    @Source("swissArmyKnife.json")
    TextResource swissArmyKnifeJson();


    @Source("swissArmyKnife.xml")
    TextResource swissArmyKnifeXml();


    @Source("widgets.css")
    CssResource widgets();


    @Source("style.css")
    Style style();

    interface Style extends CssResource
    {
        String panel();


        String rightPanel();


        String top0();
    }
}
