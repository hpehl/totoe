package name.pehl.totoe.client;

/**
 * CDATA sections are used to escape blocks of text containing characters that
 * would otherwise be regarded as markup. The only delimiter that is recognized
 * in a CDATA section is the "]]&gt;" string that ends the CDATA section. CDATA
 * sections cannot be nested. Their primary purpose is for including material
 * such as XML fragments, without needing to escape all the delimiters.
 * <p>
 * CDATA extends {@link HasText}. To get the value of the CDATA section use
 * {@link HasText#getText()}.
 * 
 * @author $Author$
 * @version $Date$ $Revision$
 */
public interface CDATA extends Node, HasText
{

}
