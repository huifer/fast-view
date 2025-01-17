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

import java.util.List;

import com.github.huifer.fast.view.redis.core.api.IRedisGeoOperation;
import com.github.huifer.fast.view.redis.core.api.RvRedisConnectionFactory;
import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class IRedisGeoOperationImpl implements IRedisGeoOperation {

	RvRedisConnectionFactory redisConnectionCacheFactory = new RvRedisConnectionFactoryImpl();

	@Override
	public void add(RedisConnectionConfig config, String key, String value, double x, double y) {
		RedisTemplate factory = redisConnectionCacheFactory.factory(config);
		GeoOperations geoOperations = factory.opsForGeo();
		geoOperations.add(key, new Point(x, y), value);
	}

	@Override
	public List<Point> get(RedisConnectionConfig config, String key, String value) {
		RedisTemplate factory = redisConnectionCacheFactory.factory(config);
		GeoOperations geoOperations = factory.opsForGeo();

		return geoOperations.position(key, value);
	}

}
