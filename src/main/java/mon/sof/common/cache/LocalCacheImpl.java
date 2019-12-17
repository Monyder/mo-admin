package mon.sof.common.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * 缓存的本地实现，不支持集群
 * 
 * @author zhangxiaomei
 * @created 2012-7-16 下午02:00:05
 * @since v1.1
 * @history
 * @see
 */
@Component("localCacheImpl")
public class LocalCacheImpl implements Cache {

	private Map<String, Map<Object, Object>> cacheMap = new ConcurrentHashMap<String, Map<Object, Object>>();

	private Map<Object, Object> getCache(String cacheName) {
		Map<Object, Object> map = cacheMap.get(cacheName);
		if (map == null) {
			map = new ConcurrentHashMap<Object, Object>();
			cacheMap.put(cacheName, map);
		}
		return map;
	}

	public Map<Object, Object> get(String cacheName) {
		return getCache(cacheName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String cacheName, Object key) {
		return (T) getCache(cacheName).get(key);
	}

	@Override
	public void put(String cacheName, Object key, Object value) {
		getCache(cacheName).put(key, value);
	}

	@Override
	public boolean remove(String cacheName, Object key) {
		return getCache(cacheName).remove(key) != null;
	}

	@Override
	public void removeAll(String cacheName) {
		cacheMap.remove(cacheName);
	}

	/**
	 * 判断缓存是否存在
	 * 
	 * @param cacheName 缓存块的名字
	 * @param cacheKeys 缓存key
	 * @return 如果缓存全部存在返回ture，如果有一个缓存不存在返回false
	 */
	public boolean isCacheExist(String cacheName, String[] cacheKeys) {
		for (String cacheKey : cacheKeys) {
			if (get(cacheName, cacheKey) == null) {
				return false;
			}
		}
		return true;
	}


}
