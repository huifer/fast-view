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

package com.github.huifer.fast.view.redis.core.api;

import java.util.ArrayList;
import java.util.List;

import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;

import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 *
 *
 * @author huifer
 */
public class RvRedisConnectionFactoryForStac implements RvRedisConnectionFactory {
	@Override
	public RedisTemplate factory(RedisConnectionConfig config) {
		throw new RuntimeException("不允许创建");
	}

	@Override
	public RedisTemplate factory(RedisConnectionConfig config, boolean cluster) {
		JedisConnectionFactory fac;
		RedisTemplate<String, String> template = new RedisTemplate<>();
		if (cluster) {


			//集群模式
			RedisClusterConfiguration rcc = new RedisClusterConfiguration();
			rcc.setPassword(config.getPwd());
			List<RedisNode> nodes = new ArrayList<>();

			for (String node : config.getNodes()) {
				String[] split = node.split(":");
				nodes.add(new RedisNode(split[0], Integer.parseInt(split[1])));
			}
			rcc.setClusterNodes(nodes);

			//单机模式
			fac = new JedisConnectionFactory(rcc);
		}
		else {
			RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
			rsc.setPort(config.getPort());
			rsc.setHostName(config.getHost());
			rsc.setDatabase(config.getDbIndex());

			//单机模式
			fac = new JedisConnectionFactory(rsc);

		}
		fac.afterPropertiesSet();
		template.setConnectionFactory(fac);
		template.afterPropertiesSet();
		template.setKeySerializer(RedisSerializer.string());
		template.setValueSerializer(RedisSerializer.string());
		template.setHashKeySerializer(RedisSerializer.string());
		template.setHashValueSerializer(RedisSerializer.string());
		template.setDefaultSerializer(RedisSerializer.string());
		return template;
	}
}
