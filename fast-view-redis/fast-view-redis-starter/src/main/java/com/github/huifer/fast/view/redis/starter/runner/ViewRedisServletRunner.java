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

package com.github.huifer.fast.view.redis.starter.runner;

import java.util.List;

import com.github.huifer.fast.view.redis.core.utils.DataStore;
import com.github.huifer.fast.view.redis.core.utils.SpringRedisProperties;
import com.github.huifer.fast.view.redis.starter.conf.HfViewRedisConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * servlet 启动时运行类
 *
 * @author huifer
 */
@Component
public class ViewRedisServletRunner {

	private static final Logger log = LoggerFactory.getLogger(ViewRedisServletRunner.class);

	@Autowired
	private ApplicationContext context;

	/**
	 * 启动时设置  RedisProperties 和  RedisConnectionFactory
	 * @return runner
	 */
	@Bean
	@ConditionalOnMissingBean({RedisProperties.class, RedisConnectionFactory.class})
	public ApplicationRunner runner() {
		return args -> {
			RedisProperties redisProperties = context.getBean(RedisProperties.class);

			if (log.isDebugEnabled()) {
				log.debug("开始设置 RedisProperties");

			}

			RedisConnectionFactory redisConnectionFactory = context.getBean(RedisConnectionFactory.class);


			SpringRedisProperties springRedisProperties = new SpringRedisProperties();
			springRedisProperties.setProperties(redisProperties);
			springRedisProperties.setRedisConnectionFactory(redisConnectionFactory);

			DataStore.setSpringRedisProperties(springRedisProperties);
			// 设置cluster

			RedisProperties.Cluster cluster = redisProperties.getCluster();
			if (cluster != null) {
				List<String> nodes = cluster.getNodes();
				if (!nodes.isEmpty()) {
					DataStore.setCluster(cluster);
					DataStore.HAS_REDIS_CLUSTER = true;

					RedisClusterConnection clusterConnection = redisConnectionFactory.getClusterConnection();
					DataStore.setClusterConnection(clusterConnection);
				}
			}
			else {
				DataStore.HAS_REDIS = true;
			}
		};
	}
}

