package name.pehl.totoe.client.internal;

import name.pehl.totoe.client.Document;
import name.pehl.totoe.client.XmlParseException;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision: 629
 *          $
 */
public class XmlParserImpl
{
    // ------------------------------------------------------------------- JSNI

    private static final JavaScriptObject nativeParser = XmlParserImpl.initialize();


    private static native JavaScriptObject initialize() /*-{
        return new $wnd.DOMParser();
    }-*/;


    // ---------------------------------------------------------- parse methods

    public Document parse(String xml, String namespaces)
    {
        try
        {
            JavaScriptObject documentJso = parseImpl(xml, namespaces);
            return NodeFactory.create(documentJso);
        }
        catch (JavaScriptException e)
        {
            throw new XmlParseException(e.getMessage(), e);
        }
    }


    private native JavaScriptObject parseImpl(String xml, String namespaces) /*-{
        if (xml == null || xml == "")
        {
            return null;
        }

        var domDoc = @name.pehl.totoe.client.internal.XmlParserImpl::nativeParser.parseFromString(xml, "text/xml");
        var error = $wnd.Sarissa.getParseErrorText(domDoc);
        if (error != $wnd.Sarissa.PARSED_OK) 
        {
            if (error == $wnd.Sarissa.PARSED_EMPTY) 
            {
                throw (new Error("XML file is empty."));
            }
            else if (error == $wnd.Sarissa.PARSED_UNKNOWN_ERROR) 
            {
                throw (new Error("Unkown error parsing xml file."));
            }
            else 
            {
                throw (new Error(error));
            }
            return null;
        }

        if (namespaces != null)
        {
            $wnd.Sarissa.setXpathNamespaces(domDoc, namespaces);
        }
        return domDoc;
    }-*/;
}
