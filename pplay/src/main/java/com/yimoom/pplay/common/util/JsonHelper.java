package com.yimoom.pplay.common.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*

 */
public class JsonHelper {

	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	// 将JSON转换成Map,其中valueClz为Map中value的Class,keyArray为Map的key
	public static Map<?, ?> json2Map(Object[] keyArray, String json, Class<?> valueClz) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		Map<Object, Class<?>> classMap = new HashMap<Object, Class<?>>();
		for (int i = 0; i < keyArray.length; i++) {
			classMap.put(keyArray[i], valueClz);
		}
		return (Map<?, ?>) JSONObject.toBean(jsonObject, Map.class, classMap);
	}

	/***
	 * 将对象转换为传入类型的List
	 *
	 * @param object
	 * @param objectClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> toList(Object object, Class<T> objectClass) {
		JSONArray jsonArray = JSONArray.fromObject(object);
		return JSONArray.toCollection(jsonArray, objectClass);
	}

	/**
	 * 功能描述：实现将一个object对象转换为json的string字符串
	 * @param obj
	 * @return
	 */
	public static String object2json(Object obj) {
		StringBuilder json = new StringBuilder();
		if (obj == null) {
			json.append("\"\"");
		} else if (obj instanceof String || obj instanceof BigDecimal
				|| obj instanceof BigInteger) {
			json.append("\"").append(string2json(obj.toString())).append("\"");
		} else if (obj instanceof Boolean) {
			json.append(Boolean.valueOf(obj.toString()));
		} else if (obj instanceof Integer || obj instanceof Float
				|| obj instanceof Short || obj instanceof Double
				|| obj instanceof Long || obj instanceof Byte) {
			json.append(obj.toString());
		} else if (obj instanceof Date || obj instanceof java.sql.Date) {
			json.append("\"").append(sdf.format(obj)).append("\"");
		} else if (obj instanceof Object[]) {
			json.append(array2json((Object[]) obj));
		} else if (obj instanceof List) {
			json.append(list2json((List<?>) obj));
		} else if (obj instanceof Map) {
			json.append(map2json((Map<?, ?>) obj));
		} else if (obj instanceof Set) {
			json.append(set2json((Set<?>) obj));
		} else {
			json.append(bean2json(obj));
		}
		return json.toString();
	}

	public static String list2json(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(object2json(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String array2json(Object[] array) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (array != null && array.length > 0) {
			for (Object obj : array) {
				json.append(object2json(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String map2json(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if (map != null && map.size() > 0) {
			for (Object key : map.keySet()) {
				json.append(object2json(key));
				json.append(":");
				json.append(object2json(map.get(key)));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	public static String set2json(Set<?> set) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (set != null && set.size() > 0) {
			for (Object obj : set) {
				json.append(object2json(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String string2json(String s) {
		if (s == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				if (ch >= '\u0000' && ch <= '\u001F') {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}

	public static String bean2json(Object bean) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = object2json(props[i].getName());
					String value = object2json(props[i].getReadMethod().invoke(
							bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Throwable e) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private final static ObjectMapper LCWU_OBJECT_MAPPER = new ObjectMapper();

	static{
		OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);
		OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);

		LCWU_OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		LCWU_OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);
		LCWU_OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);
		LCWU_OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	}

	/**
	 * 将json字符串转换成Map对象
	 * 
	 *  json类型与java类型的对应关系查看：http://wiki.fasterxml.com/JacksonInFiveMinutess
	 * 
	 * @param json
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> toMap(String json) throws Exception {
		return OBJECT_MAPPER.readValue(json, Map.class);
	}


	/**
	 * 将对象转换成json字符串
	 * 
	 * @param object
	 * @param camelCaseToLowerCaseWithUnderscores 将小写下划线分割的json属性名到驼峰格式的java属性名
	 * @return String
	 * @throws Exception
	 */
	public static String toJSONString(Object object, boolean camelCaseToLowerCaseWithUnderscores) throws Exception {
		ObjectMapper mapper = camelCaseToLowerCaseWithUnderscores ? LCWU_OBJECT_MAPPER : OBJECT_MAPPER;
		return mapper.writeValueAsString(object);
	}

	/**
	 * 将对象转换成json字符串
	 * 
	 * @param object
	 * @return String
	 * @throws Exception
	 */
	public static String toJSONString(Object object) throws Exception {
		return toJSONString(object, false);
	}


	/**
	 * 类似toJSONString()方法，除了在转换过程出现异常时,返回""(空串).
	 * 
	 * @param object
	 * @param camelCaseToLowerCaseWithUnderscores 将小写下划线分割的json属性名到驼峰格式的java属性名
	 * @return String
	 */
	public static String toJSONStringQuietly(Object object, boolean camelCaseToLowerCaseWithUnderscores) {
		ObjectMapper mapper = camelCaseToLowerCaseWithUnderscores ? LCWU_OBJECT_MAPPER : OBJECT_MAPPER;
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 类似toJSONString()方法，除了在转换过程出现异常时,返回""(空串).
	 * 
	 * @param object
	 * @return String
	 */
	public static String toJSONStringQuietly(Object object) {
		return toJSONStringQuietly(object, false);
	}


	@SuppressWarnings("unchecked")
	public static <T> T getValue(String json, String... paths) throws Exception {
		Object value = null;
		Map<String, Object> node = OBJECT_MAPPER.readValue(json, Map.class);
		for (int i = 0; i < paths.length; i++) {
			value = node.get(paths[i]);
			if (i == paths.length - 1) {
				break;
			} else if (value instanceof Map) {
				node = (Map<String, Object>) value;
			} else {
				return null;
			}
		}
		return (T)value;
	}

}


