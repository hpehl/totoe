package name.pehl.totoe.client.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import name.pehl.totoe.client.Attribute;
import name.pehl.totoe.client.Element;
import name.pehl.totoe.client.HasText;
import name.pehl.totoe.client.Node;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class ElementImpl extends NodeImpl implements Element
{
    // ----------------------------------------------------------- constructors

    protected ElementImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // ------------------------------------------------------------- attributes

    @Override
    public Attribute getAttribute(String name)
    {
        JavaScriptObject attributeJso = getAttributeImpl(name);
        return NodeFactory.create(attributeJso);
    }


    private native JavaScriptObject getAttributeImpl(String name) /*-{
        var element = this.@name.pehl.totoe.client.internal.ElementImpl::jso;
        return element.getAttributeNode(name);
    }-*/;


    @Override
    public native String getAttributeValue(String name) /*-{
        var element = this.@name.pehl.totoe.client.internal.ElementImpl::jso;
        return element.getAttribute(name);
    }-*/;


    @Override
    public boolean hasAttribute(String name)
    {
        Map<String, String> values = getAttributeValues();
        return values.containsKey(name);
    }


    @Override
    public List<Attribute> getAttributes()
    {
        List<Attribute> result = new ArrayList<Attribute>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();

        getAttributesImpl(jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add((Attribute) NodeFactory.create(jso));
        }
        return result;
    }


    private native void getAttributesImpl(List<JavaScriptObject> result)/*-{
        var element = this.@name.pehl.totoe.client.internal.ElementImpl::jso;
        if (element.attributes != null && element.attributes.length != 0)
        {
            for (var i = 0; i < element.attributes.length; i++) 
            {
                result.@java.util.List::add(Ljava/lang/Object;)(element.attributes[i]);
            }
        }
    }-*/;


    @Override
    public Map<String, String> getAttributeValues()
    {
        Map<String, String> attrributeValues = new HashMap<String, String>();
        List<Attribute> attributes = getAttributes();
        for (Attribute attribute : attributes)
        {
            String name = attribute.getName();
            if (name != null && name.length() != 0)
            {
                attrributeValues.put(name, attribute.getText());
            }
        }
        return attrributeValues;
    }


    @Override
    public boolean hasAttributes()
    {
        return !getAttributes().isEmpty();
    }


    // ------------------------------------------------------------------- text

    /**
     * Returns the text of the first child in case the first child implements
     * {@link HasText}. In all other cases this method returns <code>null</code>
     * .
     * 
     * @return the text of the first child in case the first child implements
     *         {@link HasText}, <code>null</code> otherwise.
     * @see name.pehl.totoe.client.HasText#getText()
     */
    @Override
    public String getText()
    {
        Node firstChild = getFirstChild();
        if (firstChild != null && firstChild instanceof HasText)
        {
            return ((HasText) firstChild).getText();
        }
        return null;
    }


    // --------------------------------------------------------------- children

    @Override
    public List<Node> getChildren()
    {
        List<Node> result = new ArrayList<Node>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();

        getChildrenImpl(jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add(NodeFactory.create(jso));
        }
        return result;
    }


    private native void getChildrenImpl(List<JavaScriptObject> result) /*-{
        var element = this.@name.pehl.totoe.client.internal.ElementImpl::jso;
        var children = element.childNodes;
        if (children != null && children.length != 0)
        {
            for (var i = 0; i < children.length; i++) 
            {
                result.@java.util.List::add(Ljava/lang/Object;)(children[i]);
            }
        }
    }-*/;


    @Override
    public Node getFirstChild()
    {
        JavaScriptObject firstChildJso = getFirstChildImpl();
        return NodeFactory.create(firstChildJso);
    }


    private native JavaScriptObject getFirstChildImpl() /*-{
        var element = this.@name.pehl.totoe.client.internal.ElementImpl::jso;
        return element.firstChild;
    }-*/;


    @Override
    public Node getLastChild()
    {
        JavaScriptObject lastChildJso = getLastChildImpl();
        return NodeFactory.create(lastChildJso);
    }


    private native JavaScriptObject getLastChildImpl() /*-{
        var element = this.@name.pehl.totoe.client.internal.ElementImpl::jso;
        return node.lastChild;
    }-*/;
}
