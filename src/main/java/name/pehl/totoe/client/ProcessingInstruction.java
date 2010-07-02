package name.pehl.totoe.client;

/**
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface ProcessingInstruction extends Node, HasText
{
    /**
     * Returns the target of this processing instruction. XML defines this as
     * being the first token following the markup that begins the processing
     * instruction.
     * 
     * @return the target of this processing instruction.
     */
    String getTarget();
}
