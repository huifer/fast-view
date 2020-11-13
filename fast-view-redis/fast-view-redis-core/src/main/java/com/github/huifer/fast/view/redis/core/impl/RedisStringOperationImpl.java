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


import com.github.huifer.fast.view.redis.core.api.RedisStringOperation;
import com.github.huifer.fast.view.redis.core.api.RvRedisConnectionFactory;
import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisStringOperationImpl implements RedisStringOperation {
	RvRedisConnectionFactory factory = new RvRedisConnectionFactoryImpl();

	@Override
	public void add(RedisConnectionConfig config, String k, String v) {
		getRedisTemplate(config).opsForValue().set(k, v);
	}

	private RedisTemplate getRedisTemplate(RedisConnectionConfig config) {
		return factory.factory(config);
	}

	@Override
	public Object get(RedisConnectionConfig config, String k) {
		return getRedisTemplate(config).opsForValue().get(k);
	}

	@Override
	public void delete(RedisConnectionConfig config, String k) {
		getRedisTemplate(config).delete(k);
	}

	@Override
	public void update(RedisConnectionConfig config, String k, String v) {
		getRedisTemplate(config).opsForValue().set(k, v);
	}

	@Override
	public void add(RedisTemplate redisTemplate, String k, String v) {
		redisTemplate.opsForValue().set(k, v);
	}

	@Override
	public Object get(RedisTemplate redisTemplate, String k) {
		return redisTemplate.opsForValue().get(k);
	}

	@Override
	public void delete(RedisTemplate redisTemplate, String k) {
		redisTemplate.delete(k);
	}

	@Override
	public void update(RedisTemplate redisTemplate, String k, String v) {
		redisTemplate.opsForValue().set(k, v);
	}
}
