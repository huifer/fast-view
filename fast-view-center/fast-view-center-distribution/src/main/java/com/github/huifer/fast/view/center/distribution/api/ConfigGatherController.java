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

import java.util.Map;

import com.github.huifer.fast.view.center.common.model.RestResult;
import com.github.huifer.fast.view.center.core.model.ApplicationEntity;
import com.github.huifer.fast.view.center.core.service.impl.ApplicationService;
import com.github.huifer.fast.view.center.core.service.impl.RedisConfigService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置采集
 *
 * @author huifer
 */
@RestController
@RequestMapping("/config/gather")
public class ConfigGatherController {


	@Autowired
	private RedisConfigService redisConfigService;

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/app")
	public RestResult app(
			@RequestBody Map<String, String> data
	) {
		String appName = data.get("appName");
		ApplicationEntity save = applicationService.save(appName);
		return new RestResult(200, "success", save);

	}

	@PostMapping("/redis")
	public RestResult redis(
			@RequestBody Map<String, String> redisProperties
	) {
		String data = redisProperties.get("data");
		String appName = redisProperties.get("appName");
		Gson gson = new Gson();
		RedisProperties res = gson.fromJson(data, RedisProperties.class);
		return new RestResult(200, "success", redisConfigService.save(res, appName));
	}
}
