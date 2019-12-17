package mon.sof.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 四舍五入工具类
 * @author wanghaibin
 * @created 2018年7月9日 下午2:03:30
 * @since v1.0
 */
public class DoubleFormatUtil {
    /**
     * 不需要4舍5入
     * @param d ,bit 保留位数
     * @return
     */
    public static double formatDouble(double d,int bit) {
        BigDecimal bg = new BigDecimal(d).setScale(bit, RoundingMode.DOWN);
        return bg.doubleValue();
    }
    /**
     * 需要4舍5入
     * @param d ,bit 保留位数
     * @return
     */
    public static double formatDouble45(double d,int bit) {
    	BigDecimal bg = new BigDecimal(d).setScale(bit, RoundingMode.UP);
    	return bg.doubleValue();
    }
}
