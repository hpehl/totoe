package name.pehl.totoe.json.client;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONValue;

/**
 * Extended {@link com.google.gwt.json.client.JSONObject} with support for <a
 * href="http://www.sitepen.com/blog/2008/03/17/jsonpath-support/" >JSONPath</a>
 * expressions.
 * 
 * @see http://code.google.com/p/jsonpath/wiki/ExprSyntax
 * @see http://code.google.com/p/jsonpath/wiki/Javascript
 * @author $Author$
 * @version $Date$ $Revision: 181
 *          $
 */
public class JSONObject extends com.google.gwt.json.client.JSONObject
{
    /**
     * JSONPath special characters.
     */
    public static final char[] JSON_PATH_SYMBOLS = new char[] {'$', '@', '.', '[', ']', '*', '#', ',', ':', '?', '(',
            ')',};


    public JSONObject()
    {
    }


    public JSONObject(JavaScriptObject jsValue)
    {
        super(jsValue);
    }


    /**
     * {@inheritDoc}
     * <p>
     * If the key contains {@link #JSON_PATH_SYMBOLS} this method delegates to
     * {@link #select(String)}, otherwise
     * {@link com.google.gwt.json.client.JSONObject#get(String)
     * super.get(String)} is used.
     * 
     * @param key
     * @return
     * @see com.google.gwt.json.client.JSONObject#get(java.lang.String)
     */
    @Override
    public JSONValue get(String key)
    {
        if (containsAny(key, JSON_PATH_SYMBOLS))
        {
            return select(key);
        }
        return super.get(key);
    }


    /**
     * Selects JSON data using this <a
     * href="http://www.sitepen.com/blog/2008/03/17/jsonpath-support/"
     * >JSONPath</a> library.
     * 
     * @param path
     *            An JSONPath expression to select some data.
     * @return The data selected by the path or {@link JSONNull} if no data was
     *         found or the path was null.
     * @throws JSONException
     *             If the path expression could not be evaluated.
     * @see http://code.google.com/p/jsonpath/wiki/ExprSyntax
     * @see http://code.google.com/p/jsonpath/wiki/Javascript
     */
    public JSONValue select(String path) throws JSONException
    {
        if (path == null)
        {
            return JSONNull.getInstance();
        }
        try
        {
            JSONValue value = selectImpl(getJavaScriptObject(), path);
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
            else if (typeof(data) == "object")
            {
                return @name.pehl.totoe.json.client.JSONObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
            } 
            else
            {
                throw new Error("Undefined data selected");
            }
        }
        catch (e)
        {
            throw new Error(e);
        }
    }-*/;


    /**
     * Copy of Commons-Lang / StringUtils.containsAny(String, char[])
     * 
     * @param str
     * @param searchChars
     * @return
     */
    private boolean containsAny(String str, char[] searchChars)
    {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0)
        {
            return false;
        }
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            for (int j = 0; j < searchChars.length; j++)
            {
                if (searchChars[j] == ch)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
