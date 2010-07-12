package name.pehl.totoe.client;

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
     * Like {@link #getText()} but white-spaces and new-lines are stripped from
     * the bgeinning and end of text
     * 
     * @return
     */
    String getTextStripped();
}
