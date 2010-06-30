package name.pehl.totoe.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
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
public class TotoeApp implements EntryPoint
{
    interface Binder extends UiBinder<DockLayoutPanel, TotoeApp>
    {
    }

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    TextArea xmlIn;

    @UiField
    TextBox xpath;

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
        String xml = TotoeResources.INSTANCE.swissArmyKnife().getText();
        xmlIn.setText(xml);

        // Add the outer panel to the RootLayoutPanel, so that it will be
        // displayed.
        RootLayoutPanel root = RootLayoutPanel.get();
        root.add(outer);
    }


    @UiHandler("select")
    void onSelect(ClickEvent e)
    {
        String result = "No matching nodes found";
        String xmlValue = xmlIn.getText();
        String xpathValue = xpath.getText();
        String namespacesValue = namespaces.getText();
        if (xmlValue == null || xmlValue.trim().length() == 0)
        {
            Window.alert("No xml input given");
            return;
        }
        if (xpathValue == null || xpathValue.trim().length() == 0)
        {
            Window.alert("No xpath given");
            return;
        }
        if (namespacesValue != null && namespacesValue.trim().length() == 0)
        {
            namespacesValue = null;
        }

        XmlParser xmlParser = XmlParserFactory.getXmlParser();
        Node document = xmlParser.parse(xmlValue, namespacesValue);
        Node root = document.getRoot();
        List<Node> nodes = root.selectNodes(xpathValue);
        if (!nodes.isEmpty())
        {
            StringBuilder builder = new StringBuilder();
            for (Node node : nodes)
            {
                builder.append(serialize(node)).append("\n");
            }
            result = builder.toString();
        }
        xmlOut.setText(result);
    }


    private native String serialize(Node node)/*-{
        var jsNode = node.@name.pehl.totoe.client.internal.NodeImpl::jsNode;
        return new $wnd.XMLSerializer().serializeToString(jsNode);
    }-*/;
}
