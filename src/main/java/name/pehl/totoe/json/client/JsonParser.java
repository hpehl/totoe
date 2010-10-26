package name.pehl.totoe.json.client;

import name.pehl.totoe.json.client.internal.JsonParserImpl;

import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

/**
 * JsonParser using the browsers native JSON parser. More precisely this parser
 * relies on <a
 * href="http://www.json.org/js.html">http://www.json.org/js.html</a> which uses
 * the native JSON parser if available and a javascript emulation if no native
 * JSON parser was found.
 * <p>
 * Furthermore this parser supports <a
 * href="http://www.sitepen.com/blog/2008/03/17/jsonpath-support/" >JSONPath</a>
 * expressions.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 531
 *          $
 */
public class JsonParser
{
    /**
     * JSONPath special characters.
     */
    public static final String JSON_PATH_SYMBOLS = "$@.[]*,:?()";
    private JsonParserImpl impl = new JsonParserImpl();


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
        return impl.parse(text);
    }


    /**
     * Selects JSON data using this <a
     * href="http://www.sitepen.com/blog/2008/03/17/jsonpath-support/"
     * >JSONPath</a> library.
     * 
     * @param json
     *            The input json object.
     * @param path
     *            An JSONPath expression to select some data.
     * @return The data selected by the path or {@link JSONNull} if no data was
     *         found.
     * @throws JSONException
     *             If the input parameters were <code>null</code> or the path
     *             expression could not be evaluated.
     */
    public JSONValue select(JSONObject json, String path) throws JSONException
    {
        return impl.select(json, path);
    }
}
