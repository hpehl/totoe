package name.pehl.totoe.xml.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author $Author$
 * @version $Date$ $Revision: 629
 *          $
 */
public class XmlParserApp implements EntryPoint
{
    static final String EXAMPLE_XPATH = "//dns:functions/bttf:fluxCapacitor/bttf:power/@unit";
    static final String EXAMPLE_NAMESPACES = "xmlns:dns=\"http://code.google.com/p/totoe\" "
            + "xmlns:foo=\"http://code.google.com/p/totoe/foo\" " + "xmlns:bar=\"http://code.google.com/p/totoe/bar\" "
            + "xmlns:bttf=\"http://en.wikipedia.org/wiki/Back_to_the_Future\"";

    interface Binder extends UiBinder<DockLayoutPanel, XmlParserApp>
    {
    }

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    TextArea xmlIn;

    @UiField
    TextBox xpath;

    @UiField
    TextBox context;

    @UiField
    TextBox namespaces;

    @UiField
    Button select;

    @UiField
    TextArea xmlOut;


    @Override
    public void onModuleLoad()
    {
        // Create the UI defined in XmlParserApp.ui.xml.
        DockLayoutPanel outer = binder.createAndBindUi(this);

        // Load sample xml
        String xml = XmlParserResources.INSTANCE.swissArmyKnifeDns().getText();
        xmlIn.setText(xml);

        // Set some default values
        xpath.setText(EXAMPLE_XPATH);
        namespaces.setText(EXAMPLE_NAMESPACES);

        // Add the outer panel to the RootLayoutPanel, so that it will be
        // displayed.
        RootLayoutPanel root = RootLayoutPanel.get();
        root.add(outer);
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
