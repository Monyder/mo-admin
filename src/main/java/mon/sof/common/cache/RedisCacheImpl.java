package mon.sof.common.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisCacheImpl implements RedisCache {

	private static Logger log = LoggerFactory.getLogger(RedisCacheImpl.class);

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
//		if (log.isDebugEnabled()) {
//
//			log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()
//					+ "|| key[" + key + "] value[" + value + "]");
//		}

	}

	/*---------KV---------*/
	@Override
	public Long increment(String key) {
		Long increment = redisTemplate.boundValueOps(key).increment(1);
//		if (log.isDebugEnabled()) {
//			log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()
//					+ "|| key[" + key + "] return[" + increment + "]");
//		}
		return increment;
	}

	@Override
	public Long increment(String key, int value) {
		Long increment = redisTemplate.boundValueOps(key).increment(value);
//		if (log.isDebugEnabled()) {
//			log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()
//					+ "|| key[" + key + "] value[" + value + "] return["
//					+ increment + "]");
//		}
		return increment;
	}

	/*---------hash---------*/
	@Override
	public void hashPut(String tableName, String key, Object value) {
		redisTemplate.opsForHash().put(tableName, key, value);
//		if (log.isDebugEnabled()) {
//
//			log.debug(Thread.currentThread().getStackTrace()[1].g.getMethodName()
//					+ "|| key[" + key + "] value[" + value + "]");
//		}
	}

	@Override
	public Object hashGet(String tableName, String key) {
		return redisTemplate.opsForHash().get(tableName, key);
	}

	@Override
	public void hashPutAll(String tableName, Map<String, Object> map) {
		redisTemplate.opsForHash().putAll(tableName, map);
	}

	@Override
	public Map<Object, Object> hashGetAll(String tableName) {
		return redisTemplate.opsForHash().entries(tableName);
	}

	@Override
	public Long hashIncrement(String tableName, String key) {
		return redisTemplate.opsForHash().increment(tableName, key, 1);
	}

	@Override
	public Long hashIncrement(String tableName, String key, int value) {
		return redisTemplate.opsForHash().increment(tableName, key, value);
	}

	@Override
	public boolean hashHasKey(String tableName, String key) {
		return redisTemplate.opsForHash().hasKey(tableName, key);
	}

	@Override
	public void hashDelete(String tableName, String key) {
		redisTemplate.opsForHash().delete(tableName, key);
	}

	/**
	 * 模糊key 查询
	 * @param pattern
	 * @return Set<String>
	 */
	@Override
	public Set<String> keysPattern(String pattern) {
		return redisTemplate.keys(pattern);
	}

	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}

	@Override
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void set(String key, String value, long timeoutSecond) {
		redisTemplate.opsForValue().set(key, value, timeoutSecond,
				TimeUnit.SECONDS);
	}
	
	/*---------list---------*/
	@Override
	public void leftPush(String key, String value) {
		redisTemplate.opsForList().leftPush(key, value);
	}
	@Override
	public void rightPush(String key, String value) {
		redisTemplate.opsForList().rightPush(key, value);
	}
	@Override
	public void rightPop(String key) {
		redisTemplate.opsForList().rightPop(key);
	}
	@Override
	public List<String> range(String key) {
		return redisTemplate.opsForList().range(key, 0, -1);
	}
	@Override
	public Long listSize(String key){
		return redisTemplate.opsForList().size(key);
	}
	
	/*timeout second*/
	@Override
	public void setExpire(String key,long timeoutSecond){
		redisTemplate.expire(key, timeoutSecond, TimeUnit.SECONDS);
	}
	// 根据key获取过期时间，并换算成指定单位
	@Override
	public Long findExpireKey(String key){
		return redisTemplate.getExpire(key,TimeUnit.SECONDS);
	}
}
