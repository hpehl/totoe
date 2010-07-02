package name.pehl.totoe.client.internal;

import java.util.ArrayList;
import java.util.List;

import name.pehl.totoe.client.DocumentType;
import name.pehl.totoe.client.Entity;
import name.pehl.totoe.client.Notation;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class DocumentTypeImpl extends NodeImpl implements DocumentType
{
    // ----------------------------------------------------------- constructors

    protected DocumentTypeImpl(JavaScriptObject jso)
    {
        super(jso);
    }


    // --------------------------------------------------------- public methods

    @Override
    public native String getName() /*-{
        var documentType = this.@name.pehl.totoe.client.internal.DocumentTypeImpl::jso;
        return documentType.name;
    }-*/;


    @Override
    public native String getPublicId() /*-{
        var documentType = this.@name.pehl.totoe.client.internal.DocumentTypeImpl::jso;
        return documentType.publicId;
    }-*/;


    @Override
    public native String getSystemId() /*-{
        var documentType = this.@name.pehl.totoe.client.internal.DocumentTypeImpl::jso;
        return documentType.systemId;
    }-*/;


    @Override
    public List<Entity> getEntities()
    {
        List<Entity> result = new ArrayList<Entity>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();

        getEntitiesImpl(jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add((Entity) NodeFactory.create(jso));
        }
        return result;
    }


    private native void getEntitiesImpl(List<JavaScriptObject> result) /*-{
        var documentType = this.@name.pehl.totoe.client.internal.DocumentTypeImpl::jso;
        var entities = documentType.entities;
        if (entities != null && entities.length != 0)
        {
            for (var i = 0; i < entities.length; i++) 
            {
                result.@java.util.List::add(Ljava/lang/Object;)(entities[i]);
            }
        }
    }-*/;


    @Override
    public List<Notation> getNotations()
    {
        List<Notation> result = new ArrayList<Notation>();
        List<JavaScriptObject> jsos = new ArrayList<JavaScriptObject>();

        getNotationImpl(jsos);
        for (JavaScriptObject jso : jsos)
        {
            result.add((Notation) NodeFactory.create(jso));
        }
        return result;
    }


    private native void getNotationImpl(List<JavaScriptObject> result) /*-{
        var documentType = this.@name.pehl.totoe.client.internal.DocumentTypeImpl::jso;
        var notations = documentType.notations;
        if (notations != null && notations.length != 0)
        {
            for (var i = 0; i < notations.length; i++) 
            {
                result.@java.util.List::add(Ljava/lang/Object;)(notations[i]);
            }
        }
    }-*/;
}
