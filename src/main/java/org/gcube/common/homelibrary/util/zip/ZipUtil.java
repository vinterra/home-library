/**
 * 
 */
package org.gcube.common.homelibrary.util.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.gcube.common.homelibrary.home.exceptions.InternalErrorException;
import org.gcube.common.homelibrary.home.workspace.WorkspaceFolder;
import org.gcube.common.homelibrary.home.workspace.WorkspaceItem;
import org.gcube.common.homelibrary.home.workspace.folder.items.AquaMapsItem;
import org.gcube.common.homelibrary.home.workspace.folder.items.gcube.Document;
import org.gcube.common.homelibrary.home.workspace.folder.items.ts.TimeSeries;
import org.gcube.common.homelibrary.util.zip.zipmodel.ZipItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Federico De Faveri defaveri@isti.cnr.it
 *
 */
public class ZipUtil {
	 
	protected static final Logger logger = LoggerFactory.getLogger(ZipUtil.class);

	/**
	 * Zip the folder content into a tmp zip file.
	 * @param folder the folder to be compressed.
	 * @return the zip file.
	 * @throws IOException if an error occurs.
	 * @throws InternalErrorException if an error occurs.
	 */
	public static File zipFolder(WorkspaceFolder folder) throws IOException, InternalErrorException
	{
		return zipWorkspaceItem(folder);
	}

	/**
	 * Zip the document into a tmp zip file.
	 * @param document the document to compress.
	 * @return the zip tmp file.
	 * @throws IOException if an error occurs.
	 * @throws InternalErrorException if an error occurs.
	 */
	public static File zipDocument(Document document) throws IOException, InternalErrorException
	{
		return zipWorkspaceItem(document);
	}
	
	/**
	 * @param ts the time series to zip.
	 * @return the zipped file.
	 * @throws IOException if an error occurs.
	 * @throws InternalErrorException if an error occurs.
	 */
	public static File zipTimeSeries(TimeSeries ts) throws IOException, InternalErrorException
	{
		return zipWorkspaceItem(ts);
	}
	
	/**
	 * @param aquaMapsItem the item to zip.
	 * @return the zipped item.
	 * @throws IOException if an error occurs.
	 * @throws InternalErrorException if an error occurs.
	 */
	public static File zipAquaMapsItem(AquaMapsItem aquaMapsItem) throws IOException, InternalErrorException
	{
		return zipWorkspaceItem(aquaMapsItem);
	}
	
	protected static File zipWorkspaceItem(WorkspaceItem workspaceItem) throws InternalErrorException, IOException
	{
		logger.trace("Zipping "+workspaceItem);
		
		logger.trace("converting to zip model");
		WorkspaceToZipModelConverter zipConverter = new WorkspaceToZipModelConverter();
		ZipItem item = zipConverter.convert(workspaceItem);
		
		ZipModelVisitor zipModelVisitor = new ZipModelVisitor();
		zipModelVisitor.visitItem(item);
		
		logger.trace("writing model");
		ZipModelWriter zipModelWriter = new ZipModelWriter();
		File zipFile = zipModelWriter.writeItem(item);
		
		logger.trace("conversion complete in file "+zipFile.getAbsolutePath());
		return zipFile;
	}
	
	/**
	 * Zip the file content.
	 * @param input the input file content.
	 * @param output the output file.
	 * @param entryName the zip entry name.
	 * @throws IOException if an error occurs.
	 */
	public static void zip(File input, File output, String entryName) throws IOException
	{
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(output));
		ZipEntry zipEntry = new ZipEntry(entryName);
		out.putNextEntry(zipEntry);
		IOUtils.copy(new FileInputStream(input), out);
		out.closeEntry();
		out.close();
	}

}
