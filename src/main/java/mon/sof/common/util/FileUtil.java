package mon.sof.common.util;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 文件处理工具类
 * 
 * @ClassName: FileUtil
 * 
 */
public class FileUtil {

	public static File getFile(String fullName) {
		int index = fullName.lastIndexOf(File.separator);
		if (index > 0) {
			String path = fullName.substring(0, index);
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
		}
		return new File(fullName);
	}

	/**
	 * 获取文件名
	 * 
	 * @Title: getFileName
	 * @Description:
	 * @param filePath
	 * @return
	 */
	public static String getFileName(String filePath) {
		File file = new File(filePath);
		return getFileName(file);
	}

	/**
	 * 获取文件名
	 * 
	 * @Title: getFileName
	 * @Description:
	 * @param file
	 * @return
	 */
	public static String getFileName(File file) {
		return file.getName();
	}

	/**
	 * 获取没有后缀的文件名
	 * 
	 * @Title: getFileName
	 * @Description:
	 * @param filePath
	 * @return
	 */
	public static String getFileNameUnuffix(String filePath) {
		return getFileNameUnuffix(new File(filePath));
	}

	/**
	 * 获取没有后缀的文件名
	 * 
	 * @Title: getFileName
	 * @Description:
	 * @param file
	 * @return
	 */
	public static String getFileNameUnuffix(File file) {
		String name = getFileName(file);
		if (!StringUtil.isEmpty(name)) {
			if (name.lastIndexOf(".") > 0) {
				name = name.substring(0, name.lastIndexOf("."));
			}
		}
		return name;
	}

	/**
	 * 
	 * @Title: getFileContent
	 * @Description: 获取文件内容
	 * @param filePath
	 *            文件路径
	 * @return 文件内容
	 * @throws IOException
	 */
	public static StringBuffer getFileContent(String filePath, String charset)
			throws IOException {
		File file = new File(filePath);
		return getFileContent(file, charset);
	}

	/**
	 * 
	 * @Title: getFileContent
	 * @Description: 获取文件内容
	 * @param file
	 *            文件
	 * @return 文件内容
	 * @throws IOException
	 */
	public static StringBuffer getFileContent(File file, String charset)
			throws IOException {
		BufferedReader bufferReader = null;
		StringBuffer strBuffer = new StringBuffer();
		InputStream inputStream = new FileInputStream(file);
		bufferReader = new BufferedReader(new InputStreamReader(inputStream,
				charset));

		// 读取一行
		while (bufferReader.ready()) {
			strBuffer.append(bufferReader.readLine());
		}
		bufferReader.close();
		inputStream.close();
		return strBuffer;
	}

	/**
	 * 获取文件大小
	 * 
	 * @Title: getFileSize
	 * @Description:
	 * @param filePath
	 * @return
	 */
	public static Long getFileSize(String filePath) {
		File file = new File(filePath);
		return file.length();
	}

	/**
	 * 删除文件夹
	 * 
	 * @Title: deleteDirectory
	 * @Description:
	 * @param filePath
	 * @throws IOException
	 */
	public static void deleteDirectory(String filePath) throws IOException {
		File file = new File(filePath);
		deleteDirectory(file);
	}

	/**
	 * 删除文件夹
	 * 
	 * @Title: deleteDirectory
	 * @Description:
	 * @throws IOException
	 */
	public static void deleteDirectory(File file) throws IOException {
		FileUtils.deleteDirectory(file);
	}

	/**
	 * 
	 * @Title: writeFile
	 * @Description: 写文件
	 * @param content
	 *            文件内容
	 * @param filePath
	 *            文件路径
	 * @param label
	 *            要替换的标签
	 * @throws IOException
	 */
	public static void writeFile(String content, String filePath,
			Map<String, String> label, String charset) throws IOException {
		content = replaceContentByLabel(content, label);
		writeFile(content, replaceContentByLabel(filePath, label), charset);
	}

	/**
	 * 
	 * @Title: writeFile
	 * @Description: 写文件
	 * @param content
	 *            文件内容
	 * @param filePath
	 *            文件路径
	 * @throws IOException
	 */
	public static void writeFile(String content, String filePath, String charset)
			throws IOException {
		File file = new File(filePath);
		FileUtils.forceMkdir(new File(file.getParent()));
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(
				file), charset);
		out.write(content.toCharArray());
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @Title: replaceContentByLabel
	 * @Description: 通过标签替换内容
	 * @param content
	 *            内容
	 * @param label
	 *            待替换的标签
	 * @return 替换后的字符串
	 */
	public static String replaceContentByLabel(String content,
			Map<String, String> label) {
		Iterator<Entry<String, String>> iterator = label.entrySet().iterator();
		Entry<String, String> entry = null;
		while (iterator.hasNext()) {
			entry = iterator.next();
			content = content.replaceAll(entry.getKey(), entry.getValue());
		}
		return content;
	}

	/**
	 * 拷贝文件
	 * 
	 * @Title: copyFile
	 * @Description:
	 * @param sourcePath
	 *            源文件目录
	 * @param targetPath
	 *            目标文件目录
	 * @throws IOException
	 */
	public static void copyFile(String sourcePath, String targetPath)
			throws IOException {
		copyFile(new File(sourcePath), new File(targetPath));
	}

	/**
	 * 拷贝文件
	 * 
	 * @Title: copyFile
	 * @Description:
	 * @param sourceFile
	 *            源文件
	 * @param targetFile
	 *            目标文件
	 * @throws IOException
	 */
	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		FileUtils.copyFile(sourceFile, targetFile);
	}

	/**
	 * 读取行
	 * 
	 * @Title: readLines
	 * @Description:
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static List<String> readLines(File file, String charset)
			throws IOException {
		return FileUtils.readLines(file, charset);
	}

	public static Boolean exists(String filePath) {
		return new File(filePath).exists();
	}

	/**
	 * 读取文件夹
	 * 
	 * @Title: readFolder
	 * @Description:
	 * @param sourcePath
	 * @param targetPath
	 * @param fileContent
	 */
	public static void readFolder(String sourcePath, String targetPath,
			FileContent fileContent) {
		try {
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
					String content = getFileContent(temp, "UTF-8").toString();
					fileContent.getFileContent(temp.getName(), content,
							targetPath + "/");
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					readFolder(sourcePath + "/" + file[i], targetPath + "/"
							+ file[i], fileContent);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public interface FileContent {
		void getFileContent(String fileName, String content, String targetPath)
				throws Exception;
	}
}
