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

import java.util.HashSet;
import java.util.Set;

import com.github.huifer.fast.view.redis.core.api.RedisZSetOperation;
import com.github.huifer.fast.view.redis.core.api.RvRedisConnectionFactory;
import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

public class RedisZSetOperationImpl implements RedisZSetOperation {

	RvRedisConnectionFactory factory = new RvRedisConnectionFactoryImpl();

	@Override
	public void add(RedisConnectionConfig config, String k, double score, String member) {
		Set<ZSetOperations.TypedTuple<Object>> zset = new HashSet<>();
		zset.add(
				new ZSetOperations.TypedTuple<Object>() {
					private final String data;

					private final double sc;

					@Override
					public Object getValue() {
						return data;
					}

					@Override
					public Double getScore() {
						return sc;
					}

					@Override
					public int compareTo(ZSetOperations.TypedTuple<Object> o) {
						if (o == null) {
							return 1;
						}
						return this.getScore() - o.getScore() >= 0 ? 1 : -1;
					}

					{
						sc = score;
						data = member;
					}
				});

		factory.factory(config).opsForZSet().add(k, zset);
	}

	@Override
	public void del(RedisConnectionConfig config, String key, String member) {
		factory.factory(config).opsForZSet().remove(key, member);
	}

	@Override
	public Set<ZSetOperations.TypedTuple> get(RedisConnectionConfig config, String key) {
		return factory.factory(config).opsForZSet().rangeWithScores(key, 0, -1);
	}

	@Override
	public void update(RedisConnectionConfig config, String k, double score, String member) {
		factory.factory(config).opsForZSet().add(k, member, score);
	}

	@Override
	public Long size(RedisConnectionConfig config, String k) {
		return factory.factory(config).opsForZSet().size(k);
	}

	@Override
	public Set get(RedisConnectionConfig config, String k, long start, long end) {
		return factory.factory(config).opsForZSet().rangeWithScores(k, start, end);
	}

	@Override
	public void removeOldSaveNew(RedisConnectionConfig config, String k, String oldMember, String newMember, double score) {
		// 删除历史
		del(config, k, oldMember);
		// 创建新的
		add(config, k, score, newMember);
	}

	@Override
	public void add(RedisTemplate redisTemplate, String k, double score, String member) {
		Set<ZSetOperations.TypedTuple<Object>> zset = new HashSet<>();
		zset.add(
				new ZSetOperations.TypedTuple<Object>() {
					private final String data;

					private final double sc;

					@Override
					public Object getValue() {
						return data;
					}

					@Override
					public Double getScore() {
						return sc;
					}

					@Override
					public int compareTo(ZSetOperations.TypedTuple<Object> o) {
						if (o == null) {
							return 1;
						}
						return this.getScore() - o.getScore() >= 0 ? 1 : -1;
					}

					{
						sc = score;
						data = member;
					}
				});
		redisTemplate.opsForZSet().add(k, zset);
	}

	@Override
	public void del(RedisTemplate redisTemplate, String key, String member) {
		redisTemplate.opsForZSet().remove(key, member);
	}

	@Override
	public Set get(RedisTemplate redisTemplate, String key) {
		return redisTemplate.opsForZSet().rangeWithScores(key, 0, -1);
	}

	@Override
	public void update(RedisTemplate redisTemplate, String k, double score, String member) {
		redisTemplate.opsForZSet().add(k, member, score);

	}

	@Override
	public Long size(RedisTemplate redisTemplate, String k) {
		return redisTemplate.opsForZSet().size(k);
	}

	@Override
	public Set get(RedisTemplate redisTemplate, String k, long start, long end) {
		return redisTemplate.opsForZSet().rangeWithScores(k, start, end);
	}

	@Override
	public void removeOldSaveNew(RedisTemplate redisTemplate, String k, String oldMember, String newMember, double score) {
		del(redisTemplate, k, oldMember);
		add(redisTemplate, k, score, newMember);
	}
}