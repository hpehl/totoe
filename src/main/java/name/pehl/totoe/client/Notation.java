package name.pehl.totoe.client;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
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
