package name.pehl.totoe.xml.client;

import java.util.List;

/**
 * Each Document has a doctype attribute whose value is either <code>null</code>
 * or a DocumentType object. The DocumentType interface in the DOM Core provides
 * an interface to the list of entities that are defined for the document.
 * 
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface DocumentType extends Node
{
    /**
     * Returns the public identifier.
     * 
     * @return the public identifier
     */
    String getPublicId();


    /**
     * Returns the system identifier.
     * 
     * @return the system identifier.
     */
    String getSystemId();


    /**
     * A list containing the general entities, both external and internal,
     * declared in the DTD. Parameter entities are not contained. Duplicates are
     * discarded. If there are no entities in the DTD or if there is no DTD an
     * empty list is returned.
     * 
     * @return the list with entites or an empty list if there are no entites.
     */
    List<Entity> getEntities();


    /**
     * A list containing the notations declared in the DTD. Duplicates are
     * discarded. If there are no notations in the DTD or if there is no DTD an
     * empty list is returned.
     * 
     * @return the list with notations or an empty list if there are no
     *         notations.
     */
    List<Notation> getNotations();
}
