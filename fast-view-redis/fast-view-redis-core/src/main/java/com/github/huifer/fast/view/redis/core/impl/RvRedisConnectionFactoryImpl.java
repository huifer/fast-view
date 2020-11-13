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

package com.github.huifer.fast.view.redis.core.impl;


import com.github.huifer.fast.view.redis.core.api.RvRedisConnectionFactory;
import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;
import com.github.huifer.fast.view.redis.core.utils.DataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RvRedisConnectionFactoryImpl implements RvRedisConnectionFactory {

	private static final Logger log = LoggerFactory.getLogger(RvRedisConnectionFactoryImpl.class);

	@Override
	public RedisTemplate factory(RedisConnectionConfig config) {
		log.debug("factory,config = {}", config);
		if (DataStore.getInnerRedis()) {
			log.debug("从spring中获取redisTemplate");
			return DataStore.getRedisTemplate();
		}
		else {
			log.debug("手动创建redisTemplate");

			JedisConnectionFactory conn = new JedisConnectionFactory();
			conn.setDatabase(config.getDbIndex());
			conn.setHostName(config.getHost());
			conn.setPort(config.getPort());
			conn.setPassword(config.getPwd());
			conn.afterPropertiesSet();
			RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
			template.setConnectionFactory(conn);
			template.setKeySerializer(RedisSerializer.string());
			template.setValueSerializer(RedisSerializer.string());
			template.setHashKeySerializer(RedisSerializer.string());
			template.setHashValueSerializer(RedisSerializer.string());
			template.setDefaultSerializer(RedisSerializer.string());
			return template;
		}

	}

	@Override
	public RedisTemplate factory(RedisConnectionConfig config, boolean cluster) {
		throw new RuntimeException("应用内不允许该方法创建");
	}
}
