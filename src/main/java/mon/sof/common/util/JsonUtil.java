package mon.sof.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * JSON工具类: 将任意格式转换为JSON数据格式
 *
 */
public final class JsonUtil {

	/** json请求体转换 rest-servlet.xml使用 */
	public static final ObjectMapper OBJECT_MAPPER = getMapper();

	/**
	 * json转实体
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonToObj(String json, Class<T> clazz) {
		T obj = null;
		if (StringUtil.isEmptyAfterTrim(json)) {
			return null;
		}
		try {
			obj = OBJECT_MAPPER.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage() + " json[" + json + "]",
					e);
		}
		return obj;
	}
	
	/**
	 * 将一个json数组转成bean的集合
	 * @param jsonArray 数组格式的json
	 * @param beanClazz bean的class
	 * @return bean的集合
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonArrayToBeanList(String jsonArray, Class<T> beanClazz) {
		List<Map<String,Object>> list = jsonToObj(jsonArray,List.class);
		List<T> result = new ArrayList<T>();
		for(Map<String,Object> map :list){
			result.add(jsonToObj(JsonUtil.toJson(map), beanClazz));
		}
		return result;
	}
	
	
	/**
	 * json转实体
	 * 
	 * @param <T>
	 * @param json
	 * @return
	 */
	public static <T> T jsonToObj(String json, TypeReference<T> typeReference ) {

		T obj = null;
		if (StringUtil.isEmptyAfterTrim(json)) {
			return null;
		}
		try {
			obj = OBJECT_MAPPER.readValue(json, typeReference);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage() + " json[" + json + "]", e);
		}
		return obj;
	}

	/**
	 * obj转换成json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {

		try {
			return OBJECT_MAPPER.writeValueAsString(obj);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	/**
	 * 获取映射器
	 * 
	 * @return
	 */
	private static ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();

		mapper.getDeserializationConfig().withFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(df);
		// mapper.getSerializationConfig().setDateFormat(new JsonDateFormat());
		// mapper.getSerializationConfig().withDateFormat(df);
		// mapper.getDeserializationConfig().setDateFormat(new
		// JsonDateFormat());
		// mapper.getDeserializationConfig().withDateFormat(df1);
		return mapper;

	}

	/**
	 * 把json转成Map json下所有的key-value
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> getMapFromJson(String json) {
		if (StringUtil.isEmptyAfterTrim(json)) {
			return null;
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> map = JsonUtil.jsonToObj(json, Map.class);
		Map<String, Object> ret = new HashMap<String, Object>();
		createParams(map, ret);
		return ret;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final void createParams(Map<String, Object> map,
			Map<String, Object> ret) {
		if (map == null || map.size() == 0) {
			return;
		}
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Object value = map.get(key);
			if (value instanceof Map) {
				createParams((Map) value, ret);
			} else {
				ret.put(key, value);
			}
		}
	}

	public static void main(String[] args) {
		String json = "{\"date\":\"2012-01-11 00:12:10\"}";
		User user = jsonToObj(json, User.class);
		System.out.println(user.date);
		System.out.println(JsonUtil.toJson(user));

	}

	static class User {
		private Date date;

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

	}
}
