/**
 * 
 */
package org.gcube.common.homelibrary.home.workspace.folder.items;

import org.gcube.common.homelibrary.home.workspace.folder.FolderItem;

/**
 * @author Federico De Faveri defaveri@isti.cnr.it
 *
 */

public interface Query extends FolderItem {

	/**
	 * The query text.
	 * @return the query.
	 */
	public String getQuery();
	
	
	/**
	 * Return this query type.
	 * @return the query type.
	 */
	public QueryType getQueryType();

}
