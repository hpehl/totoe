package name.pehl.totoe.client;

import java.util.List;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
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
