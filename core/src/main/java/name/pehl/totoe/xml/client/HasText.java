package name.pehl.totoe.xml.client;

import name.pehl.totoe.commons.client.WhitespaceHandling;

/**
 * Interface for providing a text value.
 * 
 * @author $Author$
 * @version $Date$ $Revision: 78
 *          $
 */
public interface HasText
{
    String getText();


    /**
     * Like {@link #getText()} but white-spaces at the bgeinning and end of text
     * are handled according to whitespaceHandling.
     * 
     * @return
     */
    String getText(WhitespaceHandling whitespaceHandling);
}
