package mon.sof.common.ffmpeg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import mon.sof.common.component.IComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 获取缩略图的组件类<br>
 * 启动时为提取缩略图的程序授权
 * @ClassName: ThumbnailComponent 
 * @Description: 
 * @author Johnson
 * @version v1.0
 * @since v1.0
 * @date 2014年8月26日 下午2:37:34 
 *
 */
@Component("thumbnailComponent")
public class ThumbnailComponent implements IComponent {
	private static Logger log = LoggerFactory.getLogger(ThumbnailComponent.class);
	
	@Override
	public void init() throws Exception {		
		String osName = System.getProperties().getProperty("os.name");
		String archName = System.getProperty("os.arch");
		String encoding = "";
		String path = ThumbnailUtil.class.getResource("").getPath();
		String arch = "x86";
		if (archName.contains("64")) {
			arch = "x64";
		}
		if (!osName.contains("Windows")) {
			String command = "chmod a+x " + path + "linux/" + arch + "/ffmpeg";
			encoding = "UTF-8";
			try {
				Runtime rt = Runtime.getRuntime();
				Process procPath = rt.exec(command);
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
			}
		}
		
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

}
