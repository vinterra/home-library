/**
 * 
 */
package org.gcube.portlets.user.homelibrary.examples;

import org.gcube.common.core.scope.GCUBEScope.MalformedScopeExpressionException;
import org.gcube.portlets.user.homelibrary.home.exceptions.HomeNotFoundException;
import org.gcube.portlets.user.homelibrary.home.exceptions.InternalErrorException;
import org.gcube.portlets.user.homelibrary.home.workspace.Workspace;
import org.gcube.portlets.user.homelibrary.home.workspace.WorkspaceArea;
import org.gcube.portlets.user.homelibrary.home.workspace.basket.Basket;
import org.gcube.portlets.user.homelibrary.home.workspace.basket.BasketBulkCreator;
import org.gcube.portlets.user.homelibrary.home.workspace.exceptions.InsufficientPrivilegesException;
import org.gcube.portlets.user.homelibrary.home.workspace.exceptions.ItemAlreadyExistException;
import org.gcube.portlets.user.homelibrary.home.workspace.exceptions.WorkspaceNotFoundException;


/**
 * This example show how to clone some WorkspaceArea items.
 * @author Federico De Faveri defaveri@isti.cnr.it
 *
 */
public class BasketBulkCreatorExample {

	/**
	 * @param args not used.
	 * @throws MalformedScopeExpressionException if an error occurs.
	 * @throws InternalErrorException if an error occurs.
	 * @throws HomeNotFoundException if an error occurs.
	 * @throws WorkspaceNotFoundException if an error occurs.
	 * @throws InsufficientPrivilegesException if an error occurs.
	 * @throws ItemAlreadyExistException if an error occurs.
	 */
	public static void main(String[] args) throws MalformedScopeExpressionException, InternalErrorException, HomeNotFoundException, WorkspaceNotFoundException, InsufficientPrivilegesException, ItemAlreadyExistException {
		WorkspaceArea workspaceArea = ExamplesUtil.createWorkspaceArea();

		//we create a test workspace
		Workspace workspace = workspaceArea.getRoot().createWorkspace("TestWorkspace", "This is a test workspace");
		
		Basket basket = workspace.createBasket("TestBasket", "This is a test basket");
		
		BasketBulkCreator bbc = basket.getNewBasketBulkCreator();
		
		//we request an annotation creation
		bbc.createAnnotation("00", "111-222-333-444");
		
		//we request a document creation
		bbc.createDocumentItem("1111", "333-222-111");
		
		//we persist changes
		bbc.commit();
	}

}
