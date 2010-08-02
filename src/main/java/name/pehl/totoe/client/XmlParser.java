package name.pehl.totoe.client;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import name.pehl.totoe.client.internal.XmlParserImpl;

/**
 * XML parser with namespace support for turning an XML input string into a
 * {@link Document} instance.
 * <p>
 * <b>Default namespace:</b><br/>
 * If you want to parse a XML document with a default namespace and you want to
 * reference the default namespace later on in XPath expressions. You have to
 * provide a prefix for the default namespace. Suppose you have the following
 * XML document:
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * &lt;swissArmyKnife xmlns="http://code.google.com/p/totoe" 
 *     xmlns:foo="http://code.google.com/p/totoe/foo"
 *     xmlns:bar="http://code.google.com/p/totoe/bar" 
 *     id="B001DZTJRQ"&gt;
 *     &lt;!--
 *         XML that has erything inside. Just like the Wenger 16999 Swiss Army Knife 
 *         http://www.amazon.com/Wenger-16999-Swiss-Army-Knife/dp/B001DZTJRQ/
 *     --&gt;
 *     &lt;description&gt;&lt;![CDATA[
 *         Call it what you will, it's a knife that's unrivaled, impractical, 
 *         and enormous, it's more knife than one can carry or would fit in one's pocket
 *     ]]&gt;&lt;/description&gt;
 *     &lt;!-- long live the metric system! --&gt;
 *     &lt;foo:dimensions foo:unit="cm"&gt;11.8 x 10.8 x 4.3&lt;/foo:dimensions&gt;
 *     &lt;bar:weight bar:unit="g"&gt;700&lt;/bar:weight&gt;
 *     &lt;functions number="more than you'll ever need"&gt;
 *         &lt;rocketLauncher kind="advanced" foo:range="intercontinental" bar:dangerous="indeed"&gt;5&lt;/rocketLauncher&gt;
 *         &lt;calculator eval="1 &&lt; 2"&gt;2 &&gt; 1&lt;/calculator&gt;
 *         &lt;bttf:fluxCapacitor xmlns:bttf="http://en.wikipedia.org/wiki/Back_to_the_Future"&gt;
 *             &lt;bttf:power unit="gigawatts"&gt;1.21&lt;/bttf:power&gt;
 *         &lt;/bttf:fluxCapacitor&gt;
 *     &lt;/functions&gt;
 * &lt;/swissArmyKnife&gt;
 * </pre>
 * 
 * To parse the XML use the following code:
 * 
 * <pre>
 * String xml = ...;
 * String namespaces = &quot;xmlns:default=\&quot;http://code.google.com/p/totoe\&quot; &quot;
 *     + &quot;xmlns:foo=\&quot;http://code.google.com/p/totoe/foo\&quot; &quot;
 *     + &quot;xmlns:bar=\&quot;http://code.google.com/p/totoe/bar\&quot; &quot;
 *     + &quot;xmlns:bttf=\&quot;http://en.wikipedia.org/wiki/Back_to_the_Future\&quot;&quot;;
 * Document document = new XmlParser().parse(xml, namespaces);
 * </pre>
 * 
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
     * in XPath expressions you have to provide a prefix for that default
     * namespace. In case you have the following xml:
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
     * &lt;lotteryTicket xmlns="http://code.google.com/p/totoe" 
     *     xmlns:foo="http://code.google.com/p/totoe/foo"
     *     xmlns:bar="http://code.google.com/p/totoe/bar"&gt;
     *     ...
     * &lt;/lotteryTicket&gt;
     * </pre>
     * 
     * Use this code to parse it:
     * 
     * <pre>
     * String xml = ...;
     * String namespaces = &quot;xmlns:default=\&quot;http://code.google.com/p/totoe\&quot; &quot;
     *     + &quot;xmlns:foo=\&quot;http://code.google.com/p/totoe/foo\&quot; &quot;
     *     + &quot;xmlns:bar=\&quot;http://code.google.com/p/totoe/bar\&quot;&quot;;
     * Document document = new XmlParser().parse(xml, namespaces);
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
     * &lt;lotteryTicket xmlns="http://code.google.com/p/totoe" 
     *     xmlns:foo="http://code.google.com/p/totoe/foo"
     *     xmlns:bar="http://code.google.com/p/totoe/bar"&gt;
     *     ...
     * &lt;/lotteryTicket&gt;
     * </pre>
     * 
     * Use this code to parse it:
     * 
     * <pre>
     * String xml = ...;
     * Map&lt;String, String&gt; namespaces = new HashMap&lt;String, String&gt;();
     * namespaces.put(&quot;default&quot;, &quot;http://code.google.com/p/totoe&quot;); 
     * namespaces.put(&quot;foo&quot;, &quot;http://code.google.com/p/totoe/foo&quot;);
     * namespaces.put(&quot;bar&quot;, &quot;http://code.google.com/p/totoe/bar&quot;);
     * Document document = new XmlParser().parse(xml, namespaces);
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
    protected String getNamespaces(Map<String, String> namespaces)
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
