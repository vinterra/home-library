/**
 * 
 */
package org.gcube.common.homelibrary.home.workspace.folder.items;

import java.io.InputStream;
import java.util.List;

import org.gcube.common.homelibary.model.versioning.WorkspaceVersion;
import org.gcube.common.homelibrary.home.exceptions.InternalErrorException;
import org.gcube.common.homelibrary.home.workspace.folder.FolderItem;

/**
 * @author Valentina Marioli valentina.marioli@isti.cnr.it
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
	public List<WorkspaceVersion> getVersionHistory() throws InternalErrorException;

	/**
	 * Restore a version
	 * @param version a previous version 
	 * @throws InternalErrorException
	 */
	public void restoreVersion(String version) throws InternalErrorException;

	
	/**
	 * Remove a version
	 * @param version a previous version 
	 * @throws InternalErrorException
	 */
	public void removeVersion(String version) throws InternalErrorException;
	
	/**
	 * Remove a list of versions
	 * @param versions a list of versions
	 * @throws InternalErrorException
	 */
	public void removeVersions(List<String> versions) throws InternalErrorException;
	
	/**
	 * Get Current version
	 * @return the current version
	 * @throws InternalErrorException
	 */
	public WorkspaceVersion getCurrentVersion() throws InternalErrorException;
	
	/**
	 * Get a version by version ID
	 * @param versionID
	 * @return a version
	 * @throws InternalErrorException
	 */
	public WorkspaceVersion getVersion(String versionID) throws InternalErrorException;
	
	/**
	 * Get a previous version
	 * @return the current version
	 * @throws InternalErrorException
	 */
	public InputStream downloadVersion(String version) throws InternalErrorException;
}
