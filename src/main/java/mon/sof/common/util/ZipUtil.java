package mon.sof.common.util;

import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.Enumeration;

public class ZipUtil {
	/**
	 * 解压文件到指定目录
	 * 
	 * @Title: unZip
	 * @Description:
	 * @param resource Path
	 *            zip文件目录 例D:/a.zip
	 * @param targetPath
	 *            指定目录 例：D:/a
	 * @throws IOException
	 */
	public static void unZip(String sourcePath, String targetPath, String charset, String outCharset) throws IOException {
		unZip(new File(sourcePath), targetPath, charset, outCharset);
	}

	public static void main(String[] args) throws IOException {
		ZipUtil util = new ZipUtil();
		util.unZip("E:\\办公\\舆情\\舆情事件资料\\H7N9孕妇.zip", "E:\\aa", "gbk", "utf-8");
	}
	
	/**
	 * 解压文件到指定目录
	 * 
	 * @Title: unZip
	 * @Description:
	 * @param zipFile
	 *            zip文件
	 * @param targetPath
	 *            例D:/a 指定目录
	 * @throws IOException
	 */
	public static void unZip(File zipFile, String targetPath, String charset, String outCharset) throws IOException {
		File pathFile = new File(targetPath);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		ZipFile zip = new ZipFile(zipFile, charset);
		for (Enumeration<?> entries = zip.getEntries(); entries.hasMoreElements();) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String zipEntryName = new String(entry.getName().getBytes(), "UTF-8");
			InputStream in = zip.getInputStream(entry);
			String outPath = (targetPath + File.separator + zipEntryName);
			// 判断路径是否存在,不存在则创建文件路径
			File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
			if (!file.exists()) {
				file.mkdirs();
			}
			// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
			if (new File(outPath).isDirectory()) {
				continue;
			}

			OutputStream out = new FileOutputStream(outPath);
			byte[] buf1 = new byte[1024];
			int len;
			while ((len = in.read(buf1)) > 0) {
				out.write(buf1, 0, len);
			}
			in.close();
			out.close();
		}
		zip.close();
	}

	/**
	 * 压缩文件到制定目录
	 * 
	 * @Title: zip
	 * @Description:
	 * @param sourcePath
	 *            源文件目录
	 * @param targetPath
	 *            zip文件
	 * @throws IOException
	 */
	public static void zip(String sourcePath, String targetPath, String charset) throws IOException {
		if (!(new File(targetPath)).canWrite()) {
			FileUtils.forceMkdir(new File(new File(targetPath).getParent()));
		}
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(targetPath));
		out.setEncoding(charset);
		ZipUtil.zip(out, sourcePath, FileUtil.getFileName(sourcePath) + File.separator);
		out.close();
	}

	/**
	 * 压缩文件到制定目录
	 * 
	 * @Title: zip
	 * @Description:
	 * @param out
	 *            zip输出流
	 * @param sourcePath
	 *            源文件目录
	 * @throws IOException
	 */
	private static void zip(ZipOutputStream out, String sourcePath, String parentPath) throws IOException {
		File a = new File(sourcePath);
		String[] file = a.list();
		File temp = null;
		for (int i = 0; i < file.length; i++) {
			if (sourcePath.endsWith(File.separator)) {
				temp = new File(sourcePath + file[i]);
			} else {
				temp = new File(sourcePath + File.separator + file[i]);
			}

			if (temp.isFile()) {
				out.putNextEntry(new ZipEntry(parentPath + file[i]));
				FileInputStream in = new FileInputStream(temp);
				int length = 0;
				byte[] b = new byte[1024];
				while ((length = in.read(b, 0, 1024)) != -1) {
					out.write(b, 0, length);
				}
				in.close();
			}
			if (temp.isDirectory()) {// 如果是子文件夹
				zip(out, sourcePath + File.separator + file[i], parentPath + file[i] + File.separator);
			}
		}
	}
	
	  
	 /**
	  * 功能:压缩多个文件成一个zip文件
	  * @param srcfile：源文件列表
	  * @param zipfile：压缩后的文件
	 */
	public static void zipFiles(File[] srcfile,File zipfile){
	    byte[] buf=new byte[1024];
	    try {
	      //ZipOutputStream类：完成文件或文件夹的压缩
	      ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipfile));
	      for(int i=0;i<srcfile.length;i++){
	        FileInputStream in=new FileInputStream(srcfile[i]);
	        out.putNextEntry(new ZipEntry(srcfile[i].getName()));
	        int len;
	        while((len=in.read(buf))>0){
	          out.write(buf,0,len);
	        }
	        out.closeEntry();
	        in.close();
	      }
	      out.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	   }
	}
}
