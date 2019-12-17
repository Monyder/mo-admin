/**
 * 
 */
package mon.sof.common.cache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author zhangxiaomei
 * @created 2018年1月5日 下午5:20:18
 * @since v1.0
 * @history
 * @see
 */
public class MockRedisCacheImpl implements RedisCache{
	
	private Map<String,String> map = new ConcurrentHashMap<String, String>();
	
	private Map<String,Map<Object,Object>> hashMap = new ConcurrentHashMap<String, Map<Object,Object>>();
	
	private Map<String,Queue<String>> queueMap = new ConcurrentHashMap<String, Queue<String>>();

	@Override
	public void set(String key, String value) {
		map.put(key, value);
	}

	@Override
	public void set(String key, String value, long timeoutSecond) {
		map.put(key, value);
	}

	@Override
	public boolean hasKey(String key) {
		return map.containsKey(key)||hashMap.containsKey(key)||queueMap.containsKey(key);
	}

	@Override
	public void delete(String key) {
		map.remove(key);
		hashMap.remove(key);
		queueMap.remove(key);
	}

	@Override
	public String get(String key) {
		return map.get(key);
	}

	@Override
	public Long increment(String key) {
		return increment(key,1);
	}

	@Override
	public Long increment(String key, int value) {
		String b = map.get(key);
		long a = Long.valueOf(b)+value;
		map.put(key, a+"");
		return a;
	}

	@Override
	public void hashPut(String tableName, String key, Object value) {
		Map<Object, Object> map2 = hashMap.get(tableName);
		if(map2==null){
			map2 = new ConcurrentHashMap<Object, Object>();
			hashMap.put(tableName, map2);
		}
		map2.put(key, value.toString());
	}

	@Override
	public Object hashGet(String tableName, String key) {
		Map<Object, Object> map2 = hashMap.get(tableName);
		if(map2==null){
			return null;
		}
		return map2.get(key);
	}

	@Override
	public void hashPutAll(String tableName, Map<String, Object> map) {
		Map<Object, Object> map2 = hashMap.get(tableName);
		if(map2==null){
			map2 = new ConcurrentHashMap<Object, Object>();
			hashMap.put(tableName, map2);
		}
		for(Entry<String,Object> entry :map.entrySet()){
			map2.put(entry.getKey(),entry.getValue().toString());
		}
	} 

	@Override
	public Map<Object, Object> hashGetAll(String tableName) {
		return hashMap.get(tableName);
	}

	@Override
	public Long hashIncrement(String tableName, String key) {
		return hashIncrement(tableName, key,1);
	}

	@Override
	public Long hashIncrement(String tableName, String key, int value) {
		Map<Object, Object> map2 = hashMap.get(tableName);
		if(map2==null){
			map2 = new ConcurrentHashMap<Object, Object>();
			hashMap.put(tableName, map2);
		}
		Object object = map2.get(key);
		long reuslt = value;
		if(object==null){
			map2.put(key, reuslt);
		}else{
			reuslt = Long.valueOf(object.toString())+value;
			map2.put(key, reuslt);
		}
		return reuslt;
	}

	@Override
	public boolean hashHasKey(String tableName, String key) {
		Map<Object, Object> map2 = hashMap.get(tableName);
		if(map2==null){
			return false;
		}
		return map2.containsKey(key);
	}

	@Override
	public void hashDelete(String tableName, String key) {
		Map<Object, Object> map2 = hashMap.get(tableName);
		if(map2==null){
			return ;
		}
		map2.remove(key);
	}

	@Override
	public void leftPush(String key, String value) {
		Queue<String> queue = queueMap.get(key);
		if(queue==null){
			queue = new ConcurrentLinkedDeque<String>();
			queueMap.put(key, queue);
		}
		queue.offer(value);
	}

	@Override
	public void rightPush(String key, String value) {
		Queue<String> queue = queueMap.get(key);
		if(queue==null){
			queue = new ConcurrentLinkedDeque<String>();
			queueMap.put(key, queue);
		}
		queue.offer(value);
	}

	@Override
	public void rightPop(String key) {
		Queue<String> queue = queueMap.get(key);
		if(queue==null){
			return;
		}
		queue.poll();
	}

	@Override
	public List<String> range(String key) {
		Queue<String> queue = queueMap.get(key);
		if(queue==null){
			return new ArrayList<String>(0);
		}
		List<String> result  =new ArrayList<String>();
		Iterator<String> iterator = queue.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			result.add(next);
		}
		return result;
	}

	@Override
	public Long listSize(String key) {
		Queue<String> queue = queueMap.get(key);
		if(queue==null){
			return 0l;
		}else{
			return Long.valueOf(queue.size());
		}
	}

	@Override
	public Set<String> keysPattern(String pattern) {
		Set<String> result = new HashSet<String>();
		String[] split = pattern.split("\\*");
		for(String str :map.keySet()){
			if(str.contains(split[0])){
				result.add(str);
			}
		}
		return result;
	}

	@Override
	public void setExpire(String key, long timeoutSecond) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long findExpireKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
