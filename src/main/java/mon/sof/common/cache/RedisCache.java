/**
 * 
 */
package mon.sof.common.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis 缓存的访问接口
 * @author zhangxiaomei
 * @created 2018年1月5日 下午5:19:37
 * @since v1.0
 * @history
 * @see
 */
public interface RedisCache {
	
	void set(String key, String value);
	
	void set(String key, String value, long timeoutSecond);
	
	boolean hasKey(String key);
	
	void delete(String key);
	
	String get(String key);
	
	/*---------key---------*/
	Long increment(String key);
	
	Long increment(String key, int value);
	
	/*---------hash---------*/
	void hashPut(String tableName, String key, Object value);
	
	Object hashGet(String tableName, String key);
	
	void hashPutAll(String tableName, Map<String, Object> map);
	
	Map<Object,Object> hashGetAll(String tableName);
	
	Long hashIncrement(String tableName, String key);
	
	Long hashIncrement(String tableName, String key, int value);
	
	boolean hashHasKey(String tableName, String key);
	
	void hashDelete(String tableName, String key);
	
	/*---------list---------*/
	void leftPush(String key, String value);
	void rightPush(String key, String value);
	void rightPop(String key);
	List<String> range(String key);
	Long listSize(String key);
	
	/*---------模糊key查询---------*/
	Set<String> keysPattern(String pattern);
	/*timeout second*/
	void setExpire(String key, long timeoutSecond);
	Long findExpireKey(String key);
}
