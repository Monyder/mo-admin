package mon.sof.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件比对工具
 */
public class FileCompareUtil {
	/**
	 * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 */
	private static List<String> readTxtFile(String filePath,String encoding) {
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (StringUtil.isNotEmpty(lineTxt.trim())){
						list.add(lineTxt.trim());
					}
				}
				read.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 文件相似度比对，100为完全相似
	 * @param source
	 * @param target
	 * @param encoding
	 * @return 文件相似度
	 */
	public static float compareSimilar(String source,String target,String encoding){
		// 相似度
		float result = 0;
		List<String> sourceList = readTxtFile(source,encoding);
		List<String> targetList = readTxtFile(target,encoding);
		float difLines = 0;
		if (sourceList.size() > targetList.size()){
			// 原集合大，在小集合中是否存在
			for (int i = 0; i < sourceList.size(); i++) {
				if (!targetList.contains(sourceList.get(i))) {
					difLines++;
				}
			}
			result = 100-difLines/sourceList.size()*100;
		} else {
			// 目标集合大，在小集合中是否存在
			for (int i = 0; i < targetList.size(); i++) {
				if (!sourceList.contains(targetList.get(i))) {
					difLines++;
				}
			}
			result = 100-difLines/targetList.size()*100;
		}
		return result;
	}
	
	public static void main(String argv[]) {
		String source = "d:/cctv.txt";// 主文件
		String target = "d:/cctv1.txt";// 进行对比的文件
		float result = compareSimilar(source, target,"UTF-8");
		double xiangSiDu = DoubleFormatUtil.formatDouble(result, 2);
		System.out.println(xiangSiDu);
	}
}
