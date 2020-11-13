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

package com.github.huifer.fast.view.center.distribution.api;

import java.util.List;
import java.util.Optional;

import com.github.huifer.fast.view.center.core.model.RedisConfigEntity;
import com.github.huifer.fast.view.center.core.repository.RedisConfigRepository;
import com.github.huifer.fast.view.redis.core.api.IRedisServerInfo;
import com.github.huifer.fast.view.redis.core.api.RedisKeysOperation;
import com.github.huifer.fast.view.redis.core.api.RvRedisConnectionFactory;
import com.github.huifer.fast.view.redis.core.api.RvRedisConnectionFactoryForStac;
import com.github.huifer.fast.view.redis.core.impl.IRedisServiceInfoImpl;
import com.github.huifer.fast.view.redis.core.impl.RedisKeysService;
import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;
import com.github.huifer.fast.view.redis.core.model.RedisKeyInfo;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author huifer
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
	private final RedisKeysOperation redisKeysOperation = new RedisKeysService();

	IRedisServerInfo redisServerInfo = new IRedisServiceInfoImpl();

	Gson gson = new Gson();

	RvRedisConnectionFactory redisConnectionFactory = new RvRedisConnectionFactoryForStac();

	@Autowired
	private RedisConfigRepository redisConfigRepository;

	@GetMapping("/d")
	public Object version() {
		Optional<RedisConfigEntity> byId = redisConfigRepository.findById(1);
		if (byId.isPresent()) {
			RedisConfigEntity redisConfigEntity = byId.get();
			String context = redisConfigEntity.getContext();
			RedisProperties redisProperties = gson.fromJson(context, RedisProperties.class);
			RedisConnectionConfig redisConnectionConfig = new RedisConnectionConfig();
			redisConnectionConfig.setDbIndex(redisProperties.getDatabase());
			redisConnectionConfig.setHost(redisProperties.getHost());
			redisConnectionConfig.setPort(redisProperties.getPort());
			redisConnectionConfig.setPwd(redisProperties.getPassword());

			List<RedisKeyInfo> keys = redisKeysOperation.keys(redisConnectionFactory.factory(redisConnectionConfig, false), "*");

			return keys;

		}
		return null;
	}
}
