/**
 * 
 */
package org.gcube.common.homelibrary.examples;

import org.gcube.common.homelibrary.home.Home;
import org.gcube.common.homelibrary.home.data.ApplicationsArea;
import org.gcube.common.homelibrary.home.data.exceptions.FolderAlreadyExistException;
import org.gcube.common.homelibrary.home.exceptions.HomeNotFoundException;
import org.gcube.common.homelibrary.home.exceptions.InternalErrorException;
import org.gcube.common.homelibrary.home.workspace.exceptions.WorkspaceFolderNotFoundException;

/**
 * @author Federico De Faveri defaveri@isti.cnr.it
 *
 */
public class CreateDataFolder {


	/**
	 * @param args not used.
	 * @throws InternalErrorException if an error occurs.
	 * @throws FolderAlreadyExistException if an error occurs.
	 * @throws WorkspaceFolderNotFoundException if an error occurs.
	 * @throws HomeNotFoundException if an error occurs.
	 * @throws MalformedScopeExpressionException if an error occurs.
	 */
	public static void main(String[] args) throws InternalErrorException, FolderAlreadyExistException,  HomeNotFoundException, WorkspaceFolderNotFoundException
	{
		Home home = ExamplesUtil.createHome("test.user");
		ApplicationsArea homeManager = home.getDataArea();
//		DataFolder root = homeManager.getDataFolderRoot();
//		
//		root.createFolder("test");

	}

}
