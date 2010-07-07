package name.pehl.totoe.client;

/**
 * The Text represents the textual content (termed character data in XML) of an
 * {@link Element} or {@link Attribute}. If there is no markup inside an
 * element's content, the text is contained in a single object implementing the
 * Text interface that is the only child of the element. If there is markup, it
 * is parsed into the information items (elements, comments, etc.) and Text
 * nodes that form the list of children of the element.
 * 
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface Text extends Node, HasText
{

}
