package name.pehl.totoe.xml.client;

/**
 * This interface represents the content of a comment, i.e., all the characters
 * between the starting '&lt;!--' and ending '--&gt;'.
 * <p>
 * Comment extends {@link HasText}. To get the value of the comment use
 * {@link HasText#getText()}.
 * 
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface Comment extends Node, HasText
{

}
