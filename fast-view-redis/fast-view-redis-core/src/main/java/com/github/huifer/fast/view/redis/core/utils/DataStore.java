/*
 *
 * Copyright 2020 HuiFer All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.huifer.fast.view.redis.core.utils;


import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 启动时存储需要的配置信息
 * @author huifer
 */
public class DataStore {
	public static SpringRedisProperties springRedisProperties;


	public static RedisConnectionConfig currConfig;

	public static RedisTemplate redisTemplate;

	public static void setRedisTemplate(RedisTemplate redisTemplate) {
		DataStore.redisTemplate = redisTemplate;
	}

	public static RedisClusterConnection clusterConnection;

	public static RedisProperties.Cluster cluster;

	public static boolean innerRedis = true;

	/**
	 * 是否开启 redis cluster
	 */
	public static boolean HAS_REDIS_CLUSTER;

	/**
	 * 是否开启 redis
	 */
	public static boolean HAS_REDIS;

	public static boolean getInnerRedis() {
		return innerRedis;
	}

	public static void setInnerRedis(boolean innerRedis) {
		DataStore.innerRedis = innerRedis;
	}

	public static boolean isHasRedis() {
		return HAS_REDIS;
	}

	public static boolean isHasRedisCluster() {
		return HAS_REDIS_CLUSTER;
	}


	public static RedisConnectionConfig getCurrConfig() {
		return currConfig;
	}

	public static void setCurrConfig(RedisConnectionConfig param) {
		if (currConfig == null) {
			currConfig = param;
		}
	}

	public static RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public static SpringRedisProperties getSpringRedisProperties() {
		if (DataStore.springRedisProperties != null) {
			return DataStore.springRedisProperties;
		}
		else {
			throw new RuntimeException("spring redis properties is null");
		}
	}

	public static void setSpringRedisProperties(SpringRedisProperties param) {
		if (DataStore.springRedisProperties == null && param != null) {

			RedisConnectionFactory redisConnectionFactory = param.getRedisConnectionFactory();

			if (redisConnectionFactory == null) {
				throw new RuntimeException("RedisConnectionFactory is null");
			}

			RedisTemplate<Object, Object> template = initRedisTemplate(redisConnectionFactory);


			initRedisConfig(param);

			DataStore.redisTemplate = template;
			DataStore.springRedisProperties = param;
		}
	}

	private static void initRedisConfig(SpringRedisProperties param) {
		RedisConnectionConfig redisConnectionConfig = new RedisConnectionConfig();
		redisConnectionConfig.setDbIndex(param.getProperties().getDatabase());
		redisConnectionConfig.setHost(param.getProperties().getHost());
		redisConnectionConfig.setPort(param.getProperties().getPort());
		redisConnectionConfig.setPwd(param.getProperties().getPassword());
		DataStore.currConfig = redisConnectionConfig;
		DataStore.setCurrConfig(redisConnectionConfig);

	}

	private static RedisTemplate<Object, Object> initRedisTemplate(RedisConnectionFactory redisConnectionFactory) {

		RedisTemplate<Object, Object> template = new RedisTemplate();
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new StringRedisSerializer());
		template.setDefaultSerializer(new StringRedisSerializer());
		template.setConnectionFactory(redisConnectionFactory);
		template.afterPropertiesSet();
		return template;
	}


	public static void setCluster(RedisProperties.Cluster cluster) {
		DataStore.cluster = cluster;
	}

	public static RedisClusterConnection getClusterConnection() {
		return DataStore.clusterConnection;
	}

	public static void setClusterConnection(RedisClusterConnection connection) {
		HAS_REDIS_CLUSTER = true;
		DataStore.clusterConnection = connection;
	}
}
