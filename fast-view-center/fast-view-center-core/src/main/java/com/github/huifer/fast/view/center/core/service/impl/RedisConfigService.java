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

package com.github.huifer.fast.view.center.core.service.impl;

import com.github.huifer.fast.view.center.core.model.ApplicationEntity;
import com.github.huifer.fast.view.center.core.model.RedisConfigEntity;
import com.github.huifer.fast.view.center.core.repository.RedisConfigRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author huifer
 */
@Service
public class RedisConfigService {
	private static final Logger log = LoggerFactory.getLogger(RedisConfigService.class);

	Gson gson = new Gson();

	@Autowired
	private RedisConfigRepository redisConfigRepository;

	@Autowired
	private ApplicationService applicationService;

	public RedisConfigEntity save(RedisConfigEntity entity) {
		return this.redisConfigRepository.save(entity);
	}

	public RedisConfigEntity update(RedisConfigEntity entity) {
		return this.redisConfigRepository.save(entity);
	}

	public RedisConfigEntity save(RedisProperties redisProperties, String appName) {
		ApplicationEntity applicationEntity = applicationService.queryByName(appName);

		if (applicationEntity != null) {
			RedisConfigEntity queryData = this.redisConfigRepository.findByAppId(applicationEntity.getId());
			// 查询不到
			if (queryData == null) {
				RedisConfigEntity saveDb = new RedisConfigEntity();
				saveDb.setAppId(applicationEntity.getId());
				saveDb.setContext(gson.toJson(redisProperties));

				return save(saveDb);
			}
			// 查询到
			else {
				queryData.setContext(gson.toJson(redisProperties));
				return this.update(queryData);

			}
		}
		return null;
	}
}
