package name.pehl.totoe.json.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author $Author$
 * @version $Date$ $Revision: 629
 *          $
 */
public class JsonParserApp implements EntryPoint
{
    static final String EXAMPLE_JSONPATH = "$.functions[?(@.name.match(/flux/))][0].value";

    interface Binder extends UiBinder<DockLayoutPanel, JsonParserApp>
    {
    }

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    TextArea jsonIn;

    @UiField
    TextBox jsonpath;

    @UiField
    TextBox context;

    @UiField
    Button select;

    @UiField
    TextArea jsonOut;


    @Override
    public void onModuleLoad()
    {
        // Create the UI defined in XmlParserApp.ui.xml.
        DockLayoutPanel outer = binder.createAndBindUi(this);

        // Load sample json
        String json = JsonParserResources.INSTANCE.swissArmyKnife().getText();
        jsonIn.setText(json);

        // Set some default values
        jsonpath.setText(EXAMPLE_JSONPATH);

        // Add the outer panel to the RootLayoutPanel, so that it will be
        // displayed.
        RootLayoutPanel root = RootLayoutPanel.get();
        root.add(outer);
    }


    @UiHandler("select")
    void onSelect(ClickEvent event)
    {
        String result = null;
        JSONObject contextObject = null;

        String jsonValue = jsonIn.getText();
        String jsonpathValue = jsonpath.getText();
        String contextValue = context.getText();
        if (jsonValue == null || jsonValue.trim().length() == 0)
        {
            result = "No json input given";
        }
        else if (jsonpathValue == null || jsonpathValue.trim().length() == 0)
        {
            result = "No jsonpath given";
        }

        try
        {
            JsonParser jsonParser = new JsonParser();
            JSONObject jsonObject = jsonParser.parse(jsonValue);
            if (contextValue != null && contextValue.trim().length() != 0)
            {
                JSONValue cv = jsonParser.select(jsonObject, contextValue);
                contextObject = cv.isObject();
            }
            else
            {
                contextObject = jsonObject;
            }
            if (contextObject == null)
            {
                result = "Context is no json object";
            }
            else
            {
                JSONValue resultValue = jsonParser.select(contextObject, jsonpathValue);
                result = resultValue.toString();
            }
        }
        catch (JSONException e)
        {
            result = "Exception:\n" + e.getMessage();
        }
        jsonOut.setText(result);
    }
}
