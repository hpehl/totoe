package name.pehl.totoe.tester.client;

import java.util.List;

import name.pehl.totoe.xml.client.Document;
import name.pehl.totoe.xml.client.HasText;
import name.pehl.totoe.xml.client.Node;
import name.pehl.totoe.xml.client.XPathException;
import name.pehl.totoe.xml.client.XmlParser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-10-27 12:42:07 +0200 (Mi, 27. Okt 2010) $ $Revision: 629
 *          $
 */
public class XmlParserPanel extends ResizeComposite
{
    // @formatter:off
    interface Binder extends UiBinder<DockLayoutPanel, XmlParserPanel> {}
    private static final Binder binder = GWT.create(Binder.class);

    @UiField TextArea xmlIn;
    @UiField TextBox xpath;
    @UiField TextBox context;
    @UiField TextBox namespaces;
    @UiField Button select;
    @UiField TextArea xmlOut;
    // @formatter:on

    public XmlParserPanel()
    {
        initWidget(binder.createAndBindUi(this));

        // Load sample xml
        String xml = Resources.INSTANCE.swissArmyKnifeXml().getText();
        xmlIn.setText(xml);

        // Set some default values
        xpath.setText(Resources.EXAMPLE_XPATH);
        namespaces.setText(Resources.EXAMPLE_NAMESPACES);
    }


    @UiHandler("select")
    void onSelect(ClickEvent event)
    {
        String result = null;
        Node contextNode = null;

        String xmlValue = xmlIn.getText();
        String xpathValue = xpath.getText();
        String contextValue = context.getText();
        String namespacesValue = namespaces.getText();
        if (xmlValue == null || xmlValue.trim().length() == 0)
        {
            result = "No xml input given";
        }
        else if (xpathValue == null || xpathValue.trim().length() == 0)
        {
            result = "No xpath given";
        }

        if (namespacesValue != null && namespacesValue.trim().length() == 0)
        {
            namespacesValue = null;
        }
        try
        {
            Document document = new XmlParser().parse(xmlValue, namespacesValue);
            if (contextValue != null && contextValue.trim().length() != 0)
            {
                contextNode = document.selectNode(contextValue);
            }
            else
            {
                contextNode = document;
            }
            List<Node> nodes = contextNode.selectNodes(xpathValue);
            result = buildResult(nodes);
        }
        catch (XPathException e)
        {
            result = "Exception:\n" + e.getMessage();
        }
        xmlOut.setText(result);
    }


    private String buildResult(List<Node> nodes)
    {
        StringBuilder builder = new StringBuilder();
        if (!nodes.isEmpty())
        {
            int index = 0;
            StringBuilder xml = new StringBuilder();
            builder.append("Result contains ").append(nodes.size()).append(" node(s).\n");
            for (Node node : nodes)
            {
                builder.append("\nNode #").append(index++).append(": ");
                builder.append("Name: ").append(node.getName());
                builder.append(", Type: ").append(node.getType());
                if (node instanceof HasText)
                {
                    builder.append(", Text: '").append(((HasText) node).getText()).append("'");
                }
                xml.append(node.serialize()).append("\n");
            }
            builder.append("\n\nResult of serialize() over all nodes:\n").append(xml.toString());
        }
        else
        {
            builder.append("No matching nodes found");
        }
        return builder.toString();
    }
}
