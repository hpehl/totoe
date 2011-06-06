package name.pehl.totoe.client.json;

import name.pehl.totoe.client.AbstractTotoeTest;
import name.pehl.totoe.json.client.JsonPath;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class JsonPathTest extends AbstractTotoeTest
{
    public void testNull()
    {
        JSONValue value = null;
        value = JsonPath.select(null, null);
        assertJsonNull(value);
        value = JsonPath.select(new JSONObject(), null);
        assertJsonNull(value);
    }


    public void testEmpty()
    {
        JSONValue value = null;
        value = JsonPath.select(null, EMPTY_STRING);
        assertJsonNull(value);
        value = JsonPath.select(new JSONObject(), EMPTY_STRING);
        assertJsonNull(value);
    }


    public void testBlank()
    {
        JSONValue value = null;
        value = JsonPath.select(null, BLANK_STRING);
        assertJsonNull(value);
        value = JsonPath.select(new JSONObject(), BLANK_STRING);
        assertJsonObject(value);
    }


    public void testInvalid()
    {
        JSONValue value = null;
        value = JsonPath.select(null, INVALID_STRING);
        assertJsonNull(value);
        value = JsonPath.select(new JSONObject(), INVALID_STRING);
        assertJsonObject(value);
    }


    private void assertJsonNull(JSONValue value)
    {
        assertNotNull(value);
        assertNotNull(value.isNull());
    }


    private void assertJsonObject(JSONValue value)
    {
        assertNotNull(value);
        assertNotNull(value.isObject());
    }
}
