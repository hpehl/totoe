package name.pehl.totoe.json.client.internal;

import name.pehl.totoe.json.client.JsonParser;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

/**
 * {@link JsonParser} implementation using the native JSON parser. More
 * precisely this implementation relies on <a
 * href="http://www.json.org/js.html">http://www.json.org/js.html</a> which uses
 * the native JSON parser if available and a javascript emulation if no native
 * JSON parser was found.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 531
 *          $
 */
public class JsonParserImpl
{
    public JSONObject parse(String text) throws JSONException
    {
        try
        {
            return parseImpl(text);
        }
        catch (JavaScriptException e)
        {
            throw new JSONException(e);
        }
    }


    private native JSONObject parseImpl(String text)
    /*-{
        try
        {
            var v = $wnd.JSON.parse(text);
            var jsonObject = @com.google.gwt.json.client.JSONObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
            return jsonObject;
        }
        catch (e)
        {
            throw new Error(e);
        }
    }-*/;


    public JSONValue select(JSONObject json, String path) throws JSONException
    {
        if (json == null)
        {
            throw new JSONException("Json must not be null");
        }
        if (path == null)
        {
            throw new JSONException("Path must not be null");
        }
        try
        {
            JSONValue value = selectImpl(json.getJavaScriptObject(), path);
            return value;
        }
        catch (JavaScriptException e)
        {
            throw new JSONException(e);
        }
    }


    private native JSONValue selectImpl(JavaScriptObject json, String path)
    /*-{
        try
        {
            var data = $wnd.jsonPath(json, path, {evalType:"RESULT", safeEval:true});
            if (!data)
            {
                return @com.google.gwt.json.client.JSONNull::getInstance();
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
            else if (typeof(data) == "undefined")
            {
                throw new Error("Undefined data selected");
            }
            else
            {
                // It's an object
                return @com.google.gwt.json.client.JSONObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
            } 
        }
        catch (e)
        {
            throw new Error(e);
        }
    }-*/;
}
