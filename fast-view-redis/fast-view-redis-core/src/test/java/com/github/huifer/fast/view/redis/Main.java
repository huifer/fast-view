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

package com.github.huifer.fast.view.redis;

import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 *
 *
 * @author huifer
 */
public class Main {
	public static void main(String[] args) {
		//单机模式
		RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
		rsc.setPort(6379);
		rsc.setHostName("localhost");
		rsc.setDatabase(0);

		RedisTemplate<String, String> template = new RedisTemplate<>();
		//单机模式
		JedisConnectionFactory fac = new JedisConnectionFactory(rsc);
		fac.afterPropertiesSet();
		template.setConnectionFactory(fac);
		template.afterPropertiesSet();
		template.setKeySerializer(RedisSerializer.string());
		template.setValueSerializer(RedisSerializer.string());
		template.setHashKeySerializer(RedisSerializer.string());
		template.setHashValueSerializer(RedisSerializer.string());
		template.setDefaultSerializer(RedisSerializer.string());
		template.opsForValue().set("aaa", "a");
	}
}
