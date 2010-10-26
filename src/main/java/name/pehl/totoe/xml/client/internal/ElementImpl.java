package name.pehl.totoe.xml.client.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import name.pehl.totoe.xml.client.Attribute;
import name.pehl.totoe.xml.client.Element;
import name.pehl.totoe.xml.client.HasText;
import name.pehl.totoe.xml.client.Node;
import name.pehl.totoe.xml.client.NodeType;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author$
 * @version $Date$ $Revision$
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
        var element = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
        return element.getAttributeNode(name);
    }-*/;


    @Override
    public String getAttributeValue(String name)
    {
        Attribute attribute = getAttribute(name);
        if (attribute != null)
        {
            return attribute.getText();
        }
        return null;
    }


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
        var element = this.@name.pehl.totoe.xml.client.internal.NodeImpl::jso;
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


    // --------------------------------------------------------------- children

    @Override
    public List<Node> getChildren()
    {
        return XmlParserUtils.getChildren(jso);
    }


    @Override
    public <T extends Node> List<T> getChildren(NodeType type)
    {
        return XmlParserUtils.getChildren(jso, type);
    }


    @Override
    public boolean hasChildren()
    {
        return XmlParserUtils.hasChildren(jso);
    }


    @Override
    public boolean hasChildren(NodeType type)
    {
        return XmlParserUtils.hasChildren(jso, type);
    }


    @Override
    public Node getFirstChild()
    {
        return XmlParserUtils.getFirstChild(jso);
    }


    @Override
    public Node getLastChild()
    {
        return XmlParserUtils.getLastChild(jso);
    }


    // ------------------------------------------------------------------- text

    /**
     * Returns the text of the first child in case the first child implements
     * {@link HasText}. In all other cases this method returns <code>null</code>
     * .
     * 
     * @return the text of the first child in case the first child implements
     *         {@link HasText}, <code>null</code> otherwise.
     * @see name.pehl.totoe.xml.client.HasText#getText()
     */
    @Override
    public String getText()
    {
        return XmlParserUtils.getTextFromFirstChild(this);
    }


    @Override
    public String getTextStripped()
    {
        return XmlParserUtils.stripWsnl(getText());
    }
}
