package name.pehl.totoe.xml.client.internal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import name.pehl.totoe.xml.client.Document;
import name.pehl.totoe.xml.client.XmlParseException;

/**
 * @author $Author$
 * @version $Date$ $Revision: 629
 *          $
 */
public class XmlParserImpl
{
    // ------------------------------------------------------- script resources

    interface ResourceBundle extends ClientBundle
    {
        ResourceBundle INSTANCE = GWT.create(ResourceBundle.class);

        @Source("sarissa.js")
        TextResource sarissaJs();

        @Source("sarissa_ieemu_xpath.js")
        TextResource sarissaXPathJs();
    }


    // ------------------------------------------------------------------- JSNI

    private static final JavaScriptObject nativeParser = XmlParserImpl.initialize();


    private static JavaScriptObject initialize()
    {
        injectScript();
        setupSarissaPrototypes();
        return initializeDOMParser();
    }


    private static void injectScript()
    {
        if (!isScriptInjected())
        {
            ScriptInjector.fromString(ResourceBundle.INSTANCE.sarissaJs().getText())
                    .setWindow(ScriptInjector.TOP_WINDOW).inject();
            ScriptInjector.fromString(ResourceBundle.INSTANCE.sarissaXPathJs().getText())
                    .setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }


    private static final native boolean isScriptInjected() /*-{
        if (!(typeof $wnd.Sarissa === "undefined") && !(null === $wnd.Sarissa)) {
            return true;
        }
        return false;
    }-*/;


    /**
     * Workaround for a bug where the Element javascript object is created in
     * different scopes. Many thanks to Greg Hengeli! See <a
     * href="http://code.google.com/p/totoe/issues/detail?id=3">http://code
     * .google.com/p/totoe/issues/detail?id=3</a> for more details.
     */
    private static native void setupSarissaPrototypes() /*-{
		if ($wnd.Sarissa._SARISSA_HAS_DOM_FEATURE
				&& document.implementation.hasFeature("XPath", "3.0")) {
			XMLDocument.prototype._sarissa_useCustomResolver = false;
			XMLDocument.prototype._sarissa_xpathNamespaces = [];
			XMLDocument.prototype.selectNodes = function(sExpr, contextNode,
					returnSingle) {
				var nsDoc = this;
				var nsresolver;
				if (this._sarissa_useCustomResolver) {
					nsresolver = function(prefix) {
						var s = nsDoc._sarissa_xpathNamespaces[prefix];
						if (s) {
							return s;
						} else {
							throw "No namespace URI found for prefix: '"
									+ prefix + "'";
						}
					};
				} else {
					nsresolver = this.createNSResolver(this.documentElement);
				}
				var result = null;
				if (!returnSingle) {
					var oResult = this.evaluate(sExpr,
							(contextNode ? contextNode : this), nsresolver,
							XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);
					var nodeList = new SarissaNodeList(oResult.snapshotLength);
					nodeList.expr = sExpr;
					for ( var i = 0; i < nodeList.length; i++) {
						nodeList[i] = oResult.snapshotItem(i);
					}
					result = nodeList;
				} else {
					result = this.evaluate(sExpr, (contextNode ? contextNode
							: this), nsresolver,
							XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
				}
				return result;
			};
			Element.prototype.selectNodes = function(sExpr) {
				var doc = this.ownerDocument;
				if (doc.selectNodes) {
					return doc.selectNodes(sExpr, this);
				} else {
					throw "Method selectNodes is only supported by XML Elements";
				}
			};
			XMLDocument.prototype.selectSingleNode = function(sExpr,
					contextNode) {
				var ctx = contextNode ? contextNode : null;
				return this.selectNodes(sExpr, ctx, true);
			};
			Element.prototype.selectSingleNode = function(sExpr) {
				var doc = this.ownerDocument;
				if (doc.selectSingleNode) {
					return doc.selectSingleNode(sExpr, this);
				} else {
					throw "Method selectNodes is only supported by XML Elements";
				}
			};
		}
    }-*/;


    private static native JavaScriptObject initializeDOMParser() /*-{
		return new $wnd.DOMParser();
    }-*/;


    // ---------------------------------------------------------- parse methods

    public Document parse(String xml, String namespaces)
    {
        if (xml == null || xml.trim().length() == 0)
        {
            return null;
        }
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
		var domDoc = @name.pehl.totoe.xml.client.internal.XmlParserImpl::nativeParser
				.parseFromString(xml, "text/xml");
		var error = $wnd.Sarissa.getParseErrorText(domDoc);
		if (error != $wnd.Sarissa.PARSED_OK) {
			if (error == $wnd.Sarissa.PARSED_EMPTY) {
				return null;
			} else if (error == $wnd.Sarissa.PARSED_UNKNOWN_ERROR) {
				throw (new Error("Unkown error parsing xml file."));
			} else {
				throw (new Error(error));
			}
			return null;
		}

		if (namespaces != null) {
			try {
				$wnd.Sarissa.setXpathNamespaces(domDoc, namespaces);
			} catch (e) {
				throw (new Error(e));
			}
		}
		return domDoc;
    }-*/;
}
