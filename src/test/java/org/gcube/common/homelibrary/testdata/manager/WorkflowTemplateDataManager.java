/**
 * 
 */
package org.gcube.common.homelibrary.testdata.manager;

import java.util.LinkedList;

import org.gcube.common.homelibrary.home.exceptions.InternalErrorException;
import org.gcube.common.homelibrary.home.workspace.WorkspaceFolder;
import org.gcube.common.homelibrary.home.workspace.exceptions.InsufficientPrivilegesException;
import org.gcube.common.homelibrary.home.workspace.exceptions.ItemAlreadyExistException;
import org.gcube.common.homelibrary.home.workspace.folder.items.WorkflowTemplate;
import org.gcube.common.homelibrary.testdata.AbstractDataManager;
import org.gcube.common.homelibrary.testdata.data.WorkflowTemplateData;
import org.gcube.common.homelibrary.util.WorkspaceUtil;

import com.thoughtworks.xstream.XStream;

/**
 * @author Federico De Faveri defaveri@isti.cnr.it
 *
 */
public class WorkflowTemplateDataManager extends AbstractDataManager<WorkflowTemplateData,WorkflowTemplate> {

	/**
	 * 
	 */
	public WorkflowTemplateDataManager() {
		super("workflowtemplates.xml");
	}

	@Override
	protected void configureXStream() {
		xstream = new XStream();
		xstream.alias("workflowtemplate", WorkflowTemplateData.class);
		xstream.alias("workflowtemplates", LinkedList.class);
	}

	@Override
	protected WorkflowTemplate fillData(WorkspaceFolder destinationFolder, WorkflowTemplateData testData) throws InternalErrorException {

		try{
			String name = WorkspaceUtil.getUniqueName(testData.getName(), destinationFolder);

			return destinationFolder.createWorkflowTemplate(name, testData.getDescription(), testData.getWorkflowId(), testData.getWorkflowStatus(), testData.getWorkflowData());
		}catch(InsufficientPrivilegesException e)
		{
			logger.error("Error creating the workflow template", e);
			throw new InternalErrorException(e);
		}catch(ItemAlreadyExistException e)
		{
			logger.error("Error creating the workflow template", e);
			throw new InternalErrorException(e);
		}
	}

}
