/**
 * 
 */
package mon.sof.common.cache;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要缓存注解
 * @author zhangxiaomei
 * @created 2018年1月11日 下午5:53:33
 * @since v1.0
 * @history
 * @see
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedCached {

}
