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

package com.github.huifer.fast.view.center.client.core.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.github.huifer.fast.view.center.client.core.service.ReadConfigService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Service;


/**
 *
 *
 * @author huifer
 */
@Service("readSpringBootConfigService")
public class ReadSpringBootConfigService implements ReadConfigService {
	@Autowired
	private ConfigurableEnvironment springEnv;

	@Override
	public String readConfig() {
		MutablePropertySources propSrcs = springEnv.getPropertySources();
		// 获取所有配置
		Map<String, String> props = StreamSupport.stream(propSrcs.spliterator(), false)
				.filter(ps -> ps instanceof EnumerablePropertySource)
				.map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toMap(Function.identity(), springEnv::getProperty));

//		logConfig(props);

		Gson gson = new Gson();
		return gson.toJson(props);
	}

	private void logConfig(Map<String, String> props) {
		// key 和 value 之间的最小间隙
		int interval = 20;
		int max = props.keySet().stream()
				.max(Comparator.comparingInt(String::length))
				.orElse("")
				.length();

		// 打印
		props.keySet().stream()
				.sorted()
				.forEach(k -> {
					int i = max - k.length() + interval;
					String join = String.join("", Collections.nCopies(i, " "));
					System.out.println(String.format("%s%s%s", k, join, props.get(k)));
				});
	}
}
