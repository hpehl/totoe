package name.pehl.totoe.tester.client;

import name.pehl.totoe.json.client.JsonParser;
import name.pehl.totoe.json.client.JsonPath;

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
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-10-27 00:56:25 +0200 (Mi, 27. Okt 2010) $ $Revision: 629
 *          $
 */
public class JsonParserPanel extends ResizeComposite
{
    // @formatter:off
    interface Binder extends UiBinder<DockLayoutPanel, JsonParserPanel> {}
    private static final Binder binder = GWT.create(Binder.class);

    @UiField TextArea jsonIn;
    @UiField TextBox jsonpath;
    @UiField TextBox context;
    @UiField Button select;
    @UiField TextArea jsonOut;
    // @formatter:on

    public JsonParserPanel()
    {
        initWidget(binder.createAndBindUi(this));

        // Load sample json
        String json = Resources.INSTANCE.swissArmyKnifeJson().getText();
        jsonIn.setText(json);

        // Set some default values
        jsonpath.setText(Resources.EXAMPLE_JSONPATH);
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
            JSONObject jsonObject = new JsonParser().parse(jsonValue);
            if (contextValue != null && contextValue.trim().length() != 0)
            {
                JSONValue jv = JsonPath.select(jsonObject, contextValue);
                contextObject = jv.isObject();
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
                JSONValue resultValue = JsonPath.select(contextObject, jsonpathValue);
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
