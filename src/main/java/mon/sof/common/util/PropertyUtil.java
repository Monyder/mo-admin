package mon.sof.common.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropertyUtil {
	public static void copyProperties(Object target, Object source) {
		try {
			PropertyUtils.copyProperties(target, source);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <O> O copyProperties(Class<O> targetClass, Object source) {
		O result = ReflectionUtil.newInstance(targetClass);
		PropertyUtil.copyProperties(result, source);
		return result;
	}
	
	public static <O> List<O> copyList(Class<O> targetClass, List<?> sourceList){
		List<O> result = new ArrayList<O>();
		for(Object source :sourceList){
			result.add(copyProperties(targetClass,source));
		}
		return result;
	}
	
	public static <O> O mapToBean(Map<String, Object> map, Class<O> beanClass){
		O result = ReflectionUtil.newInstance(beanClass);
        try {  
            BeanUtils.populate(result, map);
        } catch (Exception e) {  
            throw new RuntimeException("transMap2Bean2 Error " + e);  
        }
        return result;
	}
	
	
}
