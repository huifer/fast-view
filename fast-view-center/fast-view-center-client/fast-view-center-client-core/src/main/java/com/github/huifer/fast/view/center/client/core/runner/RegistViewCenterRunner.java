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

package com.github.huifer.fast.view.center.client.core.runner;

import java.util.HashMap;
import java.util.Map;

import com.github.huifer.fast.view.center.client.core.service.ReadConfigService;
import com.github.huifer.fast.view.center.client.core.utils.FastViewCenterClientDataStore;
import com.github.huifer.fast.view.center.client.core.utils.FastViewHttpClient;
import com.github.huifer.fast.view.center.common.constant.OpenApiConstant;
import com.github.huifer.fast.view.center.common.model.RestResult;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author huifer
 */
@Component
public class RegistViewCenterRunner implements CommandLineRunner, Ordered {
	@Autowired
	@Qualifier("readSpringBootConfigService")
	private ReadConfigService readConfigService;

	@Autowired
	private ApplicationContext context;

	@Value("${spring.application.name}")
	private String appName;

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	@Override
	public void run(String... args) throws Exception {
		String hostPort = FastViewCenterClientDataStore.getHostPort();
		if (StringUtils.isNotBlank(hostPort)) {

			RedisProperties bean = context.getBean(RedisProperties.class);

			Map<String, String> map = new HashMap<>();
			Gson g = new Gson();

			map.put("data", g.toJson(bean));
			map.put("appName", appName);
			// 将配置发送给可视化中心
			RestResult<String> stringRestResult = FastViewHttpClient.httpPost(hostPort + OpenApiConstant.CONFIG_GATHER_APP, null, map);
			if (stringRestResult.getCode() == 200) {

				FastViewHttpClient.httpPost(hostPort + OpenApiConstant.CONFIG_GATHER_REDIS, null, map);
			}
		}

	}
}
