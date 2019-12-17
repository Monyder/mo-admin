
package mon.sof.common.cache;

/**
 * 缓存接口
 * 
 * @author zhangxiaomei
 * @created 2012-7-16 下午1:53:13
 * @since v1.0
 * @history
 * @see
 */
public interface Cache {

	/**
	 * 从指定的缓存块中获取缓存对象
	 * 
	 * @param cacheName
	 *            缓存块名字
	 * @param key
	 *            缓存对象的键值
	 * @return 返回缓存对象
	 * @author zhangxiaomei
	 * @created 2012-7-16 下午1:53:13
	 */
	<T> T get(String cacheName, Object key);

	/**
	 * 将对象放入指定缓存块中
	 * 
	 * @param cacheName
	 *            缓存块名字
	 * @param key
	 *            缓存对象的键值
	 * @param value
	 *            要缓存的对象
	 * @author zhangxiaomei
	 * @created 2012-7-16 下午1:53:13
	 */
	void put(String cacheName, Object key, Object value);

	/**
	 * 从缓存块中清除掉对象
	 * 
	 * @param cacheName
	 *            缓存块名字
	 * @param key
	 *            缓存对象的键值
	 * @return 成功地从缓存中清除对象返回true，如果缓存中没有该对象，则返回false
	 * @author zhangxiaomei
	 * @created 2012-7-16 下午1:53:13
	 */
	boolean remove(String cacheName, Object key);

	/**
	 * 清除掉缓存块的所有缓存对象
	 * 
	 * @author zhangxiaomei
	 * @created 2012-7-16 下午1:53:13
	 */
	void removeAll(String cacheName);
	
	/**
	 * 判断缓存是否存在
	 * @param cacheName 缓存块的名字
	 * @param cacheKeys
	 *            缓存key
	 * @return 如果缓存全部存在返回ture，如果有一个缓存不存在返回false
	 * @created 2014-12-31 下午6:00:00
	 */
	boolean isCacheExist(String cacheName, String[] cacheKeys);

}
