package name.pehl.totoe.xml.client;

/**
 * This interface represents a notation declared in the DTD. A notation either
 * declares, by name, the format of an unparsed entity or is used for formal
 * declaration of processing instruction targets.
 * 
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface Notation extends Node
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
}
