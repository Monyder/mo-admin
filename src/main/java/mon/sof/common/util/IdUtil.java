package mon.sof.common.util;

import java.util.UUID;

/**
 * @author zhangxiaomei
 */
public final class IdUtil {

	/**
	 * 产生32位uuid
	 * @return uuid
	 */
	public static String creatUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
}
