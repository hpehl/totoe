package name.pehl.totoe.client;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import name.pehl.totoe.client.internal.XmlParserImpl;

/**
 * @author $Author$
 * @version $Date$ $Revision: 623
 *          $
 */
public class XmlParser
{
    private XmlParserImpl impl = new XmlParserImpl();


    // ---------------------------------------------------------- parse methods

    /**
     * Parses the given xml to an instance of {@link Document}.
     * 
     * @param xml
     * @return
     * @throws XmlParseException
     *             if an error occured while parsing
     */
    public Document parse(String xml) throws XmlParseException
    {
        return impl.parse(xml, null);
    }


    /**
     * Parses the given xml to an instance of {@link Document} using the
     * specified namespaces. The namespaces have to be specified as a
     * whilespace-seperated list of namespace declarations as those would appear
     * in an XML document (except for the default namespace - see below).
     * <p>
     * If your xml has a default namespace and you want to reference it later on
     * in xpath expressions you have to provide a prefix for that default
     * namespace. In case you have the following xml:
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
     * &lt;lotteryTicket xmlns="http://code.google.com/p/piriti" 
     *     xmlns:foo="http://code.google.com/p/piriti/foo"
     *     xmlns:bar="http://code.google.com/p/piriti/bar"&gt;
     *     ...
     * &lt;/lotteryTicket&gt;
     * </pre>
     * 
     * Use this code to parse it:
     * 
     * <pre>
     * String xml = ...;
     * String namespaces = &quot;xmlns:default=\&quot;http://code.google.com/p/piriti\&quot;&quot;
     *     + &quot;xmlns:foo=\&quot;http://code.google.com/p/piriti/foo\&quot;&quot;
     *     + &quot;xmlns:bar=\&quot;http://code.google.com/p/piriti/bar\&quot;&quot;;
     * XmlParser xmlParser = new XmlParser();
     * Document document = xmlParser.parse(xml, namespaces);
     * </pre>
     * 
     * @param xml
     * @param namespaces
     *            a whilespace-seperated list of namespace declarations as those
     *            would appear in an XML document.
     * @return
     * @throws XmlParseException
     *             if an error occured while parsing
     */
    public Document parse(String xml, String namespaces) throws XmlParseException
    {
        return impl.parse(xml, namespaces);
    }


    /**
     * Parses the given xml to an instance of {@link Document} using the
     * specified namespaces. The namespaces have to be specified as a map with
     * the namespace prefix as key and the namespace uri as value.
     * <p>
     * If your xml has a default namespace and you want to reference it later on
     * in xpath expressions you have to provide a prefix for that default
     * namespace. In case you have the following xml:
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
     * &lt;lotteryTicket xmlns="http://code.google.com/p/piriti" 
     *     xmlns:foo="http://code.google.com/p/piriti/foo"
     *     xmlns:bar="http://code.google.com/p/piriti/bar"&gt;
     *     ...
     * &lt;/lotteryTicket&gt;
     * </pre>
     * 
     * Use this code to parse it:
     * 
     * <pre>
     * String xml = ...;
     * Map&lt;String, String&gt; namespaces = new HashMap&lt;String, String&gt;();
     * namespaces.put(&quot;default&quot;, &quot;http://code.google.com/p/piriti&quot;); // default namespace
     * namespaces.put(&quot;foo&quot;, &quot;http://code.google.com/p/piriti/foo&quot;);
     * namespaces.put(&quot;bar&quot;, &quot;http://code.google.com/p/piriti/bar&quot;);
     * XmlParser xmlParser = new XmlParser();
     * Document document = xmlParser.parse(xml, namespaces);
     * </pre>
     * 
     * @param xml
     * @param namespaces
     *            a map with the namespace prefix as key and the namespace uri
     *            as value.
     * @return
     * @throws XmlParseException
     *             if an error occured while parsing
     */
    public Document parse(String xml, Map<String, String> namespaces) throws XmlParseException
    {
        return impl.parse(xml, getNamespaces(namespaces));
    }
    
    
    // --------------------------------------------------------- helper methods

    /**
     * Converts the specifed namespaces in the map to a whilespace-seperated
     * list of namespace declarations as those would appear in an XML document.
     * 
     * @param namespaces
     *            Namespaces with the namespace prefix as key and the namespace
     *            uri as value.
     * @return a whilespace-seperated list of namespace declarations as those
     *         would appear in an XML document or <code>null</code> if the
     *         namespaces argument was <code>null</code> or empty.
     */
    private String getNamespaces(Map<String, String> namespaces)
    {
        String result = null;
        if (namespaces != null && !namespaces.isEmpty())
        {
            StringBuilder builder = new StringBuilder();
            for (Iterator<Entry<String, String>> iter = namespaces.entrySet().iterator(); iter.hasNext();)
            {
                Entry<String, String> entry = iter.next();
                String prefix = entry.getKey();
                String uri = entry.getValue();
                if (prefix != null && prefix.length() != 0 && uri != null && uri.length() != 0)
                {
                    builder.append("xmlns:");
                    builder.append(prefix);
                    builder.append("=\"");
                    builder.append(uri);
                    builder.append("\"");
                    if (iter.hasNext())
                    {
                        builder.append(" ");
                    }
                }
            }
            result = builder.toString();
        }
        return result;
    }
}
