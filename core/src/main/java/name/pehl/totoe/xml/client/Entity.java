package name.pehl.totoe.xml.client;

/**
 * This interface represents an entity, either parsed or unparsed, in an XML
 * document. Note that this models the entity itself not the entity declaration.
 * 
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface Entity extends Node
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
     * Returns the notation name. For unparsed entities this is the name of the
     * notation for the entity. For parsed entities, this is null.
     * 
     * @return the notation name.
     */
    String getNotationName();
}
