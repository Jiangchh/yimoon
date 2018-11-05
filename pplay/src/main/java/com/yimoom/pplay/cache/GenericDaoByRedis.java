package com.yimoom.pplay.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public class GenericDaoByRedis<T> {
	@Autowired
	private RedisTemplate<String, T> redisTemplate;
	public ValueOperations<String, T> getOperations(){
		return redisTemplate.opsForValue();
	}
	/**
	 * 该方法不判断参数是否为空，由继承的方法来判断
	 * @param Object
	 * @param key
	 */
	protected void saveObject(T Object,String key) {

		getOperations().set(key, Object, 30, TimeUnit.SECONDS);

	}
	/**
	 * 该方法可能返回空值
	 * @param key
	 * @return
	 */
	protected T getObject(String key) {
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			T object = getOperations().get(key);
			return object;
		}else {
			return null;
		}
	}
}
