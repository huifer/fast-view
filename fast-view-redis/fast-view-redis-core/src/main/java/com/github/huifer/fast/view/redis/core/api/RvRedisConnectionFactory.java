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

import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis template 生成工厂
 * @author huifer
 */
public interface RvRedisConnectionFactory {

	/**
	 * 生成 redisTemplate
	 * @param config redis 连接配置
	 * @return redisTemplate
	 */
	RedisTemplate factory(RedisConnectionConfig config);
}
