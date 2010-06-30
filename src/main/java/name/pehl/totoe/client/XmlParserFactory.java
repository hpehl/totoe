package name.pehl.totoe.client;

import name.pehl.totoe.client.internal.XmlParserImpl;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public final class XmlParserFactory
{
    private static final XmlParser instance = new XmlParserImpl();


    private XmlParserFactory()
    {
    }


    public static XmlParser getXmlParser()
    {
        return instance;
    }
}
