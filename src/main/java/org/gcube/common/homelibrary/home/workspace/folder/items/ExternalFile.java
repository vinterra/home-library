/**
 * 
 */
package org.gcube.common.homelibrary.home.workspace.folder.items;

import java.io.InputStream;
import java.util.List;

import org.gcube.common.homelibrary.home.exceptions.InternalErrorException;
import org.gcube.common.homelibrary.home.workspace.folder.FolderItem;

/**
 * @author Federico De Faveri defaveri@isti.cnr.it
 *
 */
public interface ExternalFile extends FolderItem, File {
	
	/**
	 * Set Data
	 * @param data an inputstream
	 * @throws InternalErrorException
	 */
	void setData(InputStream data) throws InternalErrorException;
	/**
	 * Get a list of versions
	 * @return a list of versions
	 * @throws InternalErrorException
	 */
	public List<String> getVersioning() throws InternalErrorException;

	/**
	 * Restore a version
	 * @param version a previous version 
	 * @throws InternalErrorException
	 */
	public void restoreVersion(String version) throws InternalErrorException;

}
