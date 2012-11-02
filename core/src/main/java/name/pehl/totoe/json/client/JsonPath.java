package name.pehl.totoe.json.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Java wrapper for <a
 * href="http://www.sitepen.com/blog/2008/03/17/jsonpath-support/" >JSONPath</a>
 * expressions.
 * 
 * @see http://code.google.com/p/jsonpath/wiki/ExprSyntax
 * @see http://code.google.com/p/jsonpath/wiki/Javascript
 * @author $LastChangedBy:$
 * @version $LastChangedRevision:$
 */

public final class JsonPath
{
    interface ResourceBundle extends ClientBundle
    {
        ResourceBundle INSTANCE = GWT.create(ResourceBundle.class);

        @Source("jsonpath.js")
        TextResource jsonPathJs();
    }

    /**
     * Private constructor to ensure that the class acts as a true utility class
     * i.e. it isn't instantiable and extensible.
     */
    private JsonPath()
    {
    }


    private static void injectScript()
    {
        if (!isScriptInjected())
        {
            ScriptInjector.fromString(ResourceBundle.INSTANCE.jsonPathJs().getText())
                    .setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }


    private static final native boolean isScriptInjected() /*-{
        if (!(typeof $wnd.jsonPath === "undefined") && !(null === $wnd.jsonPath)) {
            return true;
        }
        return false;
    }-*/;


    /**
     * Selects JSON data using this <a
     * href="http://www.sitepen.com/blog/2008/03/17/jsonpath-support/"
     * >JSONPath</a> library.
     * 
     * @param json
     *            The json object to select the data from
     * @param path
     *            An JSONPath expression to select some data.
     * @return The data selected by the path or {@link JSONNull} if no data was
     *         found or the path was null.
     * @throws JSONException
     *             If the path expression could not be evaluated.
     * @see http://code.google.com/p/jsonpath/wiki/ExprSyntax
     * @see http://code.google.com/p/jsonpath/wiki/Javascript
     */
    public static JSONValue select(JSONObject json, String path) throws JSONException
    {
        if (path == null || json == null)
        {
            return JSONNull.getInstance();
        }
        try
        {
            injectScript();
            JSONValue value = selectImpl(json.getJavaScriptObject(), path);
            return value != null ? value : JSONNull.getInstance();
        }
        catch (JavaScriptException e)
        {
            throw new JSONException(e);
        }
    }


    private static native JSONValue selectImpl(JavaScriptObject json, String path)
    /*-{
        try
        {
            var data = $wnd.jsonPath(json, path, {evalType:"RESULT", safeEval:true});
            if (typeof(data) == "undefined")
            {
                return null;
            }
            else if (data instanceof Array || data instanceof $wnd.Array) 
            {
                return @com.google.gwt.json.client.JSONArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
            }
            else if (typeof(data) == "boolean")
            {
                return @com.google.gwt.json.client.JSONBoolean::getInstance(Z)(data);
            }
            else if (typeof(data) == "number")
            {
                return @com.google.gwt.json.client.JSONNumber::new(D)(data);
            }
            else if (typeof(data) == "string")
            {
                return @com.google.gwt.json.client.JSONString::new(Ljava/lang/String;)(data);
            }
            else
            {
                if (!data)
                {
                    return null;
                }

                // Try as object
                return @com.google.gwt.json.client.JSONObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
            }
        }
        catch (e)
        {
            throw new Error(e);
        }
    }-*/;
}
