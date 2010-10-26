package name.pehl.totoe.xml.client;

/**
 * The ProcessingInstruction interface represents a "processing instruction",
 * used in XML as a way to keep processor-specific information in the text of
 * the document.
 * <p>
 * Please note that this interface is included here for the sake of
 * completeness. It is not recognized by the different browsers.
 * 
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
