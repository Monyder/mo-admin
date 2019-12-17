package mon.sof.common.ffmpeg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 缩略图的提取的工具类
 * 
 * @ClassName: ThumbnailUtil
 * @Description:
 * @author Johnson
 * @verson v1.0
 * @since v1.0
 * @date 2014年8月26日 下午2:38:32
 * 
 */
public class ThumbnailUtil {
	private static Logger log = LoggerFactory.getLogger(ThumbnailUtil.class);

	/**
	 * 生成缩略图
	 * 
	 * @Title: transfer
	 * @Description:
	 * @param inFile
	 *            视频文件
	 * @param outFile
	 *            缩略图
	 * @return
	 */
	public static boolean transfer(String inFile, String outFile) {
		List<String> commandArr = new ArrayList<String>();
		commandArr.add("-i");
		commandArr.add(inFile);
		commandArr.add("-y");
		commandArr.add("-f");
		commandArr.add("mjpeg");
		commandArr.add("-ss");
		commandArr.add("00:00:10");
		commandArr.add("-t");
		commandArr.add("00:00:01");
		commandArr.add("-s");
		commandArr.add("276x244");
		commandArr.add(outFile);
		return doTransfer(commandArr);

	}

	/**
	 * 视频/音频格式转换
	 * 
	 * @Title: transferFormat
	 * @Description:
	 * @param inFile
	 *            待转换视频/音频
	 * @param outFile
	 *            专换成的视频/音频
	 * @return
	 */
	public static boolean transferFormat(String inFile, String outFile) {
		List<String> commandArr = new ArrayList<String>();
		commandArr.add("-i");
		commandArr.add(inFile);
		commandArr.add("-ab");
		commandArr.add("128");
		commandArr.add("-acodec");
		commandArr.add("libmp3lame");
		commandArr.add("-ac");
		commandArr.add("1");
		commandArr.add("-ar");
		commandArr.add("22050");
		commandArr.add("-r");
		commandArr.add("29.97");
		commandArr.add("-s");
		commandArr.add("320x240");
		commandArr.add("-y");
		commandArr.add(outFile);
		return doTransfer(commandArr);
	}

	/**
	 * 视频添加水印
	 * 
	 * @Title: addWatermark
	 * @Description:
	 * @param inFile
	 *            待添加的视频
	 * @param outFile
	 *            添加后的视频
	 * @return
	 */
	public static boolean addWatermark(String inFile,String watermarkFile, String outFile) {
		List<String> commandArr = new ArrayList<String>();
		commandArr.add("-i");
		commandArr.add(inFile);
		commandArr.add("-i");
		commandArr.add(watermarkFile);
		commandArr.add("-filter_complex");
		commandArr.add("[1:v]scale=50:50[s];[0:v][s]overlay=main_w-overlay_w:0");
		commandArr.add("-b:v");
		commandArr.add("500000");
		commandArr.add("-c:v");
		commandArr.add("h264");
		commandArr.add("-s");
		commandArr.add("cif");
		commandArr.add("-f");
		commandArr.add("mpegts");
		commandArr.add(outFile);
		return doTransfer(commandArr);
	}
	
	/**
	 * 用于执行命令，判断当前操作系统调用相应的ffmpg文件
	 * 
	 * @Title: doTransfer
	 * @Description:
	 * @param commandArr
	 * @return
	 */
	private static boolean doTransfer(List<String> commandArr) {
		String osName = System.getProperties().getProperty("os.name");
		String archName = System.getProperty("os.arch");
		String encoding = null;
		String path = ThumbnailUtil.class.getResource("").getPath();
		String arch = "x86";
		if (archName.contains("64")) {
			arch = "x64";
		}
		List<String> commandList = new ArrayList<String>();
		if (osName.contains("Windows")) {
			commandList.add(path + "win/" + arch + "/ffmpeg");
			encoding = "GBK";
		} else {
			commandList.add(path + "linux/" + arch + "/./ffmpeg");
			encoding = "UTF-8";
		}
		commandList.addAll(commandArr);

		try {
			Runtime rt = Runtime.getRuntime();
			Process procPath = rt.exec(commandList.toArray(new String[] {}));
			InputStream stderr = procPath.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr, encoding);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				log.error(line);
				System.out.println(line);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			return false;
		}
		return true;
	}
	
}
