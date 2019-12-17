/**
 * 
 */
package mon.sof.common.cache;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mon.sof.common.util.ReflectionUtil;
import org.springframework.util.ClassUtils;


/**
 * @author zhangxiaomei
 * @created 2018年1月11日 下午5:59:03
 * @since v1.0
 * @history
 * @see
 */
public class CacheUtil {
	
	/**
	 * 获取类需要缓存的所有属性名称
	 * @param beanClass
	 * @return
	 * @author zhangxiaomei
	 * @created 2018年1月12日 下午6:04:49
	 */
	public static List<String> getNeedCacheField(Class<?> beanClass) {
		List<String> result = new ArrayList<String>();
		
		// Ignore CGLIB subclasses - introspect the actual user class.
		Class<?> userClass = ClassUtils.getUserClass(beanClass);

		Field[] fields = ReflectionUtil.getDeclaredFields(userClass);
		for(Field field :fields){
			NeedCached annotation = field.getAnnotation(NeedCached.class);
			if (annotation != null) {
				result.add(field.getName());
			}
		}
		return result;
	}

	/**
	 * 获取Java对象需要缓存的属性及值
	 * @param bean
	 * @return
	 * @author zhangxiaomei
	 * @created 2018年1月11日 下午6:09:10
	 */
	public static Map<String,Object> getNeedCacheField(Object bean) {
		Map<String,Object> result = new HashMap<String, Object>();
		
		// Ignore CGLIB subclasses - introspect the actual user class.
		Class<?> userClass = ClassUtils.getUserClass(bean.getClass());

		Field[] fields = ReflectionUtil.getDeclaredFields(userClass);
		for(Field field :fields){
			NeedCached annotation = field.getAnnotation(NeedCached.class);
			if (annotation != null) {
				result.put(field.getName(), ReflectionUtil.getFieldValue(bean, field));
			}
		}
		return result;
	}

}
