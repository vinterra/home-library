/**
 * 
 */
package org.gcube.common.homelibrary.home.workspace.folder.items.gcube.link;

/**
 * @author Federico De Faveri defaveri@isti.cnr.it
 *
 */
@Deprecated
public interface DocumentAlternativeLink {
	
	/**
	 * Return the parent URI.
	 * @return the parent URI.
	 */
	public String getParentURI();
	
	/**
	 * The info object URI.
	 * @return the URI.
	 */
	public String getURI();
	
	/**
	 * Return this alternative name.
	 * @return the alternative name.
	 */
	public String getName();
	
	/**
	 * The alternative mime type.
	 * @return the mime type.
	 */
	public String getMimeType();

}
