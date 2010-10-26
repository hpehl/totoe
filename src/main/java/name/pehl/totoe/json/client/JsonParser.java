package name.pehl.totoe.json.client;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.json.client.JSONException;

/**
 * JsonParser using the browsers native JSON parser. More precisely this parser
 * relies on <a
 * href="http://www.json.org/js.html">http://www.json.org/js.html</a> which uses
 * the native JSON parser if available and a javascript emulation if no native
 * JSON parser was found.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 531
 *          $
 */
public class JsonParser
{
    /**
     * Parse the specified string and return the relevant JSON object.
     * 
     * @param text
     * @return
     * @throws JSONException
     *             if the specified string represents no valid JSON data
     */
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
            var jsonObject = @name.pehl.totoe.json.client.JSONObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
            return jsonObject;
        }
        catch (e)
        {
            throw new Error(e);
        }
    }-*/;
}
