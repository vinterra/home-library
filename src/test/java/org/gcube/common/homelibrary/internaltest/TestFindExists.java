/**
 * 
 */
package org.gcube.common.homelibrary.internaltest;

import org.gcube.common.homelibrary.examples.ExamplesUtil;
import org.gcube.common.homelibrary.home.workspace.Workspace;
import org.gcube.common.homelibrary.home.workspace.WorkspaceFolder;
import org.gcube.common.homelibrary.home.workspace.WorkspaceItem;
import org.gcube.common.homelibrary.home.workspace.folder.FolderItem;
import org.gcube.common.homelibrary.home.workspace.folder.items.QueryType;

/**
 * @author Federico De Faveri defaveri@isti.cnr.it
 *
 */
public class TestFindExists {

	/**
	 * @param args not used.
	 * @throws Exception if an error occurs.
	 */
	public static void main(String[] args) throws Exception {
		
		Workspace workspace = ExamplesUtil.createWorkspace();
		
		WorkspaceFolder root = workspace.getRoot();
		
		String name = "TestQuery2";
		
		FolderItem item = root.createQueryItem(name,"This is a test query", "select * from query", QueryType.GOOGLE_SEARCH);
		System.out.println("Created item: "+item);
		
		
		WorkspaceItem pathFoundItem = workspace.find(item.getPath());
		
		System.out.println("pathFoundItem: "+pathFoundItem);
		
	}

}
